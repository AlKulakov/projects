#!/usr/bin/env python3

######################################################

intValue = 43 #Числовой тип
stringValue = "ksdfds" #Строки
floatValue = 2.32 #Числа с плавающей точкой
listValue = [23, 32, "kdf"] # Нумерованный список, массив
dictionaryValue = {"key1":34, "key2":43}  #Словарь в виде ключа и значений
tupleValue = (20, "dfdfs", 93) #Не нумерованный список
setValue  = {"fdsf", "dfsdf"} #Множества
booleanValue = True # Булевой тип данных

#################################################################

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

#Index manipulations as strings
listValue + [3, 45, "sfsdd"] # Concat lists

listValue.append("el") # Add element in the end of list

listValue.pop() # Remove last element

pop_item = listValue.pop() # Save popped element

listValue.pop(0) # Remove element with 0 index

listValue.sort() # Sorting list a-z 1-9

listValue.reverse() # Reversing list

################################################################

#Cant be sorted



