# HOMEWORK
PI=3.14
def avg(*args):
    '''
    DOCSTRING: Функция считает среднее арифметическое
    INPUT: Аргументы в виде кортежа
    OUTPUT: Среднее арифметическое
    '''
    return sum(args)/len(args)
    
def mini(a, b):
    '''
    DOCSTRING: Если оба числа четные функция возвращает минимальное, иначе - максимальное
    INPUT: Два числа
    OUTPUT: Минимальное или максимальное значение
    '''
    if a%2==0 and b%2==0:
        return min(a,b)
    else:
        return max(a,b)

def flag(string):
    '''
    DOCSTRING: Функция проверяет чтобы первый символ двух слов был одинаковый
    INPUT: Строка
    OUTPUT: Истинность
    '''
    return string.split()[0][0]==string.split()[1][0]

def flag2(c,d):
    '''
    DOCSTRING: Функция проверяет чтобы одно из двух чисел или их сумма были равно 20 
    INPUT: Два числа
    OUTPUT: Истинность
    '''
    return c+d==20 or c==20 or d==20

def mc(string):
    '''
    DOCSTRING: Функция переводит первый и четвертый символ в верхний регистр
    INPUT: Строка
    OUTPUT: Новая строка
    '''
    mcd = ""
    for i in range(len(string)):
        if i == 0 or i == 3:
            mcd += string[i].upper()
        else:
            mcd += string[i]
    return mcd
    
def rev(string):
    '''
    DOCSTRING: Функция возвращает строку задом на перед
    INPUT: Строка
    OUTPUT: Строка задом наперед
    '''
    return string[::-1]
    
def boolean(n):
    '''
    DOCSTRING: Функция проверяет удаленность от 100 и 200
    INPUT: Число
    OUTPUT: Истинность
    '''
    if abs(n-100)<=10 or abs(n-200)<=10:
        return True
    else: 
        return False

def neighbor(lst):
    '''
    DOCSTRING: Функция проверяет есть ли одинаковые соседние элементы списка
    INPUT: Список
    OUTPUT: Истинность
    '''
    flag = bool()
    for i in range(1, len(lst)-1):
        if lst[i] == lst[i-1] or lst[i]==lst[i+1]:
            flag = True
        else:
            flag = False
    return flag     

def pap(string):
    '''
    DOCSTRING: Функция записывает каждый символ строки три раза
    INPUT: Строка
    OUTPUT: Новая строка
    '''
    newstr = str()
    for char in string:
        newstr+=char*3
    return newstr
    
def black_jack(a,b,c):
    '''
    DOCSTRING: Функция делает блэк джек
    INPUT: Три числа
    OUTPUT: Результат
    '''
    result = a+b+c
    if result <= 21:
        return result
    elif result > 21 and (a==11 or b==11 or c==11):
        result-=10
    if result > 21:
        return "BUST"
        
def sum69(arr):
    '''
    DOCSTRING: Функция возвращает сумму между числами 6 и 9
    INPUT: Список чисел
    OUTPUT: Сумма
    '''
    if arr.count(6)>0 and arr.count(9)>0:
        if arr.index(6) < arr.index(9):
            return sum(arr[:arr.index(6)])
        else:
            return sum(arr)
    else:
        return sum(arr)

def spy007(arr):
    '''
    DOCSTRING: Функция ищет последовательность 0 0 7 в списке
    INPUT: Список
    OUTPUT: Истинность
    '''
    if arr.count(0) >= 2 and arr.count(7)>=1:
        if arr.index(0,2) < len(arr[:arr.index(0,2)])+arr[arr.index(0,2):].index(7):
            return True
        else:
            return False
    else:
        return False
    

def simpleNumCount(n):
    '''
    DOCSTRING: Функция возвращает количество простых чисел до заданного
    INPUT: Число
    OUTPUT: Количество простых чисел
    '''
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
    '''
    DOCSTRING: Функция рисует заданными символами
    INPUT: Символ
    OUTPUT: Нет
    '''
    print(f"  {a}  \n {a} {a} \n{a}{a}{a}{a}{a}\n{a}   {a}\n{a}{a}{a}{a}{a}")
printbig("o")
def sphereVolume(r):
    '''
    DOCSTRING: Функция считает объем сферы
    INPUT: Радиус [r]
    OUTPUT: Объем [V]
    '''
    volume = 4/3 * PI * (r ** 3)
    return volume
print(sphereVolume(4))

def check_in_range(number, lower, higher):
    '''
    DOCSTRING: Функция проверяет, содержится ли число в диапазоне
    INPUT: Число, меньшее и большее значение в диапазоне
    OUTPUT: True or False
    '''
    return number in range(lower, higher)

print(check_in_range(3,4,5))

def registr_char_count(string):
    '''
    DOCSTRING: Функция возвращает число букв в нижнем и верхнем регистрах
    INPUT: Строка
    OUTPUT: Словарь с количеством букв каждого регистра
    '''
    amount = {'Lower':0, 'Upper':0}
    for char in string:
        if char.isupper():
            amount['Upper']+=1
        if char.islower():
            amount['Lower']+=1
    return amount
    
print(registr_char_count("Hello, my name is World"))

def unique_items(input_list):
    '''
    DOCSTRING: Функция возвращает только уникальные элементы списка
    INPUT: Входной список
    OUTPUT: Список с уникальными элементами
    '''
    new_list = list()
    for item in input_list:
        if item in new_list:
            continue
        else:
            new_list.append(item)
            
    return new_list
    
print(unique_items([1,2,2,3,4,4,4,5,5]))
            
def multiply(input_list):
    '''
    DOCSTRING: Функция возвращает произведение элементов цикла
    INPUT: Входной список
    OUTPUT: Результат произведения
    '''
    multiply_result = 1
    for item in input_list:
        multiply_result*=item
    return multiply_result
    
print(multiply([2,3,4,5]))
    
def polindrome(string):
    '''
    DOCSTRING: Функция проверяет полиндромность фразы или слова
    INPUT: Фраза
    OUTPUT: Истинность полидромности
    '''
    string="".join(string.split(" "))
    for i in range(len(string)):
        if string[i]!=string[-i-1]:
            return False
    return True
    
print(polindrome("nurses run"))

import string

def check_alphabet(string):
    '''
    DOCSTRING: Функция проверяет, есть ли все символы алфавита в строке
    INPUT: Строка
    OUTPUT: Истинность
    '''
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    for char in alphabet:
        if char not in string:
            return False
    return True
    
print(check_alphabet("The quick brown fox jumps over the lazy dog"))
    
    
