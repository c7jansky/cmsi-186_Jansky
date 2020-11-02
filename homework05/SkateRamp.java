public class SkateRamp
{

//~~~Main Constructor!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public SkateRamp ()
  {


  }
  
  
 
//~~~validateArgsAndSetupIntergration Starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public boolean validateInitialArgs( String [] args ){
     
    int i = 1; 
    int MINIMUM_COMMAND_POLY = 5;
    int MINIMUM_COMMAND_SIN = 3;
    int MAXIMUM_COMMAND_SIN = 4;
    String Usage =  "To correctly use the function you must type either 'poly' \n" +
                    "followed by at least 4 numbers or type 'sin' followed by 2 \n" +
                    "numbers, adda an additional number followed by a '%'to \n" + 
                    "determine your personal error, the default will be .01%. \t\'\\\'";
     String functionType = new String (args [0]);
     functionType = functionType.toLowerCase();
     
     if (functionType.equals("poly") && args.length > MINIMUM_COMMAND_POLY){
        return true;
        
     } else if (functionType.equals("poly") && args.length < MINIMUM_COMMAND_POLY){
        System.out.println ("You need more coefficients listed to run a polynomial.");
         return false;
         
     } else if (functionType.equals("poly") && args.length > MINIMUM_COMMAND_POLY){
        System.out.println ("You need to list 'poly' first if you wish to calculate for a polynomial function.");
         return false;
         
     } else if (functionType.equals("sin") && args.length > MINIMUM_COMMAND_SIN){
         return true;
         
     } else if (functionType.equals("sin") && args.length < MINIMUM_COMMAND_SIN){
        System.out.println ("You need your bounds listed correctly to run a Sin function.");
         return false;
         
     } else if (functionType.equals("sin") && args.length > MINIMUM_COMMAND_SIN){
        System.out.println ("You need to list 'sin' first if you wish to calculate for a Sin function.");
         return false;
         
     } else if (functionType.equals("sin") && args.length > MAXIMUM_COMMAND_SIN){
         System.out.println ("You need need your 2 bounds listed correctly to run a Sin function.");
         return false;
     } else {
        System.out.println (Usage);
         return false;
         
        }
    } 
    
 
 
 
    
//~~~areaCalculator Starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public double areaCalculator(double[]coeffsI, double uValue, double lValue, double percentage){
        
        double rectangleWidth = 0.0;
        double Area = 0.0;
        double previousArea = 1000;
        double boundDifference = uValue - lValue;
        double xStartValue = lValue;
        double currBinXValue = 0.0;
        double binAmmount = 0.0;
        double percentError = 100;
        if (uValue <= lValue){
            System.out.println("Your upper bound must be larger than your lower bound.");
            //System.exit(0);
        } else {
            for (int i = 1; percentError * 100 >= (percentage / 100); i++){
             
        // i = number of trials
                previousArea = Area;
                Area = 0.0;
                rectangleWidth = boundDifference / Math.pow(2, i - 1);
                binAmmount = Math.pow(2, i - 1);
                
                for (int k = 1; k <= binAmmount; k++){
                    
            // k = bins number for each addition to the Area
                    
                    currBinXValue = lValue + ((k) * rectangleWidth);
                    
                    Area += yCalculator(coeffsI, currBinXValue) * rectangleWidth;
                    
                }

                percentError = ((Math.abs(Area - previousArea)/ Math.abs(previousArea)) * 100);
                
            }
        }
        return (Area * 3);
    }
    
    
    
    
//~~~ yCalculator starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    public double yCalculator (double[]coefficients, double currentBound){
    
    double yValue = 0.0;
    
    
    for( int i = 0; i < coefficients.length; i++){
            
           yValue +=  coefficients[i] * Math.pow (currentBound, i);
            
        }
     //System.out.println("the y value is" + yValue);
    return yValue;
  } 
  
  
  
  
//~~~sinareaCalculator Starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public double sinAreaCalculator(double uValue, double lValue, double percentage){
        
        double rectangleWidth = 0.0;
        double Area = 0.0;
        double previousArea = 1000;
        double boundDifference = uValue - lValue;
        double xStartValue = lValue;
        double currBinXValue = 0.0;
        double binAmmount = 0.0;
        double percentError = 100;
        if (uValue <= lValue){
            System.out.println("Your upper bound must be larger than your lower bound.");
            //System.exit(0);
        } else {
            for (int i = 1; percentError * 100 >= (percentage / 100); i++){
             
        // i = number of trials
                previousArea = Area;
                Area = 0.0;
                rectangleWidth = boundDifference / Math.pow(2, i - 1);
                binAmmount = Math.pow(2, i - 1);
                
                for (int k = 1; k <= binAmmount; k++){
                    
            // k = bins number for each addition to the Area
                    
                    currBinXValue = lValue + ((k) * rectangleWidth);
                    
                    Area += sinCalculator(currBinXValue) * rectangleWidth;
                    
                }

                percentError = ((Math.abs(Area - previousArea)/ Math.abs(previousArea)) * 100);
                
            }
        }
        return (Area * 3);
    }
    



//~~~ sinCalculator starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  
  public double sinCalculator (double currentBound){
    
    double yValue = 0.0;
            
    yValue +=  Math.sin(currentBound);
    
    return yValue;
  } 
 
 
 
  
//~~ExactArea tarts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  

  public static double ExactArea (double[]coefficients, double uValue,
				 double lValue)
  {



    int j = 0;
    double power1 = 0.0;
    double power2 = 0.0;
    double sum1 = 0.0;
    double sum2 = 0.0;
    double[] formula1 = new double[coefficients.length];
    double[] formula2 = new double[coefficients.length];
    double integral = 0.0;

    for (int i = 0; i < coefficients.length; i++)
      {
	power1 = Math.pow (uValue, i + 1);
	formula1[i] = ((coefficients[i] / (i + 1)) * power1);
      }

    for (int i = 0; i < coefficients.length; i++)
      {
	power2 = Math.pow (lValue, i + 1);
	formula2[j] = ((coefficients[i] / (i + 1)) * power2);
      }

    for (int i = 0; i < coefficients.length; i++)
      {
	sum1 = formula1[i] + sum1;
	sum2 = formula2[i] + sum2;
	integral = sum1 - sum2;
      }

    return integral;
  }



//~~~toString Starts!!!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String toString (String functType, double upper, double lower, double prct){
      
      String EndMessage = "After running the " + functType + " function with bounds of " + upper + 
      " as the upperBound, and " + lower + " as the lowerBound, with an error range of "+ prct + 
      "% the estimated area for 3 supports under the ramp should be: ";
        return EndMessage;
    }
  
  
    
    
// main starts !!! ~~~~~~~~~~~~~~~~~~~~~
  public static void main (String[]args){
    
    String Usage =  "Typing ERROR! To correctly use the function you must type either 'poly' \n" +
                    "followed by at least 4 numbers or type 'sin' followed by 2 \n" +
                    "numbers, adda an additional number followed by a '%'to \n" + 
                    "determine your personal error, the default will be 1.0%. \t\'\\\'";
    
                    SkateRamp Yew = new SkateRamp ();
    
    
    if (args[0].contains("runMyTests")){
        //Yew.runMyTests();
    }


    // below works ~~~~~~~~~~~~~~~~~~~~~
    double DEFAULT_PERCENTAGE = 1.0;
    double epsilon = DEFAULT_PERCENTAGE;
    boolean know = false;
    
    if (epsilon == DEFAULT_PERCENTAGE){
        know = true;
    }
    
    if (args[args.length - 1].contains("%")){
        epsilon = (Double.parseDouble( args[args.length - 1].substring(0, args[args.length - 1].length() - 1)) * 100);
    } 
    double PRCT = (epsilon / 100);
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    double upperBound = Double.parseDouble (args[(args.length - 2)]);
    double lowerBound = Double.parseDouble (args[(args.length - 3)]);
    
    double Area = 0;
    int j = 0;
    double[] Coeffs = new double[args.length - 4];
    String funct = null;
    String functionT = new String(args[0]);
    functionT = functionT.toLowerCase();
    if (functionT.equals("poly")){
        funct = functionT;
    } else if (functionT.equals("sin")){
        funct = functionT;
    }

    
    if (Yew.validateInitialArgs(args) == false){
        System.exit(0);
    }
    
    try{
        if (upperBound <= lowerBound){
        
        System.out.println("Error: You need to have a larger upper bound then your lowerbound.");
            
        } else {
            if (funct.equals("poly")){
                    if (epsilon != DEFAULT_PERCENTAGE){
                	for (int i = 1; i < (args.length - 3); i++){
                	    
                	    if (args.length - 3 != i){
                    		Coeffs[j] = Double.parseDouble (args[i]);
                    		j++;
                	     }
            	    }
            	    System.out.println(Yew.toString (functionT, upperBound, lowerBound, PRCT));
            	    System.out.println (Yew.areaCalculator (Coeffs, upperBound, lowerBound, epsilon) + " feet");
                } else { 
                    
                    upperBound = Double.parseDouble (args[(args.length - 1)]);
                    lowerBound = Double.parseDouble (args[(args.length - 2)]);
                    
                    for (int i = 1; i < (args.length - 2); i++){
                	    
                	    if (args.length - 2 != i){
                    		Coeffs[j] = Double.parseDouble (args[i]);
                    		j++;
                	     }
                    }
                    System.out.println(Yew.toString (functionT, upperBound, lowerBound, PRCT));
                    System.out.println (Yew.areaCalculator (Coeffs, upperBound, lowerBound, epsilon) + " feet");
                }
            
                
                
                	     
             
            } else if (funct.equals("sin")){
                funct = "sin";
        	    if (epsilon != DEFAULT_PERCENTAGE){
                    upperBound = Double.parseDouble (args[(args.length - 2)]);
                    lowerBound = Double.parseDouble (args[(args.length - 3)]);
                    System.out.println(Yew.toString (functionT, upperBound, lowerBound, PRCT));
                    System.out.println (Yew.sinAreaCalculator (upperBound, lowerBound, epsilon) + " feet"); 
                    
        	    } else {
        	        upperBound = Double.parseDouble (args[(args.length - 1)]);
        	        lowerBound = Double.parseDouble (args[(args.length - 2)]);
        	        System.out.println(Yew.toString (functionT, upperBound, lowerBound, PRCT));
        	        System.out.println (Yew.sinAreaCalculator (upperBound, lowerBound, epsilon) + " feet"); 
        	    }
                
            }
        }
      } catch (Exception e){
        if (funct.equals(null)){
            System.out.println(Usage);
        }
      }
          
    
        
    }


//~~runMyTestsStarts~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/* public void runMyTests(){
    // testing sevseal iterations
    System.out.println("Remove/ comment out the system.exit's before running runMyTests");
    //String argstest10[] = new String[] { "A", "B", "C", "D", "E" };
    //String argstest9[] = new String[] { "poly", "j", "3", "1", "j" }; 
    //String argstest8[] = new String[] { "Test"}; 
    //String argstest7[] = new String[] { }; 
    //String argstest6[] = new String[] { "sin", "j", "3"}; 
    String argstest5[] = new String[] { "sin", "5", "3"}; 
    String argstest4[] = new String[] { "sin", "2", "3"}; 
    String argstest3[] = new String[] { "poly", "2", "3", "j", "4" }; 
    String argstest2[] = new String[] { "newt", "2", "3", "1", "4" }; 
    String argstest1[] = new String[] { "poly", "2", "3", "1", "4" };
    String poly2[] = new String[] { "poly", "2", "3", "1","1","4", "1%" };
    String poly3[] = new String[] { "poly", "1", "3", "3","1","4", "1%" }; 
    String poly4[] = new String[] { "poly", "2", "3", "3","1","4", "1%" }; 
    String poly5[] = new String[] { "poly", "2","2","2","2","2","2", "3", "3","1","4", "1%" };
    String poly6[] = new String[] { "poly", "-2","2", "3", "-2","1","4", "1%" }; 
    String poly7[] = new String[] { "poly", "-2","2", "3", "-2","1","4" }; 
    String poly8[] = new String[] { "poly", "-2","-2", "-3", "-2","1","4" }; 
    String poly9[] = new String[] { "poly", "-2","2","-1","-4" }; 
    String poly10[] = new String[] { "poly", "-2","2","-1","6","4" }; 
    String sintest1[] = new String[] { "sin", "1", "3"}; 
    String sintest2[] = new String[] { "sin", "1", "3", "%1"};
    String sintest3[] = new String[] { "sin", "1", "3", "%10"}; 
    String sintest4[] = new String[] { "sin", "-2", "3", "%1"}; 
    String sintest5[] = new String[] { "sin", "-2", "3"}; 
    String sintest6[] = new String[] { "sin", "-2", "9", "2%"};
    String sintest7[] = new String[] { "sin", "10", "20", "2%"}; 
    String sintest8[] = new String[] { "sin", "-2", "9", "70%"};
    String sintest9[] = new String[] { "sin", "2", "9", "20%"}; 
    String sintest10[] = new String[] { "sin", "-4", "9", "4%"};
} */

}
