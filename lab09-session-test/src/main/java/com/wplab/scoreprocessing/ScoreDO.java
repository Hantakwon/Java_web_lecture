package com.wplab.scoreprocessing;
import java.util.ArrayList;

public class ScoreDO {
	private int[] scores;
	private long total;
	private double average = 0.0;
	private double stddev = 0.0;
	
	public ScoreDO() {
		// TODO Auto-generated constructor stub
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getStddev() {
		return stddev;
	}

	public void setStddev(double stddev) {
		this.stddev = stddev;
	}
	
	
}
