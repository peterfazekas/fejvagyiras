package hu.headortail.model.service;

import hu.headortail.model.domain.Statistic;

public class StatisticService {

	private static final String HEAD = "F";
	
	private final Statistic statistic;
	private int headCounter = 0;
	
	public StatisticService(Statistic statistic) {
		this.statistic = statistic;
	}

	public void process(String coin) {
		statistic.incCounter();
		processHead(coin);
	}
	
	private void processHead(String coin) {
		if (HEAD.equals(coin)) {
			statistic.incHeadCounter();
			headCounter++;
		} else {
			if (headCounter == 2) {
				statistic.incDoubleHeadCounter();
			}
			if (headCounter > statistic.getLongestHeadSequence()) {
				statistic.setLongestHeadSequence(headCounter);
				statistic.setLongestSequenceStart(statistic.getCounter() - headCounter);
			}
			headCounter = 0;
		}
	}
}
