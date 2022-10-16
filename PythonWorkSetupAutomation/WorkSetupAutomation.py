#!usr/bin/env python3

import webbrowser as wb

def workauto():
    IEpath = 'C:\\Program Files\\Internet Explorer\\iexplore.exe %s'
    URLS = ("github.com",
            "google.com")
    for url in URLS:
        wb.get(IEpath).open(url)

workauto()