from random import randint, shuffle

suits = ('Бубны', 'Крести', 'Черви', 'Пики')

ranks = ('Двойка', 'Тройка', 'Четверка', 'Пятерка', 'Шестерка', 'Семерка', 'Восьмерка', 'Девятка', 'Десятка', 'Валет', 'Дама', 'Король', 'Туз')

values = {'Двойка': 2, 'Тройка': 3, 'Четверка': 4, 'Пятерка': 5, 'Шестерка': 6, 'Семерка': 7, 'Восьмерка': 8, 'Девятка': 9, 'Десятка': 10, 'Валет': 10, 'Дама': 10, 'Король': 10, 'Туз': 11}

class Card():

    def __init__(self, suit, rank):
        self.suit = suit
        self.rank = rank

    def __str__(self) -> str:
        return self.rank + ":" + self.suit

class Deck():

    game_deck = list()

    def __init__(self):
        for suit in suits:
            for rank in ranks:
                self.game_deck.append(Card(suit,rank))

    def shuffle_cards(self):
        shuffle(self.game_deck)

    def deal_card(self):
        return self.game_deck.pop()

    def __str__(self):
        string = str()
        for item in self.game_deck:
            string=string+ " " + str(item)
        return "Карты в колоде: " + string

class Hand():
    def __init__(self):
        self.cards = []
        self.value = 0
        self.aces = 0

    def add_card(self, card):
        self.cards.append(card)

    def adjust_for_ace(self):
        pass

class Chips:

    def __init__(self):
        self.total = 0
        self.bet = 0
    
    

test_deck = Deck()
test_deck.shuffle_cards()
print(test_deck)