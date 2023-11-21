public class a5_zach_cw {
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

        int[] kolejnosc = {0, 0, 0, 0, 0, 0};
        int[] best_kolejnosc = new int[6];
        int sumCzas = 0;
        int best_sumCzas = Integer.MAX_VALUE;
        int l = 0;
        while (l < wiersze) {
            sumCzas = 0;
            int index = l;
            int[] wykorzystane = {0, 0, 0, 0, 0, 0};
            wykorzystane[l] = 1;
            kolejnosc[0] = l;
            int over = wiersze;
            int kolejka = 0;
            while (over > 0) {
                int czas = Integer.MAX_VALUE;
                int new_index = 0;

                for (int i = 0; i < wiersze; i++) {
                    if (koszty[index][i] < czas && koszty[index][i] > 0 && wykorzystane[i] == 0) {
                        czas = koszty[index][i];
                        new_index = i;
                    }
                }

                sumCzas += koszty[index][new_index];
                kolejnosc[kolejka] = index;
                index = new_index;
                wykorzystane[index] = 1;
                kolejka++;
                over--;
            }
            sumCzas += koszty[kolejnosc[5]][kolejnosc[0]];
            if (sumCzas < best_sumCzas) {
                best_sumCzas = sumCzas;
                for (int i = 0; i < wiersze; i++)
                    best_kolejnosc[i] = kolejnosc[i];
            }
            l++;
        }

        System.out.print("Kolejnosc: ");
        for (int i = 0; i < wiersze; i++)
            System.out.print(best_kolejnosc[i] + 1 + ", ");
        System.out.print(best_kolejnosc[0] + 1 + " ");

        System.out.println();
        System.out.println("Dlugosc: " + best_sumCzas);
    }
}
