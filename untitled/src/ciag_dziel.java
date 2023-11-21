public class ciag_dziel {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(liczf(n - 1));
    }

    public static double liczf(double n) {
        if (n == 0)
            return 2;
        else if (n == 1) {
            return 4;
        } else {
            return (liczf(n - 1) * liczf(n - 2)) / 2;
        }
    }
}
