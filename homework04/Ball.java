import java.text.DecimalFormat;
import java.lang.Math;

public class Ball{

   private static final double BALL_RADIUS          = 4.45;
   private static final double BALL_WEIGHT          = 1.0;
   private static final double FRICTION_COEFFICIENT = 0.99;
   public  static final int    X_INDEX              = 0;
   public  static final int    Y_INDEX              = 1;
   private static final int    TAB_OFFSET_INDEX     = 22;

   private boolean  isInBounds      = true;
   private boolean  Rest            = false;
   private double[] currLocation  = new double[2];
   private double[] currSpeed    = new double[2];
   private double   frictionValue   = FRICTION_COEFFICIENT;

   public Ball( double xLocation, double yLocation, double xMovement, double yMovement ) {

    currLocation[X_INDEX] = xLocation;
    currLocation[Y_INDEX] = yLocation;
    currSpeed[X_INDEX]   = xMovement;
    currSpeed[Y_INDEX]   = yMovement;

   }

    public double[] getCurrentSpeed() {

        return currSpeed;
    }

    public double getCurrentSpeed( String xy ) {
        try{
            if ( xy.equals("x") || xy.equals ("X")){
                return currSpeed[X_INDEX];
            }
            else if (xy.equals("y") || xy.equals ("Y")){
                return currSpeed[Y_INDEX];
            }
            else{
                throw new IllegalArgumentException("There was an error with the speed of the ball, exiting program");
   //             System.exit(0);
            }
        }
        catch (IllegalArgumentException i){
            System.out.println("There was an error with the input of the speed of the ball, exiting program");
            System.exit(0);
            return 0.0;
        }
    }

    public double[] getCurrentPosition( ) {
        return currLocation;
    }

    public boolean isStillMoving() {
        if (Math.abs(currSpeed[X_INDEX] * 12) < 1 && Math.abs(currSpeed[Y_INDEX] * 12) < 1 ) {
            currSpeed[X_INDEX] = 0;
            currSpeed[Y_INDEX] = 0;
            if (Rest != true) {
                System.out.println("A ball stopped moving at : X location: " + currLocation[X_INDEX] + ", Y location: " + currLocation[Y_INDEX]);
            }
        Rest = true;
        }
    return Rest;
    }

    public boolean setBallOutOfBounds( double fieldWidth, double fieldHeight ) {
         if (Math.abs(currLocation[X_INDEX]) > fieldWidth / 2 || Math.abs(currLocation[Y_INDEX]) > fieldHeight / 2) {
            System.out.print("The ball is now out of bounds");
            currSpeed[X_INDEX] = 0;
            currSpeed[Y_INDEX] = 0;
            isInBounds = false;
         }
         else{
            isInBounds = true;
         }
         return isInBounds;
      }

    public double[] updateSpeedsForOneTick( double timeSlice ) {
        currSpeed[X_INDEX] *= Math.pow(FRICTION_COEFFICIENT,timeSlice);
        currSpeed[Y_INDEX] *= Math.pow(FRICTION_COEFFICIENT,timeSlice);
        return currSpeed;
    }

    public void move( double timeSlice ) {
        currSpeed = updateSpeedsForOneTick(timeSlice);
        currLocation[X_INDEX] += (currSpeed[X_INDEX]);
        currLocation[Y_INDEX] += (currSpeed[Y_INDEX]);
    }

    public String toString() {
        DecimalFormat dfl = new DecimalFormat( "#0.000");
        DecimalFormat dfs = new DecimalFormat( "#0.0000");
        String output = "Ball #";
        return ("The Ball Speed is (X,Y): (" + dfs.format(currSpeed[X_INDEX]) + ","+ dfs.format(currSpeed[Y_INDEX]) +"). The Ball Location is (X,Y): (" + dfs.format(currLocation[X_INDEX]) + "," + dfs.format(currLocation[Y_INDEX]) + "). Is the ball at rest?: " + this.Rest);
     }
}
