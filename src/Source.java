import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Source {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Algorithm algorithm = new Algorithm();

        System.out.println("=========================================================");
        System.out.println("Type 'Eulers' or 'Karatsuba' for corresponding algorithm:");
        System.out.println("=========================================================");

        String line = scanner.nextLine();

        while(!line.equals("Eulers") && !line.equals("Karatsuba")){
            System.out.println("Typo, please type 'Eulers' or 'Karatsuba' as shown.");
            line = scanner.nextLine();
        }

        if(line.equals("Eulers")){
            System.out.println("Enter the upper bound N for Euler's conjecture:");
            int N = scanner.nextInt();
            algorithm.eulersConjecture(N);
        }
        else{//karatsuba method
            //get values and call karatsuba
            System.out.println("Enter the two numbers to multiply:");
            BigInteger x = new BigInteger(scanner.next());
            BigInteger y = new BigInteger(scanner.next());
            BigInteger result = algorithm.karatsuba(x, y);
            System.out.println("Result: " + result);
        }
    }

}
