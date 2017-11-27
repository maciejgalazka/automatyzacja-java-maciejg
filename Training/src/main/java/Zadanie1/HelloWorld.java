package Zadanie1;
import java.util.Scanner;


public class HelloWorld {

    public static void printMessage(){

        System.out.println("Witaj Świecie");
        System.out.println("Aby wyjść z aplikacji wpisz exit i naciśnij klawisz enter");
    }

    public static void scanUserInput(){

        while (true) {

            Scanner scan = new Scanner(System.in);

            if (scan.hasNext("exit")) {

                break;
            }
            else{
                System.out.println("Aby wyjść z aplikacji wpisz exit i naciśnij klawisz enter");
            }
        }
    }

    public static  void main(String[] args) {

        printMessage();
        scanUserInput();


}

}
