public class A20_Dynamiczne {
    public static void main(String[] args) {
        final int N = 12;
        int[] tab = new int[N];
        tab[0] = 1;
        tab[1] = 1;

        for (int i = 2; i < tab.length; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        System.out.println(tab[N - 1]);
    }
}