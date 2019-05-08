public class Bishop extends ChessPiece
{
    public Bishop(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        moveType = "diagonal";
        pieceType = "Bishop";
    }

    public boolean validMove(ChessBoard board, int colmn, int row)
    {
        try
        {
            Math.abs((colmnPos - colmn)/(rowPos - row));
        }
        catch(ArithmeticException a)
        {
            try
            {
                throw new IllegalChessMoveException();
            }
            catch(IllegalChessMoveException e)
            {
                System.out.println(e);
            }
            System.out.println("[Bishop: only moves diagonally]");
            return false;
        }

        return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
    }

    public String marker()
    {
        return "b";
    }
}
