package me.crazydopefox.mcinvbuilder.core.utils;

import java.util.Iterator;

public class IterateUtils {

    public static <T> Iterator<T> infinity(Iterable<T> collection, int skip) {
        Iterator<T> it = infinity(collection);
        for (int i = 0; i < skip; i++) {
            it.next();
        }
        return it;
    }

    public static <T> Iterator<T> infinity(Iterable<T> collection) {
        return infinity(collection, 0);
    }

}
