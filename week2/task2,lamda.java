import java.io.*;
import java.util.*;
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation isOdd() {
        return new PerformOperation() {
            public boolean check(int a) {
                return a % 2 != 0;
            }
        };
    }
    public PerformOperation isPrime() {
        return new PerformOperation() {
            public boolean check(int a) {
                if (a <= 1) return false;
                for (int i = 2; i * i <= a; i++) {
                    if (a % i == 0)
                        return false;
                }
                return true;
            }
        };
    }
    public PerformOperation isPalindrome() {
        return new PerformOperation() {
            public boolean check(int a) {
                int temp = a, rev = 0;
                while (temp > 0) {
                    rev = rev * 10 + temp % 10;
                    temp /= 10;
                }
                return rev == a;
            }
        };
    }
}
public class Solution {
    public static void main(String[] args) throws Exception {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            int ch = Integer.parseInt(s[0]);
            int num = Integer.parseInt(s[1]);
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "ODD" : "EVEN");
            } 
            else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "PRIME" : "COMPOSITE");
            } 
            else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                System.out.println(ret ? "PALINDROME" : "NOT PALINDROME");
            }
        }
    }
}
