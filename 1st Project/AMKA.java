import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.lang.Character.isDigit;

public class AMKA {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String UserChoice = "";
        int UserAge;

        String AMKA;
        String Num[] = new String[11];
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime current = LocalDateTime.now();
        String Currentdate = dtf.format(current).toString();
        String UserDate;
        String UserGender;


        do {
            do {
                System.out.println("Type the AMKA number (Must be  11 characters):");
                AMKA = kb.next();
            } while (AMKA.length() != 11);

            for (int i = 0; i < 11; i++) {
                if (!isDigit(AMKA.charAt(i))) {
                    do {
                        System.out.println("The AMKA number you typed wasn't valid. Please type the correct number:");
                        AMKA = kb.next();
                        } while (AMKA.length() != 11);
                    i = -1;
                } else {
                    Num[i] = String.valueOf(AMKA.charAt(i));
                }
            }

            UserDate = AMKA.substring(4, 6);
            UserAge = CompareDates(UserDate, Currentdate);
            UserGender = FindGender(AMKA.substring(6, 10));

            System.out.println("The gender is : " + UserGender + " and the age: " + UserAge + "\n" + "In case you would like to repeat the process please press 1, " +
                    "otherwise, in order to terminate the app press any other character.");
            UserChoice = kb.next();

        }while(UserChoice.equals("1"));
    }


    static int CompareDates(String UserDate, String CurrentDate){
        int UserYear =  Integer.parseInt(UserDate);
        if(UserYear>=0 && UserYear <= 20 ){
            UserYear = 2000 + UserYear;
        }else{
            UserYear = 1900+UserYear;
        }

        int CurrentYear =  Integer.parseInt(CurrentDate.substring(6,10));
        return CurrentYear - UserYear;
    }

    static String FindGender(String code){
        int Code = Integer.parseInt(code);
        String Gender;

        if( Code % 2 == 1){
            Gender = "Male";
        }else{
            Gender = "Female";
        }
        return  Gender;
    }

}
