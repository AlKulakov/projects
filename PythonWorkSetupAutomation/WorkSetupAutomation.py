#!usr/bin/env python3

import webbrowser as wb

def workauto():
    IEpath = 'C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe %s'
    URLS = ("github.com/AlKulakov",
            "google.com")
    for url in URLS:
        wb.get(IEpath).open(url)

workauto()
