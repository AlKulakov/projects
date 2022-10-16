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

newString = stringValue + newString #Concat

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