package com.accenture.tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	ArrayList<String> posArr = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	boolean gameEnd = false;
	int moveCount = 0;

	public void initializePos() {
		for (int i = 0; i < 9; i++) {
			posArr.add(" ");
			// posArr.add((i+1)+"");
		}
	}

	public void playGame() {

		while ((!gameEnd)&&moveCount<9) {
			displayGrid();
			gameEnd = playerMove();
			if (!gameEnd&&moveCount<9) {
				gameEnd = cpuMove();
			}
		}
		if(!gameEnd&&moveCount==9) {
			displayGrid();
			System.out.println("It was a draw!");
		}
	}

	public void displayGrid() {
		for (int i = 0; i < 9; i++) {
			if (i != 0 && i != 3 && i != 6) {
				System.out.print("|"); // in line dividers
			}
			System.out.print(posArr.get(i));

			if (i == 2 || i == 5) {
				System.out.println("\n-+-+-");// middle dividers
			}

		}
//		System.out.println(pos1 + "|" + pos2 + "|" + pos3);// line 1
//		System.out.println("-+-+-");// divider
//		System.out.println(pos4 + "|" + pos5 + "|" + pos6);// line 2
//		System.out.println("-+-+-");
//		System.out.println(pos7 + "|" + pos8 + "|" + pos9);// line 3
	}

	public boolean playerMove() {
		int input = -1;
		boolean exit = false, win = false;
		while (!exit) {
			System.out.println("\nPlayer, please enter position:");
			if (sc.hasNextInt()) {
				input = sc.nextInt();
			}

			if (input >= 1 && input <= 9) {
				input--;
				if (posArr.get(input).equals(" ")) {
					posArr.set(input, "O");
					moveCount++;
					exit = true;
				} else {
					System.out.println("Position is already occupied.");
				}
			} else {
				System.out.println("Invalid input, please try again");
			}
		}
		// input++;
		win = checkWin(++input, "O");

		if (win) {
			displayGrid();
			System.out.println("\n=Player has won!=");
		}
		return win;
	}

	public boolean cpuMove() {
		Random rand = new Random();
		boolean exit = false, win = false;
		int r = 0;
		while (!exit) {
			r = rand.nextInt(0, 9);
			if (posArr.get(r).equals(" ")) {
				posArr.set(r, "X");
				moveCount++;
				exit = true;
			}
		}
		win = checkWin(++r, "X");

		if (win) {
			displayGrid();
			System.out.println("\n=CPU has won!=");
		}

		return win;
	}

	public boolean checkWin(int movePos, String sym) {
		boolean win = false;
		// Player win check
		switch (movePos) {
		case 1:
			win = h1(sym) || v1(sym) || d1(sym);
			break;
		case 2:
			win = h1(sym) || v2(sym);
			break;
		case 3:
			win = h1(sym) || v3(sym) || d2(sym);
			break;
		case 4:
			win = h2(sym) || v1(sym);
			break;
		case 5:
			win = h2(sym) || v2(sym);
			break;
		case 6:
			win = h2(sym) || v3(sym);
			break;
		case 7:
			win = h3(sym) || v1(sym) || d2(sym);
			break;
		case 8:
			win = h3(sym) || v2(sym);
			break;
		case 9:
			win = h3(sym) || v3(sym) || d1(sym);
			break;
		}

		return win;
	}

	// check victory conditions for horizontal lines
	public boolean h1(String cm) {
		return (posArr.get(0).equals(cm) && posArr.get(1).equals(cm) && posArr.get(2).equals(cm));
	}

	public boolean h2(String cm) {
		return (posArr.get(3).equals(cm) && posArr.get(4).equals(cm) && posArr.get(5).equals(cm));
	}

	public boolean h3(String cm) {
		return (posArr.get(6).equals(cm) && posArr.get(7).equals(cm) && posArr.get(8).equals(cm));
	}

	// check victory conditions for vertical lines
	public boolean v1(String cm) {
		return (posArr.get(0).equals(cm) && posArr.get(3).equals(cm) && posArr.get(6).equals(cm));
	}

	public boolean v2(String cm) {
		return (posArr.get(1).equals(cm) && posArr.get(4).equals(cm) && posArr.get(7).equals(cm));
	}

	public boolean v3(String cm) {
		return (posArr.get(2).equals(cm) && posArr.get(5).equals(cm) && posArr.get(8).equals(cm));
	}

	// diagonal lines
	public boolean d1(String cm) {
		return (posArr.get(0).equals(cm) && posArr.get(4).equals(cm) && posArr.get(8).equals(cm));
	}

	public boolean d2(String cm) {
		return (posArr.get(2).equals(cm) && posArr.get(4).equals(cm) && posArr.get(6).equals(cm));
	}
}
