package li.剑指offer.数字.分数化简;

public class Solution {
    public static void main(String[] args) {
        long a = 13;
        long b = 30;
        String result = res(a, b);
        System.out.println(result);
    }

    public static long gcd(long a, long b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public static String res(long a, long b){
        long k = gcd(a, b);
        if (k > 1){
            a /= k;
            b /= k;
        }
        return a + "/" + b;
    }
}
