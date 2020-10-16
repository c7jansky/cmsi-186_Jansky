import java.text.DecimalFormat;
import java.lang.Math;

public class SoccerSim {
    
    private static final double DEFAULT_FIELD_WIDTH   = 1000.0;
    private static final double DEFAULT_FIELD_HEIGHT  = 1000.0;
    private static final double DEFAULT_POLE_X_POS    = 321.0;
    private static final double DEFAULT_POLE_Y_POS    = 543.0;
    private static final double DEFAULT_TIME_SLICE    = 1.0;
 
    private boolean  initialReport      = true;
    private boolean  stillMoving        = true;
    private boolean  timeSliceDefault   = true;
    boolean Collision = false;
    private double   timeSlice          = DEFAULT_TIME_SLICE;
    private double   totalTimeSecs      = 0.0;
    private double[] fieldSizes         = null;
    private double[] poleLocation       = null;
    private int      ballCount          = 0;
 
    private Ball[]   soccerBalls        = null;
    private Clock    c                  = null;

    private static final String USAGE_MESSAGE         = "\n  Usage:" +
         "\n    java SoccerSim <ball-parameters> ... <ball-parameters> [timeslice]" +
         "\n      where EACH <ball-parameters> field is a 4-tuple of the values:" +
         "\n            starting-x, starting-y, start-speed-x, start-speed-y" +
         "\n" +
         "\n    try running with three soccer balls: <10 10 1 1>, <18 18 -1 -1>, and <311 311 1 1>" +
         "\n    this should produce a collision between the first two balls in about four iterations." +
         "\n\n  Please try again.";
    Clock clock = new Clock();
    private int 1collision = 0;
    private int 2collision = 0;
    double [] locationOfCollision1 = null;
    double [] locationOfCollision2 = null;
    public SoccerSim() {

    }

    public void validateArgsAndSetupSim( String arguments[] ) throws NumberFormatException, IllegalArgumentException {
        int ballcount = 0;

        if( 0 == arguments.length || 2 == (arguments.length % 4) || 3 == (arguments.length % 4) || 1 == arguments.length ) {
            try{
                throw new IllegalArgumentException(USAGE_MESSAGE);
            }
            catch (IllegalArgumentException iae){
                System.out.println(USAGE_MESSAGE);
                System.exit(0);
            }
            

        } 
        else{
            if( 1 == (arguments.length % 4) ) {
                    
                try{
                    timeSlice = Clock.validateTimeSliceArg(arguments[arguments.length -1]);
                }
                catch (Exception e) {
                        system.out.println(USAGE_MESSAGE);
                        System.exit(0);
                }
            }

         ballCount = (int)Math.floor(arguments.length/4);
         soccerBalls = new Ball[ballCount];

         for ( int i = 0; i < soccerBalls.length; i++ ){
            try {
              soccerBalls[i] = new Ball(Double.parseDouble(arguments[i * 4]),
                                        Double.parseDouble(arguments[i * 4 + 1]),
                                        Double.parseDouble(arguments[i * 4 + 2]),
                                        Double.parseDouble(arguments[i * 4 + 3]));
            } catch ( NumberFormatException nfe ){
              System.out.println("Error changing the arguments to doubles, please enter the correct arguments in the proper next time, shutting down");
              System.exit(0);
            }

        }
        //
    }

    public void report() {
      clock.tick(timeSlice);
      clock.toString();
        for ( int i = 0; i < soccerBalls.length; i++ ){
            this.soccerBalls[i].move(timeSlice);
            String output = soccerBalls[i].toString();
            int ballLabel = i + 1;
            System.out.println(clock.toString()+ "|Ball #" + (i+1) +" :" + output );
        }
    }

    public void simUpdate() {
        report();
        boolean moveStatus = atLeastOneBallStillMoving();
        Collision();
        if (moveStatus == false || Collision == true) {
            if (moveStatus == false){
                System.out.print( "All balls have stopped moving. This occurred at:"+ clock.toString() + "");
                System.exit(0);
            }
            if (Collision = true){
            System.out.println("There was a collision between " + ballsCollided[0] + " and ball " + ballsCollided[1] + "at (" + locationOfCollision1[0] + "," + locationOfCollision1[1] + "), and (" + locationOfCollision2[0] + "," + locationOfCollision2[1] + ") at: " + clock.toString());
            System.exit(0);
            }
        }
    }

    public int[] collisionCheck() {
        for ( int i = 0; i < soccerBalls.length - 1; i++ ) {
            double radius = 4.45;
            double distance;
            double [] 1ball = soccerBalls[i].getPosition();
            double [] 2ball = soccerBalls[j].getPosition();
            double 1ballx = 1ball[0];
            double 1bally = 1ball[1];
            double 2ballx = 2ball[0];
            double 2bally = 2ball[1];
            distance = Math.sqrt((2ballx - 1ballx)*(2ballx - 1ballx) + (2bally - 1bally)*(2bally - 1bally));
            distance = distance*12;
            if ( distance <= radius * 2) {
                1collision = i;
                2collision = j;
                ballsCollided[0] = i;
                ballsCollided[1] = j;
                locationOfCollision1 = soccerBalls[ballsCollided[0]].getPosition();
                locationOfCollision2 = soccerBalls[ballsCollided[1]].getPosition();
                Collision = true;
            }
        }
        for ( int j = i + 1; j < soccerBalls.length; j++) {
            double radius = 4.45
            double distance;
            double [] 1ball = soccerBalls[i].getPosition();
            double [] 2ball = soccerBalls[j].getPosition();
            double 1ballx = 1ball[0];
            double 1bally = 1ball[1];
            double 2ballx = 2ball[0];
            double 2bally = 2ball[1];
            distance = Math.sqrt((2ballx - 1ballx)*(2ballx - 1ballx) + (2bally - 1bally)*(2bally - 1bally));
            distance = distance*12;
            if ( distance <= radius * 2) {
                1collision = i;
                2collision = j;
                ballsCollided[0] = i;
                ballsCollided[1] = j;
                locationOfCollision1 = soccerBalls[ballsCollided[0]].getPosition();
                locationOfCollision2 = soccerBalls[ballsCollided[1]].getPosition();
                Collision = true;
                    break outer;
            }
        }
        
        return ballsCollided;
    }

    public boolean atLeastOneBallStillMoving() {
        boolean [] moveArray = new boolean [soccerBalls.length];
        for ( int i = 0; i < soccerBalls.length; i++ ) {
            if (soccerBalls[i].isStillMoving() == true || soccerBalls[i].isBallOutOfBounds(DEFAULT_PLAYGROUND_HEIGHT,DEFAULT_PLAYGROUND_HEIGHT) == true){
                moveArray[i] = false;
            }
            else{
                moveArray[i] = true;
            }
        }
        int checker = 0;
        for (int l = 0; l < moveArray.length; l++){
            if ( moveArray[l] == false){
                checker ++;
            }
        }
        if (checker < moveArray.length){
            return true;
        }
        return false;
    }

    public static void main( String args[] ) {
        System.out.println( "\n  Hello, world, from the SoccerSim program!" );
        SoccerSim ss = new SoccerSim();
        try {
           ss.validateArgsAndSetupSim( args );
        }
        catch( NumberFormatException nfe ) {
           System.out.println( USAGE_MESSAGE );
           System.exit( 1 );
        }
        catch( IllegalArgumentException iae ) {
           System.out.println( USAGE_MESSAGE );
           System.exit( 2 );
        }
  
        ss.report();
        while( true ) {
           ss.simUpdate();
        }
     }
}
