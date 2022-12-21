package com.accenture.tictactoe;

import java.util.Scanner;

public class TicTacToe2D {
	char board[][] = new char[3][3];
	Scanner sc = new Scanner(System.in);
	int moveCount = 0;

	public void populateBoard2D() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public void displayBoard() {
		for (int i = 0; i < board.length; i++) {
			if (i != 0) {
				System.out.println("\n-+-+-");// middle dividers
			}
			for (int j = 0; j < board[i].length; j++) {
				if (j != 0) {
					System.out.print("|");
				}
				System.out.print(board[i][j]);
			}
		}
	}

	public boolean playGame() {
		String curr = "";
		boolean win = false;
		if (moveCount % 2 == 0) {
			curr = "Player 1";
		} else {
			curr = "Player 2";
		}
		displayBoard();
		win = move(curr);
		return win;
	}

	public boolean move(String type) {
		int input = -1;
		boolean exit = false, win = false;
		char sym = ' ';
		if (type.equals("Player 1")) {
			sym = 'X';
		} else {
			sym = 'O';
		}
		while (!exit) {

			System.out.println("\n" + type + ", please enter position:");
			if (sc.hasNextInt()) {
				input = sc.nextInt();
			}

			if (input >= 1 && input <= 9) {
				input--;
				int x = input / 3, y = input % 3;
				if (board[x][y] == ' ') {
					board[x][y] = sym;
					moveCount++;
					exit = true;
				} else {
					System.out.println("Position is already occupied.");
				}
			} else {
				System.out.println("Invalid input, please try again");
			}
		}

		win = checkWin(input, sym);

		if (win) {
			displayBoard();
			System.out.println("\n=" + type + " has won!=");
		}
		return win;
	}

	public boolean checkWin(int input, char sym) {
		boolean win = false;
		int row = -1, col = -1;
		switch (input) {
		case 0:
			row = 0;
			col = 0;
			break;
		case 1:
			row = 0;
			col = 1;
			break;
		case 2:
			row = 0;
			col = 2;
			break;
		case 3:
			row = 1;
			col = 0;
			break;
		case 4:
			row = 1;
			col = 1;
			break;
		case 5:
			row = 1;
			col = 2;
			break;
		case 6:
			row = 2;
			col = 0;
			break;
		case 7:
			row = 2;
			col = 1;
			break;
		case 8:
			row = 2;
			col = 2;
			break;
		default:
			break;
		}

		if (!win) {
			win = checkRow(row, col, sym);
		}

		if (!win) {
			win = checkCol(row, col, sym);
		}
		
		if(input==5) {
			if(!win) {
				checkLDiag(row, col, sym);
			}
			
			if(!win) {
				checkRDiag(row, col, sym);
			}
		}

		return win;
	}

	boolean checkRow(int row, int col, char sym) {
		boolean win = false;

		int c2 = col + 1, c3 = col + 2;

		if (c2 >= board[row].length) {
			c2 = col - 2;
			c3 = col - 1;
		} else if (c3 >= board[row].length) {
			c3 = col - 1;
		}
		char[] bRow = board[row];

		if (bRow[col] == sym && bRow[c2] == sym && bRow[c3] == sym) {
			win = true;
		}

		return win;
	}

	boolean checkCol(int row, int col, char sym) {
		boolean win = false;

		int r2 = row + 1, r3 = row + 2;

		if (r2 >= board[row].length) {
			r2 = row - 2;
			r3 = row - 1;
		} else if (r3 >= board[row].length) {
			r3 = row - 1;
		}

		if (board[row][col] == sym && board[r2][col] == sym && board[r3][col] == sym) {
			win = true;
		}

		return win;
	}

	boolean checkLDiag(int row, int col, char sym) {
		boolean win = false;

		int r2 = row + 1, r3 = row + 2;
		int c2 = col + 1, c3 = col + 2;

		if (r2 >= board[row].length) {
			r2 = row - 2;
			r3 = row - 1;
			c2 = col - 2;
			c3 = col - 1;
		} else if (r3 >= board[row].length) {
			r3 = row - 1;
			c3 = col - 1;
		}
		if (board[row][col] == sym && board[r2][c2] == sym && board[r3][c3] == sym) {
			win = true;
		}
		return win;
	}

	boolean checkRDiag(int row, int col, char sym) {
		boolean win = false;
		int r2 = row + 1, r3 = row + 2;
		int c2 = col - 1, c3 = col - 2;

		if (r2 >= board[row].length) {
			r2 = row - 1;
			c2 = col + 1;
			r3 = row - 2;
			c3 = col + 2;
		}else if(r3 >= board[row].length){
			r3 = row - 2;
			c3 = col + 2;
		}
		if (board[row][col] == sym && board[r2][c2] == sym && board[r3][c3] == sym) {
			win = true;
		}
		return win;
	}
}
