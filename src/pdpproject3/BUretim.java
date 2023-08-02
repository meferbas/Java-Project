package pdpproject3;

import java.util.Random;
public class BUretim extends Uretim {

    @Override
    public int uretim(){
        Random random = new Random();
        int randomSayi = random.nextInt(6) + 5;
        return randomSayi;
    }

}
