public class Persistent {
    public static void main(String[] args) {
        System.out.println(persistence(999));
    }

    public static int persistence(long n) {
        long mult = n;
        int count = 0;
        while (mult >= 10) {
            int tmp = 1;
            String[] numStr = String.valueOf(mult).split("");
            for (int i = 0; i < numStr.length; i++) {
                tmp *= (Integer.parseInt(numStr[i]));
            }
            mult = tmp;
            count++;
        }
        return count;
    }
}