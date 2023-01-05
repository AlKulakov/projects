#!usr/bin/env python3
import subprocess
import os
import inspect
def mvFile():
    '''
    DOCSTRING: Перенести файл в нужную директорию
    INPUT: Нет
    OUTPUT: Нет
    '''
    currentPath = os.path.dirname(inspect.getabsfile(mvFile))
    file_path = os.path.join(currentPath, "br.exe")
    currentUser = os.getlogin()
    print(file_path)
    subprocess.call(f'move {file_path} C:\\Users\\{currentUser}\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup')
    print(f'move {file_path} C:\\Users\\{currentUser}\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup')
mvFile()