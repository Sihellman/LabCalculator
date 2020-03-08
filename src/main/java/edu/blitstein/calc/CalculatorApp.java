package edu.blitstein.calc;

import edu.blitstein.calc.engine.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {


        //Numbers this close to zero are treated as if equal to zero.
        public static void main(String[] args)
            throws DivideByZeroException {




            System.out.println("Calculator is on.");
            System.out.print("Format of each line: ");
            System.out.println("operator space number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter @ space number");
            System.out.print("Enter initial value: ");
            Scanner keyboard = new Scanner(System.in);
            double initialValue = keyboard.nextDouble();
            Calculator clerk = new Calculator(initialValue);
            System.out.println("Starting with = " + clerk.getResult());


            while (true) {
                char nextOp = (keyboard.next().charAt(0));
                double result;
            /*if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else {*/
                try {
                    double nextNumber = keyboard.nextDouble();

                    result = clerk.evaluate(nextOp, clerk.getResult(), nextNumber);
                    System.out.println("result " + nextOp + " " + nextNumber + " = " + result);

                    System.out.println("updated result = " + result);







                } catch (DivideByZeroException dbze) {
                    System.out.println(dbze.getMessage());

                } catch (UnknownOpException uoe) {
                    System.out.println(uoe.getMessage());

                } catch (NumberFormatException nfe) {
                    System.out.println(nfe.getMessage());
                } catch (InputMismatchException ime) {
                    System.out.println(ime.getMessage());

                }


                }



        }
}
