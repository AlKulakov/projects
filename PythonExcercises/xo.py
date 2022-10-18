
def welcome():
    print("Welcome! This is XO game. use 1-9 keyboard keys for choosing place!\n\n1|2|3\n-----\n4|5|6\n-----\n7|8|9\n\n")

def display_board(board):
    print(f"########################################\n\n\n\n{board[0]}|{board[1]}|{board[2]}\n-----\n{board[3]}|{board[4]}|{board[5]}\n-----\n{board[6]}|{board[7]}|{board[8]}")

def input_players_data():
    Name1 = input("Write Player 1 name: ")
    Choose1 = str()
    Choose2 = str()
    while True:
        Choose1 = str(input(f"Hello, {Name1}hoose x or o: "))
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
    for i in range(0:len(board):3):
        if board[i-1] == board[i] == board[i+1]:
            for key, value in player_data.items:
                if board[i] == value:
                    return key
    for i in range(3):
        if board[i] == board[i+3] == board[i+6]:
            for key, value in player_data.items:
                if board[i] == value:
                    return key
    if board[0] == board[4] == board[8]:
        for key, value in player_data.items:
            if board[0] == value:
                return key
    if board[2] == board[4] == board[6]:
        for key, value in player_data.items:
            if board[2] == value:
                return key
    return False

def move(player_data, player_name, board):

    return board

def process_game(player_data, board):
    moveCount = 0 
    while True:
        display_board(board)
        for key, value in player_data:
            board = move(player_data, player_data[key], board)
            moveCount += 1
            flag = check_winner(board, player_data)
            if flag:
                return flag
            if moveCount == 9:
                return "Ничья"
        

def startGame():
    board = [" ", " ", " ", " ", " ", " ", " ", " ", " "]
    welcome()
    player_data = input_players_data()
    game_result = process_game(player_data, board)
    if game_result == "Ничья":
        print("Победила - дружба!")
    else:
        print(f"Победил {game_result}")
startGame()