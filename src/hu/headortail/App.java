package hu.headortail;

import java.util.Random;
import java.util.Scanner;

import hu.headortail.controller.HeadOrTail;
import hu.headortail.model.domain.Statistic;
import hu.headortail.model.service.Console;
import hu.headortail.model.service.DataReader;
import hu.headortail.model.service.ResultWriter;
import hu.headortail.model.service.Simulate;
import hu.headortail.model.service.StatisticService;

public class App {

	private final HeadOrTail headOrTail;
	private final Console console;
	private final ResultWriter resultWriter;
	
	public App() {
		Random random = new Random();
		Statistic statistic = new Statistic();
		DataReader file = new DataReader(new StatisticService(statistic));
		file.read("kiserlet.txt");
		Simulate simulate = new Simulate(random);
		headOrTail = new HeadOrTail(statistic, simulate);
		console = new Console(new Scanner(System.in));
		resultWriter = new ResultWriter("dobasok.txt");
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		System.out.println("1. feladat: " + headOrTail.getFirstTossUp());
		String bet = console.readBet("2. feladat: Tippeljen! [F/I]: ");
		System.out.println(headOrTail.getBetResult(bet));
		System.out.println("3. feladat: " + headOrTail.getExperimentCount());
		System.out.println("4. feladat: " + headOrTail.getHeadStatistic());
		System.out.println("5. feladat: " + headOrTail.getDoubleHeadCount());
		System.out.println("6. feladat: " + headOrTail.getLongestSequenceDetail());
		resultWriter.print(headOrTail.getSimulationStatistic());
	}

}
