package pdpproject3;
import java.util.Random;
public class ATaktik extends Taktik{
    public ATaktik(){

    }
    @Override
    public int savas(){
        Random random = new Random();
        int randomSayi = random.nextInt(501);
        return randomSayi;

    }
}
