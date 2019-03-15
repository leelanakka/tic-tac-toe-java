package com.step.games.tictactoe;

import java.util.*;

public class Game {
    private final Set<Integer> possibleMoves = new HashSet<>();
    private final List<List<Integer>> winningChances;
    private Player[] players = new Player[2];
    private int currentPlayerIndex;

    public Game(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;
        for (int index = 1; index <= 9; index++) {
            possibleMoves.add(index);
        }

        this.winningChances = getWinningChances();
        this.currentPlayerIndex = 0;
    }

    private List<List<Integer>> getWinningChances() {
        List<List<Integer>> dummyName = new ArrayList<>(8);
        dummyName.add(Arrays.asList(1, 2, 3));
        dummyName.add(Arrays.asList(4, 5, 6));
        dummyName.add(Arrays.asList(7, 8, 9));
        dummyName.add(Arrays.asList(1, 4, 7));
        dummyName.add(Arrays.asList(2, 5, 8));
        dummyName.add(Arrays.asList(3, 6, 9));
        dummyName.add(Arrays.asList(1, 5, 9));
        dummyName.add(Arrays.asList(3, 5, 7));
        return dummyName;
    }

    public boolean placeMove(int move) {
        getCurrentPlayer().addMoves(move);
        return this.possibleMoves.remove(move);
    }

    public boolean isValidMove(int move) {
        return this.possibleMoves.contains(move);
    }

    public Map<Integer, Character> presentStatusOfBoard() {
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


    public boolean isGameFinished() {
        return getCurrentPlayer().hasWon(this.winningChances);
    }

    public Player getCurrentPlayer() {
        return this.players[this.currentPlayerIndex % 2];
    }

    public void changeTurn() {
        this.currentPlayerIndex++;
    }
}
