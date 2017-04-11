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

    String implementingGoogleSearch(String s) {
        if (s == null)
            return s;
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                spaceCount++;
        }
        int newLength = s.length() + 2 * spaceCount;
        char[] newStr = new char[newLength];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                newStr[newLength - 1] = '0';
                newStr[newLength - 2] = '2';
                newStr[newLength - 3] = '%';
                newLength -= 3;
            } else {
                newStr[newLength - 1] = s.charAt(i);
                newLength -= 1;
            }
        }
        return String.valueOf(newStr);
    }

    void stringCompression(String s) {
        String t = s + " ";
        if (t == null)
            return;
        StringBuilder br = new StringBuilder();
        int count = 1;
        char temp = t.charAt(0);
        for (int i = 1; i < t.length(); i++) {
            if (t.charAt(i) == temp)
                count++;
            else {
                br.append("" + temp + count);
                count = 1;
                temp = t.charAt(i);
            }
        }
        System.out.print(String.valueOf(br));
    }


    void rotateMatrixBy90antiClockWise(int[][] arr) {
        System.out.println("original matrix");
        printMatrix(arr);
        System.out.println();
        transposematrix(arr);
        reverseColumn(arr);
        printMatrix(arr);

    }

    private void reverseColumn(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
        }
    }

    private void transposematrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }


    private void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    void rotateMatrixBy90Clockwise(int[][] arr) {
        System.out.println("original matrix");
        printMatrix(arr);
        System.out.println();
        transposematrix(arr);
        reverseRow(arr);
        printMatrix(arr);
    }

    void reverseRow(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, k = arr.length - 1; j < k; j++, k--) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
            }
        }
    }
  /*  Rotate by +90:

    Transpose
    Reverse each row

    Rotate by -90:

    Method 1 :

    Transpose
    Reverse each column

    Method 2 :

    Reverse each row
            Transpose

    Rotate by +180:

    Method 1: Rotate by +90 twice

    Method 2: Reverse each row and then reverse each column (Transpose)

    Rotate by -180:

    Method 1: Rotate by -90 twice

    Method 2: Reverse each column and then reverse each row

    Method 3: Rotate by +180 as they are same*/

    void rotateMatrixInPlace(int[][] arr) {
        printMatrix(arr);
        int size = arr.length;
        int layer_count = size / 2;
        for (int i = 0; i < layer_count; i++) {
            int first = i;
            int last = size - first - 1;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int top = arr[first][j];
                int right_side = arr[j][last];
                int bottom = arr[last][last - offset];
                int left_side = arr[last - offset][first];

                arr[first][j] = left_side;
                arr[j][last] = top;
                arr[last][last - offset] = right_side;
                arr[last - offset][first] = bottom;

            }
        }
        System.out.println("after rotation ");
        printMatrix(arr);
    }

    void setEntirerowColumnToZero(int[][] arr) {
        printMatrix(arr);
        if (arr == null)
            return;
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++)
            row[i] = 1;
        for (int i = 0; i < arr[0].length; i++)
            col[i] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (row[i] == 0 || col[j] == 0)
                    arr[i][j] = 0;
            }
        }
        printMatrix(arr);
    }
}