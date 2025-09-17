/**
 * Lab 01.01: ABC-123 Assignment
 * @author 26lee@da.org
 * @version 09.17.2025
 */

import java.util.Scanner;

/**
 * Class SimpleIOMath takes user input and performs basic math operations.
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private String favNumber;

    public void promptUser() {
        Scanner in = new Scanner(System.in);

        System.out.println(
                "* Sit yourself down, take a seat *\n" +
                        "* All you gotta do is repeat after me *");

        while(true) {
            try {
                System.out.print("Question 1: What is your name? ");
                name = in.nextLine();
                if (!(name.matches("[a-z-A-Z\\s]+") && !name.trim().isEmpty())) {
                    System.out.println("Invalid name.");
                }
                else{
                    break;
                }
            }
            catch (Exception e) {
                //User enters exception catch if bad data
                System.out.println(e.getMessage());
                //Flush the return key ASCII code from input buffer
                //ASCII 10 or 13
                in.next();
            }
        }

        while (true) {
            try {
                System.out.print("Question 2: What is your age? ");
                String line = in.nextLine().trim();
                age = Integer.parseInt(line);

                if (age < 1 || age > 150) {
                    System.out.println("Invalid age. Must be 1–150.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Question 3: What is your favorite number? ");
                favNumber = in.nextLine().trim();

                if (favNumber.equalsIgnoreCase("pi")) {
                    favNumber = String.valueOf(Math.PI);
                    break;
                } else {
                    Double.parseDouble(favNumber);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    /**
     * Computes the first prime factor of a number
     * @param number to factorize
     * @return smallest prime factor or number if prime
     */
    private int primeFactor(int number) {
        for  (int i = 2; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return i;
        }

        return number;
    }

    /**
     * Prints user info and does some math. Output includes lyrics, name, age, and favorite number
     */
    public void printInfo() {
        System.out.println(
                """
                        I'm gonna teach you how to sing it out
                        Let me tell you what it's all about
                        Reading, writing, arithmetic
                        Are the branches of the learning tree"""
        );

        System.out.println(
                "Your name is: " + name
                        + "\nYour age is: " + age
                        + "\nAt your next birthday, you will turn " + (age+1)
                        + "\nThe first prime factor of " + age + " is " + primeFactor(age)
                        + "\nYour favorite number is: " + favNumber
                        + "\nYour favorite number squared is: " + Math.round(Math.pow(Double.parseDouble(favNumber), 2))
                        + "\n* end of program *"

        );
    }

    /**
     * Main method for class SimpleIOMath
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        SimpleIOMath app = new SimpleIOMath();
        app.promptUser();
        app.printInfo();
    }

}