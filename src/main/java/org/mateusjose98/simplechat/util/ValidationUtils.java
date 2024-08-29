package org.mateusjose98.simplechat.util;

import java.util.List;

public class ValidationUtils {

    public static List<?> requireSize(List<?> list, int size) {
        if (list.size() != size) {
            throw new IllegalArgumentException("List size must be " + size);
        }
        return list;
    }
}
