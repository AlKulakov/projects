#!/usr/bin/env python

def counter(list):
    count = 0
    for element in list:
        if element.isnumeric():
            count+=1
    return count

print("[+] Print your list to count...")
inp = input()
list = inp.split(" ")
print("[-] Numeric symbols count: ", counter(list))
