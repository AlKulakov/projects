import math
class Line():
    def __init__(self, coordinatesA: tuple, coordinatesB: tuple):
        self.coordinatesA = coordinatesA
        self.coordinatesB = coordinatesB

    def line_length(self):
        return ((self.coordinatesA[0]-self.coordinatesB[0]) ** 2 ) + ((self.coordinatesA[1] - self.coordinatesB[1]) ** 2) ** 0.5

    def angle(self):
        return math.atan((self.coordinatesB[1]-self.coordinatesA[1])/(self.coordinatesB[0]-self.coordinatesA[0]))*57.3

line1 = Line((3,4), (4,6))
print(f"Длина линии равна {line1.line_length()}")
print(f"Угол наклона прямой равен {str(line1.angle())[:5]}")
