package pdpproject3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Koloni {
    int populasyon;
    int yemekStok;
    int kazanma;
    int kaybetme;
    boolean elenen;
    char sembol;
    int rastgeleDeger;
    int elenmisKoloniSayisi;

    public Koloni() {
        this.populasyon = 0;
        this.yemekStok = 0;
        this.kazanma = 0;
        this.kaybetme = 0;
        this.elenen = false;
    }

    public static void kolonileriOlustur(List<Koloni> koloniler) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Kolonileri giriniz: ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            boolean invalidInput = false;
            for (String token : tokens) {
                if (token.matches("\\d+")) {
                    Koloni colony = new Koloni();
                    colony.elenen = false;
                    colony.populasyon = Integer.parseInt(token);
                    colony.yemekStok = colony.populasyon * colony.populasyon;
                    colony.kazanma = 0;
                    colony.kaybetme = 0;
                    koloniler.add(colony);
                } else {
                    System.out.println("Yanlış giriş saptandı. Sadece sayı girişi yapınız.");
                    koloniler.clear();
                    invalidInput = true;
                    break;
                }
            }

            if (!invalidInput) {
                validInput = true;
            }
        }
    }


    public static boolean sembolVarMi(List<Koloni> koloniler, char sembol) {
        for (Koloni koloni : koloniler) {
            if (koloni.sembol == sembol) {
                return true;
            }
        }
        return false;
    }
    public static char rastgeleSembolAta(List<Koloni> koloniler) {
        Random random = new Random();
        String semboller = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~"; 

        char sembol;

        do {
            sembol = semboller.charAt(random.nextInt(semboller.length()));
        } while (sembolVarMi(koloniler, sembol));

        return sembol;
    }



    public static void kolonileriYazdir(List<Koloni> koloniler, List<Koloni> elenmisKoloniler, int elenmisKoloniSayisi, int tur) {
        System.out.println("Koloni\t\tPopulasyon\tYemek Stogu\t   Kazanma\t   Kaybetme");
        for (Koloni koloni : koloniler) {
            if (koloni.populasyon > 0 && koloni.yemekStok > 0) {
                System.out.printf("   %c\t\t", koloni.sembol);
                System.out.printf("%6d\t\t", koloni.populasyon);
                System.out.printf("%7d\t\t", koloni.yemekStok);
                System.out.printf("%7d\t\t%7d\n", koloni.kazanma, koloni.kaybetme);
            }
        }

        List<Character> yazdirilanKoloniler = new ArrayList<>(); 
        for (Koloni elenmisKoloni : elenmisKoloniler) {
            char sembol = elenmisKoloni.sembol;
            if (!yazdirilanKoloniler.contains(sembol)) {
                System.out.printf("   %c\t\t", sembol);
                System.out.printf("    --\t\t");
                System.out.printf("    --\t\t");
                System.out.printf("     --\t\t");
                System.out.printf("     --\t\t\n");
                yazdirilanKoloniler.add(sembol);
            }
        }

        System.out.println("---------------------------------------------------------------------------------\t\t");
    }



}
