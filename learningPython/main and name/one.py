#one.py
#print(__name__=="__main__")

def fun():
    print("Function in fun()")

print("In one.py")
if __name__ == "__main__":
    print("one.py запускается напрямую")
else:
    print("Используется импорт")