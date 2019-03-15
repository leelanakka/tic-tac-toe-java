package com.step.games.tictactoe;

import java.util.*;

public class Game {
    private final Set<Integer> possibleMoves = new HashSet<>();
    private final List<List> winningChances;
    private Player[] players = new Player[2];
    private int currentPlayerIndex;

    public Game(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;
        possibleMoves.add(1);
        possibleMoves.add(2);
        possibleMoves.add(3);
        possibleMoves.add(4);
        possibleMoves.add(5);
        possibleMoves.add(6);
        possibleMoves.add(7);
        possibleMoves.add(8);
        possibleMoves.add(9);

        this.winningChances = new ArrayList<>(8);
        winningChances.add(Arrays.asList(1, 2, 3));
        winningChances.add(Arrays.asList(4, 5, 6));
        winningChances.add(Arrays.asList(7, 8, 9));
        winningChances.add(Arrays.asList(1, 4, 7));
        winningChances.add(Arrays.asList(2, 5, 8));
        winningChances.add(Arrays.asList(3, 6, 9));
        winningChances.add(Arrays.asList(1, 5, 9));
        winningChances.add(Arrays.asList(3, 5, 7));

        this.currentPlayerIndex = 0;
    }

    public boolean placeMove(int move) {
        if (this.possibleMoves.contains(move)) {
            this.possibleMoves.remove(move);
            return true;
        }
        return false;
    }

    public Map presentStatusOfBoard() {
        HashMap<Integer, Character> totalMoves = new HashMap<>(9);
        ArrayList player1Moves = players[0].getMoves();
        char player1Symbol = players[0].getSymbol();
        char player2Symbol = players[1].getSymbol();
        ArrayList player2Moves = players[1].getMoves();
        for (Object move : player1Moves) {
            totalMoves.put((Integer) move, player1Symbol);
        }

        for (Object move : player2Moves) {
            totalMoves.put((Integer) move, player2Symbol);
        }
        return totalMoves;
    }


    public boolean isWon(Player currentPlayer) {
        return currentPlayer.hasWon(winningChances);
    }

    public Player getCurrentPlayer() {
        return this.players[this.currentPlayerIndex % 2];
    }

    public void changeTurn() {
        this.currentPlayerIndex++;
    }
}
