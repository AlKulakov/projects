#!/usr/bin/env python

def factorial(n):
    result = n
    if n == 1:
        return n
    return n*factorial(n-1)

def zeroCount(factorial, count):
    while factorial.endswith("0"):
        factorial = factorial[:len(factorial)-1]
        count+=1
    return count

print("[+] Write the N number...")
n = int(input())
fac = str(factorial(n))
print("There is a ", zeroCount(fac, 0), " zeros in factorial...")
