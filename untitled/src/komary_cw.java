public class komary_cw {
    public static void main(String[] args) {
        double populacja = 1000;
        double samce = 450;
        double samice = populacja - samce;
        int ilosc_tygodni = 0;

        while (samce <= samice) {
            double nowa_populacja = (populacja * 0.1);
            double nowe_samce = (nowa_populacja * 0.45);
            double nowe_samice = nowa_populacja - nowe_samce;
            samce = samce - (samce * 0.02) + nowe_samce;
            samice = samice - (samice * 0.05) + nowe_samice;
            ilosc_tygodni++;

            populacja = samce + samice;

            //System.out.println("mamy " + samce + " samcow i " + samice + " samic po " + ilosc_tygodni + " tygodniach.");
        }

        System.out.println("Ilosc samcow zrowna sie lub przekroczy po " + ilosc_tygodni + " tygodniach.");
    }
}
