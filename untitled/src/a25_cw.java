public class a25_cw {

    static int p (int t){
        return (int)(p(t-1) * Math.exp(0.003));
    }

    public static void main(String[] args) {
        int popul = 1000000;
        int lososie = 1000000;
        
        int czas = 0;
        boolean polowa = true, trojka = true, dziesiatka = true, setka = true;
        while (lososie >= 100) {
            lososie = lososie + (int)(lososie * Math.exp(0.003));

            lososie = lososie - (int)(lososie * 0.001);
            lososie = lososie - (int)(lososie * 0.002);
            czas++;

            if (lososie <= (popul/2) && polowa){
                System.out.println("Po " + czas + " minutach umarła 1/2 poczatkowej populacji");
                polowa = false;
            }
            else if (lososie <= (int)(popul/3) && trojka) {
                System.out.println("Po " + czas + " minutach umarła 1/3 poczatkowej populacji");
                trojka = false;
            }
        }
    }

}
