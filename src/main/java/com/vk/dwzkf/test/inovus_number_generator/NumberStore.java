package com.vk.dwzkf.test.inovus_number_generator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Shageev
 * @since 12.08.2024
 */
public class NumberStore {
    private final Map<Long, Long> cache = new HashMap<>();
    private Long last = null;

    public void store(Long number) {
        cache.put(number, number);
        last = number;
    }

    public long size() {
        return cache.size();
    }

    public long next() {
        return last()+1;
    }

    public long last() {
        return last == null ? -1 : last;
    }

    public boolean isFree(Long number) {
        return !cache.containsKey(number);
    }
}
