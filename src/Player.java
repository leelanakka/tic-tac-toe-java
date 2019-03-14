import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player {
    private String name;
    private ArrayList<Integer> moves = new ArrayList<>();
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void addMoves(int move) {
        this.moves.add(move);
    }

    public ArrayList<Integer> getMoves() {
        return this.moves;
    }

    public boolean hasWon(List<List> possibleMoves) {
        Iterator iterator = possibleMoves.iterator();
        for (int index = 0; index < 8; index++) {
            List setOfMoves = (List) iterator.next();
            if (this.moves.containsAll(setOfMoves)) {
                return true;
            }
        }
        return false;
    }
}

