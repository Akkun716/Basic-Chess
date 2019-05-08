public class OutOfBoundsException extends ArrayIndexOutOfBoundsException
{
    public OutOfBoundsException()
    {
        super();
    }

    public String toString()
    {
        return "[Final position input not on board]";
    }
}
