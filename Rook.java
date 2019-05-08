public class Rook extends ChessPiece
{
    public Rook(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        pieceType = "Rook";
    }

    public boolean validMove(ChessBoard board, int colmn, int row)
    {
        if(colmn != colmnPos && row != rowPos)
        {
            try
            {
                throw new IllegalChessMoveException();
            }
            catch(IllegalChessMoveException e)
            {
                System.out.println(e);
            }

            System.out.println("[Rook: only moves vertically OR horizontally]");
            return false;
        }
        else
        {
            if(colmn == colmnPos)
            {
                moveType = "vertical";
                return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
            }
            else if(row == rowPos)
            {
                moveType = "horizontal";
                return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
            }

            return false;
        }
    }

    public String marker()
    {
        return "r";
    }
}