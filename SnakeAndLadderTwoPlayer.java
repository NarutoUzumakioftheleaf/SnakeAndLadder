import java.util.*;

public class SnakeAndLadderTwoPlayer {

    private static final int WINNING_POSITION = 100;
    private static final Map<Integer, Integer> ladders = new HashMap<>();
    private static final Map<Integer, Integer> snakes = new HashMap<>();

    static {
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(78, 98);
        ladders.put(87, 94);

        snakes.put(16, 6);
        snakes.put(46, 25);
        snakes.put(49, 11);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(74, 53);
        snakes.put(89, 68);
        snakes.put(92, 88);
        snakes.put(95, 75);
        snakes.put(99, 80);
    }

    private static class Player {
        String name;
        int position = 0;
        int diceRolls = 0;

        Player(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Two-Player Snake and Ladder Game!");

        // Add two players
        System.out.print("Enter name for Player 1: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Enter name for Player 2: ");
        Player player2 = new Player(scanner.nextLine());

        Player currentPlayer = player1;
        boolean gameWon = false;

        while (!gameWon) {
            System.out.println(currentPlayer.name + "'s turn. Press Enter to roll the dice.");
            scanner.nextLine();

            boolean playAgain;
            do {
                int dice = rollDice();
                currentPlayer.diceRolls++;
                System.out.println(currentPlayer.name + " rolled a " + dice);

                currentPlayer.position += dice;

                if (currentPlayer.position > WINNING_POSITION) {
                    currentPlayer.position -= dice;
                    System.out.println(currentPlayer.name + " needs to roll exactly " + (WINNING_POSITION - currentPlayer.position) + " to win.");
                    playAgain = false;
                } else {
                    if (ladders.containsKey(currentPlayer.position)) {
                        System.out.println("Yay! " + currentPlayer.name + " climbed a ladder from " + currentPlayer.position + " to " + ladders.get(currentPlayer.position));
                        currentPlayer.position = ladders.get(currentPlayer.position);
                        playAgain = true; // Play again for a ladder
                    } else if (snakes.containsKey(currentPlayer.position)) {
                        System.out.println("Oops! " + currentPlayer.name + " got bitten by a snake and slid from " + currentPlayer.position + " to " + snakes.get(currentPlayer.position));
                        currentPlayer.position = snakes.get(currentPlayer.position);
                        playAgain = false;
                    } else {
                        playAgain = false;
                    }
                }

                System.out.println(currentPlayer.name + " is now at position " + currentPlayer.position);

                if (currentPlayer.position == WINNING_POSITION) {
                    gameWon = true;
                    System.out.println("\nCongratulations, " + currentPlayer.name + "! You have won the game in " + currentPlayer.diceRolls + " rolls.");
                    break;
                }
            } while (playAgain);

            // Switch player
            if (!gameWon) {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }

        // Report final stats
        System.out.println("\nGame Summary:");
        System.out.println(player1.name + " rolled the dice " + player1.diceRolls + " times and ended at position " + player1.position);
        System.out.println(player2.name + " rolled the dice " + player2.diceRolls + " times and ended at position " + player2.position);

        scanner.close();
    }

    private static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
