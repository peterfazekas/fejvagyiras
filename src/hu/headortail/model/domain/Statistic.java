package hu.headortail.model.domain;

public class Statistic {

	private int counter;
	private int headCounter;
	private int doubleHeadCounter;
	private int longestHeadSequence;
	private int longestSequenceStart;

	public int getCounter() {
		return counter;
	}
	
	public void incCounter() {
		counter++;
	}

	public int getHeadCounter() {
		return headCounter;
	}
	
	public void incHeadCounter() {
		headCounter++;
	}

	public int getDoubleHeadCounter() {
		return doubleHeadCounter;
	}
	
	public void incDoubleHeadCounter() {
		doubleHeadCounter++;
	}
	
	public int getLongestHeadSequence() {
		return longestHeadSequence;
	}
	
	public void setLongestHeadSequence(int longestHeadSequence) {
		this.longestHeadSequence = longestHeadSequence;
	}
	
	public int getLongestSequenceStart() {
		return longestSequenceStart;
	}
	
	public void setLongestSequenceStart(int longestSequenceStart) {
		this.longestSequenceStart = longestSequenceStart;
	}
	
	
}
