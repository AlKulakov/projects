import math
class Line():
    def __init__(self, coordinatesA: tuple, coordinatesB: tuple):
    #DOCSTRING: Конструктор класса прямой
    #INPUT: Координаты точки А, координаты точки Б
    #OUTPUT: Нет
        self.coordinatesA = coordinatesA
        self.coordinatesB = coordinatesB

    def line_length(self):
    #DOCSTRING: Функция подсчета длины прямой
    #INPUT: Нет
    #OUTPUT: Длина
        return (((self.coordinatesA[0]-self.coordinatesB[0]) ** 2 ) + ((self.coordinatesA[1] - self.coordinatesB[1]) ** 2)) ** 0.5

    def angle(self):
    #DOCSTRING: Функция подсчета угла наклона прямой
    #INPUT: Нет
    #OUTPUT: Угол наклона в градусах
        return math.atan((self.coordinatesB[1]-self.coordinatesA[1])/(self.coordinatesB[0]-self.coordinatesA[0]))*57.3

line1 = Line((1,2), (4,5))
print(f"Длина линии равна {line1.line_length()}")
print(f"Угол наклона прямой равен {str(line1.angle())[:5]}")
