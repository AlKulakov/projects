#!/usr/bin/env python3

import smtplib
import argparse

def get_args():
    parser = argparse.ArgumentParser()
    parser.add_argument("-t", "--target", dest="target", help="[-] There is a mail address of your target")
    parser.add_argument("-s", "--subject", dest="subject", help="[-] There is a subject of message")
    parser.add_argument("-m", "--message", dest="message", help="[-] There is a message you want to send")
    args=parser.parse_args()
    if not args.target:
        parser.error("[-] There is an error, type -h for help")
    if not args.subject:
        args.subject="Nameless message"
    if not args.message:
        parser.error("[-] There is an error, type -h for help")
    return args

def sendEmail(targetEmail, messageText):
    server = smtplib.SMTP_SSL('smtp.mail.ru', 465)
    server.login('bagitaf@mail.ru', 'NTG6yhqqLugjRwweURj2')
    server.sendmail('bagitaf@mail.ru', targetEmail, messageText)
    server.close()

arg = get_args()
targetEmail = arg.target
subject = arg.subject
text = arg.message
message = f'Subject: {subject}\n\nFrom: Bagitaf Georgiy\nTo: {targetEmail}\n\n{text}'
sendEmail(targetEmail, message)



