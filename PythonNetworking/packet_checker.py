#!/usr/bin/env python

import scapy.all as scapy

def sniff(interface):
	scapy.sniff(iface=interface, store=False, prn=packet_process_sniff)

def packet_process_sniff(packet):
	print(packet)

sniff("wlp6s0b1")