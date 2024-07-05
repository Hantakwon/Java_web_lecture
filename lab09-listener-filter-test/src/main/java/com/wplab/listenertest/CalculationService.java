package com.wplab.listenertest;

public class CalculationService {
	public long intervalSum(int first, int second) {
		long sum = 0;
		if (first <= second) {
			for(int i=first; i<=second; i++) {
				sum += i;
			}
		}
		return sum;
	}
}
