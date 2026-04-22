package tdd;

public class Game {
	
	public int current_roll=0;
	public int[] rolls=new int[21];
	
	void roll(int nbQuilles) {
		rolls[current_roll++] = nbQuilles;
	}
	
	int score() {
		int totalScore=0;
		int frameIndex=0;
		
		//il faut tester si c'est un strike avant de tester si c'est un spare 
		//parce que le strike est aussi un spare 
		for(int frame=0;frame<10;frame++) {
			if(isStrike(frameIndex)) {
				totalScore+=10+rolls[frameIndex+1]+rolls[frameIndex+2];
				frameIndex+=1;
			}
			else if(isSpare(frameIndex)) {
				totalScore+=10+rolls[frameIndex+2];
				frameIndex+=2;
			}
			else {
				totalScore+=rolls[frameIndex]+rolls[frameIndex+1];
				frameIndex+=2;
			}
		}
		return totalScore;
	}
	
	private boolean isSpare(int frameIndex) {
		if((rolls[frameIndex]+rolls[frameIndex+1])==10) {
			return true;
		}
		return false;
	}
	
	private boolean isStrike(int frameIndex) {
		if(rolls[frameIndex]==10) {
			return true;
		}
		else {
			return false;
		}
	}
}
