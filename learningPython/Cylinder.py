class Cylinder():
    PI = 3.14
    def __init__(self, height=1, radius=1):
    '''
    DOCSTRING: Конструктор класса цилиндра
    INPUT: Высота, радиус цилиндра
    OUTPUT: Нет
    '''
        self.height = height
        self.radius = radius

    def volume(self):
    '''
    DOCSTRING: Функция подсчета объема цилиндра
    INPUT: Нет
    OUTPUT: Объем цилиндра
    '''
        return self.PI * (self.radius ** 2) * self.height
    
    def surface_area(self):
    '''
    DOCSTRING: Функция подсчета площади
    INPUT: Нет
    OUTPUT: Площадь поверхности
    '''
        return 2 * self.PI * self.radius * self.height

cylind = Cylinder(3,4)

print(f"Объем заданного цилиндра равен {str(cylind.volume())[:5]}")
print(f"Площадь поверхности заданного цилиндра равен {str(cylind.surface_area())[:5]}")