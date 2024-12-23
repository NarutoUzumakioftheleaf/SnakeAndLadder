public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to this game! \n");

        int position = 0;
        final int WINNING_POSITION = 100;

        while (position < WINNING_POSITION) {
            int number = (int) (Math.random() * 6) + 1; // Roll the dice
            System.out.println("Your dice is rolling...");
            System.out.println("Hey you get number " + number);

            int option = (int) (Math.random() * 3) + 1; // Choose an option

            switch (option) {
                case 1 -> System.out.println("You chose No Play and remain at position " + position);
                case 2 -> {
                    position += number;
                    if (position > WINNING_POSITION) {
                        position -= number; // Prevent overshooting
                        System.out.println("You overshoot the winning position! Stay at position " + position);
                    } else {
                        System.out.println("You chose Ladder and moved ahead to position " + position);
                    }
                }
                default -> {
                    position -= number;
                    if (position < 0) {
                        position = 0; // Restart from 0 if below 0
                        System.out.println("You chose Snake and moved back to position 0");
                    } else {
                        System.out.println("You chose Snake and moved back to position " + position);
                    }
                }
            }

            System.out.println("Current Position: " + position + "\n");
        }

        System.out.println("Congratulations! You reached the winning position: " + WINNING_POSITION);
    }
}
