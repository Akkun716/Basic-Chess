# Basic Chess Game

This was a project from my CS112 course that focused on exception handling and validation of moves for chess pieces. There are changes made to the project after its submission, either due to commenting and to enhance readibility and understandability or functional to build upon the project and enhance its capabilities.

##Input Files

The program is currently run using text files that specify chess pieces to be populated and pieces to be moved within the current instance of the board. Pieces are create with the following command: `[piece] [row] [column] [color]`, with row and column 0 beginning from the "top left" of the board and colors black and white represented with the int values 1 and 2. 

## Running program

The ChessDriver class is the main runner of the project, executed simply by compiling the file with `javac ChessDriver.java` and execution with `java ChessDriver [file 1] ...`. If no files are inputed by user, the program will default to running input.txt, new_input.txt, and my_input.txt.
