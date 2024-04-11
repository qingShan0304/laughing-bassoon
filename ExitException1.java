package q2;

public class ExitException1 extends Exception
{
    String message;
    public ExitException1()
    {
    }

    public ExitException1(String message)
    {
        System.out.println(message);

    }
}
