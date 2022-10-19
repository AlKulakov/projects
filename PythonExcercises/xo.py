
def welcome():
    '''
    DOCSTRING: Функция печатает приветствие игроков
    INPUT: Нет
    OUTPUT: Нет
    '''
    print("\n\nWelcome! This is XO game. use 1-9 keyboard keys for choosing place!\n\n\t\t     1|2|3\n\t\t     -----\n\t\t     4|5|6\n\t\t     -----\n\t\t     7|8|9\n\n")

def display_board(board):
    '''
    DOCSTRING: Функция печатает доску
    INPUT: Игровая доска в виде списка
    OUTPUT: Нет
    '''
    print(f"\n\n################################################\n\n\n\n\t\t     {board[0]}|{board[1]}|{board[2]}\n\t\t     -----\n\t\t     {board[3]}|{board[4]}|{board[5]}\n\t\t     -----\n\t\t     {board[6]}|{board[7]}|{board[8]}\n\n")

def input_players_data():
    '''
    DOCSTRING: Функция производит ввод данных игроков
    INPUT: Нет
    OUTPUT: Данные игроков в виде списка
    '''
    Name1 = input("Write Player 1 name: ")
    Choose1 = str()
    Choose2 = str()
    while True:
        Choose1 = str(input(f"Hello, {Name1}, choose x or o: "))
        if Choose1=='x' or Choose1=='o':
            break
    Name2 = input("Write Player 2 name: ")
    if Choose1 == 'x':
        Choose2 = 'o'
    else:
        Choose2 = 'x'
    playersData = {Name1:Choose1, Name2:Choose2}
    return playersData

def check_winner(board, player_data):
    '''
    DOCSTRING: Функция проверяет комбинации и победителя
    INPUT: Доска, данные игроков
    OUTPUT: Имя победителя [key], либо Ложь
    '''
    for i in range(1, len(board), 3):
        if board[i-1] == board[i] == board[i+1]:
            for key, value in player_data.items():
                if board[i] == value:
                    return key
    for i in range(3):
        if board[i] == board[i+3] == board[i+6]:
            for key, value in player_data.items():
                if board[i] == value:
                    return key
    if board[0] == board[4] == board[8]:
        for key, value in player_data.items():
            if board[0] == value:
                return key
    if board[2] == board[4] == board[6]:
        for key, value in player_data.items():
            if board[2] == value:
                return key
    return False

def move(player_data, player_name, board):
    '''
    DOCSTRING: Функция производит ходы игроков
    INPUT: Информация об игроках, имя игрока, делающего ход, доска
    OUTPUT: Доска с произведенным ходом
    '''
    while True:
        number = input(f"{player_name}, ваш ход: ")
        if number.isnumeric()==True:
            number = int(number)
        else:
            continue
        if number in range(1,10) and board[number-1]==" ":
            break
    board[number-1] = player_data[player_name]
    
    return board

def process_game(player_data, board):
    '''
    DOCSTRING: Функция запускает процесс игры
    INPUT: Данные игроков и игровая доска
    OUTPUT: Результат игры - победитель или ничья
    '''
    moveCount = 0 
    while True:
        display_board(board)
        for key, value in player_data.items():
            board = move(player_data, key, board)
            moveCount += 1
            flag = check_winner(board, player_data)
            display_board(board)
            if flag:
                return flag
            if moveCount == 9:
                return "Ничья"
        
def restart_request():
    '''
    DOCSTRING: Функция запрашивает у пользователя повторную игру
    INPUT: Нет
    OUTPUT: Результат
    '''
    request_result = input("Do you want to play again? yes/no ")
    if request_result == "yes" or request_result == "no":
        return request_result
    else:
        restart_request()
    
def startGame():
    '''
    DOCSTRING: Функция создает игровое поле, игроков и запускает основные функции
    INPUT: Нет
    OUTPUT: Нет
    '''
    board = [" ", " ", " ", " ", " ", " ", " ", " ", " "]
    welcome()
    player_data = input_players_data()
    game_result = process_game(player_data, board)
    if game_result == "Ничья":
        print("\n\n\t\t####################\n\t\t#Победила - дружба!#\n\t\t####################\n\n")
    else:
        print(f"\n\n################################################\n\t\t     Победил {game_result}!\n################################################\n\n")
    if restart_request() == "yes":
        startGame()
    
startGame()