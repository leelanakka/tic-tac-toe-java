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
//        game.printBoard();

        do {
//            game.printBoard();
            game.changeTurn();
            System.out.println(game.getCurrentPlayer().getName() + " please enter your choice");
            int move = scanner.nextInt();
            while (!game.mapMoves(move)) {
                System.out.println("please enter a valid input  -->");
                move = scanner.nextInt();
            }

            game.getCurrentPlayer().addMoves(move);
        } while (!game.isWon(game.getCurrentPlayer()));

//        game.printBoard();
        System.out.println(game.getCurrentPlayer().getName() + " has won the game");
    }
}
