public class Knight extends ChessPiece
{
    public Knight(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        pieceType = "Knight";
    }

    public boolean validMove(ChessBoard board, int colmn, int row)
    {
        int horizonDif = Math.abs(colmn - colmnPos);
        int rowDif = Math.abs(row - rowPos);

        if(horizonDif == 2 && rowDif == 1)
        {
            if(board.getBoard()[row][colmn] == null)
            {
                return true;
            }
        }
        else if(rowDif == 2 && horizonDif == 1)
        {
            if(board.getBoard()[row][colmn] == null)
            {
                return true;
            }
        }

        try
        {
            throw new IllegalChessMoveException();
        }
        catch(IllegalChessMoveException e)
        {
            System.out.println(e);
        }

        System.out.println("[Knight: only moves in an L-shape (two spaces one direction and one adjacent]");
        return false;
    }

    public String marker()
    {
        return "k";
    }
}
