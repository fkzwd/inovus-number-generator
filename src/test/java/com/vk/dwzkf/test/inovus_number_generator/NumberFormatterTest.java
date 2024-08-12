package com.vk.dwzkf.test.inovus_number_generator;

import org.junit.jupiter.api.Test;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
public class NumberFormatterTest {
    @Test
    public void test() {
        AutoNumberGenerator autoNumberGenerator = new AutoNumberGenerator();
        System.out.println(autoNumberGenerator.next());
        System.out.println(autoNumberGenerator.random());
        System.out.println(autoNumberGenerator.next());
        System.out.println(autoNumberGenerator.random());
        System.out.println(autoNumberGenerator.next());
        System.out.println(autoNumberGenerator.random());
        System.out.println(autoNumberGenerator.next());
        System.out.println(autoNumberGenerator.random());
        System.out.println(autoNumberGenerator.next());
    }



    @Test
    public void test2() {
        NumberFormatter numberFormatter = NumberFormatter.build("A010A");
        System.out.println(numberFormatter.format(25L));
    }

    @Test
    public void test3() {
        NumberFormatter numberFormatter = NumberFormatter.build("BBBB");
        for (long i = 0; i < numberFormatter.getMaxValue(); i++) {
            System.out.printf("%s=%s\n", Long.toBinaryString(i), numberFormatter.format(i));
        }
    }
}