package org.example.params;

import java.util.stream.IntStream;

public class Utility {


    /*
    Utility mechanisms:
    -object class
    -statitc methods
    -singleton
     */

    // 1. Check if number is odd
    //odd- impar,even=par
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // 2. Round a double value to nearest integer
    public static double roundDouble(double value) {
        return Math.round(value);
    }

    // 3. Check if a string is palindrome
    //StringBuilder este weapper peste String, asa cum Integer este peste int
    // (un  numar sau un  text care de la stanga la dreapta e identic,ex ana)
    public static boolean isPalindrome(String text) {
        if (text == null) return false;
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    // 4. Convert string to uppercase
    // trim - eliminia caracterele albel de la stanga la dreapta stringului -> "   alune    " , "alune"

    public static String toUppercase(String imput) {
        return imput.trim().toUpperCase();

    }

    // 5. Check if an object is an instance of a given class
    //Object = universal parent for all Java classes ->can override toString ,hashCode
    public static boolean isInstance(Object obj, Class<?> cls) {
        return cls.isInstance(obj);

    }
    //6.Check if number is prime

    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        return IntStream.rangeClosed(2,(int) Math.sqrt(number))
                .allMatch( it -> number % it !=0);
    }
}
