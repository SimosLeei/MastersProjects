
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Sudoku {

   public  ArrayList<int[][]> sudokuPuzzles = new ArrayList<>();
   public Stack<int[][]> sudokuStack = new Stack<>();
   public LinkedList<int[][]> sudokulinkedList = new LinkedList<>();

    public Sudoku(int[][] sudoku, int structure) {

        switch (structure) {
            case 1:
                this.sudokuPuzzles.add(sudoku);
                break;

            case 2:
                this.sudokuPuzzles.add(sudoku);
                break;
            case 3:
                this.sudokuStack.add(sudoku);
                break;
            case 4:
                this.sudokulinkedList.add(sudoku);
                break;

        }
    }

    public void solveHandler(int structure){
        switch(structure) {
            case 1: solveALS();
                break;
            case 2: solveALQ();break;
            case 3: solveST();break;
            case 4: solveLLQ();break;
        }

    }


    public void solveALS() { //ALS = ArrayList as Stack ==  last in first out //(Ι)
        int row;
        int col;
        while (!this.sudokuPuzzles.isEmpty()) {
            ArrayList<Integer> cells = new ArrayList();
            int[][] sud = this.sudokuPuzzles.get(this.sudokuPuzzles.size() - 1);

            cells = hasEmptyCells(sud);
            if(!(cells ==null)){
                row = cells.get(0);
                col = cells.get(1);
                this.sudokuPuzzles.remove(this.sudokuPuzzles.size() - 1);

                for (int num = 1; num <= 9; num++) {
                    if (isValid(sud, row, col, num)) {
                        sud[row][col] = num;
                        this.sudokuPuzzles.add(CopyNewArray(sud));
                        sud[row][col]=0;
                    }

                }
            }else{
                display(sud);
                System.exit(2);
            }
        }
        System.out.println("There is no solution for the given sudoku!\n ****Please Try again with another sudoku****");

    }

    public void solveALQ() {
        int row;
        int col;
        while (!this.sudokuPuzzles.isEmpty()) {
            ArrayList<Integer> cells = new ArrayList();
            int[][] sud = this.sudokuPuzzles.get(0);

            cells = hasEmptyCells(sud);
            if(!(cells ==null)){
                row = cells.get(0);
                col = cells.get(1);
                this.sudokuPuzzles.remove(0);

                for (int num = 1; num <= 9; num++) {
                    if (isValid(sud, row, col, num)) {
                        sud[row][col] = num;
                        this.sudokuPuzzles.add(CopyNewArray(sud));
                        sud[row][col]=0;
                    }

                }
            }else{
                display(sud);
                System.exit(2);
            }
        }
        System.out.println("There is no solution for the given sudoku!\n ****Please Try again with another sudoku****");

    } //idia i arraylist, diafora oti vazoyme sto telos (opos kai prin, bgazoyme apo tin arxi <-- Oura

    public void solveST() {
        int row;
        int col;
        while (!this.sudokuStack.isEmpty()) {
            ArrayList<Integer> cells = new ArrayList();
            int[][] sud = this.sudokuStack.pop();

            cells = hasEmptyCells(sud);
            if(!(cells ==null)){
                row = cells.get(0);
                col = cells.get(1);

                for (int num = 1; num <= 9; num++) {
                    if (isValid(sud, row, col, num)) {
                        sud[row][col] = num;
                        this.sudokuStack.push(CopyNewArray(sud));
                        sud[row][col]=0;
                    }

                }
            }else{
                display(sud);
                System.exit(3);
            }
        }
        System.out.println("There is no solution for the given sudoku!\n ****Please Try again with another sudoku****");
    } //xrisi tis domis Stack

    public void solveLLQ() {
        int row;
        int col;
        while (!this.sudokulinkedList.isEmpty()) {
            ArrayList<Integer> cells = new ArrayList();
            int[][] sud = this.sudokulinkedList.getFirst();

            cells = hasEmptyCells(sud);
            if(!(cells ==null)){
                row = cells.get(0);
                col = cells.get(1);
                this.sudokulinkedList.removeFirst();

                for (int num = 1; num <= 9; num++) {
                    if (isValid(sud, row, col, num)) {
                        sud[row][col] = num;
                        this.sudokulinkedList.addLast(CopyNewArray(sud));
                       // display(sud);
                        sud[row][col]=0;
                    }

                }
            }else{
                display(sud);
                System.exit(4);
            }
        }
        System.out.println("There is no solution for the given sudoku!\n ****Please Try again with another sudoku****");
    } //xrisi LinkedList, eisagogi sti mia akri eksagogi apo tin alli <-- Fifo





    static boolean isInRow(int[][] puzzle, int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    static boolean isInColumn(int[][] puzzle, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    static boolean isInBlock(int[][] puzzle, int row, int col, int num) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (puzzle[i][j] == num)
                    return true;

        return false;
    }

    static boolean isValid(int[][] puz, int row, int col, int num) {
        return !isInBlock(puz, row, col, num) && !isInColumn(puz, col, num) && !isInRow(puz, row, num);
    }

    private ArrayList<Integer> hasEmptyCells(int[][] arr) {
        ArrayList<Integer> emptyCell = new ArrayList<Integer>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (arr[row][col] == 0) {
                    emptyCell.add(row);
                    emptyCell.add(col);
                    return emptyCell;
                }
            }
        }
        return null;
    }


        static void display( int[][] sudokuPuzzle){

            for (int[] ints : sudokuPuzzle) {
                for (int col = 0; col < sudokuPuzzle.length; col++) {
                    System.out.print(ints[col]);
                }
                System.out.println();
            }
            System.out.println();
        }

        static int[][] CopyNewArray ( int[][] sudoku){
            int[][] newSudoku = new int[sudoku.length][sudoku.length];
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    newSudoku[row][col] = sudoku[row][col];
                }
            }
            return newSudoku;
        }


    }
