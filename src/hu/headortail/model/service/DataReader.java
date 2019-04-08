package hu.headortail.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	private final StatisticService statisticService;
	
	public DataReader(StatisticService statisticService) {
		this.statisticService = statisticService;
	}

	public void read(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			br.lines().forEach(statisticService::process);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
