import java.util.Random;

public class a5_mc_cw {
    public static void main(String[] args) {
        int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 18, 0, 4},
                {28, 24, 1, 17, 5, 0}
        };
        int wiersze = 6;
        int ilosc_prob = 1000;
        Random rand = new Random();

        int[] kolejnosc = new int[wiersze];
        int[] best_kolejnosc = new int[wiersze];
        int best_sumCzas = Integer.MAX_VALUE;

        int i = 0;
        while (i < ilosc_prob) {
            int[] uzyte = {0, 0, 0, 0, 0, 0};
            int mozliwe = wiersze;
            int kolejka = 0;
            int sumCzas = 0;
            while (mozliwe > 0) {
                int los = rand.nextInt(6);
                if (uzyte[los] == 0) {
                    kolejnosc[kolejka] = los;
                    uzyte[los] = 1;
                    kolejka++;
                    mozliwe--;
                }
            }
            int g = 0;
            while (g < wiersze - 1) {
                sumCzas += koszty[kolejnosc[g]][kolejnosc[g + 1]];
                g++;
            }

            sumCzas += koszty[kolejnosc[5]][kolejnosc[0]];

            if (best_sumCzas > sumCzas) {
                best_sumCzas = sumCzas;
                for (int j = 0; j < wiersze; j++) {
                    best_kolejnosc[j] = kolejnosc[j];
                }
            }
            i++;
        }
        System.out.println("Najlepsze to " + best_sumCzas);
        System.out.print("Kolejnosc: ");
        for (int j = 0; j < wiersze; j++)
            System.out.print(best_kolejnosc[j] + 1 + ", ");
        System.out.println(best_kolejnosc[0] + 1);

    }
}
