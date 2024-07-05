package com.wplab.eltest;

public class MyMath {
    public static int intervalSum(int num1, int num2) {
    	int sum = 0;
    	
    	if (num1 < num2) {
    		for (int i = num1; i <= num2; i++) {
                sum += i;
            }
    	}
    	else {
    		sum = num1;
    	}
        
        return sum;
    }
    
    public static boolean compareChar(int source, char target) {
        char sourceChar = (char) source;
        return sourceChar == target;
    }
}
