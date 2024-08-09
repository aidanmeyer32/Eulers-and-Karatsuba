import java.util.*;
import java.math.BigInteger;
public class Algorithm {
    public Algorithm(){}

    public void eulersConjecture(int N) {
        HashMap<BigInteger, int[]> hashTable = new HashMap<>();
        BigInteger p = new BigInteger("1000000007");  // Large prime

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                BigInteger sum = BigInteger.valueOf(a).pow(4).add(BigInteger.valueOf(b).pow(4)).mod(p);
                hashTable.put(sum, new int[]{a, b});
            }
        }

        for (int c = 1; c <= N; c++) {
            for (int d = 1; d <= N; d++) {
                BigInteger diff = BigInteger.valueOf(d).pow(4).subtract(BigInteger.valueOf(c).pow(4)).mod(p);
                if (hashTable.containsKey(diff)) {
                    int[] ab = hashTable.get(diff);
                    BigInteger a4 = BigInteger.valueOf(ab[0]).pow(4);
                    BigInteger b4 = BigInteger.valueOf(ab[1]).pow(4);
                    BigInteger c4 = BigInteger.valueOf(c).pow(4);
                    BigInteger d4 = BigInteger.valueOf(d).pow(4);
                    if (a4.add(b4).equals(c4.add(d4))) {
                        System.out.println("Counterexample found: " + ab[0] + "^4 + " + ab[1] + "^4 + " + c + "^4 = " + d + "^4");
                        return;
                    }
                }
            }
        }

        System.out.println("No counterexample found for N = " + N);
    }
    public BigInteger karatsuba(BigInteger x, BigInteger y) {
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 10000) {
            return x.multiply(y);
        }

        N = (N / 2) + (N % 2);  // half the number of bits, rounded up
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

}
