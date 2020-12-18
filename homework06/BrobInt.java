import java.util.Arrays;
import java.util.*;

public class BrobInt {
    
    
    public String operationValue;
  
    
    BrobInt(String Value) 
    { 
        operationValue = Value;
        
        //this.operationValue = value;
    } 
    
    

    public static void main(String[] args) {
        String firstNum = args[0];
        String secondNum = args[1];
        
         BrobInt N1 = new BrobInt(firstNum);
        
         BrobInt N2 = new BrobInt(secondNum);
        
        
        //System.out.println(plus(firstNum, secondNum));
        
        //System.out.println(N1.plus(N2));
        //System.out.println(N1.minus(N2));
        //System.out.println(N1.multipliedBy(N2));
        //System.out.println(N1.dividedBy(N2));
        
        //System.out.println(Num1.makeStrings());
    }

//=====================================================================================

    public String toString()
    {
        
        
        String one = this.operationValue;
        
        return one;
        
     
    }
    
    public int compare(BrobInt Num){

        String x = this.toString();
        
        String y = Num.toString();
        
        int Answer = compareTo(x, y);
        
        return Answer;

    }
    
    public String plus(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        String Answer = sum(x, y);
        
        return Answer;
        
        
    }
    
    public String minus(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        String Answer = difference(x, y);
        
        return Answer;
        
        
    }
    
    public String multipliedBy(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        String Answer = product(x, y);
        
        return Answer;
        
        
    }
    
    public String dividedBy(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        String Answer = quotient(x, y);
        
        return Answer;
        
        
    }
    
    public String modulus(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        String Answer = remainder(x, y);
        
        return Answer;
        
        
    }

    public Boolean equals(BrobInt Num){
        
        String x = this.toString();
        
        String y = Num.toString();
        
        Boolean Answer = equalTo(x, y);
        
        return Answer;
    }
    
    public BrobInt ZERO(){
        
        BrobInt ZERO = new BrobInt("0");
        
        return ZERO;  
    }

    public BrobInt ONE(){
        
        BrobInt ONE = new BrobInt("1");
        
        return ONE;  
    }

    public BrobInt TEN(){
        
        BrobInt TEN = new BrobInt("10");
        
        return TEN;  
    }
   
    public String sum(String Num1, String Num2) {
        
        boolean num1IsNeg = false, num2IsNeg = false;
        boolean negEnd = false;
       
       if (Num1.length() < 8 && (Num2.length()) < 9){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I + Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
            } else {
                
                if (!Num1.matches("[-]?\\d++") || !Num2.matches("[-]?\\d++")) {
                    throw new IllegalArgumentException();
                }
                
                
                
                if (Num1.charAt(0) == '-') {
                    num1IsNeg = true;
                    Num1 = Num1.substring(1);
                }
                
                
                if (Num2.charAt(0) == '-') {
                    num2IsNeg = true;
                    Num2 = Num2.substring(1);
                }
                
                
                StringBuilder outcome = new StringBuilder();
                
                
                Num1 = new StringBuffer(Num1).reverse().toString();
                Num2 = new StringBuffer(Num2).reverse().toString();
                
                char[] num1Arr = Num1.toCharArray();
                char[] num2Arr = Num2.toCharArray();
                
                
                
                if (Num1.length() > Num2.length()) {
                    num2Arr = Arrays.copyOf(num2Arr, num1Arr.length);
                    Arrays.fill(num2Arr, Num2.length(), num1Arr.length, '0');
        
                } else {
                    num1Arr = Arrays.copyOf(num1Arr, num2Arr.length);
                    Arrays.fill(num1Arr, Num1.length(), num2Arr.length, '0');
                }
                
                
                int Carry = 0;
               
       
       
                if (num1IsNeg ^ num2IsNeg) {
                    for (int i = num1Arr.length - 1; i >= 0; i--) {
                        if(num1Arr[i] == num2Arr[i]) {
                            continue;
                        } else if (num1Arr[i] < num2Arr[i]) {
                            char[] tempNumberArray = num1Arr;
                            num1Arr = num2Arr;
                            num2Arr = tempNumberArray;
                            negEnd = true;
                        } 
                        break;
                    }
                    
                    
                } else if(num1IsNeg && num2IsNeg) {
                    negEnd = true;
                }
                
                
                
                for (int i = 0; i < num1Arr.length || i < num2Arr.length; i++) {
                    
                    if (!(num1IsNeg ^ num2IsNeg)) {
                        int numSum = Carry + changeToInt(num1Arr[i]) + changeToInt(num2Arr[i]);
                        int addDigits = numSum % 10;
                        Carry = numSum >= 10 ? 1 : 0;
                        outcome.append(addDigits);
                    
                    
                    } else {
                        int numSub = changeToInt(num1Arr[i]) - changeToInt(num2Arr[i]);
                        if (numSub < 0) {
                            numSub = (10 + changeToInt(num1Arr[i])) - changeToInt(num2Arr[i]);
                            num1Arr[i+1]--;
                        }
                        outcome.append(numSub);
                    }
                }
                outcome.append(Carry);
                
                
                String Answer = outcome.reverse().toString();
                
                
                do {
                    Answer = Answer.substring(1);
                    if(Answer.length() == 1 && Answer.charAt(0) == '0') {
                        break;
                    }
                }  while (Answer.charAt(0) == '0');
                
                
                if (negEnd != true && negEnd) {
                    Answer = "-" + Answer;
                }
                return Answer;
            }
    }
    //-------------------------------------------------------
    
    public String difference(String Num1, String Num2) {
        
       
        if (!Num1.matches("[-]?\\d++") || !Num2.matches("[-]?\\d++")) { //Works!
            throw new IllegalArgumentException();
        }
        
        
        if (Num1.charAt(0) == '-' && Num2.charAt(0) == '-') { 
            
            //System.out.println("here");
            if (Num1.length() < 8 && (Num2.length()) < 8){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I - Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
            } else {
                
                int Num1End = Num1.charAt(Num1.length() - 1);
                int Num2End = Num2.charAt(Num2.length() - 1);
                
                if (Num1.length() > Num2.length() || Num1End > Num2End){
                    
                        //System.out.println("here");
                        
                        Num2 = Num2.substring(1);
                        
                        String Solution = sum(Num1, Num2);
                        
                        Solution = "-" + Solution;
                        return Solution;
                        
                    } else {
                        
                        //System.out.println("hero");
                        
                        Num2 = Num2.substring(1);
                        String Solution2 = sum(Num1, Num2);
                        Solution2 = Solution2.substring(1);
                        return Solution2;
                    }
            }
        }
        
        
        
        else if (Num1.charAt(0) == '-' && Num2.charAt(0) != '-') { // i.e. -5 - 5 = -10
            
            //System.out.println("here");
            
            if (Num1.length() < 8 && (Num2.length() ) < 8){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I - Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
            } else {
                String Solution = "";
                
                    
                Num1 = Num1.substring(1);
                    
                    
                Solution = "-" + sum(Num1, Num2);
                    
                if (Solution == "-0"){
                        
                    Solution.substring(1);
                    return Solution;
                        
                } else {
                    
                    return Solution;
                    
                        
                }
            }
                
            
        }
        
        
        else if (Num1.charAt(0) != '-' && Num2.charAt(0) == '-') { // i.e. 5 - -5 = 10
            
            //System.out.println("here");
            
            
            //System.out.println(Num2);
            if (Num1.length() < 8 && (Num2.length() ) < 8){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I - Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
            } else {
                Num2 = Num2.substring(1);
                
                String Solution = sum(Num1, Num2);
            
                return Solution;
            }
        }
        
        
        
        else if (Num1.charAt(0) != '-' && Num2.charAt(0) != '-') {
            
           if (Num1.length() < 8 && (Num2.length() ) < 8){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I - Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
            } else { 
                Num2 = "-" + Num2;
                return sum(Num1, Num2);
            }
            
        } else {
            
            return ("error");
        }
    
        
    }  
    
    //--------------------------------------------------------
  
public String product(String Num1, String Num2) {
    
    Boolean num1IsNeg = false;
    Boolean num2IsNeg = false;
    
    if (Num1.charAt(0) == '-') {
        num1IsNeg = true;
        Num1 = Num1.substring(1);
    }
                
                
    if (Num2.charAt(0) == '-') {
        num2IsNeg = true;
        Num2 = Num2.substring(1);
    }
       
    int lenNum1 = Num1.length(); 
    int lenNum2 = Num2.length(); 
    if (lenNum1 == 0 || lenNum2 == 0) 
        return "0"; 
  
    int result[] = new int[lenNum1 + lenNum2]; 
  
      
    int number1Index = 0;  
    int number2Index = 0;  
      
    
    for (int i = lenNum1 - 1; i >= 0; i--) 
    { 
        int carry = 0; 
        int firstNumber = Num1.charAt(i) - '0'; 
  
        number2Index = 0;  
          
    
        for (int j = lenNum2 - 1; j >= 0; j--) 
        { 
            
            int secondNumber = Num2.charAt(j) - '0'; 
  
            
            int sum = firstNumber * secondNumber + result[number1Index + number2Index] + carry; 
  
            
            carry = sum / 10; 
  
            result[number1Index + number2Index] = sum % 10; 
  
            number2Index++; 
        } 
  
        
        if (carry > 0) 
            result[number1Index + number2Index] += carry; 
  
        
        number1Index++; 
    } 
  
    
    int i = result.length - 1; 
    while (i >= 0 && result[i] == 0) 
    i--; 
  
    
    if (i == -1) 
    return "0"; 
  
    
    String holdString = ""; 
      
    while (i >= 0) 
        holdString += (result[i--]); 
    
    if (num1IsNeg && num2IsNeg){
        
        return holdString;
        
    } else if (num1IsNeg && num2IsNeg == false) {
        
        return "-" + holdString;
        
    } else if (num2IsNeg && num1IsNeg == false) {
    
        return "-" + holdString;

    } else {
        
        return holdString;
    }
    
} 

//---------------------------------------------------------------------

public String quotient(String Num1, String Num2) {
    
    if (Num1.length() < 5 && (Num2.length()) < 5){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I / Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
    } else {        
        
        int Compare = compareTo(Num1, Num2);
        
        if (Compare == 0){
            
            return "1";
            
        } else if (Num2 == "0"){
            
            System.out.println("IllegalArgumentException: You Cannot Divide by Zero");
            
            return "End Program";
            
        } else if (Compare == -1){
            
            return "0";
            //Same as multiplication, watch later!!!!!!!!!!!!!!!!!!
        }
        
        String Num3 = "";
        int n = Num2.length();
        
        for (int i = 0; i < n; i++){
            char numEx = Num1.charAt(i);
            
            String numExtract = String.valueOf(numEx);
            
            Num3 = Num3 + numExtract;
            
        }
        
        int nNew = n;
        
        
        
        for (int i = 0; i < n; i++){
            int numComNum3 = Num3.charAt(i);
            
            int numComNum2 = Num2.charAt(i);
            
            if (numComNum2 > numComNum3){
            
                nNew = n+1;
                Num3 = "";
                break;
                
                
            }
        }
        
        if (nNew != n){
            
            Num3 = "";
            
            for (int i = 0; i < nNew; i++){
                char numEx = Num1.charAt(i);
            
                String numExtract = String.valueOf(numEx);
            
                Num3 = Num3 + numExtract;
            
            }
        }
        
        
        
        String Diff = "";
        int quotientCurr = 0;
        String QuotientHolder = "";
        int L1 = Num1.length();
        int L2 = Num2.length();
        
        
            while (nNew <= L1){
        
                quotientCurr = 0;
               
               
               
                while (compareTo(Num3, Num2) == 1 || compareTo(Num3, Num2) == 0){
                
                    
                    Num3 = difference(Num3, Num2);
                    
                    
                    
                    quotientCurr = quotientCurr + 1;
                    
                    if (Num3 != "0" && Num3 == Num2){
                    
                        quotientCurr = quotientCurr + 1;
                        Num3 = "0";
                        
                    } 

                    //nNew = nNew + 1;
                }
                
                
               
                
                nNew = nNew + 1;
                
                
                String Insert = String.valueOf(quotientCurr);
                

                
                QuotientHolder = QuotientHolder + Insert;
                
                if (nNew - 1 == L1){
                    
                    break;
                }
                
                //Num3 = product(Num3, "10");
                
                
                
                //QuotientHolder = product(QuotientHolder, "10");
                
                
                String NextDigit = Num1.substring( nNew -1, nNew );
                
                
                
                Num3 = Num3 + NextDigit;
                
               
                
                String Check = sum(Num3, "0");
                
                Num3 = Check;
                
            }
        
        return QuotientHolder;
            
    }
}
//---------------------------------------------------------------------

public String remainder(String Num1, String Num2) {
    
    if (Num1.length() < 5 && (Num2.length()) < 5){
                
                int Num1I = Integer.parseInt(Num1);
                int Num2I = Integer.parseInt(Num2);
                int sum1 = Num1I / Num2I;
                String Solu = String.valueOf(sum1);
                return (Solu);
                
    } else {        
        
        int Compare = compareTo(Num1, Num2);
        
        if (Compare == 0){
            
            return "1";
            
        } else if (Num2 == "0"){
            
            System.out.println("IllegalArgumentException: You Cannot Divide by Zero");
            
            return "End Program";
            
        } else if (Compare == -1){
            
            return "0";
            //Same as multiplication, watch later!!!!!!!!!!!!!!!!!!
        }
        
        String Num3 = "";
        int n = Num2.length();
        
        for (int i = 0; i < n; i++){
            char numEx = Num1.charAt(i);
            
            String numExtract = String.valueOf(numEx);
            
            Num3 = Num3 + numExtract;
            
        }
        
        int nNew = n;
        
        for (int i = 0; i < n; i++){
            int numComNum3 = Num3.charAt(i);
            
            int numComNum2 = Num2.charAt(i);
            
            if (numComNum2 > numComNum3){
            
                nNew = n+1;
                Num3 = "";
                break;
                
                
            }
        }
        
        if (nNew != n){
            
            Num3 = "";
            
            for (int i = 0; i < nNew; i++){
                char numEx = Num1.charAt(i);
            
                String numExtract = String.valueOf(numEx);
            
                Num3 = Num3 + numExtract;
            
            }
        }
        
        
        
        String Diff = "";
        int quotientCurr = 0;
        String QuotientHolder = "";
        int L1 = Num1.length();
        int L2 = Num2.length();
        
        
        while (nNew <= L1){
        
                quotientCurr = 0;
               
               
               
                while (compareTo(Num3, Num2) == 1 || compareTo(Num3, Num2) == 0){
                
                    
                    Num3 = difference(Num3, Num2);
                    
                    
                    
                    quotientCurr = quotientCurr + 1;
                    
                    if (Num3 != "0" && Num3 == Num2){
                    
                        quotientCurr = quotientCurr + 1;
                        Num3 = "0";
                        
                    } 

                    //nNew = nNew + 1;
                }
                
                
               
                
                nNew = nNew + 1;
                
                
                String Insert = String.valueOf(quotientCurr);
                

                
                QuotientHolder = QuotientHolder + Insert;
                
                if (nNew - 1 == L1){
                    
                    break;
                }
                
                //Num3 = product(Num3, "10");
                
                
                
                //QuotientHolder = product(QuotientHolder, "10");
                
                
                String NextDigit = Num1.substring( nNew -1, nNew );
                
                
                
                Num3 = Num3 + NextDigit;
                
               
                
                String Check = sum(Num3, "0");
                
                Num3 = Check;
                
            }
        
        return Num3;
            
    }
}
//---------------------------------------------------------------------
public int compareTo(String Num1, String Num2){
    
    int Num1End = Num1.charAt(Num1.length() - 1);
    int Num2End = Num2.charAt(Num2.length() - 1);
    int L1 = Num1.length() - 1;
    int L2 = Num2.length() - 1;
    int Num1NegCheck = Num1.charAt(0);
    int Num2NegCheck = Num2.charAt(0);
    
    while (String.valueOf(Num1NegCheck) == "0"){
        Num1.substring(1);
    }
    
    while (String.valueOf(Num2NegCheck) == "0"){
        Num2.substring(1);
    }
    
    int k = 0;
    
    if ( L1 > L2 ) {
        
        if (String.valueOf(Num1NegCheck) == "-"){
            
            k = -1;
            
        } else {
            
            k = 1;
            
        }
         
    } else if ( L1 < L2 ) {
        
        if (String.valueOf(Num2NegCheck) == "-"){
            
            k = 1;
            
        } else {
            
            k = -1;
            
        }
        
    } else if ( L1 == L2 ){
        
        
        for (int i = 0; i < L1; i++){
            char num1 = Num1.charAt(i);
            char num2 = Num2.charAt(i);
            
            if (num2 > num1){
                k = -1;
               
            } else if (num2 < num1){
               k = 1;
                
            }
            
        }
        
    } else {
        
        k = 0;
        
    }
    //System.out.println("K is " + k);
    return k;
}

//--------------------------------------------------------------------

public Boolean equalTo(String Num1, String Num2){
    
    if (Num1 == Num2){
        return true;
        
    } else {
    
        return false;
        
    }
    
}

//--------------------------------------------------------------------

public String valueOf(long val){
    
    String s = String.valueOf(val);

    return s;
    
}

//---------------------------------------------------------------------
    private int changeToInt(char c) {
        String strNum = c + "";
        switch (strNum) {
        case "0":
            return 0;
        case "1":
            return 1;
        case "2":
            return 2;
        case "3":
            return 3;
        case "4":
            return 4;
        case "5":
            return 5;
        case "6":
            return 6;
        case "7":
            return 7;
        case "8":
            return 8;
        case "9":
            return 9;
        default:
            throw new IllegalArgumentException(); 
        }
    }
}
