import java.io.FileNotFoundException;

public class ChessDriver
{
    public static void main(String[] args)
    {
        ChessBoard board = new ChessBoard();
        ChessPiece piece;
        boolean again = true;

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