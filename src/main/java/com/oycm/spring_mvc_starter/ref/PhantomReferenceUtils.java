package com.oycm.spring_mvc_starter.ref;

import com.oycm.spring_mvc_starter.ref.pojo.BigObject;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/3/4 13:27
 */
@SuppressWarnings(value = "all")
public class PhantomReferenceUtils {

    public static void main(String[] args) {

        ReferenceQueue<BigObject> referenceQueue = new ReferenceQueue<BigObject>();
        List<PhantomReference<BigObject>> referenceList = new ArrayList<>();
        List<BigObject> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            BigObject bigObject = new BigObject();
            PhantomReference<BigObject> userPhantomReference = new PhantomReference<>(bigObject, referenceQueue);
            if (i < 10){
                list.add(bigObject);
            }
            referenceList.add(userPhantomReference);
            Reference<? extends BigObject> temp = referenceQueue.poll();
            System.out.println(i + ": " + temp);
        }
        for (int i = 0; i < referenceList.size(); i++) {
            if (referenceList.get(i).get() != null){
                System.out.println(i + " hava " + referenceList.get(i));
            }else {
                System.out.println(i + ": " + referenceList.get(i));
            }
        }
        System.out.println();
    }
}
