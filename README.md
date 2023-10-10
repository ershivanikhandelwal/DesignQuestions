**Requirement:**

Current Scope:

    1. Size of the board? - 3X3
    2. How many players? - 2
    3. Type of players? - Human, Computer
    4. Symbols? - O and X

Future Scope:
    
    1. Can size may change in future? - Yes(nxn)
    2. Can multiple players play in future? - Yes(p)

Problem Statement:
  * Board can be of any NxN size.
  * There can be two players.
  * Each player will be allotted a symbol.
  * The symbol can be one of O and X.
  * The players can be of type either human or bot.
  * Each human player will have a name, email and profile image.
  * Each bot player will have a difficulty level.
  * Any random player can start the game.
  * Then the players will take turns to play alternatively.
  * The player with any consecutive N symbols in a row, column or diagonal wins. (check Winner)
  * If the board is full and no player has won, the game is a draw.


Entities: 
  * Board
  * Player
  * Symbol
  * Game

Attributes: 
  * Board Size
  * No of Players
  * Type of player
  * Player symbol
  * Player Name, email and image
  * Difficulty Level

Behaviour:
  * Choose Symbol
  * Choose Player
  * Select Difficulty
  * Start Game
  * Player turn
  * Check winning condition
  * Check draw condition



