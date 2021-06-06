/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Soroush Alinaghian
 */
package base;

import java.util.Scanner;

/*
Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for the starting temperature. The program should prompt for the type of conversion and then perform the conversion.

The formulas are

C = (F − 32) × 5 / 9
and
F = (C × 9 / 5) + 32

Example Output

Press C to convert from Fahrenheit to Celsius.
Press F to convert from Celsius to Fahrenheit.
Your choice: C
Please enter the temperature in Fahrenheit: 32
The temperature in Celsius is 0.

Constraints

Ensure that you allow upper or lowercase values for C and F.
Use as few output statements as possible and avoid repeating output strings.

Challenges

Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Break the program into functions that perform the computations.
Implement this program as a GUI program that automatically updates the values when any value changes.
Modify the program so it also supports the Kelvin scale.
 */
public class App<scale> {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String temperature = pickTempScale();
        char temp_choice = celsiusOrFahrenheit(temperature);
        conversion(temp_choice);
    }

    private static void conversion(int temp_choice) {
        if(temp_choice == 'c'||temp_choice == 'C'){
            System.out.print("Please enter the temperature in Fahrenheit: ");
            int f_degrees = getFahrenheit();
            fahrenheitToCelsius(f_degrees);
        }else if(temp_choice == 'f' ||temp_choice == 'F'){
            System.out.print("Please enter the temperature in Celsius: ");
            int c_degrees = getCelsius();
            celsiusToFahrenheit(c_degrees);
        }
    }

    private static void celsiusToFahrenheit(int degrees) {
        int f = (degrees * 9/5) + 32;
        System.out.println("The temperature in fahrenheit is " + f + ".");
    }

    private static int getCelsius() {
        return in.nextInt();
    }

    private static int getFahrenheit() {
        return in.nextInt();
    }

    private static void fahrenheitToCelsius(int degrees) {
        int c = (degrees - 32) * 5/9;
        System.out.println("The temperature in celsius is " + c + ".");

    }

    private static char celsiusOrFahrenheit(String temp) {

        char scale = temp.charAt(0);
        char ch1, ch2;

        if(scale == 'c' || scale == 'C') {
            ch1 = Character.toUpperCase(scale);
            System.out.print("Your choice: " );
            System.out.println(ch1);
        }else if(scale == 'f' || scale == 'F'){
            ch2 = Character.toUpperCase(scale);
            System.out.print("Your choice: ");
            System.out.println(ch2);
        }
        return scale;
    }

    private static String pickTempScale() {
        System.out.println("Press C to convert from Fahrenheit to Celsius.");
        System.out.println("Press F to convert from Celsius to Fahrenheit.");
        return in.next();
    }
}
