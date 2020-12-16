import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.*;
import java.util.Random;
import java.util.Arrays;

/** 
* @author Chris Jansky
*/

public class BirthdaySolver {
    public static void main(String args[]) {
        
        
            if (args.length == 0){
                
            String n = "100000";
            String k = "1000";
            
            String Amount = experiment(k);
            
           
            String daysInYear = "365";
            
            
            String DenomTotal_1 = DenomTotal(n);
            
            
            String tNume_1 = tNume(daysInYear);
            
            
            String tDenom1_1 = tDenom1(n);
            
            
            String tDenomTotal_1 = tDenomTotal(tDenom1_1);
            
        
            String NumeTotal_1 = NumeTotal(tNume_1, tDenomTotal_1);
            
            
            String Sub_1 = Sub(NumeTotal_1, DenomTotal_1);
            
            
            String Answer = ProbabilityAnswer(Sub_1);
            
            System.out.println(Answer);
            System.out.println(Amount);
                
            } else {
            
            String n = args[0];
            String k = args[1];
            
            String checkForNegN = String.valueOf(n.charAt(0)); 
            String checkForNegK = String.valueOf(k.charAt(0)); 
            
            if (checkForNegN == "-" || checkForNegK == "-"){
                
            System.out.println("inputs cannot be negative.");    
                
            } else {
                
            
            String Amount = experiment(k);
            
           
            String daysInYear = "365";
            
            
            String DenomTotal_1 = DenomTotal(n);
            
            
            String tNume_1 = tNume(daysInYear);
            
            
            String tDenom1_1 = tDenom1(n);
            
            
            String tDenomTotal_1 = tDenomTotal(tDenom1_1);
            
        
            String NumeTotal_1 = NumeTotal(tNume_1, tDenomTotal_1);
            
            
            String Sub_1 = Sub(NumeTotal_1, DenomTotal_1);
            
            
            String Answer = ProbabilityAnswer(Sub_1);
            
            System.out.println(Answer);
            System.out.println(Amount);
            
            }
         
        }
        
        
        
    }
    
    public static String factorial(String n){ //========================================
        
        int N = Integer.parseInt(n);
        
        BigInteger factorial = BigInteger.ONE; 
        
        for (int i = N; i > 0; i--) { 
            factorial = factorial.multiply(BigInteger.valueOf(i)); 
            
        } 
        
        String resultString = factorial.toString(); 
        
        return resultString;
        
    }

/** 
* calculates factorial
*/
    
    public static String DenomTotal(String n){ //========================================
        
        BigInteger Days;
        
        Days = new BigInteger("365"); 
        int exponent = Integer.parseInt(n); 
        
        //System.out.println(exponent);
        
        BigInteger result = Days.pow(exponent);
        
        String resultString = result.toString(); 
        
        return resultString;
        
        
    }

    public static String tNume(String daysInYear){ //========================================
        
        
        String resultString = factorial(daysInYear); 
        
        return resultString;
        
    }
    
    public static String tDenom1(String n){
        
        BigInteger a 
            = new BigInteger(n); 
        BigInteger b 
            = new BigInteger("365"); 
            
        BigInteger diff = b.subtract(a);
        
        String resultString = diff.toString(); 
        
        return resultString;
        
    }
    
    public static String tDenomTotal(String tDenom1){
        
        
        String resultString = factorial(tDenom1);
         
        return resultString;
        
    }
    
    public static String NumeTotal(String tNume, String tDenomTotal){
        MathContext mc 
            = new MathContext(10); 
        
        BigDecimal a 
            = new BigDecimal(tNume); 
        BigDecimal divisor 
            = new BigDecimal(tDenomTotal);
            
        BigDecimal quotient = a.divide(divisor, mc);
            
        String resultString = quotient.toString(); 
        
        return resultString;
        
    }
    
    public static String Sub(String NumeTotal, String DenomTotal){
        
        BigDecimal a 
            = new BigDecimal(NumeTotal); 
        BigDecimal b 
            = new BigDecimal(DenomTotal);
            
        MathContext mc 
            = new MathContext(10); 
        
        BigDecimal quotient = a.divide(b, mc);
            
        String resultString = quotient.toString(); 
        
        return resultString;
        
    }
    
    public static String ProbabilityAnswer(String Sub){
        
        BigDecimal a 
            = new BigDecimal("1"); 
        BigDecimal b 
            = new BigDecimal(Sub);
            
        MathContext mc 
            = new MathContext(40); 
        
        BigDecimal diff = a.subtract(b, mc);
        
        String resultString = diff.toString(); 
        
        return resultString;
        
    }
    
    public static String experiment(String k){
        
        MathContext mc 
            = new MathContext(10); 
        
        boolean[] birthdayArray = new boolean[365];
        Arrays.fill(birthdayArray, false);
        
        //int Counter = 0;
        
        BigDecimal Counter, a2, b1;
        
        BigInteger b2;
        
        //b1 = new BigInteger("0");
        
        
        b2 = new BigInteger(k);
        
        a2 = new BigDecimal(k);
        
        Counter = new BigDecimal("0");
        
        for (BigInteger a1 = BigInteger.valueOf(0); a1.compareTo(b2) < 0; a1 = a1.add(BigInteger.ONE)) {
            
            int randomBDay = (int)(Math.random() * (364 - 1 + 1) + 1);
            
            if (birthdayArray[randomBDay] == false){
                birthdayArray[randomBDay] = true;
            } else {
                Counter = Counter.add(BigDecimal.ONE);
            }
            
            
        }
        
        
        b1 = new BigDecimal("100");
        
        BigDecimal a3 = Counter.divide(a2, mc);
        
        BigDecimal Final = a3.multiply(b1, mc);
        
        //System.out.println(Final);
        
        String resultString = Final.toString(); 
        
        return resultString;
            
    } 
    
}
