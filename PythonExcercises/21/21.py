
from random import betavariate, shuffle, randint
    
def aces_value():
    while True:
        try:
            value = int(input("Цена туза, 1 или 11? > "))
        except:
            print("Вы ввели не число, попробуйте снова")
            continue
        else:
            if value in [1,11]:
                return value
            else:
                continue

suits = ('Бубны', 'Крести', 'Черви', 'Пики')

ranks = ('Двойка', 'Тройка', 'Четверка', 'Пятерка', 'Шестерка', 'Семерка', 'Восьмерка', 'Девятка', 'Десятка', 'Валет', 'Дама', 'Король', 'Туз')

values = {'Двойка': 2, 'Тройка': 3, 'Четверка': 4, 'Пятерка': 5, 'Шестерка': 6, 'Семерка': 7, 'Восьмерка': 8, 'Девятка': 9, 'Десятка': 10, 'Валет': 10, 'Дама': 10, 'Король': 10, 'Туз': aces_value()}

class Deck:
    game_deck = list()
    def __init__(self):
        for suit in suits:
            for rank in ranks:
                self.game_deck.append(Card(suit,rank))
    def shuffle_cards(self):
        shuffle(self.game_deck)
    def give_card(self):
        return self.game_deck.pop()
    def __str__(self):
        string = str()
        for item in self.game_deck:
            string=string+ " " + str(item)
        return string

class Card():
    def __init__(self, suit, rank):
        self.suit = suit
        self.rank = rank
    def __str__(self) -> str:
        return self.suit + ":" + self.rank

class Player():
    value = 0
    cards = []
    def __init__(self, name):
        self.name = name
    def add_card(self, card):
        self.cards.append(card)
        value += values[str(card).split(":")[1]]
        print(f"{self.name} взял карту")
    def show_card(self, number):
        print(f"Одна из карт {self.player} - {str(self.cards[number])}")
    def get_value(self):
        return self.value

class Cash():
    dealer_cash = 5000
    bet = 0
    def __init__(self, amount=0):
        self.amount=amount
    def bet(self, bet_amount):
        if bet_amount > self.dealer_cash:
            return False
        else:
            print("Ставка сделана")
            self.bet = bet_amount
    def get_amount(self):
        return self.amount
    def win_bet(self):
        self.amount+=self.bet
        self.dealer_cash-=self.bet
        print("Поздравляем, вы победили!")
    def lose_bet(self):
        self.amount-=self.bet
        self.dealer_cash+=self.bet
        print("Поздравляем, вы проиграли!")

def take_bet():
    while True
        try:
            bet = int(input("Введите сумму ставки в фишках: "))
        except:
            print("Вы ввели не число, попробуйте снова")
        else:
            return bet

def hit(deck, player):
    

game_process = True
new_deck = Deck()
new_deck.shuffle_cards()
player_name = input("Введите имя игрока: ")
dealer = Player("Dealer")
player = Player(player_name)
player_cash = Cash(500)
for i in range(2):
    dealer.add_card(new_deck.give_card())
    player.add_card(new_deck.give_card())
    player.show_card(i)
dealer.show_card(randint(0,1))
while game_process:
