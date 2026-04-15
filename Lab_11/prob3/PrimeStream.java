package Lab_11.prob3;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrimeStream {

    public static boolean isPrime(int currentI){
        for(int i=2;i<currentI;i++){
            if(currentI%i==0){
                return false;
            }
        }
        return true;
    }
    public static int nextPrime(int current){
        int next=current+1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }
    public  void printFirstNPrimes(int num) {
        Supplier<Stream<Integer>> prim= ()->Stream.iterate(2,n->nextPrime(n));
         prim.get().limit(num)
                 .forEach(l-> System.out.println(l));
    }
    public static void main(String[] args){
        Stream<Integer> primes= Stream.iterate(2,n->nextPrime(n));
                primes.limit(10)
                .forEach(n-> System.out.println(n));

            PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
            ps.printFirstNPrimes(10);
            System.out.println("====");
            ps.printFirstNPrimes(5);
        }


    }

