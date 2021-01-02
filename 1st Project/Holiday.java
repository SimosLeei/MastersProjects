import java.util.Scanner;

public class Holiday {
    public static void main(String[] args) {
        int destination;
        String winner = "";
        String loser = "";
        Scanner keyboard = new Scanner(System.in);
        int Vote1 = 0;
        int Vote2 = 0;
        int Vote3 = 0;
        int ValidVotes = 0;


        for (int i = 0; i < 20; i++) {
            System.out.println("Please vote the ideal destination. Press 1 for Mykonos , 2 for Santorini and 3 for Rodos");
            destination = keyboard.nextInt();

            if (destination == 1) {
                Vote1++;
                System.out.println(" ****************** \n You voted Mykonos! \n ******************\n");
            } else if (destination == 2) {
                Vote2++;
                System.out.println(" ****************** \n You voted Santorini!\n ******************\n");
            } else if (destination == 3) {
                Vote3++;
                System.out.println(" ****************** \n You voted Rodos!\n ******************\n");
            }else{
                System.out.println(" ****************** \n Your vote was not valid!\n ******************\n");
            }
        }

        ValidVotes = Vote1+Vote2+Vote3;

        double Vote1Per = ((double)Vote1/ValidVotes) *100;

        double Vote2Per = ((double)Vote2/ValidVotes) *100;
        double Vote3Per = ((double)Vote3/ValidVotes) *100;
        System.out.println("Mykonos canvassed " + Vote1 +" votes and has the "+ String.format("%.2f",Vote1Per)+ " % of the sum of valid votes!");
        System.out.println("Santorini canvassed " + Vote2 +" votes and has the "+ String.format("%.2f",Vote2Per) + " % of the sum of valid votes!");
        System.out.println("Rodos canvassed " + Vote3 +" votes and has the "+ String.format("%.2f",Vote3Per) + " % of the sum of valid votes!\n");


        int max  = Vote1;
        winner = "Mykonos";
        loser = "Mykonos";
        int min = Vote1;

        if (max>Vote2){
            min = Vote2;
            loser = "Santorini";
        }else{
            max = Vote2;
            winner = "Santorini";
        }

        if( max>Vote3 ){
            if(min > Vote3)
            min = Vote3;
            loser = "Rodos";
        }else{
            max = Vote3;
            winner = "Rodos";
        }

        if(Vote1==Vote2 && Vote2==Vote3){
            System.out.println("The outcome resulted in triple tie with " + Vote1 + " votes each destination");

        }else if(Vote1 == Vote2 && Vote2 >Vote3){
            System.out.println("There is a tie between the destinations : Mykonos and Santorini with "+Vote1+ " votes," +
                    " while the least ideal destination is " + loser + " with " + min +" votes."  );
        }else if (Vote2 == Vote3 && Vote3 >Vote1){
            System.out.println("There is a tie between the destinations : Santorini and Rodos with "+Vote2+ " votes," +
                    " while the least ideal destination is " + loser + " with " + min +" votes."  );
        }else if (Vote1 == Vote3 && Vote3 >Vote2) {
            System.out.println("There is a tie between the destinations : Mykonos and Rodos with "+Vote1+ " votes," +
                    " while the least ideal destination is " + loser + " with " + min +" votes."  );
        }else{
        System.out.println( winner + " has been voted as the ideal destination " + " with " + max +" votes, " +
                "while the least ideal destination is: " + loser + " with " + min +" votes.");
        }
    }
}

