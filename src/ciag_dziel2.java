public class ciag_dziel2 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibo(n-1));
    }

    public static int fibo(int n){
        if (n == 0)
            return 1;
        else if (n == 1)
            return 1;
        else return (fibo(n-1) * fibo(n-2)) * 3;

    }
}
