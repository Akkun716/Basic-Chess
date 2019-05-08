public class IllegalChessMoveException extends Exception
{
    public IllegalChessMoveException()
    {
        super();
    }

    public String toString()
    {
        return "[That move is invalid for this piece]";
    }
}
