package pdpproject3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
			List<Koloni> koloniler = new ArrayList<>();
	        List<Koloni> elenmisKoloniler = new ArrayList<>();
	        int elenmisKoloniSayisi = 0;
	        int turSayisi = 0;
	        ATaktik a= new ATaktik();
	        BTaktik b= new BTaktik();
	        AUretim aU = new AUretim();
	        BUretim bU = new BUretim();
	        Koloni.kolonileriOlustur(koloniler);

	        Random random = new Random();
	        for (Koloni koloni : koloniler) {
	            boolean sembolVarMi;
	            do {
	                sembolVarMi = false;
	                koloni.sembol = Koloni.rastgeleSembolAta(koloniler);

	                for (Koloni k : koloniler) {
	                    if (koloni.sembol == k.sembol && koloni != k) {
	                        sembolVarMi = true;
	                        break;
	                    }
	                }
	            } while (sembolVarMi);
	        }

	        while (koloniler.size() > 1) {

	            for (Koloni koloni : koloniler) {
	                if (turSayisi == 0) {
	                    koloni.yemekStok = koloni.populasyon * koloni.populasyon;
	                } else {
	                    if (random.nextBoolean())
	                        aU.uretim();
	                    else
	                        bU.uretim();
	                }
	                if (random.nextBoolean()){
	                    koloni.rastgeleDeger=a.savas();
	                }
	                else
	                    koloni.rastgeleDeger=b.savas();

	            }

	            if (turSayisi == 0) {
	                System.out.println("Tur sayisi: " + turSayisi);
	                Koloni.kolonileriYazdir(koloniler, elenmisKoloniler,elenmisKoloniSayisi, turSayisi);
	            }

	            for (int i = 0; i < koloniler.size()-1 ; i++) {
	                for (int j = i + 1; j < koloniler.size(); j++) {
	                    Oyun.eslesme(koloniler.get(i), koloniler.get(j), elenmisKoloniler, elenmisKoloniSayisi);

	                    if (koloniler.get(i).populasyon <= 0 || koloniler.get(i).yemekStok <= 0) {
	                        koloniler.get(i).populasyon = 0;
	                        koloniler.get(i).yemekStok = 0;
	                    }
	                    if (koloniler.get(j).populasyon <= 0 || koloniler.get(j).yemekStok <= 0) {
	                        koloniler.get(j).populasyon = 0;
	                        koloniler.get(j).yemekStok = 0;


	                    }
	                }
	            }

	            System.out.println("Tur sayisi: " + (turSayisi+1));
	            Koloni.kolonileriYazdir(koloniler, elenmisKoloniler, elenmisKoloniSayisi, turSayisi);

	            for (int i = 0; i < koloniler.size(); i++) {
	                if (koloniler.get(i).populasyon <= 0 || koloniler.get(i).yemekStok <= 0) {
	                    elenmisKoloniler.add(koloniler.get(i));
	                    koloniler.remove(i);
	                    elenmisKoloniSayisi++;
	                    i--;
	                }
	            }


	            turSayisi++;
	        }


	}

}
