/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda dzieli i zwycierzaj
*/


public class A1_Dziel_i_zwyciezaj
{

    final static int N = 6;                // liczba przedmiotĂłw
    final static int MAX_V = 10;           // objetoĹ›Ä‡ plecaka

    final static int[] V = {2,6,3,3,1,2};  // objetoĹ›ci przedmiotĂłw
    final static int[] W = {4,6,5,10,2,7}; // wartoĹ›ci przedmiotĂłw

    static int P(int i, int v)
    {
        int w1; // wartoĹ›Ä‡, gdy nie bierzemy i-tego przedmiotu
        int w2; // wartoĹ›Ä‡, gdy bierzemy i-ty przedmiot
        if (i == 0 && v < V[0])
        {
            return 0;
        }
        if (i == 0 && v >= V[0])
        {
            return W[0];
        }
        w1 = P(i - 1, v);
        if (i > 0 && v < V[i])
        {
            return w1;
        }
        w2 = W[i] + P(i - 1, v - V[i]);
        if (w2 > w1) // gdy i > 0 && v >= V[i]
        {
            return w2;
        }
        else
        {
            return w1;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Wartosc przedmiotow: " + P(N - 1, MAX_V));
    }
}
