
### Solver Class 

Is the client. Gets the path and data structure selection arguments from the user throught the command line.
Then calling the static method *ReadSudoku()* which reads the sudoku puzzle from the given file and lastly based on 
users data structure selection calls the method *solveHandler(selection)* of the Sudoku class.

### Sudoku Class

This class contains a constuctor for the creation of Sudoku objects as well as the methods that solve the puzzles.
Through the solveHandler and the variable given by the user, the method selects the structure that will solve the sudoku.

All the structures use the same methods to solve the puzzle, the difference lies in the way the handle the puzzles (which are 
in the form of an 2D array). 
For example, Stack takes the array which is at the top of it, while Queue takes the array which is located at the start of 
the Arraylist.
