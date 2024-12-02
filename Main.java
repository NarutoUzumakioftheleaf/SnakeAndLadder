//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to this game! \n");
        int number=(int)(Math.random()*6)+1;
        System.out.println("your Dice is rolling...");
        System.out.println("Hey you get number "+ number);
        int option=(int) (Math.random()*3)+1;
        int position=0;
        switch(option){
            case 1-> System.out.println("You choose No Play and remains at position "+position);
            case 2-> {
                position+=number;
                System.out.println("You choose Ladder and move ahead to position "+ position);
            }
            default-> {
                position-=number;
                if(position<0)
                    position=0;
                System.out.println("You choose snake and moved back to position " + position);
            }
        }
    }
}