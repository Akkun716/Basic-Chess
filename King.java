public class King extends ChessPiece
{
    public King(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        pieceType = "King";
    }

    public boolean validMove(ChessBoard board, int colmn, int row)
    {
        int diagonDif;
        try
        {
            diagonDif = Math.abs((colmnPos - colmn)/(rowPos - row));
        }
        catch(ArithmeticException e)
        {
            diagonDif = 0;
        }
        int horizonDif = Math.abs(colmnPos - colmn);
        int verticalDif = Math.abs(rowPos - row);

        if(diagonDif == 1)
        {
            moveType = "diagonal";
            if(Math.abs(colmnPos - colmn) == 1 && Math.abs(rowPos - row) == 1)
            {
                return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
            }
        }
        else if(colmn == colmnPos && verticalDif == 1)
        {
            moveType = "vertical";
            return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
        }
        else if(row == rowPos && horizonDif == 1)
        {
            moveType = "horizontal";
            return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
        }

        try
        {
            throw new IllegalChessMoveException();
        }
        catch(IllegalChessMoveException e)
        {
            System.out.println(e);
        }

        System.out.println("[King: only moves once space in any direction]");
        return false;
    }

    public String marker()
    {
        return "K";
    }
}
