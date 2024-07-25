# usr/bin/env python
import scapy.all as scapy
import pprint
import argparse

def get_args():
    '''
    DOCSTRING: Получение аргументов при запуске скрипта
    INPUT: Нет
    OUTPUT: IP-адрес
    '''
    parser = argparse.ArgumentParser()
    parser.add_argument("-i", "--ipaddress", dest="ip_address", help="Ip address for sending packets")
    arg = parser.parse_args()
    if not arg.ip_address:
        parser.error("[-] Please put an ip address. Check --help for help")
    return arg.ip_address



def scan(ip):
    '''
    DOCSTRING: Получить текущие подключения в сети
    INPUT: IP-адресс
    OUTPUT: Список подключений к сети clients_list
    '''
    arp_req = scapy.ARP(pdst=ip)
    broadcast = scapy.Ether(dst = "ff:ff:ff:ff:ff:ff")
    arp_req_b = broadcast/arp_req
    answered_list = scapy.srp(arp_req_b, timeout=1, verbose=False)[0]
    clients_list = []
    for element in answered_list:
        client_dict = {"ip":element[1].psrc, "mac":element[1].hwsrc}
        clients_list.append(client_dict)
    return clients_list

def print_res(clients_list):
    '''
    DOCSTRING: Печать данных подлюченных клиентов
    INPUT: Список клиентов
    OUTPUT: Нет
    '''
    print("--------------------------------------")
    print("| IP\t\t| MAC-address \t")
    print("--------------------------------------")
    for el in clients_list:
        print("|", el["ip"], "\t|", el["mac"])
        print("--------------------------------------")



arg = get_args()
client_list = scan(arg)
print_res(client_list)
