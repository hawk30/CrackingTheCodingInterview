package com.company;

public class Main {

    public static void main(String[] args) {
        Cracking ck= new Cracking();
        /*System.out.println("unoque characters "+ ck.stringHasAlluniqueCharacter("qwertyuiopq"));
        System.out.println(ck.reverseNullTerminatedString("gaurav is awesome"));
        System.out.print("permutation of two strings "+ ck.oneStringPermutationOther("abc", "bca"));*/
        ck.generatePermutationsOfString("abc");
        System.out.println(" google search "+ ck.implementingGoogleSearch("i am gaurav"));
    }
}
