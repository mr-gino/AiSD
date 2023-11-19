import java.util.Random;

public class Figura_cw {
    public static void main(String[] args) {
        System.out.println("Pole = " + pole(100));
    }

    public static double pole(int ilosc) {
        int p = 0;
        Random rand = new Random();

        for (int i = 0; i < ilosc; i++) {
            double x = rand.nextInt(701) / 1000.0;
            double y = rand.nextInt(1101) / 1000.0 + 0.4;
            if (y <= Math.pow((x / 10.0), x))
                p++;
        }
        return (p / (double) ilosc);
    }
}
