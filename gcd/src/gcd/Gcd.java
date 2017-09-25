/*
 * HTBLA Leonding 2017/18
 * Helcig Michael
 */
package gcd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author michaelhelcig
 */
public class Gcd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num1 = 12, num2 = 9;
        System.out.printf("Number 1: %d Number 2: %d\n", num1, num2);
        System.out.printf("Euclid: %d\n", euclidCalc(num1, num2));
        System.out.printf("Prime: %d\n", primeCalc(num1, num2));
        System.out.printf("other Calculator: %d\n", otherCalc(num1, num2));
    }
    
    public static int euclidCalc(int num1, int num2){
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    
    public static int primeCalc(int num1, int num2){
        List<Prime> num1Primes = splitNumberInPrimes(num1);
        List<Prime> num2Primes = splitNumberInPrimes(num2);
        
        return getCommonPrimes(num1Primes, num2Primes);
    }
    
    public static int getNextPrime(int prime){
        boolean isPrime;
        do {
           isPrime = true;
           prime++;
            for (int i = 2; i < prime; i++) if(prime % i == 0) isPrime = false;
        } while (!isPrime);
        return prime;
    }

    private static List<Prime> splitNumberInPrimes(int num) {
        List<Prime> numPrimes;
        numPrimes = new LinkedList<>();
        Prime newPrime;
        int oldPrime = 1;
        do {
            newPrime = new Prime(getNextPrime(oldPrime));
            while(num % newPrime.getPrime() == 0){
                num = num / newPrime.getPrime();
                newPrime.addToQuantity();
            }
            numPrimes.add(newPrime);
            oldPrime = newPrime.getPrime();
        } while (num != 1);
        return numPrimes;
    }

    private static int getCommonPrimes(List<Prime> num1Primes, List<Prime> num2Primes) {
        Prime newPrime;
        int gcd = 0;
        for (int i = 0; i < num1Primes.size(); i++) {
            newPrime = null;
            for (int j = 0; j < num2Primes.size(); j++) {
                if(num1Primes.get(i).getPrime() == num2Primes.get(j).getPrime()){
                    newPrime = num2Primes.get(j);
                    break;
                }
            }
            if (newPrime != null && newPrime.getQuantity() != 0 && num1Primes.get(i).getQuantity() != 0) gcd += Math.pow(newPrime.getPrime(), Math.min(num1Primes.get(i).getQuantity(), newPrime.getQuantity()));
        }
       return gcd;
  }

    private static int otherCalc(int num1, int num2) {
        int gcd = num1;
        while (num1 % gcd != 0 || num2 % gcd != 0) gcd--;
        return gcd;
    }
}
