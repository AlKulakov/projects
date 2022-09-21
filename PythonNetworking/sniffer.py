#!/usr/bin/env python
import scapy.all as scapy
from scapy.layers import http

def sniff(face):
    scapy.sniff(iface=face, store=False, prn=process_sniffed_packet)

def process_sniffed_packet(packet):
    if packet.haslayer(http.HTTPRequest):
        print(packet)

sniff("eth0")