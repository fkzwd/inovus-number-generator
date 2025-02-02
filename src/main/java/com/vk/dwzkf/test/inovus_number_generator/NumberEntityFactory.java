package com.vk.dwzkf.test.inovus_number_generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
public class NumberEntityFactory {
    private static final NumberEntityFactory instance = new NumberEntityFactory();
    private static final List<NumberEntity> available = new ArrayList<>();

    static {
        available.add(
                new NumberEntity(
                        sort("АЕТОРНУКХСВМ".toCharArray()),
                        'А',
                        false
                )
        );
        available.add(
                new NumberEntity(
                        sort("AETOPHYKXCBM".toCharArray()),
                        'A',
                        false
                )
        );
        available.add(new NumberEntity("AB".toCharArray(), 'B', false));
        available.add(new NumberEntity("0123456789".toCharArray(), '1', true));
        available.add(new NumberEntity("01".toCharArray(), '0', true));
    }

    private static char[] sort(char[] array) {
        Arrays.sort(array);
        return array;
    }

    public NumberEntity findByMask(char mask) {
        for (NumberEntity numberEntity : available) {
            if (numberEntity.getMask() == mask) {
                return numberEntity;
            }
        }
        throw new IllegalStateException("Not found");
    }

    public static NumberEntityFactory getInstance() {
        return instance;
    }
}
