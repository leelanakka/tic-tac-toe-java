import java.util.*;

public class Game {
    private final Set<Integer> possibleMoves = new HashSet<>();

    private Player[] players = new Player[2];
    private final List<List> winningChances;
    private char[] board = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

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
    }


//    public void printBoard() {
//        System.out.print("\n -------------\n");
//        for (int i = 0; i < this.board.length; i++) {
//            System.out.print(" | " + this.board[i]);
//            if (i % 3 == 2) {
//                System.out.print(" |\n -------------\n");
//            }
//        }
//    }

    public boolean mapMoves(int move) {
        if (this.possibleMoves.contains(move)) {
            this.possibleMoves.remove(move);
            return true;
        }
        return false;
    }


    public boolean isWon(Player currentPlayer) {
        return currentPlayer.hasWon(winningChances);
    }

    public Player getCurrentPlayer() {
        return this.players[0];
    }

    public void changeTurn() {
        Player temp = players[0];
        players[0] = players[1];
        players[1] = temp;
    }
}
