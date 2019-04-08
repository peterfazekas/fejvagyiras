package hu.headortail.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import hu.headortail.model.domain.Statistic;
import hu.headortail.model.service.Simulate;

public class HeadOrTail {

	private static final String FFFF = "FFFF";
	private static final String FFFI = "FFFI";
	
	private final Statistic statistic;
	private final Simulate simulate;

	public HeadOrTail(Statistic statistic, Simulate simulate) {
		this.statistic = statistic;
		this.simulate = simulate;
	}

	public String getFirstTossUp() {
		return String.format("A p�nzfeldob�s eredm�nye: %s", simulate.tossUp());
	}
	
	public String getBetResult(String bet) {
		String result = simulate.tossUp();
		return String.format("A tipp %s, a dob�s %s volt.%n%s", 
				bet, result, bet.startsWith(result) ? "�n eltal�lta!" : "�n nem tal�lta el!");
	}
	
	public String getExperimentCount() {
		return String.format("A k�s�rlet %d dob�sb�l �llt.", statistic.getCounter());
	}
	
	public String getHeadStatistic() {
		return String.format("A k�s�rlet sor�n a fej relat�v gyakoris�ga %4.2f%% volt.", 
				statistic.getHeadCounter() * 100.0 / statistic.getCounter());
	}
	
	public String getDoubleHeadCount() {
		return String.format("A kis�rlet sor�n %d alkalommal dobtak pontosan k�t fejet egym�s ut�n.", 
				statistic.getDoubleHeadCounter());
	}
	
	public String getLongestSequenceDetail() {
		return String.format("A leghosszabb tisztafej sorozat %d tagb�l �ll, kezdete a(z) %d. dob�s", 
				statistic.getLongestHeadSequence(), statistic.getLongestSequenceStart());
	}
	
	public String getSimulationStatistic() {
		List<String> simulationResult = getSimulationResult();
		StringBuilder sb = new StringBuilder();
		sb.append(FFFF).append(": ").append(countEvents(simulationResult, FFFF)).append(", ")
			.append(FFFI).append(": ").append(countEvents(simulationResult, FFFI)).append("\r\n")
			.append(printSimulationResult(simulationResult));
		return sb.toString();
	}
	
	private String printSimulationResult(List<String> results) {
		return results.stream().collect(Collectors.joining(" ")) ;
	}
	
	private long countEvents(List<String> results, String pattern) {
		return results.stream().filter(i -> i.equals(pattern)).count();
	}
	
	private List<String> getSimulationResult() {
		return IntStream.range(0,  1000).mapToObj(i -> getFourTossUps()).collect(Collectors.toList());
	}
	
	private String getFourTossUps() {
		return IntStream.range(0,  4).mapToObj(i -> simulate.tossUp()).collect(Collectors.joining());
	}
}
