#!/usr/bin/env python

def counter(list):
    '''
    DOCSTRING: Подсчет числовых значений в списке
    INPUT: Список [list]
    OUTPUT: Количество чисел [count]
    '''
    count = 0
    for element in list:
        if element.isnumeric():
            count+=1
    return count

print("[+] Print your list to count...")
inp = input()
list = inp.split(" ")
print("[-] Numeric symbols count: ", counter(list))
