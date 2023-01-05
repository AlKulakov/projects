#!/usr/bin/env python

def validation(nestedList, simpleList):
'''
    DOCSTRING: Проверка содержания списка [nestedList] в [simpleList]
    INPUT: Списки [nestedList], [simpleList]
    OUTPUT: Соответсвие [valid]
    '''
    valid = True
    for element in nestedList:
        if type(element)==list:
            for el in element:
                if el not in simpleList:
                    valid = False
    return valid

list1 = [5, 3, ["asd", 6], 4]
list2 = [1, 6, "asd"]
print("Sublist of list1 is in list2: ", validation(list1, list2))

