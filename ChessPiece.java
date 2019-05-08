abstract class ChessPiece
{
    protected int colmnPos;
    protected int rowPos;
    protected int color;
    protected String moveType;
    protected String pieceType;

    public int getRowPos()
    {
        return rowPos;
    }

    public int getColmnPos()
    {
        return colmnPos;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int colorSet)
    {
        if(colorSet < 3)
        {
            color = colorSet;
        }
        else
        {
            System.out.println("[The entry was not valid]");
        }
    }

    public abstract boolean validMove(ChessBoard board, int colmn, int row);

    public void move(ChessBoard board, int colmn, int row)
    {
        if(validMove(board, colmn, row))
        {
            board.getBoard()[row][colmn] = this;
            board.getBoard()[rowPos][colmnPos] = null;
            int temp1 = rowPos;
            int temp2 = colmnPos;
            rowPos = row;
            colmnPos = colmn;

            System.out.println(pieceType + ": (" + temp1 + ", " + temp2 + ") (" + colmn + ", " + row + ")");
            System.out.println("Moved! (" + temp2 + ", " + temp1 + ") (" + colmn + ", " + row + ")");
            System.out.println(board);
        }
        else
        {
            System.out.println(pieceType + ": (" + colmnPos + ", " + rowPos + ") (" + colmn + ", " + row + ")");
            System.out.println("Failed... (" + colmnPos + ", " + rowPos + ") (" + colmn + ", " + row + ")");
            System.out.println(board);
        }

        System.out.println("===========================\n");

    }

    public abstract String marker();

    public String toString()
    {
        return pieceType + " [" + getColmnPos() + ", " + getRowPos() + "]";
    }

}