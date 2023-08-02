package pdpproject3;

import java.util.Random;
public class AUretim extends Uretim {
   
    @Override
    public int uretim(){

        Random random = new Random();
        int randomSayi = random.nextInt(5) + 1;
        return randomSayi;
    }

}
