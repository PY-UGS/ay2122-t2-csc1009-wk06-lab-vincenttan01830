package com.company;

import java.util.*;

public class HashMap {

    //Question 1: Adding a value into the linked hash map and sort it
    public static LinkedHashMap<Integer, Integer> addAndSort(LinkedHashMap<Integer, Integer> lhm, int value) {
        Set<Integer> keys = lhm.keySet();
        lhm.put(keys.size(), 0);
        int temp = 0;
        for (Integer key : keys) {
            if (value < lhm.get(key)) {
                temp = lhm.get(key);
                lhm.put(key, value);
                value = temp;
            }
        }
        lhm.put(keys.size() - 1, value);
        return lhm;
    }

    //Question 2: Swapping the position of the values
    public static LinkedHashMap<Integer, Integer> swapValues(LinkedHashMap<Integer, Integer> lhm, int indOne, int indTwo) {
        if(indOne != indTwo){
            Set<Integer> keys = lhm.keySet();
            if(indOne < keys.size() && indTwo < keys.size()) {
                int valOne = lhm.get(indOne);
                int valTwo = lhm.get(indTwo);
                for (Integer key : keys) {
                    if (key == indOne) {
                        lhm.put(indOne, valTwo);
                        lhm.put(indTwo, valOne);
                    }
                }
                return lhm;
            }
        }
        return lhm;
    }

    //Question 3: Finding the existence of a value in the list
    public static int numExist(LinkedHashMap<Integer, Integer> list, int val) {
        Set<Integer> keys = list.keySet();
        for (Integer key : keys) {
            if (val == list.get(key)) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        lhm.put(0, 1);
        lhm.put(1, 3);
        lhm.put(2, 5);
        lhm.put(3, 7);
        lhm.put(4, 9);
        lhm.put(5, 11);
        System.out.println("Elements in Linked Hashmap before insertion: " + lhm);
        LinkedHashMap<Integer, Integer> sortedHashMap = addAndSort(lhm, 6);
        System.out.println("Elements in sorted Linked Hashmap after insertion: " + sortedHashMap);

        System.out.println("Elements in Linked Hashmap before swap: " + lhm);
        swapValues(sortedHashMap, 1, 3);
        System.out.println("Elements in sorted Linked Hashmap after swap: " + sortedHashMap);

        //Question 3: Finding the existence of a value in the list
        LinkedHashMap<Integer, Integer> randomlhm = new LinkedHashMap<>();
        int min = 1000;
        int max = 9999;

        for(int i = 0; i <= 500; i++){
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            randomlhm.put(i, random_int);
        }
        System.out.println("Linked Hash Map with random integers: " + randomlhm);
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        int found = numExist(randomlhm, random_int);
        System.out.println("New random number is " + random_int);
        if(found != -1){
            System.out.println("Number is found in index: " + found);
        }
        else{
            System.out.println("Number not found in the list");
        }

    }
}
