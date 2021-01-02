import java.util.Scanner;

public class URLsVisitedApp {


    public static void main(String[] args) {
       String FileName;

       System.out.print("Which file you would like to analyze? ");
       Scanner input = new Scanner(System.in);
       FileName = input.next();
       FileAnalyzer(FileName);

    }

    public static void FileAnalyzer(String filename){
        URLsVisited myURLs = new URLsVisited(filename);


        myURLs.printAll();

        myURLs.removeDuplicates();
        myURLs.printAll();

    }
}
