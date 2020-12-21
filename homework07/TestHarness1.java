import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.*;
import java.util.Random;
import java.util.Arrays;

public class TestHarness1 {
    public static void main(String args[]) {
        
        TestHarness1("hello");
            
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
    
    public static String TestHarness1(String O){
        
        //String O = "useless";
            
            System.out.println("WELCOME TO JAVA BIRTHDAY SOLVER TEST STARTING TESTS:");
            
            System.out.println("=====================================================");
            System.out.println("=====================================================");
            System.out.println("=====================================================");
            
            System.out.println("GENERATING 29 RANDOM DIGITS FROM 1-10,000 FOR ARGS[0] AND 1-10,000 FOR ARGS[1]");
            
            System.out.println("=====================================================");
            System.out.println("=====================================================");
            System.out.println("=====================================================");
            
            
            int i = 0;
            
            while (i < 30) {
            
                int RandInt1 = (int)(Math.random() * (9999 - 1 + 1) + 1);
                
                int RandInt2 = (int)(Math.random() * (9999 - 1 + 1) + 1);
                
                String Input1 = String.valueOf(RandInt1);
                
                String Input2 = String.valueOf(RandInt2);
                
                String J = Input1;
            
                String L = Input2;
            
                String Amount = experiment(L);
            
           
                String daysInYear = "365";
            
            
                String DenomTotal_1 = DenomTotal(J);
            
            
                String tNume_1 = tNume(daysInYear);
            
            
                String tDenom1_1 = tDenom1(J);
            
            
                String tDenomTotal_1 = tDenomTotal(tDenom1_1);
            
        
                String NumeTotal_1 = NumeTotal(tNume_1, tDenomTotal_1);
            
            
                String Sub_1 = Sub(NumeTotal_1, DenomTotal_1);
            
            
                String Answer = ProbabilityAnswer(Sub_1);
                
                
                System.out.println("FOR TRIAL " + i + ":");
                System.out.println("FOR THE EXACT PROBABILITY, WE ROLLED: " + J +" STUDENTS");
                System.out.println("FOR THE PROBABILITY OF SUCH WE GOT: " + Answer + ", WHICH REPRESENTS THE DECIMAL PERCENTAGE");
                System.out.println("FOR THE EXPERIMENTATION, WE ROLLED: " + L + "TRIALS");
                System.out.println("THE ANSWER OF SUCH BECAME : " + Amount + " PERCENT SHARED BIRTHDAYS");
            
                //System.out.println(Answer);
                //System.out.println(Amount);
                
              i++; 
            }
            
        
       return ""; 
    }
    
}
