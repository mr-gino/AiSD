public class ciag_dziel3 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibo(n - 1));
    }

    public static double fibo(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 3;
        else return fibo(n - 1) + fibo(n - 2);
    }
}
