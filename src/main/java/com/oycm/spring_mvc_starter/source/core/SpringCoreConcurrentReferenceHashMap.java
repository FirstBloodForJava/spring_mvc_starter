package com.oycm.spring_mvc_starter.source.core;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Iterator;

/**
 * @author ouyangcm
 * create 2024/2/28 16:45
 */
public class SpringCoreConcurrentReferenceHashMap {

    public static void main(String[] args) {
        ConcurrentReferenceHashMap<String, String> referenceMap = new ConcurrentReferenceHashMap<>();

        System.out.println(referenceMap.put("key", "value"));

        System.out.println(referenceMap);

    }
}
class MyIterator  implements Iterator<Long> {

    long unseen;

    long lastReturned = 0;

    public MyIterator(long unseen) {
        this.unseen = unseen;
    }

    @Override
    public boolean hasNext() {
        return unseen != 0;
    }

    @Override
    public java.lang.Long next() {

        lastReturned = Long.numberOfTrailingZeros(unseen);

        unseen = (unseen >> lastReturned);

        return lastReturned;
    }
}
