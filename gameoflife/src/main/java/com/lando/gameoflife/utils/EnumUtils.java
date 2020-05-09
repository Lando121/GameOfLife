package com.lando.gameoflife.utils;

import java.util.Random;

public class EnumUtils {
    static final Random random = new Random(); 

    public static <T extends Enum<?>> T randomEnum(Class<T> enumClass) {
        int randomNumber = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[randomNumber];
    }
}