package com.company;

public class Main {

    public static void main(String[] args) {
        Cracking ck= new Cracking();
        /*System.out.println("unoque characters "+ ck.stringHasAlluniqueCharacter("qwertyuiopq"));
        System.out.println(ck.reverseNullTerminatedString("gaurav is awesome"));
        System.out.print("permutation of two strings "+ ck.oneStringPermutationOther("abc", "bca"));*/
        //ck.generatePermutationsOfString("abc");
        //System.out.println(" google search "+ ck.implementingGoogleSearch("i am gaurav"));
       //ck.stringCompression("aaabccccddddddddac");
        int arr[][]= { {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        //ck.rotateMatrixBy90antiClockWise(arr);
        //ck.rotateMatrixBy90Clockwise(arr);
        ck.rotateMatrixInPlace(arr);
    }
}
