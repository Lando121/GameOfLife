package app.utility;

import java.util.Random;

public class EnumUtils {
    static final Random random = new Random(); 

    public static <T extends Enum<?>> T randomEnum(Class<T> t) {
        int x = random.nextInt(t.getEnumConstants().length);
        return t.getEnumConstants()[x];
    }
}