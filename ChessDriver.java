import java.io.FileNotFoundException;

public class ChessDriver
{
    public static void main(String[] args)
    {
        ChessBoard board = new ChessBoard();
        ChessPiece piece;
        boolean again = true;

        /* User can enter a specific file to view result */
        if(args.length != 0) {
            for(String file: args) {
                try
                {
                    board.inputRead(file);
                }
                catch(FileNotFoundException e)
                {
                    System.out.printf("[File %s was not found]", file);
                }

                board.clearBoard();
                System.out.println(board);
            }
        } else {
        /* Default runner if no files are inputed */
            try
            {
                board.inputRead("input.txt");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("[File was not found]");
            }

            board.clearBoard();
            System.out.println(board);
    
            try
            {
                board.inputRead("new_input.txt");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("[File was not found]");
            }


            board.clearBoard();

            try
            {
                board.inputRead("my_input.txt");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("[File was not found]");
            }
            System.out.println();
        }
    }
}
