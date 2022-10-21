class BankClient():
    
    def __init__(self, name, balance):
        self.name = name
        self.balance = balance
    
    def deposit(self, amount=0):
        self.balance += amount
        print(f"Деньги зачислены в количестве {amount}")
    
    def withdraw(self, amount=0):
        if self.balance >= amount:
            self.balance-=amount
            print(f"Деньги сняты в количестве {amount}")
        else:
            print("Недостаточно средств")
    
    def show_balance(self):
        return self.balance

client = BankClient("Aleksandr", 1000)
print("Введите withdraw Сумма для снятия денег, deposit Сумма для зачисления, show для показа баланса")
while(True):
    request = input("> ")
    req_results = request.split()
    if req_results[0] == "deposit" and req_results[1].isnumeric():
        client.deposit(int(req_results[1]))
    elif req_results[0] == "withdraw" and req_results[1].isnumeric():
        client.withdraw(int(req_results[1]))
    elif req_results[0] == "show":
        print(client.show_balance())
    else:
        print("Error. Wrong command")
