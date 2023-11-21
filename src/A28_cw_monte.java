import java.util.Random;

public class A28_cw_monte {
    public static void main(String[] args) {
        int[] nominal = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] ilosc = {7, 0, 1, 1, 4, 1, 4, 7, 30};

        Random rand = new Random();

        int suma = 0;
        int ilosc_prob = 100;
        int max_do_wydania = 0;

        int kwota = 753;


        for (int i = 0; i < ilosc.length; i++) {
            suma += (nominal[i] * ilosc[i]);
            max_do_wydania += ilosc[i];
        }
        int[] best_wydane = new int[ilosc.length];

        int best_monet = max_do_wydania;

        if (kwota > suma) {
            System.out.println("Za mało pieniędzy w kasie!");
        } else {
            for (int i = 0; i < ilosc_prob; i++) {
                int ile_monet = 0;
                int[] wydane = new int[ilosc.length];
                int do_wydania = kwota;
                boolean mozliwosc = true;
                while (do_wydania > 0 && ile_monet < max_do_wydania && mozliwosc) {
                    int los = rand.nextInt(nominal.length);
                    //System.out.println("tu jestem i los " + los + ", do wydania: " + do_wydania + " wylosowano " + nominal[los] + " i jest go " + (ilosc[los] - wydane[los]));
                    if (nominal[los] <= do_wydania && wydane[los] < ilosc[los]) {
                        wydane[los]++;
                        do_wydania = do_wydania - nominal[los];
                        ile_monet++;
                    }

                    for (int j = 0; j < nominal.length; j++) {
                        if (nominal[j] <= do_wydania && (ilosc[j] - wydane[j]) > 0) {
                            mozliwosc = true;
                        } else mozliwosc = false;
                    }
                }
                if (ile_monet < best_monet) {
                    for (int j = 0; j < wydane.length; j++)
                        best_wydane[j] = wydane[j];
                    best_monet = ile_monet;
                }
            }
        }
        System.out.println("Wydano " + best_monet + " monety, co sklada sie na: ");
        for (int i = 0; i < best_wydane.length; i++) {
            if (best_wydane[i] != 0)
                System.out.println(best_wydane[i] + " moneta po " + (nominal[i] / 100.0) + " zl");
        }
    }
}
