package com.company;

import java.util.*;

/**
 * Created by gaurav on 5/4/17.
 */
public class Cracking {

    public boolean stringHasAlluniqueCharacter(String s){
        if(s==null)
            return false;
    /*    char[] temp= s.toCharArray();
        Arrays.sort(temp);
        for(int i=0;i<temp.length-1;i++){
            if(temp[i]==temp[i+1])
                return false;
       }*/
        Map<Character, Integer> map= new HashMap<>();
        char[] temp= s.toCharArray();
        for(int i=0; i<s.length();i++){
            //int k= map.containsKey(temp[i])? map.get(temp[i])+1: 0;
            //map.put(temp[i],k);
            if(map.containsKey(temp[i]))
                return false;
            else {
                int k= map.containsKey(temp[i])? map.get(temp[i])+1: 0;
                map.put(temp[i], k);
            }
        }
       return true;
    }

    public String reverseNullTerminatedString(String s){
        /*if(s==null)
            return;
        char[] temp=s.toCharArray();
        String rev="";
        for(int i=s.length()-1;i>=0;i--)
            rev+=temp[i];
        System.out.print("reverse "+ rev);*/
        if(s.length()<=1)
            return s;
        return reverseNullTerminatedString(s.substring(1))+s.charAt(0);

    }
}
