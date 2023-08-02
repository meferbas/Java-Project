package pdpproject3;

import java.util.List;
import java.util.Random;

public class Oyun {
    public static void ilkKoloniKazaninca(Koloni koloni1, Koloni koloni2) {
        int diff = Math.abs(koloni1.rastgeleDeger - koloni2.rastgeleDeger);
        int threshold = (diff * 100) / 1000;
        int tmpValue = 0;
        koloni2.populasyon = koloni2.populasyon * (100 - threshold) / 100;
        tmpValue = koloni2.yemekStok * threshold / 100;
        koloni2.yemekStok = koloni2.yemekStok - koloni2.yemekStok * threshold / 100;
        koloni1.yemekStok = koloni1.yemekStok + tmpValue;
        koloni1.yemekStok = koloni1.yemekStok - koloni1.populasyon * 2;
        koloni2.yemekStok = koloni2.yemekStok - koloni2.populasyon * 2;
        koloni2.kaybetme++;
        koloni1.kazanma++;
        tmpValue = 0;
    }

    public static void ikinciKoloniKazaninca(Koloni koloni1, Koloni koloni2) {
        int diff = Math.abs(koloni1.rastgeleDeger - koloni2.rastgeleDeger);
        int threshold = (diff * 100) / 1000;
        int tmpValue = 0;

        koloni1.populasyon = koloni1.populasyon * (100 - threshold) / 100;
        tmpValue = koloni1.yemekStok * threshold / 100;
        koloni1.yemekStok = koloni1.yemekStok - koloni1.yemekStok * threshold / 100;
        koloni2.yemekStok = koloni2.yemekStok + tmpValue;
        koloni1.yemekStok = koloni1.yemekStok - koloni1.populasyon * 2;
        koloni2.yemekStok = koloni2.yemekStok - koloni2.populasyon * 2;
        koloni1.kaybetme++;
        koloni2.kazanma++;
        tmpValue = 0;
    }

    public static void eslesme(Koloni koloni1, Koloni koloni2, List<Koloni> elenmisKoloniler, int elenmisKoloniSayisi) {
        if (koloni1.elenen || koloni2.elenen) {
            return;
        }



        int MAX_ELENEN_KOLONI = 100;
        Random random = new Random();
        int randomValue = random.nextInt(2);

        if (koloni1.rastgeleDeger > koloni2.rastgeleDeger) {
            ilkKoloniKazaninca(koloni1, koloni2);
        } else if (koloni1.rastgeleDeger < koloni2.rastgeleDeger) {
            ikinciKoloniKazaninca(koloni1, koloni2);
        } else {
            if (koloni1.populasyon > koloni2.populasyon) {
                ilkKoloniKazaninca(koloni1, koloni2);
            } else if (koloni1.populasyon < koloni2.populasyon) {
                ikinciKoloniKazaninca(koloni1, koloni2);
            } else {
                if (randomValue != 0) {
                    ikinciKoloniKazaninca(koloni1, koloni2);
                } else {
                    ilkKoloniKazaninca(koloni1, koloni2);
                }
            }
        }

        if (koloni1.populasyon <= 0) {
            koloni1.populasyon = 0;
            if (elenmisKoloniler.size() < MAX_ELENEN_KOLONI) {
                Koloni elenenColony = new Koloni();
                elenenColony.sembol = koloni1.sembol;
                elenenColony.populasyon = koloni1.populasyon;
                elenenColony.yemekStok = koloni1.yemekStok;
                koloni1.elenen = true;
                elenmisKoloniler.add(elenenColony);

            }
        }

        if (koloni2.populasyon <= 0) {
            koloni2.populasyon = 0;
            if (elenmisKoloniler.size() < MAX_ELENEN_KOLONI) {
                Koloni elenenColony = new Koloni();
                elenenColony.sembol = koloni2.sembol;
                elenenColony.populasyon = koloni2.populasyon;
                elenenColony.yemekStok = koloni2.yemekStok;
                koloni2.elenen = true;
                elenmisKoloniler.add(elenenColony);

            }
        }
    }

}
