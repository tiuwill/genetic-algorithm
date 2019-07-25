import java.nio.charset.Charset;
import java.util.Random;

public class RandomStringUtils {


    public static String random(int length){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 123; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            if(randomLimitedInt == 123)
                buffer.append((char) 32);
            else
                buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    public static char random(){
        int leftLimit = 32; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));

        return (char) randomLimitedInt;
    }



}
