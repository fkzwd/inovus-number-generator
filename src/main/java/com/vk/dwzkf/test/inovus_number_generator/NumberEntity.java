package com.vk.dwzkf.test.inovus_number_generator;

import lombok.Getter;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
@Getter
public class NumberEntity {
    private final char[] values;
    private final char mask;
    private final boolean primary;

    public NumberEntity(char[] values, char mask, boolean primary) {
        this.values = values;
        this.mask = mask;
        this.primary = primary;
    }
}
