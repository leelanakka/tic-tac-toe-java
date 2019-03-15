package com.step.games.tictactoe;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter player1 name \t");
        String player1Name = scanner.next();
        System.out.println("please enter player2 name\t");
        String player2Name = scanner.next();
        Player player1 = new Player(player1Name, 'X');
        Player player2 = new Player(player2Name, 'O');

        System.out.println(player2Name + " your symbol is " + "O");
        System.out.println(player1Name + " your symbol is " + "X");
        Game game = new Game(player1, player2);

        do {
            game.changeTurn();
            printBoard(game.presentStatusOfBoard());
            System.out.println(game.getCurrentPlayer().getName() + " please enter your choice");
            int move = scanner.nextInt();
            while (!game.placeMove(move)) {
                System.out.println("please enter a valid input ");
                move = scanner.nextInt();
            }

            game.getCurrentPlayer().addMoves(move);
        } while (!game.isWon(game.getCurrentPlayer()));

        printBoard(game.presentStatusOfBoard());
        System.out.println(game.getCurrentPlayer().getName() + " has won the game");
    }

    public static void printBoard(Map moves) {
        System.out.print("\n -------------\n");
        for (int index = 1; index <=9; index++) {
            if (moves.get(index) == null) {
                moves.put(index, " ");
            }
            System.out.print(" | " + moves.get(index));
            if (index % 3 == 0) {
                System.out.print(" |\n -------------\n");
            }
        }
    }
}
