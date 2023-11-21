public class A20_Dziel_i_zwyciezaj {
    public static void main(String[] args)
    {
        final int N = 12; // n-ty wyraz ci�gu
        System.out.println(fibo(N));
    }
    static int fibo(int n)
    {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }
}