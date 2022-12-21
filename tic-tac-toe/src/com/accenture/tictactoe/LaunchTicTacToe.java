package com.accenture.tictactoe;

public class LaunchTicTacToe {

	public static void main(String[] args) {

		TicTacToe ttt = new TicTacToe();
		ttt.initializePos();
		ttt.playGame();

//		TicTacToe2D ttt2D = new TicTacToe2D();
//		ttt2D.populateBoard2D();
//		// ttt2D.displayBoard();
//		boolean win = false;
//		while (!win) {
//			win = ttt2D.playGame();
//		}

	}

}
