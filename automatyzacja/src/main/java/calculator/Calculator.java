package calculator;

public class Calculator {
  //  private static final double POSITIVE_INFINITY=0;

//  //  private int b;

   // public calculator.Calculator(int a, int b) {
  //      this.a = a;
 //       this.b = b;
//

    public static double add (double a, double b) {

        return a + b;
    }

    public static double subtract (double a, double b){

        return a-b;
    }

    public static double multiply (double a, double b){

        return a*b;
    }

    public static double divide (double a, double b){

        if (a==0 && b==0) {
            return 0;

        }
        else
        return a/b;
    }




}

