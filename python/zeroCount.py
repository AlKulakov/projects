#!/usr/bin/env python

def factorial(n):
    '''
    DOCSTRING: Подсчет факториала числа рекурсией
    INPUT: Число [n], факториал которого нужно найти
    OUTPUT: Факториал числа
    '''
    result = n
    if n == 1:
        return n
    return n*factorial(n-1)

def zeroCount(factorial, count):
    '''
    DOCSTRING: Подсчет нулей в конце числа факториала рекурсией
    INPUT: Факториал, количество нулей
    OUTPUT: Количество нулей факториала [count]
    '''
    while factorial.endswith("0"):
        factorial = factorial[:len(factorial)-1]
        count+=1
    return count

print("[+] Write the N number...")
n = int(input())
fac = str(factorial(n))
print("There is a ", zeroCount(fac, 0), " zeros in factorial...")
