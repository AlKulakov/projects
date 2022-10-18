#!/usr/bin/env python3

######################################################
					# DEFAULTS
intValue = 43 #Числовой тип
stringValue = "ksdfds" #Строки
floatValue = 2.32 #Числа с плавающей точкой
listValue = [23, 32, "kdf"] # Нумерованный список, массив
dictionaryValue = {"key1":34, "key2":43}  #Словарь в виде ключа и значений
tupleValue = (20, "dfdfs", 93) #Не нумерованный список
setValue  = {"fdsf", "dfsdf"} #Множества
booleanValue = True # Булевой тип данных
4 ** (1/2) - # Square root
#################################################################
					# STRINGS
newString = "bfsodifhsldfk" 
print(newString[1:9:2]) # [Начальный элемент:Конечный элемент:Шаг]

len(stringValue) # Длина строки, массива и т.д.

<<<<<<< HEAD
newString[-1] # Обратная индексация

newString[:5] # Первые 6 символов

newString[::-1] #Инверсия строки

=======
newString = stringValue + newString #Concat
>>>>>>> 2e4b2f74c7f313fd11d84445af3c5851bc3e13e9

newString = newString * 3 # Multiple string

newString.upper() # To upper registr whole string
newString.lower() #  To lower registr
newString.islower() # Check the string to lower registr
newString.isupper() # Check the string to upper registr
newString.count("bfs") #Check the amount of substrings in the string
newString.capitalize() # Make the first symbol upper
newString.find('j', 2, 25) # Find first index of the symbol ('symbol', start, end)
newString.split('f') # To split string with 'f' symbol
newString.startswith('k') # Check the begining with this substring
newString.endswith('k') # Check the ending with this substring
newString.isnum() # Check numeric appearence
newString.isalpha() # Check alphabet appearance
newString.isalnum() # Check alphabet and numeric appearence

print("My name is {name}, my second name {secname}".format(secname="Kulakov", name="Aleksandr")) # Formatting strings

result = 100/555
print("Result: {r:.5f}".format(r=result)) # (value:space.width f)

print(f"Result: {result}") # f strings

#################################################################
						# LISTS
#Index manipulations as strings
listValue + [3, 45, "sfsdd"] # Concat lists

listValue.append("el") # Add element in the end of list

listValue.pop() # Remove last element

pop_item = listValue.pop() # Save popped element

listValue.pop(0) # Remove element with 0 index

listValue.sort() # Sorting list a-z 1-9

listValue.reverse() # Reversing list

################################################################
					# DICTIONARIES
#Cant be sorted


dic = {"abc":[23,34,53], 43:34} # Dictionary

dic["abc"][1] # Take element from Dictionary with 1 index

dic[43] = "New value" # Change value

dic.keys() # Show keys

dic.values() # Show values

dic.items() # Show all

################################################################
					# TUPLES
#Cant be changed

tupleValue.index("a") # First element appearence

tupleValue.count(23) # Count of elements

################################################################
					# SETS
#Unique elements

newSet = set() # New set

newSet.add(2) # Add item to set

mylist = [3, 3, 4, 5, 6, 6]
set(mylist) # Convert list to set

################################################################
					#bool

b = None

################################################################
					#FILES
%%writefile mynewfile.txt
sfgsdfgsd
sdfgsdfgsd
dfsgdfgdfgfggd

myFile = open("myfile.txt", "w+") # Create new file
# w - create and write
# r - read
# r+ - read and write
# w+ - create or read and write
# b - binary file (01)
# a - create or open for adding new info
myFile.close() # Close file
print(*myFile) # Print file info
new_file.read() # file reading
with open("myfile.txt", "a+") as new_file:
	new_file.write("New line") # Append in file

##############################################################
					# Logic
1<3<4 # Two comparing operators
1<3 and 3<4 # && operator
1>3 or 4<5 # || operator
1 is not 3 # != operator

###############################################################
					#For
for element in listValue # Cicle for
	print(element)


corList = [(1,2), (3,4), (5,6)]

for (a,b) in corList: # Tuple encounter
	print(a)
	print(b)

for a,b in corList:
	print(a)
	print(b)

dicti = {'k1': 2, 'k2':3, 'k3': 4}

for item in dicti.items(): # For in dictionariess
	print(item)

for key,value in dicti.items(): # Dictionaries encounter
	print(key)
	print(value)

################################################################
					#WHILE

while True:
	print("hsldhfd")
else:					#Else can be used with while
	print("abc")

while True:
	pass			#Filler

################################################################
					#OPERATORS

for i in range(5): # Generator of the values (start, stop, step)
	print(i)

for element in enumerate(word): # Creates tuples with index and value
	print(item)

zip(listValue, mylist) # Unite 2 or more lists in tuples

for item in zip(listValue, mylist):
	print item

'x' in ['x', 'y', 'z']

'mykey' in {'mykey':1234}

list1 = [10, 15,20, 5]

min(list1) # returns minimal value
max(list1) # returns maximal value
#-------------------------
from random import shuffle
list2 = [1,2,3,4,5]

shuffle(list2) # random shuffle the elements

randint(0,100) # returns random integer value (start, stop)

input("Enter: ") # system input value

float(value) #To float
int(value) #To int
str(value) #To string

####################################################
					#List generators

mystr = "Hello world"

newlist = [character for character in mystr] # Creates list with string's character

newlst = [i**2 for i in range(1,10) if i%2==0] # Creates list with squares numbers 1-10 range

#########################################################
					#Methods

help(value.method) #Get documentation

def function_name(): #Function definition
	'''
	DOCSTRING: function info
	INPUT: No
	OUTPUT: dfg
	'''
	print("dfg")

return 10 in [213, 10, 23]

def pig_latin(word):
	firstLetter = word[0]
	if firstLetter in "aeuoi":
		word = word + 'ay'
	else:
		word = word[1:] + firstLetter + "ay"
	return word

def myfun(*args): # Can be inputed many arguments | args - tuple
	return sum(args) * 0.05
myfun(10,213,1231)

def mfun(**kwargs):  #input arguments into the dictionary
	if 'source' in kwargs:
		return kwargs['source']

mfun(source='192.168.1.10')

#####################################################
                      #Some Excercises
def avg(*args):
    return sum(args)/len(args)
    
def mini(a, b):
    if a%2==0 and b%2==0:
        return min(a,b)
    else:
        return max(a,b)

def flag(string):
    return string.split()[0][0]==string.split()[1][0]

def flag2(c,d):
    return c+d==20 or c==20 or d==20

def mc(string):
    mcd = ""
    for i in range(len(string)):
        if i == 0 or i == 3:
            mcd += string[i].upper()
        else:
            mcd += string[i]
    return mcd
    
def rev(string):
    return string[::-1]
    
def boolean(n):
    if abs(n-100)<=10 or abs(n-200)<=10:
        return True
    else: 
        return False

def neighbor(lst):
    flag = bool()
    for i in range(1, len(lst)-1):
        if lst[i] == lst[i-1] or lst[i]==lst[i+1]:
            flag = True
        else:
            flag = False
    return flag     

def pap(string):
    newstr = str()
    for char in string:
        newstr+=char*3
    return newstr
    
def black_jack(a,b,c):
    result = a+b+c
    if result <= 21:
        return result
    elif result > 21 and (a==11 or b==11 or c==11):
        result-=10
    if result > 21:
        return "BUST"
        
def sum69(arr):
    if arr.count(6)>0 and arr.count(9)>0:
        if arr.index(6) < arr.index(9):
            return sum(arr[:arr.index(6)])
        else:
            return sum(arr)
    else:
        return sum(arr)

def spy007(arr):
    if arr.count(0) >= 2 and arr.count(7)>=1:
        if arr.index(0,2) < len(arr[:arr.index(0,2)])+arr[arr.index(0,2):].index(7):
            return True
        else:
            return False
    else:
        return False
    

def simpleNumCount(n):
    count = 0
    flag = False
    for i in range(1,n):
        for j in range(1,i):
            if i%j==0 and i!=0 and j!=0 and i!=1 and j!=1 and i!=j:
                flag=False    
                break
            else:
                flag=True
        if flag:
            count+=1
    return count
        
print(simpleNumCount(24))

def printbig(a):
    print(f"  {a}  \n {a} {a} \n{a}{a}{a}{a}{a}\n{a}   {a}\n{a}{a}{a}{a}{a}")
printbig("o")
##############################################################
						#map, filter, lambda
lsst = [1,2,3,4,5]
def sqt(x):
	return x**(1/2)

for items in map(sqt, lsst): #Allow you to use list in variebles functions
	print(items)

list(map(sqt, lsst))

nums = [1,2,3,4,5,6,7,8,9]

def check_even(num): 
	return num%2==0

print(list(filter(check_even, nums))) #returns elements with True value

sq = lambda num: num ** 2 # Anonimous lambda functions

sq(3)

list(map(lambda num: num ** 2, nums))

###################################################################
						#scope

'''
LEGB law:

Local - in def or lambda, not identified as global
Enclosing functions locals - local names in def or lambda levels, from closest to further 
G - global module variebles
B - Built-in names in python (open, range ...)
'''
x = 50
def sc():
	global x #Global variable in def function
	x = 50
	return x



















