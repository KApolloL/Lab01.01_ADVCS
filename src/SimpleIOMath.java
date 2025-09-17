/**
 * Lab 01.01: ABC-123 Assignment
 * @author 26lee@da.org
 * @version 09.14.2025
 */

import java.util.Scanner;

/**
 *
 *
 *
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    public void promptUser() {
        Scanner in = new Scanner(System.in);

        System.out.println(
                "* Sit yourself down, take a seat *\n" +
                "* All you gotta do is repeat after me *");

        while (true) {
            try {
                System.out.print("Question 1: What is your name? ");
                name = in.nextLine().trim();

                if (!(name.matches("[a-zA-Z\\s]+") && !name.isEmpty())) {
                    System.out.println("Invalid name. Use only letters and spaces.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                in.nextLine(); // flush buffer
            }
        }

        while (true) {
            try {
                System.out.print("Question 2: What is your age? ");
                String age_in = in.nextLine().trim().replaceAll("[^0-9]", "");
                age = Integer.parseInt(age_in);

                if (age < 0 || age > 150) {
                    System.out.println("Invalid age. Must be 0–150.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Question 3: What is your favorite number? ");
                String fav_in = in.nextLine().trim().replaceAll("[^0-9-]", "");
                favNumber = Integer.parseInt(fav_in);

                if (favNumber < -1000000 || favNumber > 1000000) {
                    System.out.println("Number too large/small.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private int primeFactor(int number) {
      for  (int i = 2; i <= Math.sqrt(number); i += 2) {
          if (number % i == 0)
              return i;
          }

        return number;
    }

    /**
     *
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
                + "\nYour favorite number squared is: " + Math.round(Math.pow(favNumber, 2))
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
