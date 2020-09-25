public class PiSolver
{

    public static void main(String[] args) 
    {
        int UserInput;
        int i;
        int Throws = 0;
        int Hits = 0;
        double x, y;

        if (args.length > 0)
        {
            try
            {
                    UserInput = Integer.parseInt(args[0]);

                    for (i = 0; i < UserInput ; i++)
                    {
                        x = Math.random();
                        y = Math.random();

                        Throws++;
                        if ( (x * x) + (y * y) <= 1 )
                        {
                            Hits++;
                        }
                    }
                System.out.println("Pi/4 = " + ((double)Hits/ (double)Throws));
                System.out.println("Pi = " + 4 * ((double)Hits/ (double)Throws));
            }
            catch (NumberFormatException e)
            {
                System.err.println ("Argument " + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
    }
}        
