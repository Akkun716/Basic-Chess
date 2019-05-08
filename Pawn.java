public class Pawn extends ChessPiece
{
    private boolean frstMove;

    public Pawn(int x, int y)
    {
        colmnPos = x;
        rowPos = y;
        color = 0;
        frstMove = true;
        moveType = "vertical";
        pieceType = "Pawn";
    }

    public boolean validMove(ChessBoard board, int colmn, int row)
    {
        if(colmn == colmnPos)
        {
            int moveDif = Math.abs(row - rowPos);
            if(frstMove)
            {
                if(color == 2)
                {
                    if(colmn == colmnPos && row < rowPos && moveDif <= 2 && moveDif > 0)
                    {
                        if(board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType))
                        {
                            frstMove = false;
                            return true;
                        }
                    }
                }
                else
                {
                    if(colmn == colmnPos && row > rowPos && moveDif <= 2 && moveDif > 0)
                    {
                        if(board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType))
                        {
                            frstMove = false;
                            return true;
                        }
                    }
                }
            }
            else
            {
                if(color == 2)
                {
                    if(colmn == colmnPos && row < rowPos && moveDif == 1)
                    {
                        return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
                    }
                }
                else
                {
                    if(colmn == colmnPos && row > rowPos && moveDif == 1)
                    {
                        return board.pathCheck(this, colmnPos, rowPos, colmn, row, moveType);
                    }
                }
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

        System.out.println("[Pawn: only moves forward 1 space unless 1st move, can move 2]");
        return false;
    }

    public String marker()
    {
        return "p";
    }
}
