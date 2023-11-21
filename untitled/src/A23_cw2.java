public class A23_cw2 {

    static final int POPULACJA = 100000;
    static final int CHORZY_POCZATKOWO = 10;
    static final int DNI_KONTAKTU = 7;
    static final int DNI_PO_ODPORNYCH = 14;

    public static void main(String[] args) {
        int dni = dniNajwiecejChorych(POPULACJA, CHORZY_POCZATKOWO);
        System.out.println("Najwięcej chorych będzie po " + dni + " dniach.");
    }

    public static int dniNajwiecejChorych(int liczbaOsob, int liczbaChorych) {
        if (liczbaChorych >= liczbaOsob) {
            return 0;
        }

        int osobyPodatne = liczbaOsob - liczbaChorych;
        int dniPrzedzieleniem = DNI_KONTAKTU + dniNajwiecejChorych(liczbaOsob, liczbaChorych * 3);

        int osobyPodzielone = osobyPodatne / 2;
        int dniPoPodziale = DNI_KONTAKTU + dniNajwiecejChorych(osobyPodzielone, liczbaChorych * 3);

        return Math.max(dniPrzedzieleniem, dniPoPodziale);
    }
}