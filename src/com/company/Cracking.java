package com.company;

import java.util.*;

/**
 * Created by gaurav on 5/4/17.
 */
public class Cracking {

    public boolean stringHasAlluniqueCharacter(String s) {
        if (s == null)
            return false;
    /*    char[] temp= s.toCharArray();
        Arrays.sort(temp);
        for(int i=0;i<temp.length-1;i++){
            if(temp[i]==temp[i+1])
                return false;
       }*/
        Map<Character, Integer> map = new HashMap<>();
        char[] temp = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //int k= map.containsKey(temp[i])? map.get(temp[i])+1: 0;
            //map.put(temp[i],k);
            if (map.containsKey(temp[i]))
                return false;
            else {
                int k = map.containsKey(temp[i]) ? map.get(temp[i]) + 1 : 0;
                map.put(temp[i], k);
            }
        }
        return true;
    }

    public String reverseNullTerminatedString(String s) {
        /*if(s==null)
            return;
        char[] temp=s.toCharArray();
        String rev="";
        for(int i=s.length()-1;i>=0;i--)
            rev+=temp[i];
        System.out.print("reverse "+ rev);*/
        if (s.length() <= 1)
            return s;
        return reverseNullTerminatedString(s.substring(1)) + s.charAt(0);

    }

    boolean oneStringPermutationOther(String s1, String s2) {
        if (s1 == null && s2 != null)
            return false;
        if (s1 != null && s2 == null)
            return false;
        if (s1 == null && s2 == null)
            return false;
        /*int l1=s1.length(), l2=s2.length();
        if(l1!=l2)
            return false;
        char[] t1=s1.toCharArray();
        char[] t2=s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        for(int i=0;i<l1;i++){
            if(t1[i]!=t2[i])
                return false;
        }
        return true;*/
        Map<Character, Integer> map = new HashMap<>();
        char[] t1 = s1.toCharArray();
        char[] t2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            int k = map.containsKey(t1[i]) ? map.get(t1[i]) + 1 : 0;
            map.put(t1[i], k);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(t2[i]))
                return false;
        }
        return true;
    }

    void generatePermutationsOfString(String s) {
        if (s == null)
            return;
        permute(s, 0, s.length() - 1);
    }

    void permute(String s, int l, int r) {
        if (l == r)
            System.out.println(s);
        else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permute(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }


    String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
