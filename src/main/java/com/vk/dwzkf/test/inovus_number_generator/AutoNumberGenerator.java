package com.vk.dwzkf.test.inovus_number_generator;

import java.util.Random;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
public class AutoNumberGenerator {
    private final NumberStore numberStore = new NumberStore();
    private final NumberFormatter numberFormatter = NumberFormatter.build("A111AA");
    private final Random random = new Random();
    private static final String suffix = "116 RUS";

    public String random() {
        int random = getRandom();
        while (!numberStore.isFree((long) random)) {
            random = getRandom();
        }
        numberStore.store((long) random);
        return numberFormatter.format((long) random)  + " " + suffix;
    }

    private int getRandom() {
        return Math.abs(this.random.nextInt((int) numberFormatter.getMaxValue()));
    }

    public String next() {
        long next = numberStore.next();
        numberStore.store(next);
        return numberFormatter.format(next) + " " + suffix;
    }
}
