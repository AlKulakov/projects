try:
    for i in ['a', 'b', 'c']:
        print(i**2)
except TypeError:
    print("Неверный тип данных")

x = 5
z = 0

try:
    x/z
except ZeroDivisionError:
    print("Деление на ноль невозможно!")
finally:
    print("Сделано...")

def ask():
    while True:
        try:
            n = int(input("Введите число:"))
        except ValueError:
            print("Это не число!")
            continue
        else:
            return n**2

print(ask())
