package com.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ArrayStructures {

    public int[] myArray = new int[20];
    int arraySize = 10;
    String reverseee = "";

    public void fillRandomNumbers() {
        for(int i=0; i< arraySize; i++) {
            myArray[i] = (int)(Math.random()*10) + 10;
        }
    }

    public void printOutPut() {
        System.out.println("---------");
        for (int i=0;i<arraySize;i++) {
            System.out.println("| " + i + " | " + myArray[i] + " |");
        }
        System.out.println("---------");
    }

    public int getValueAtIndex(int index) {
        int ret = -1;
        if (index < arraySize) {
            ret = myArray[index];
        }
        return ret;
    }

    public boolean doesArrayContainThisValue(int val) {
        boolean contain = false;
        for(int i=0; i<arraySize;i++) {
            if (myArray[i] == val) {
                contain = true;
            }
        }
        return contain;
    }

    public List<Integer> getIndexOfSearchVal(int val) {
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for(int i=0; i<arraySize;i++) {
            if (myArray[i] == val) {
                list.add(count, i);
                count++;
            }
        }
        return list;
    }

    public boolean deleteAnItem(int index) {
        boolean ret = false;
        if (index < arraySize) {
            for(int i=index;i<arraySize;i++) {
                myArray[i] = myArray[i+1];
            }
            arraySize--;
        }
        return ret;
    }

    public void usingRandomGeneratorNumber() {
        int[] array = new int[10];
        Random ran = new Random();
        ran.setSeed(System.currentTimeMillis());

        for(int i=0; i<array.length;i++ ) {
            array[i] = ran.nextInt(100);
        }

        int[] newarray = Arrays.copyOf(array,array.length);
        System.out.println("Are arrays equal: " + Arrays.equals(array, newarray));
        myArray = Arrays.copyOf(array, 10);
        
    }

    public void insertAnItem(int val) {
        if (arraySize < 20) {
            myArray[arraySize] = val;
        }
        arraySize++;
    }

    public void bubbleSort() {
        for(int i=arraySize-1;i>0;i--) {
            for(int j=0;j<i;j++) {
                if (myArray[j] > myArray[j+1]) {
                    swapVal(j, j+1);
                }
            }
        }
    }

    public void swapVal(int firstVal, int secVal) {
        int temp = myArray[firstVal];
        myArray[firstVal] = myArray[secVal];
        myArray[secVal] = temp;
    }

    public void binarySearch(int val) {
        int lowerIndex = 0;
        int higherIndex = arraySize -1;
        int count = 0;

        while(lowerIndex <= higherIndex) {
            int middleIndex = (lowerIndex + higherIndex)/2;
            if(myArray[middleIndex] < val) {
                lowerIndex = middleIndex + 1;
            } else if(myArray[middleIndex] > val) {
                higherIndex = lowerIndex - 1;
            } else {
                System.out.println("\nFound a match for " + val + " at Index " + middleIndex);
                lowerIndex = higherIndex + 1;
            }
            count++;
        }
        System.out.println("Processing complexity: " + count);
    }

    public void selectionSort() {
        int count = 0;
        for(int i=0; i<arraySize; i++) {
            int min = i;
            for(int j=i;j<arraySize; j++) {
                if (myArray[min] > myArray[j]) {
                    min = j;
                }
            }
            swapVal(i, min);
        }
    }

    public boolean isMatched(String expression) {
        final String opening = "{([";
        final String closing = "})]";

        Stack<Character> buff = new LinkedStack<>();

        for(char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buff.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buff.isEmpty()) {
                    return false;
                }
                if ((closing.indexOf(c) != opening.indexOf(buff.pop()))) {
                    return false;
                }
            }
        }
        return buff.isEmpty();
    }

    public void insertionSortRajeev() {
        int count1=0;
        int count2=0;
        for(int i=1; i<arraySize;i++) {
            count1++;
            for(int j=0; j< i;j++) {
                if (myArray[j] > myArray[i]) {
                    swapVal(j, i);
                }
                count2++;
            }
        }
        System.out.println("Total count for insertionsort: " + (count1 + count2) + " count1 " + count1 + " count2 " + count2);
    }

    public void insertionSort() {
        int count1=0;
        int count2=0;
        for(int i=1; i<arraySize;i++) {
            count1++;
            int curr = myArray[i];
            int j=i;
            while(j>0 && myArray[j-1] > curr) {
                myArray[j] = myArray[j-1];
                j--;
                count2++;
            }
            myArray[j] = curr;
        }
        System.out.println("Total count for insertionsort: " + (count1 + count2) + " count1 " + count1 + " count2 " + count2);
    }

    public void findDuplicate() {
        Set array = new HashSet();
        List<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = scan.nextInt();
        System.out.println("Enter array int elements: ");
        int count = 0;
        while(count < n) {
            count++;
            int input = scan.nextInt();
            boolean dup = array.add(input);
            if (dup == false) {
                list.add(input);
            }
        }
        System.out.println("Array elements: " + Arrays.asList(array));
        System.out.println("Duplicate Array elements: " + Arrays.asList(list));
    }

    public void isPalindrome1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scan.nextLine();
        System.out.println("String: " + input);

        char[] array = input.toCharArray();
        int j = input.length() - 1;
        int count = 0;
        long time = System.currentTimeMillis();
        for(int i=0; i<input.length(); i++) {
            if (array[i] == array[j--]) {
                if (count == (input.length()/2 + 1)) {
                    System.out.println("Input string is Palindrom");
                    System.out.println("Time is mill sec: " + (System.currentTimeMillis() - time));
                    return;
                }
                count++;
            }
        }
        if (count != input.length()/2 + 1) {
            System.out.println("Input string is not Palindrom2");
        }
    }

    public void isPalindrome2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scan.nextLine();
        System.out.println("String: " + input);

        String reverse = new StringBuffer(input).reverse().toString();
        System.out.println("Input string is Palindrome ? " + reverse.equals(input));

        String rev = new StringBuilder(input).reverse().toString();
        System.out.println("Input string is Palindrome ? " + rev.equals(input));

        String newstr = "";
        for(int i = input.length() -1; i >= 0; i--) {
            newstr = newstr + input.charAt(i);
        }
        System.out.println("Input string is Palindrome ? " + newstr.equals(input));
    }

    public void removeCharAt() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scan.nextLine();
        System.out.println("String: " + input);
        Scanner rem = new Scanner(System.in);
        System.out.println("Input char remove:");
        int remInt = rem.nextInt();

        String newstr = "";
        for(int i=0; i<input.length(); i++) {
            if(i != remInt-1) {
                newstr = newstr + input.charAt(i);
            }
        }
        System.out.println("new String: " + newstr);
    }

    public void reverseString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input String: ");
        String input = scan.nextLine();
        System.out.println("String: " + input);

        String newstr = "";
        for(int i = input.length() -1; i >= 0; i--) {
            newstr = newstr + input.charAt(i);
        }

        System.out.println("Reverse a String: " + newstr);
    }

    public String reverseStringRecurcively(String str) {
        if (str.length() == 1) {
            return str;
        } else {
           return reverseee += str.charAt(str.length()-1) + reverseStringRecurcively(
                           str.substring(0, str.length()-1));
        }
    }

    public void strToInt() {
        String str = "-1234";
        int num = Integer.parseInt(str);
        System.out.println("Str to Int with parseInt: " + num);

        int val = Integer.valueOf(str);
        System.out.println("Str to Int with valueOf: " + val);
        System.out.println("Str to Int with valueOf: " + (int)'0');
    }

    public void strToIntManually() {
        String str = "";
        int i = 0;
        int num = 0;
        boolean isNeg = false;

        if (str.charAt(0) == '-') {
            System.out.println("This is a negative num: ");
            i = 1;
            isNeg = true;
        }

        while(i < str.length()) {
            if (str.charAt(i) >= '0' && (str.charAt(i)) <= '9') {
                num *= 10;
                num += str.charAt(i++) - '0';
            } else {
                System.out.println("This is not a Number, Format exception");
                break;
            }
        }
        if (isNeg) {
            num = -num;
        }
        System.out.println("Final Output: " + num);
    }

    public static void autoBoxingEx() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(1);
        Integer a = 128;
        Integer b = 128;

        System.out.println("Out Values: " + (a == b));
    }
    
    /*
     * Program to find missing number from 1 to 9 integers
     */
    public void missingNumber() {
    	int[] array = {1,2,4,5,6,7,8,9};
    	int sum = 0;
    	for(int k=0;k<array.length;k++){
    		sum+=array[k];
    	}
    	System.out.println("total sum :" + sum);
    	int n = array.length+1;
    	System.out.println("what is n: " + n);
    	System.out.println("total sum :" + (n*(n+1)/2 - sum));
    	int a = 1;
    	int b = 1;
    	for (int i=1; i<=9; i++) {
    		a = a^i;
    	}
    	System.out.println("Inter mediate output: " + a);
    	
    	for(int j=0; j<array.length; j++) {
    		b = b^array[j];
    	}
    	System.out.println("final output: " + (a^b));
    }
    
    /*
     * Program to find missing number from 1 to 10
     * using BitSet. 
     */
    public void missingNumbWithBitset() {
    	int[] a = {2,4,5,7,8,9,10};
    	int n=10;
    	BitSet bitset = new BitSet(n);
    	for(int i=0;i<a.length;i++){
    		bitset.set(a[i]-1);
    	}
    	int missingcount = n - a.length;
    	int lastmissingcount = 0;
    	for(int j=0;j<missingcount;j++){
    		lastmissingcount = bitset.nextClearBit(lastmissingcount);
    		System.out.println(++lastmissingcount);
    	}
    }
    
    /*
     * find pairs of numbers equal to a number
     */
    public void numberPair() {
    	int[] a = {1,2,3,4,5,6};
    	for(int i=0;i<a.length;i++){
    		for(int j=0;j<a.length;j++){
    			if(5 == (a[i] + a[j])){
    				System.out.println("pair of elements: " + "[" + a[i] + "," + a[j] + "]");
    			}
    		}
    	}
    }
    
    public void insertionSort2nd() {
    	for(int i=0; i<arraySize; i++) {
    		int j = i;
    		while(j>0 && myArray[j] < myArray[j-1]) {
    			swapVal(j, j-1);
    			j--;
    		}
    	}
    }

    public static void main(String[] args) {
        ArrayStructures arrayst = new ArrayStructures();
        //arrayst.fillRandomNumbers();
        //arrayst.printOutPut();
        arrayst.usingRandomGeneratorNumber();
        //arrayst.insertionSortRajeev();
        //arrayst.insertionSort();
        //arrayst.printOutPut();
        //arrayst.findDuplicate();
        //arrayst.reverseString();
        //System.out.println("what is the output: " + 5/2);
        //System.out.println("Reverse String Recurcively: " + arrayst.reverseStringRecurcively("This is code of recursion!!"));
        //System.out.println("Length: " + "This is code of recursion!!".length());
        //arrayst.strToIntManually();
        //arrayst.autoBoxingEx();
        //System.out.println("Find out: " + arrayst.reverseStringRecurcively("This is code of recursion!!"));
        //arrayst.missingNumbWithBitset();
        //arrayst.numberPair();
        arrayst.insertionSort2nd();
        arrayst.printOutPut();
    }

}
