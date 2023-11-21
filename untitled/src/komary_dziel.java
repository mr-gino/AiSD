public class komary_dziel {

    public static int liczPopu(double popu, double samce, double samice, int tygodnie) {
        if (samce >= samice) {
            return tygodnie;
        }

        double nowa_populacja = (popu * 0.1);
        System.out.println("nowa_populacja: " + nowa_populacja);
        double nowe_samce = (nowa_populacja * 0.45);
        double nowe_samice = nowa_populacja - nowe_samce;
        samce = samce - (samce * 0.02) + nowe_samce;
        samice = samice - (samice * 0.05) + nowe_samice;
        popu = samce + samice;
        tygodnie++;

        System.out.println("mamy " + samce + " samcow i " + samice + " samic po " + tygodnie + " tygodniach.");

        return liczPopu(popu, samce, samice, tygodnie);
    }

    public static void main(String[] args) {
        System.out.println(liczPopu(1000, 450, 550, 0));
    }
}
