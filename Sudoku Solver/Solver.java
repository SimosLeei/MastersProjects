import java.io.*;
import java.util.Scanner;


public class Solver {

    private static int structureSelection ;
    private static String path;
    public static void main(String[] args) {

        for(int i = 0; i<args.length;i++){
            if(i==0){
            path = args[i];
            }else{
                structureSelection = Integer.parseInt(args[i]);

            }
        }
        if(structureSelection==1||structureSelection==2||structureSelection==3||structureSelection==4) {

            ReadSudoku();
        }else{
            System.out.println("Invalid structure selection. Please enter in the terminal:\n" +
                    "1. For ArrayList as Stack\n"+
                    "2. For ArrayList as Queue\n"+
                    "3. For Stack as Stack\n"+
                    "4. For LinkedList as Queue\n");

        }


    }

    static void ReadSudoku() {

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
            int[][] sudokuArray = new int[9][9];
            int counter =0;
            while (sc.hasNextLine()) {
                for (int i = 0; i < sudokuArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; j++) {
                        sudokuArray[i][j] = Integer.parseInt(line[j]);
                        counter++;
                    }
                }
            }
            if(counter==81) {
                Sudoku sudoku = new Sudoku(sudokuArray, structureSelection);


                switch (structureSelection) {
                    case 1:
                        System.out.println("\nSolving with ArrayList Class as Stack\n");
                        sudoku.solveHandler(1);
                        break;
                    case 2:
                        System.out.println("\nSolving with ArrayList Class as Queue\n");
                        sudoku.solveHandler(2);
                        break;
                    case 3:
                        System.out.println("\nSolving with Stack Class\n");
                        sudoku.solveHandler(3);
                        break;
                    case 4:
                        System.out.println("\nSolving with LinkedList as Queue\n");
                        sudoku.solveHandler(4);
                        break;
                }
            }else{
                System.out.println("Invalid Sudoku. Please try again with a valid one.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found. Please create a puzzle.txt in the same folder this app is in. Exiting...");
        }
    }
}