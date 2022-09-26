#!/usr/bin/env python

print("[+] Write your sequence, for example: 1 2 3 4 5 6 ...")
sequenceString = str(input())
sequenceList = sequenceString.split(" ")
diff = []
diffOfTheDiff = []
linearSec = True
cubicSec = True
quatricSec = True

for i in range(len(sequenceList)-1):
    diff.append(int(sequenceList[i+1])-int(sequenceList[i]))
    if i!=0 and diff[i]!=diff[i-1]:
        linearSec = False

for j in range(len(diff)-1):
    diffOfTheDiff.append(diff[j+1]-diff[j])
    if j!=0 and diffOfTheDiff[j]!=diffOfTheDiff[j-1]:
        quatricSec = False

for k in range(len(sequenceList)):
    if k ** 3 != int(sequenceList[k]):
        cubicSec = False

if linearSec:
    print("[-] This sequence is linear...")
elif cubicSec:
    print("[-] This sequence is cubic...")
elif quatricSec:
    print("[-] This secuence is quatric...")
else:
    print("[-] This secuence is trash...")

