package com.company;

public class PracticeArrays {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, 3, 4};
        char[] b = {'a', 'e', 'd', 'e', 'b'};
        char target = 'd';
        String[] c = {"death and taxes", "xenophobia", "boo", "terrible two's", "exciting times"};
        int size = 5, value = 7;
        int[] d;
        String[] e;


        System.out.println(noNegatives(a));
        System.out.println(eCount(b));
        System.out.println(charCount(b, target));
        System.out.println(isSorted(a));
        System.out.println(equalNeighbors(b));
        System.out.println(xCount(c));

        absoluteValues(a);
        for (int j : a) {
            System.out.print(j + "\t");
        }

        System.out.println();
        d = createIntArray(size, value);
        for (int i = 0; i < size; i++) {
            System.out.print(d[i] + "\t");
        }

        System.out.println();
        e = stringsWithXs(c);
        for (String s : e) {
            System.out.print(s + "\t");
        }
    }


    /*
    Write a method named noNegatives. It should accept an array of integers. It should return true if none of the
    values are negative. If any of the values are negative it should return false
     */

    public static boolean noNegatives(int[] a) {
        for (int j : a) {
            if (j < 0) {
                return false;
            }
        }
        return true;
    }


    /*
    Write a method named absoluteValues. It should accept an array of integers. It should replace any negative values
    with the corresponding positive value.
     */

    public static void absoluteValues(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                a[i] *= -1;
            }
        }
    }


    /*
    Write a method named eCount. It should accept an array of chars. It should return the number of times that the
    character ‘e’ shows up in the array.
     */

    public static int eCount(char[] a) {
        int count = 0;
        char target = 'e';

        for (char c : a) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }


    /*
    Write a method named charCount. It should be similar to eCount, but instead of counting ‘e’s it should accept a
    second argument, a target char. The method should return the number of times the target char shows up in the array
     */

    public static int charCount(char[] a, char targetChar) {
        int count = 0;

        for (char c : a) {
            if (c == targetChar) {
                count++;
            }
        }
        return count;
    }


    /*
    Write a method named isSorted. It should accept an array of integers and return true if the values are sorted in
    ascending order. False if they are not.
     */

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }


    /*
    Write a method named equalNeighbors. It should accept an array of chars. It should return true if there are two
    adjacent elements in the array with equal values. If there are not, it should return false.
     */


    public static boolean equalNeighbors(char[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                return true;
            }
        }
        return false;
    }


    /*
    Write a method named xCount that accepts an array of String objects, and returns the number of x’s in the strings.
    You can use an inner loop and the charAt() method in String.
     */

    public static int xCount(String[] a) {
        int count = 0;
        char target = 'x';

        for (String s : a) {

            for (int x = 0; x < s.length(); x++) {
                if (s.charAt(x) == target) {
                    count++;
                }
            }
        }
        return count;
    }


    /*
    Write a method named createIntArray. It should accept two int arguments: count, and initialValue.  It should return
    a new array with count element, each initialized to initialValue.
     */

    public static int[] createIntArray(int count, int initialValue) {
        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            array[i] = initialValue;
        }
        return array;
    }


    /*
    Write a method named stringsWithXs. It should accept an array of Strings, and return a new array of Strings that
    contains each String from the original array that has an x.
     */

    public static String[] stringsWithXs(String[] a) {
        String[] array = new String[a.length];
        char target = 'x';
        boolean hasX = false;
        int index, count = 0;

        for (String s : a) {
            index = 0;

            while (!hasX && index < s.length()) {
                if (s.charAt(index) == target) {
                    hasX = true;
                }
                index++;
            }

            if (hasX) {
                array[count] = s;
                count++;
                hasX = false;
            }
        }

        String[] finalArray = new String[count];
        System.arraycopy(array,0,finalArray, 0, count);

        return finalArray;
    }
}
