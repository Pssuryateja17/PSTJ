
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            String s = sc.nextLine();
            int n = s.length();

            int[] a = new int[26];
            int[] b = new int[26];

            int mid = n / 2;

            for (int i = 0; i < mid; i++) {
                a[s.charAt(i) - 'a']++;
            }

            for (int i = (n % 2 == 0 ? mid : mid + 1); i < n; i++) {
                b[s.charAt(i) - 'a']++;
            }

            boolean lapindrome = true;
            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    lapindrome = false;
                    break;
                }
            }

            if (lapindrome)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}
