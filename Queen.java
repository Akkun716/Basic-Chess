public class Queen extends ChessPiece
{
    public Queen(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        pieceType = "Queen";
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
            return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
        }
        else if(colmn == colmnPos)
        {
            moveType = "vertical";
            return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
        }
        else if(row == rowPos)
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

        System.out.println("[Queen: moves vertically, horizontally, or diagonally]");
        return false;
    }

    public String marker()
    {
        return "Q";
    }
}
