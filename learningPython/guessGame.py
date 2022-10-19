from random import randint
def guessGame():
    '''
    DOCSTRING: Функция угадывания чисел
    INPUT: Нет
    OUTPUT: Количество попыток угадывания пользователя
    '''
    goal = randint(1,100)
    attempt = 0
    previousInput = None
    warmFlag = False
    while(True):
        inputNumber = input("Print a number: ")
        try:
            intNumber = int(inputNumber)
            if intNumber == goal:
                print(f"YOU GUESSED {goal}!")
                break
            if intNumber<1 or intNumber>100:
                print("OUT OF RANGE!")
                continue
            if abs(goal-intNumber) > 10:
                print("COLD!")
                warmFlag = False
                continue
            if warmFlag is not True and (goal-intNumber) <= 10:
                print("WARM!")
                warmFlag = True
            if intNumber<1 or intNumber>100:
                print("OUT OF RANGE!")
            if previousInput is not None and abs(goal-previousInput) >= abs(goal-intNumber):
                print("WARMER!")
            elif previousInput is not None and abs(goal-previousInput) < abs(goal-intNumber):
                print("COLDER!")
            previousInput = intNumber
        except:
            print("Wrong input!")
        attempt += 1
    return attempt

attempts = guessGame()
print(f"You guessed {attempts} times!")