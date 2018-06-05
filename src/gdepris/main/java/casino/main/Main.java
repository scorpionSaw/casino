package casino.main;

import casino.model.Player;
import casino.model.Wheel;

public class Main {

	private static Wheel wheel;
	private static Player geoffrey;
	
	public static void main(String[] args){
		wheel = new Wheel();
		
		
		int nbSimulations = 100;
		
		int roundsPerSimulation = 100;
		
		int nbLose = 0;
		int nbWin = 0;
		
		int lesserBankroll = 1000000;
		int biggerBankroll = 0;
		int averageBankroll = 0;
		
		int startBankroll = 555;

		//wheel.roll(roundsPerSimulation);
		
		
		for(int i=0; i<nbSimulations; i++){


			geoffrey = new Player(startBankroll);
			wheel.rollColorMartingal(geoffrey, roundsPerSimulation, 1);
			
			if(geoffrey.getBankroll() < startBankroll){
				nbLose ++;
				
				if(lesserBankroll > geoffrey.getBankroll()){
					lesserBankroll = geoffrey.getBankroll();
				}
				
			} else {
				nbWin ++;
				
				if(biggerBankroll < geoffrey.getBankroll()){
					biggerBankroll = geoffrey.getBankroll();
				}
			}
			
			averageBankroll += geoffrey.getBankroll();
			
		}
		
		averageBankroll /= nbSimulations;
		
		System.out.println("Lose ["+nbLose+"] Win ["+nbWin+"] Lesser BankRoll ["+lesserBankroll+"] Bigger BankRoll ["+biggerBankroll+"] Average BankRoll ["+averageBankroll+"]");
		nbLose = 0;
		nbWin = 0;
		averageBankroll = 0;
		
		startBankroll = 555;
		
		for(int i=0; i<nbSimulations; i++){

			geoffrey = new Player(startBankroll);

			wheel.rollColorMartingalSmart(geoffrey, roundsPerSimulation, 1);
			
			if(geoffrey.getBankroll() < startBankroll){
				nbLose ++;
				
				if(lesserBankroll > geoffrey.getBankroll()){
					lesserBankroll = geoffrey.getBankroll();
				}
				
			} else {
				nbWin ++;
				
				if(biggerBankroll < geoffrey.getBankroll()){
					biggerBankroll = geoffrey.getBankroll();
				}
			}
			
			averageBankroll += geoffrey.getBankroll();
			
		}
		
		averageBankroll /= nbSimulations;
		
		System.out.println("Lose ["+nbLose+"] Win ["+nbWin+"] Lesser BankRoll ["+lesserBankroll+"] Bigger BankRoll ["+biggerBankroll+"] Average BankRoll ["+averageBankroll+"]");
		
	}
}
