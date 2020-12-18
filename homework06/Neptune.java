import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.*;

public class Neptune {


    public Neptune(){

    }

    public static void main( String[] args ) {
    
        BrobInt c = new BrobInt("299792458"); //Speed of light

        BrobInt c_c = new BrobInt("-299792458");

        BrobInt a = new BrobInt( args[0] ); // User Input (acceleration)

        BrobInt t1b = new BrobInt( "11186" );

        BrobInt t1_b = new BrobInt( "-11186" );

        BrobInt q4 = new BrobInt("4");

        BrobInt q2 = new BrobInt("2");

        BrobInt q0 = new BrobInt("0");

        BrobInt q23500 = new BrobInt( "23500" );
        
        BrobInt qD1 = new BrobInt( "3600" );

        BrobInt q_D1 = new BrobInt( "-3600" );

        BrobInt qD2 = new BrobInt( "1800" );

        BrobInt a2 = new BrobInt( a.multipliedBy(q2) ); // 2 * a

        BrobInt c2 = new BrobInt( c.dividedBy( q2 )); // c / 2

        BrobInt c_2 = new BrobInt( c_c.dividedBy( q2 )); // -(c / 2)

        BrobInt c22 = new BrobInt( c2.dividedBy( c2 )); // (c / 2 )^ 2

        BrobInt aDiv2 = new BrobInt( a.dividedBy( q2 )); // a / 2

        BrobInt c1800 = new BrobInt( c.multipliedBy(qD2) ); // c * 1800

        BrobInt a3600 = new BrobInt( a.multipliedBy(qD1) ); // a * 3600
        
        BrobInt a_3600 = new BrobInt( a.multipliedBy(q_D1) ); // a * -3600

        BrobInt q2q23500 = new BrobInt( q23500.multipliedBy(q23500) ); // 23500 * 23500

        //BrobInt t2b

        //Starting Math for T1  -----------------------------------------------------------------------

        BrobInt t1b2 = new BrobInt( t1b.multipliedBy(t1b) ); // 11,186 ^ 2

        BrobInt t14a = new BrobInt( q4.multipliedBy(aDiv2) ); // 4 * (a / 2)

        BrobInt t1cd = new BrobInt( c22.minus(t1b2) ); // (c/2)^2 - (11,186)^2

        BrobInt t1c = new BrobInt( t1cd.dividedBy(a2) ); // c22 - t1b2 / a2

        BrobInt t14ac = new BrobInt( t14a.multipliedBy(t1c) ); 

        String t1b4ac = t1b2.plus(t14ac);

        BigInteger sqrtt1b4ac = new BigInteger( t1b4ac );

        BigInteger squareRoot = sqrtt1b4ac.sqrt();

        String t1Sqrt = squareRoot.toString();

        BrobInt t1tl = new BrobInt(t1Sqrt);

        BrobInt t1t = new BrobInt( t1_b.multipliedBy(t1tl));

        BrobInt T1 = new BrobInt( t1t.dividedBy(a3600) );

        // End of Math for T1

       //Math for T2=============================================================

       BrobInt t2nn1 = new BrobInt( q2.multipliedBy(c22) );

       BrobInt t2nn12 = new BrobInt( t2nn1.minus(t1b2) ); 

       BrobInt t2nn = new BrobInt( t2nn12.minus(q2q23500) ); 

       BrobInt t2r = new BrobInt( t2nn.dividedBy(a2) );

       BrobInt t2n = new BrobInt( q0.minus(t2r) ); 

       BrobInt T2 = new BrobInt( t2n.dividedBy(c1800));

       //End of Math for T2

       //Math for T3 ===========================================================
       
       BrobInt t3nn = new BrobInt( q2q23500.minus(c22) ); 

       BrobInt t3c = new BrobInt( t3nn.dividedBy(a2) ); 

       BrobInt t34ac = new BrobInt( t14a.multipliedBy(t3c) ); 

       BrobInt t3r = new BrobInt( c22.minus(t34ac) ); 

       String t3rs = c22.minus(t34ac);

       BigInteger sqrtt3r = new BigInteger( t3rs );
       
       BigInteger squareRoot3 = sqrtt3r.sqrt();
       
       //BigInteger squareRoot3 = t3rs.sqrt();

       String t3Sqrt = squareRoot3.toString();

       BrobInt t3tr = new BrobInt(t3Sqrt);

       BrobInt t3t = new BrobInt( c_2.multipliedBy(t3tr));

       BrobInt T3 = new BrobInt( t3t.dividedBy(a_3600) );

       //End of Math for T3

       // Math to find Time==================

       BrobInt T12 = new BrobInt( T1.plus(T2) );
       
       BrobInt T123 = new BrobInt( T12.plus(T3) );

       BrobInt FinalTime  = new BrobInt( T123.multipliedBy(q2) );

       BrobInt a_min = new BrobInt( "5106" );

       int Check = a.compare(a_min);

       if (Check < 0){
           System.out.println("Please make sure your input is equal to 5107 or greater.");
       } else {

           System.out.println(" The amount of time it took to travel from Earth to Neptune and back, given that we accelerated and decelerated into atmospheres at " + a.toString() + "m/s,");
           System.out.println(" took approximately " + FinalTime.toString() + " seconds!");

       }
        
        







    }

}
