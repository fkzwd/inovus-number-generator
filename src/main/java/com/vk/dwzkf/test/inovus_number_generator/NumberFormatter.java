package com.vk.dwzkf.test.inovus_number_generator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
public class NumberFormatter {
    private final List<NumberEntity> entities = new ArrayList<>();
    @Getter
    private long maxValue = 0L;

    private NumberFormatter() {

    }

    public static NumberFormatter build(String format) {
        NumberFormatter numberFormatter = new NumberFormatter();
        char[] chars = format.toCharArray();
        for (char mask : chars) {
            NumberEntity entity = NumberEntityFactory.getInstance().findByMask(mask);
            numberFormatter.entities.add(entity);
        }
        numberFormatter.maxValue = numberFormatter.maxValue();
        return numberFormatter;
    }

    private long maxValue() {
        long max = 1;
        for (int i = entities.size() - 1; i >= 0; i--) {
            max *= entities.get(i).getValues().length;
        }
        return max;
    }

    public String format(Long value) {
        if (value > maxValue) throw new IllegalStateException("Unable to parse; Value too long");
        StringBuilder sb = new StringBuilder("-".repeat(entities.size()));
        for (boolean primary : List.of(true, false)) {
            for (int i = entities.size() - 1; i >= 0; i--) {
                NumberEntity numberEntity = entities.get(i);
                if (numberEntity.isPrimary() != primary) continue;
                int radix = numberEntity.getValues().length;
                long remainder = value % radix;
                char next = numberEntity.getValues()[(int) remainder];
                sb.setCharAt(i, next);
                value = value - remainder;
                value = value / radix;
            }
        }
        return sb.toString();
    }
}
