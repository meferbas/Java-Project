package pdpproject3;

import java.util.Random;

public class BTaktik extends Taktik {
    @Override
    public int savas(){
        Random random = new Random();
        int randomSayi = random.nextInt(501) + 500;
        return randomSayi;
    }

}