import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Math.random;
import java.util.Arrays;
import java.util;

public class HighRoll {
    
    public static void main( final String args[] ){
        System.out.println( "\n Welcome to the High Roll Dice Game!\n" );
        System.out.println( " Try and see how high of a dice score you can get!" );
        System.out.println( "Press the '1' key to roll all of the dice.");
        System.out.println( "Press the '2' key to roll a single dice, type in the 2 first, then type the dice number that you wish to reroll.");
        System.out.println( "Press the '3' key to calculate the score for this set.");
        System.out.println( "Press the '4' key to save the score as a high score.");
        System.out.println( "Press the '5' key to display the high score.");
        System.out.println( "Press the 'q' key to quit the program." );

        private int HighScore;

        final BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
        while( true ) {
            System.out.print( "Type a number from one to six>>" );
            final String inputLine = null;
            try {
                inputLine =  input.readLine();
                if( 0 == inputLine.length() ) {
                    System.out.println("enter some text!:");
                }

                System.out.println( " You typed: " + inputLine );
                if "1" == inputLine.charAt(0) ){
                    ds.roll
                }

                if "2" == inputLine.charAt(0) {
                    ds.rollIndividual
                    ds.getIndividual
                }

                if "3" == inputLine.charAt(0) {
                    ds.sum
                }

                if "4" == inputLine.charAt(0) {
                    roundScore == DiceSet.sum;
                    if roundScore > HighScore {
                        HighScore = roundScore;
                    }

                }

                if "5" == inputLine.charAt(0) {
                    System.out.println( highscore );
                }

                if( 'q' == inputLine.charAt(0) ) {
                    break;
                }

                if( 'Q' == inputline.charAt(0) ) {
                    System.out.println("Please type the 'Q' lowercased");
                }
            }
            catch( IOException ioe ) {
                System.out.println( "Caught IOException" );
                System.out.println( "Please type a valid number or letter." );
            }
            }
        }
    }


    public class Die {

        private int sides;
        private int value;
        private final int MINIMUM_SIDES = 4;

        public Die( final int nSides ){
            sides = nSides;
            sides = ( Integer.parseInt( args[1] ) );
        }

        public int roll(){
            value = (int)(math.random() * sides + 1);
        }

        public int getValue(){
            return value;
        }

        public Stirng toString(){
            return (" ["+ Integer.toString(value) + "] ");
        }

        public static String toString(){
            return (" ["+ Integer.toString(value) + "] ");
        }

        public static void main( final String[] args){
            system.out.println( "How many sides would you like on the dice you roll?" );
            if (int)(args [1] <= 4){
                sides = new sides( Integer.parseInt( args[1] ) );  
            }
            else {
                system.out.println (" Any number less than or equal to 4 is not an acceptable dice.");
            }
            
            
            
            
        }
    }

    public class DiceSet {

        private int count;
        private int sides;
        private Die[] ds = null;

        public DiceSet( final int k, final int n ){
            ds = new Die[ count ];
            for( int i = 0; i < count; i++){
                ds[i] = new Die [ sides ];
            }
        }

        public int sum(){
            int sum = 0;
            for (int i = 0; i < ds.length; i++){
                sum = sum + ds[i];
            return sum;
        }

        public void roll(){
                for (int i = 0; i < ds.length; i++){
                    Die.roll;
                    ds[i] = new Die ();
                    ds[i] = int Die.getValue()
                }    
        }

        public void rollIndividual( int i ){
                Die.roll;
                ds[(int)args[1]] = Die.getValue
        }

        public int getIndividual( int i ){
            return DiceSet.rollIndividual;
        }

        public String toString(){
            for (int i = 0; i < ds.length; i++){
                String result = " [" + ds[i] + "] ";
                return result;
            }    
        }

        public static String toString( DiceSet ds){
            for (int i = 0; i < ds.length; i++){
                String result = " [" + ds[i] + "] ";
                return result;
            }    
        }

        public boolean isIdentical( DiceSet ds ){
            return true;
        }

        public static void main( String[] args ){
            count = new count( Integer.parseInt( args[0] ) );
            sides = new sides( Integer.parseInt( args[1] ) );
        }

    }
}
