public class a19_cw {
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

    static int N = 9;
    static int sumOdl = 0;

    static int[] odpadniete = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    static String[] przystanki = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt",
            "Bukareszt", "Zagrzeb", "Sofia"};

    public static int znajdzPierwsze() {
        int ile = 0;

        int out = 0;
        for (int i = 0; i < miasto.length; i++) {
            int new_ile = 0;
            for (int j = 0; j < miasto.length; j++) {
                if (miasto[i][j] > 0)
                    new_ile++;


            }
            if (ile < new_ile) {
                out = i;
                ile = new_ile;
            }
        }

        odpadniete[out] = 1;
        System.out.print(przystanki[out] + ", ");


        return out;
    }

    public static int wyznaczTrase(int n) {
        //System.out.println(przystanki[n] + ",");
        int m = n;

        int odleglosc = 999;
        int index = 0;
        for (int i = 0; i < miasto.length; i++) {
            if (odleglosc > miasto[m][i] && miasto[m][i] > 0 && odpadniete[i] == 0) {

                //System.out.println("------Mamy m: "+m+", i: "+i+", miasto: "+ miasto[m][i] + " odpadniete: " + odpadniete[i]);

                index = i;
                odleglosc = miasto[m][i];
            }
        }
        System.out.print(przystanki[index] + ", ");
        sumOdl += miasto[m][index];

        odpadniete[index] = 1;


        return index;
    }

    public static void main(String[] args) {
        System.out.print("Trasa: ");
        int pierwszy = znajdzPierwsze();
        int in = 0;
        for (int i = 0; i < N - 1; i++) {
            if (i == 0)
                in = wyznaczTrase(pierwszy);
            else
                in = wyznaczTrase(in);
        }
        System.out.println();
        System.out.println("Dlugosc trasy: " + sumOdl);
    }
}
