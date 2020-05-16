X! O! Super! - extended Tic Tak Toe game.

Game available by URL:
https://drive.google.com/open?id=1EZ8Md8h1PbMlpLJE3GEkYdsUSRvgor7t

GitHub repository:
https://github.com/DenisKuivalainen/Tic-Tac-Toe/tree/5x5

PATCH NOTES
v1.1
    - New algorithm of valuing and parameters for cells in "AI" mode.
    - Number of operations during opponent turn in "AI" mode was reduced.
    - Code was reorganized in case of complexity.
v1.2
    - Rendering of buttons was reorganized.

I. RULES
	The object of extended Tic Tac Toe is to get four in a row. 
	You play on a five by five game board. 
	The first player is known as "X" and the second is "O". 
	Players alternate placing "X" and "O" on the game board until either opponent has four in a row or all twenty five squares are filled.

II. INTERFACE
	Interface divided into 2 parts: control field on top and game field in the bottom.

	Control field contains information field and 2 buttons:
	1. Information field displays status of the game:
		a. "X turn!" - Turn of player, who plays with "X"
		b. "O turn!" - Turn of player, who plays with "O" / AI turn
		c. "X wins!" - Game ends, player, who plays with "X", wins
		d. "O wins!" - Game ends, player, who plays with "O", wins
		e. "Draw" - Dame ends, no one wins
	2. Button "RST" - Restarts the game
	3. Button "AI" / "PP" - Changes game mode (more details in part III.)

	Game field contains 25 buttons.
	1. Game field button - When clicked, the value text sets to "X" or "O", depends on turn

III. GAMEMODE
	The game consists of 2 modes:
	1. "AI" mode - set by default, player plays against code (actually, it is not AI)
	2. "PP" mode - gamemode for 2 Players



Download X! O!:
https://drive.google.com/open?id=1iX5fRdKQ86UIfo-ZbKb_sH0f78xy6m0y

X! O! GitHub repository:
https://github.com/DenisKuivalainen/Tic-Tac-Toe



Made by Denis Kuivalainen
2020


