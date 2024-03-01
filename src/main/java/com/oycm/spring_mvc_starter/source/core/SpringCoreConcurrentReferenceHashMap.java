package com.oycm.spring_mvc_starter.source.core;

import java.util.Iterator;

/**
 * @author ouyangcm
 * create 2024/2/28 16:45
 */
public class SpringCoreConcurrentReferenceHashMap {

    public static void main(String[] args) {
        for (long i = Long.MIN_VALUE; i < Long.MAX_VALUE ; i += 1L) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            MyIterator iterator = new MyIterator(i);
            while (iterator.hasNext()){
                s1.append(iterator.next()).append(",");
            }

            EnumSetIterator enumSetIterator = new EnumSetIterator(i);
            while (enumSetIterator.hasNext()){
                s2.append(enumSetIterator.next()).append(",");
            }
            if (!s1.toString().equals(s2.toString())){
                System.err.println(s1);
                System.err.println(s2);
            }
            //break;
        }

    }
}
class MyIterator implements Iterator<Long> {

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
    public Long next() {
        if (unseen == 0){
            throw new RuntimeException("no element");
        }
        // 从右边开始找1
        lastReturned = Long.numberOfTrailingZeros(unseen);

        unseen &= ~(1L << lastReturned);

        return lastReturned;
    }
}
class EnumSetIterator implements Iterator<Integer> {

    long unseen;

    long lastReturned = 0;

    EnumSetIterator(Long unseen) {
        this.unseen = unseen;
    }

    @Override
    public boolean hasNext() {
        return unseen != 0;
    }

    @Override
    public Integer next() {
        if (unseen == 0)
            throw new RuntimeException();
        lastReturned = unseen & -unseen;
        unseen -= lastReturned;
        return Long.numberOfTrailingZeros(lastReturned);
    }
}
