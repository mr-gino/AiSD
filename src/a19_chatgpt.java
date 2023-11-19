public class a19_chatgpt {

    static int[][] miasto = {
            {0, 300, 402, 350, -1, -1, -1, -1, -1},
            {300, 0, -1, -1, 440, 474, -1, -1, -1},
            {402, -1, 0, -1, -1, 330, -1, -1, -1},
            {365, -1, -1, 0, -1, -1, 823, -1, -1},
            {-1, 440, -1, -1, 0, -1, -1, 430, -1},
            {-1, 474, 330, -1, -1, 0, 813, 365, 774},
            {-1, -1, -1, 823, -1, 812, 0, -1, 403},
            {-1, -1, -1, -1, 430, 365, -1, 0, 768},
            {-1, -1, -1, -1, -1, 774, 403, 768, 0},
    };

    static String[] przystanki = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt",
            "Bukareszt", "Zagrzeb", "Sofia"};

    public static void main(String[] args) {
        int startCity = znajdzNajwiekszaLiczbePolaczen();
        int[] trasa = znajdzNajkrotszaDroge(startCity);

        wypiszWynik(trasa);
    }

    static int znajdzNajwiekszaLiczbePolaczen() {
        int startCity = 0;
        int maxConnections = 0;

        for (int i = 0; i < miasto.length; i++) {
            int connections = 0;
            for (int j = 0; j < miasto[i].length; j++) {
                if (miasto[i][j] != -1) {
                    connections++;
                }
            }
            if (connections > maxConnections) {
                maxConnections = connections;
                startCity = i;
            }
        }

        return startCity;
    }

    static int[] znajdzNajkrotszaDroge(int startCity) {
        int[] trasa = new int[miasto.length];
        boolean[] odwiedzone = new boolean[miasto.length];

        trasa[0] = startCity;
        odwiedzone[startCity] = true;

        for (int i = 1; i < miasto.length; i++) {
            int obecneMiasto = trasa[i - 1];
            int najkrotszaDroga = Integer.MAX_VALUE;
            int najlepszeMiasto = -1;

            for (int j = 0; j < miasto[obecneMiasto].length; j++) {
                if (!odwiedzone[j] && miasto[obecneMiasto][j] != -1 && miasto[obecneMiasto][j] < najkrotszaDroga) {
                    najkrotszaDroga = miasto[obecneMiasto][j];
                    najlepszeMiasto = j;
                }
            }

            trasa[i] = najlepszeMiasto;
            odwiedzone[najlepszeMiasto] = true;
        }

        return trasa;
    }

    static void wypiszWynik(int[] trasa) {
        int sumaDlugosci = 0;

        System.out.println("Kolejność odwiedzania miast:");

        for (int i = 0; i < trasa.length; i++) {
            System.out.print(przystanki[trasa[i]]);
            if (i < trasa.length - 1) {
                System.out.print(" -> ");
            }

            if (i < trasa.length - 1 && miasto[trasa[i]][trasa[i + 1]] != -1) {
                sumaDlugosci += miasto[trasa[i]][trasa[i + 1]];
            }
        }

        System.out.println("\nSumaryczna długość trasy: " + sumaDlugosci + " km");
    }
}
