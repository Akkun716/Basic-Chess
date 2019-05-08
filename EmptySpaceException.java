public class EmptySpaceException extends Exception
{
    public EmptySpaceException()
    {
        super();
    }

    public String toString()
    {
        return "[You are trying to access a piece that does not exist]";
    }
}
