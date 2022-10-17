#!/usr/bin/env python3

import smtplib
import argparse
import os
import sys
from configparser import ConfigParser
import inspect

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

def get_cfg():
    currentPath = os.path.dirname(inspect.getabsfile(get_cfg))
    cfg_path = os.path.join(currentPath, "conf.ini")
    if os.path.exists(cfg_path):
        cfg = ConfigParser()
        cfg.read(cfg_path)
    else:
        print(f"[-] There is no conf.ini file in script folder! Exiting! Currrent catalog: {cfg_path}")
        sys.exit(1)
    cfgInfo = dict()
    cfgInfo['server'] = cfg.get("smtp", "server")
    cfgInfo['port'] = cfg.get("smtp", "port")
    cfgInfo['host_address'] = cfg.get("smtp", "host_address")
    cfgInfo['host_password'] = cfg.get("smtp", "host_password")
    return cfgInfo

def sendEmail(targetEmail, messageText):
    cfg_info = get_cfg()
    server = smtplib.SMTP_SSL(cfg_info['server'], cfg_info['port'])
    server.login(cfg_info['host_address'], cfg_info['host_password'])
    server.sendmail(cfg_info['host_address'], targetEmail, messageText)
    server.close()

arg = get_args()
targetEmail = arg.target
subject = arg.subject
text = arg.message
cfg = get_cfg()
sender = cfg['host_address']
message = f'Subject: {subject}\n\nFrom: {sender}\nTo: {targetEmail}\nSubject: {subject}\n\n{text}'
sendEmail(targetEmail, message)