package com.wplab.scoreprocessing;

public class ScoreProcessingService {

	public void processScores(ScoreDO scoreDO) {
		long sum = 0;
		long ssum = 0;
		int[] scores = scoreDO.getScores();
		
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
			ssum += (scores[i] * scores[i]);
		}

		double avg = (double)sum/scores.length;
		double var = ((double)ssum/scores.length) - (avg * avg);

		scoreDO.setTotal(sum);
		scoreDO.setAverage(avg);
		scoreDO.setStddev(Math.sqrt(var));
	}
	
}