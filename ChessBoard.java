import java.util.*;
import java.io.*;

//THE CHESS BOARD WILL MOVE THE CHESS PIECES!!! USE A GET FUNCTION TO SELECT THE PEICE AND MOVE IT
public class ChessBoard
{
    private ChessPiece[][] board;

    public ChessBoard()
    {
        board = new ChessPiece[8][8];
        for(int row = board.length - 1; row > 0; row--)
        {
            for(int colmn = 0; colmn < board[row].length - 1; colmn++)
            {
                board[row][colmn] = null;
            }
        }
    }

//Clears the board of pieces
    public void clearBoard()
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int colmn = 0; colmn < board[row].length; colmn++)
            {
                board[row][colmn] = null;
            }
        }
    }

    public void setBoard()
//Clears the board and sets the pieces in their corresponding game placements
    {
        clearBoard();
        for(int row = 0; row < board.length; row++)
        {
            //This sets the back row of the board
            if(row == 0)
            {
                for(int colmn = 0; colmn < board[row].length; colmn++)
                {
                    if(colmn == 0 || colmn == 7)
                    {
                        board[row][colmn] = new Rook(colmn, row);
                    }
                    else if(colmn == 1 || colmn == 6)
                    {
                        board[row][colmn] = new Knight(colmn, row);
                    }
                    else if(colmn == 2 || colmn == 5)
                    {
                        board[row][colmn] = new Bishop(colmn, row);
                    }
                    else if(colmn == 3)
                    {
                        board[row][3] = new Queen(colmn, row);
                    }
                    else if(colmn == 4)
                    {
                        board[row][4] = new King(colmn, row);
                    }
                    board[row][colmn].setColor(1);
                }
            }
            else if(row == 1)
            {
                for(int colmn = 0; colmn < board[row].length; colmn++)
                {
                    board[row][colmn] = new Pawn(colmn, row);
                    board[row][colmn].setColor(1);
                }
            }
            else if(row == 6)
            {
                for(int colmn = 0; colmn < board[row].length; colmn++)
                {
                    board[row][colmn] = new Pawn(colmn, row);
                    board[row][colmn].setColor(2);
                }
            }
            else if(row == 7)
            {
                for(int colmn = 0; colmn < board[row].length; colmn++)
                {
                    if(colmn == 0 || colmn == 7)
                    {
                        board[row][colmn] = new Rook(colmn, row);
                    }
                    else if(colmn == 1 || colmn == 6)
                    {
                        board[row][colmn] = new Knight(colmn, row);
                    }
                    else if(colmn == 2 || colmn == 5)
                    {
                        board[row][colmn] = new Bishop(colmn, row);
                    }
                    else if(colmn == 3)
                    {
                        board[row][3] = new Queen(colmn, row);
                    }
                    else if(colmn == 4)
                    {
                        board[row][4] = new King(colmn, row);
                    }
                    board[row][colmn].setColor(2);
                }
            }


        }
    }

//Reads the input file
    public void inputRead(String file) throws FileNotFoundException
    {
        ChessPiece piece = null;
        Scanner scan;
        scan = new Scanner(new File(file));
        String line;
        String[] lineSegment;


        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            lineSegment = line.split(" ");
            lineSegment[0] = lineSegment[0].strip();

            if(lineSegment.length < 3)
            {
                System.out.println(this);
            }
            else if(lineSegment[0].equals("move"))
            {
                piece = getPiece(Integer.valueOf(lineSegment[1]), Integer.valueOf(lineSegment[2]));
                if(piece != null)
                {
                    piece.move(this, Integer.valueOf(lineSegment[3]), Integer.valueOf(lineSegment[4]));
                }
            }
            else if(!lineSegment[0].equals("move"))
            {
                System.out.println(lineSegment[0]);
                setPiece(lineSegment[0], Integer.valueOf(lineSegment[1]), Integer.valueOf(lineSegment[2]));
                if(lineSegment.length > 3)
                {
                    piece = getPiece(Integer.valueOf(lineSegment[1]), Integer.valueOf(lineSegment[2]));
                    piece.setColor(Integer.valueOf(lineSegment[3]));
                }
            }

        }

    }


//Allows the user to set pieces on the board
    public void setPiece(String piece, int colmn, int row)
    {
        ChessPiece pieceSet = new Pawn(colmn, row);
        piece.strip();

        if(board[row][colmn] == null)
        {
            if(piece.equals("pawn"))
            {}
            else if(piece.equals("rook"))
            {
                pieceSet = new Rook(colmn, row);
            }
            else if(piece.equals("knight"))
            {
                pieceSet = new Knight(colmn, row);
            }
            else if(piece.equals("bishop"))
            {
                pieceSet = new Bishop(colmn, row);
            }
            else if(piece.equals("queen"))
            {
                pieceSet = new Queen(colmn, row);
            }
            else if(piece.equals("king"))
            {
                pieceSet = new King(colmn, row);
            }
            else
            {
                pieceSet = null;
                System.out.println("[Your input was invalid]");
            }

            board[row][colmn] = pieceSet;
        }
        else
        {
            System.out.println("[This space is already occupied]");
        }
    }

//Allows the user to remove pieces
    public ChessPiece removePiece(int colmn, int row)
    {
        ChessPiece removed = board[row][colmn];
        if(board[row][colmn] == null)
        {
            try{throw new EmptySpaceException();}
            catch(EmptySpaceException e)
            {
                System.out.println(e);
            }
        }
        else
        {
            board[row][colmn] = null;
        }

        return removed;
    }


    public ChessPiece getPiece(int colmn, int row)
    {
        if(board[row][colmn] == null)
        {
            try{throw new EmptySpaceException();}
            catch(EmptySpaceException e)
            {
                System.out.println(e);
            }
        }

        return board[row][colmn];

    }

    public ChessPiece[][] getBoard()
    {
        return board;
    }

    public boolean pathCheck(ChessPiece piece, int colmn, int row, int colmnNew, int rowNew, String moveType)
    {
        try
        {
            switch(moveType)
            {
                case "vertical":
                    int higher, lower;
                    if(row > rowNew)
                    {
                        higher = row;
                        lower = rowNew;
                    }
                    else
                    {
                        higher = rowNew;
                        lower = row;
                    }

                    for(int i = lower; i <= higher; i++)
                    {
                        if(board[i][colmn] != null && board[i][colmn] != piece)
                        {
                            try {throw new PathwayException();}
                            catch (PathwayException e)
                            {
                                System.out.println(e);
                            }
                            return false;
                        }
                    }

                    return true;

                case "horizontal":
                    int rightmost, leftmost;
                    if(colmn > colmnNew)
                    {
                        rightmost = colmn;
                        leftmost = colmnNew;
                    }
                    else
                    {
                        rightmost = colmnNew;
                        leftmost = colmn;
                    }

                    for(int i = leftmost; i <= rightmost; i++)
                    {
                        if(board[row][i] != null && board[row][i] != piece)
                        {
                            try {throw new PathwayException();}
                            catch (PathwayException e)
                            {
                                System.out.println(e);
                            }
                            return false;
                        }
                    }

                    return true;

                case "diagonal":
                    int downRow, downColmn, upRow, upColmn;
                    boolean downDiagonal;
                    if(row < rowNew && colmn > colmnNew)
                    {
                        downRow = row;
                        downColmn = colmn;
                        upRow = rowNew;
                        upColmn = colmnNew;
                        downDiagonal = true;
                    }
                    else if(row > rowNew && colmn < colmnNew)
                    {
                        downRow = rowNew;
                        downColmn = colmnNew;
                        upRow = row;
                        upColmn = colmn;
                        downDiagonal = true;
                    }
                    else if(row > rowNew && colmn > colmnNew)
                    {
                        downRow = rowNew;
                        downColmn = colmnNew;
                        upRow = row;
                        upColmn = colmn;
                        downDiagonal = false;
                    }
                    else
                    {
                        downRow = row;
                        downColmn = colmn;
                        upRow = rowNew;
                        upColmn = colmnNew;
                        downDiagonal = false;
                    }

                    for(int i = 0; i <= (upRow - downRow); i++)
                    {
                        if(downDiagonal)
                        {
                            if(board[downRow + i][downColmn - i] != null && board[downRow + i][downColmn - i] != piece)
                            {
                                try{throw new PathwayException();}
                                catch(PathwayException e)
                                {
                                    System.out.println(e);
                                    return false;
                                }
                            }
                        }
                        else
                        {
                            if(board[downRow + i][downColmn + i] != null && board[downRow + i][downColmn + i] != piece)
                            {
                                try{throw new PathwayException();}
                                catch(PathwayException e)
                                {
                                    System.out.println(e);
                                    return false;
                                }
                            }
                        }
                    }

                    return true;
            }
        }
        catch(Exception a)
        {
            try
            {
                throw new OutOfBoundsException();
            }
            catch(OutOfBoundsException e)
            {
                System.out.println(e);
            }
        }

        return false;
    }

    public void playGame()
    {
        boolean again = true;
        int playerTurn = 2;
        Scanner userInput = new Scanner(System.in);

        while(again)
        {
            if(playerTurn == 1)
            {
                playerTurn++;
            }
            else
            {
                playerTurn--;
            }
        }
    }

    public String toString()
    {
        String output = "";
        for(int row = board.length - 1; row >= 0; row--)
        {
            output += "=" + row + "= ";
            for(int colmn = 0; colmn < board[row].length; colmn++)
            {
                if(board[row][colmn] == null)
                {
                    output += "[ ] ";
                }
                else
                {
                    output += "[" + board[row][colmn].marker() + "] ";
                }
            }
            output += "\n";
        }

        output += "=== ";
        for(int colmn = 0; colmn < board[0].length; colmn++)
        {
            output += "=" + colmn + "= ";
        }

        return output += "\n";
    }

//This display method would be utilized for a regular game of chess
    public String display()
    {
        String output = "";
        String letters = "abcdefgh";
        for(int row = board.length - 1; row >= 0; row--)
        {
            output += "=" + (row + 1) + "= ";
            for(int colmn = 0; colmn < board[row].length; colmn++)
            {
                if(board[row][colmn] == null)
                {
                    output += "[ ] ";
                }
                else
                {
                    output += "[" + board[row][colmn].marker() + "] ";
                }
            }
            output += "\n";
        }

        output += "=== ";
        for(int colmn = 0; colmn < board[0].length; colmn++)
        {
            output += "=" + letters.charAt(colmn) + "= ";
        }

        return output += "\n";
    }
}