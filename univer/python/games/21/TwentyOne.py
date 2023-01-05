from random import randint, shuffle
import time
suits = ('Бубны', 'Крести', 'Черви', 'Пики')

ranks = ('Двойка', 'Тройка', 'Четверка', 'Пятерка', 'Шестерка', 'Семерка', 'Восьмерка', 'Девятка', 'Десятка', 'Валет', 'Дама', 'Король', 'Туз')

values = {'Двойка': 2, 'Тройка': 3, 'Четверка': 4, 'Пятерка': 5, 'Шестерка': 6, 'Семерка': 7, 'Восьмерка': 8, 'Девятка': 9, 'Десятка': 10, 'Валет': 10, 'Дама': 10, 'Король': 10, 'Туз': 11}
playing = bool()
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
        self.value+=values[card.rank]

        if card.rank=="Туз":
            self.aces+=1
        

    def adjust_for_ace(self):

        while self.value and self.aces:
            self.value -= 10
            self.aces = 1

class Chips:

    def __init__(self, total=100):
        self.total = total
        self.bet = 0
    
    def win_bet(self):
        total+=self.bet

    def lose_bet(self):
        total-=self.bet

def take_bet(chips):

    while True:
        try:
            chips.bet = int(input("Введите число фишек, которое хотите поставить: "))
            break
        except:
            print("Пожалуйста, введите число")
            continue
        else:
            if chips.bet > chips.total:
                print(f"Извините, недостаточно фишек. Доступно {chips.total}")

def hit(deck, hand):
    single_card = deck.deal_card()
    hand.add_card(single_card)
    hand.adjust_for_ace()

def hit_or_stand(deck, hand): 

    while True:
        x = input("Взять дополнительную карту (hit) или остаться при текущих картах (stand). Введите h или s: ")

        if x[0].lower() == "h":
            hit(deck, hand)
            break

        elif x[0].lower() == "s":
            print("Остаемся при текущих картах")
            playing = False
            break

        else:
            print("Ответ непонятен.")
            continue

        break

def player_busts(player, dealer, chips):
    print("Превышено число 21 для игрока! Игрок проиграл!")
    chips.lose_bet()

def dealer_busts(player, dealer, chips):
    print("Превышено число 21 для дилера! Дилер проиграл!")
    chips.win_bet()

def player_wins(player, dealer, chips):
    print("Игрок победил!")
    chips.win_bet()

def dealer_wins(player, dealer, chips):
    print("Дилер победил")
    chips.lose_bet()

def push(player, dealer, chips):
    print("Ничья!")

def show_some(player, dealer):

    print("\nКарты дилера:")
    print(" <Карта скрыта>")
    print('', dealer.cards[1])
    print('\nКарты игрока:', *player.cards, sep="\n ")

def show_all(player, dealer):

    print("\nКарты дилера:", *dealer.cards, sep="\n ")
    print("Карты дилера = ", dealer.value)
    print('\nКарты игрока', *player.cards, sep="\n ")
    print('Карты игрока =', player.value)


while True:

    print("Добро пожаловать в игру 21!")
    deck = Deck()
    deck.shuffle_cards()

    player_hand = Hand()
    player_hand.add_card(deck.deal_card())
    player_hand.add_card(deck.deal_card())

    dealer_hand = Hand()
    dealer_hand.add_card(deck.deal_card())
    dealer_hand.add_card(deck.deal_card())

    player_chips = Chips(500)

    take_bet(player_chips)

    show_some(player_hand, dealer_hand)

    while playing:

        hit_or_stand(deck, player_hand)
        show_some(player_hand, dealer_hand)

        if player_hand.value > 21:
            player_busts(player_hand, dealer_hand, player_chips)
            break

    if player_hand.value <= 21:

        while dealer_hand.value < 17:
            hit(deck, dealer_hand)

        show_all(player_hand, dealer_hand)

        if dealer_hand.value < player_hand.value:
            dealer_wins(player_hand, dealer_hand, player_chips)

        elif dealer_hand.value > 21:
            dealer_busts(player_hand, dealer_hand, player_chips)

        elif dealer_hand.value < player_hand.value:
            player_wins(player_hand, dealer_hand, player_chips)
            
        elif dealer_hand.value == player_hand.value:
            push(player_hand, dealer_hand, player_chips)

    print(f"Кол-во фишек игрока: {player_chips.total}")
        
    new_game = input("Do you want to play again? y/n")
    if new_game[0].lower() == "y":
        playing = True
        continue
    else:
        print("error!")
        break
