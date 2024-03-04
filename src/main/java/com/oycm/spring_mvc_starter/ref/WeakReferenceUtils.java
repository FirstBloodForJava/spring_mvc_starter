package com.oycm.spring_mvc_starter.ref;

import com.oycm.spring_mvc_starter.ref.pojo.BigObject;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/3/4 10:36
 */
@SuppressWarnings(value = "all")
public class WeakReferenceUtils {
    public static void main(String[] args) {

        ReferenceQueue<BigObject> referenceQueue = new ReferenceQueue<BigObject>();
        List<WeakReference<BigObject>> referenceList = new ArrayList<>();
        List<BigObject> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeakReference<BigObject> userWeakReference = new WeakReference<>(new BigObject(), referenceQueue);
            if (i < 10){
                list.add(userWeakReference.get());
            }
            referenceList.add(userWeakReference);
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
