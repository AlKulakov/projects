#!usr/bin/env python3

import webbrowser as wb
import os

def workauto():
    IEpath = 'C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe %s'
    ProgramPath = 'C:\\Program Files\\Notepad++\\notepad++.exe'
    os.startfile(ProgramPath)
    URLS = ("github.com",
            "google.com")
    for url in URLS:
        wb.get(IEpath).open(url)

workauto()
