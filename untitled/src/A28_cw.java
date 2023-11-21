public class A28_cw {
    public static void main(String[] args) {
        int[] nominal = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] ilosc = {7, 0, 1, 1, 4, 1, 4, 7, 30};

        int suma = 0;

        for (int i = 0; i < nominal.length; i++)
            suma += (nominal[i] * ilosc[i]);

        System.out.println("mamy " + suma);


        int kwota = 753;
        int i = 0;

        if (kwota > suma)
            System.out.println("Za mało pieniędzy w kasie!");
        else {
            while (kwota > 0) {
                if (kwota >= nominal[i] && ilosc[i] > 0) {
                    System.out.print(nominal[i] / 100.0 + ", ");
                    kwota = kwota - nominal[i];
                } else {
                    i++;
                }
            }
        }
    }
}
