package br.com.icarros.testes.fizzbuzz;

public class FizzBuzz {
    static String isFizzBuzz(int number) {
        String res = "";
        if (number % 3 == 0) {
            res += "Fizz";
        }
        if (number % 5 == 0) {
            res += "Buzz";
        }
        return res;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " " + isFizzBuzz(i));
        }
    }
}