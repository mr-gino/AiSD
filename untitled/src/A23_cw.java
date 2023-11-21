public class A23_cw {
    public static void main(String[] args) {
        int liczbaPopulacji = 100000;
        int liczbaChorych = 10;
        int dzien = 1;

        while (liczbaChorych <= liczbaPopulacji / 2) {
            int nowiChorzy = liczbaChorych / 2 * 2; // Połowa chorych zaraża dwie osoby dziennie
            liczbaChorych += nowiChorzy;
            dzien++;

            if (dzien > 7) {
                liczbaChorych -= liczbaChorych / 2; // Po 7 dniach osoby wyzdrowiałe przestają zarażać
            }
        }

        System.out.println("Przewidywany dzień przekroczenia połowy populacji: " + dzien);
    }
}