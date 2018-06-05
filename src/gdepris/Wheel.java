package gdepris;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Wheel {
	
	Square[] numbers = new Square[37]; {
			numbers[0] = new Square(0, SquareColor.GREEN);
			numbers[1] = new Square(1, SquareColor.RED);
			numbers[2] = new Square(2,SquareColor.BLACK);
			numbers[3] = new Square(3,SquareColor.RED);
			numbers[4] = new Square(4,SquareColor.BLACK);
			numbers[5] = new Square(5,SquareColor.RED);
			numbers[6] = new Square(6,SquareColor.BLACK);
			numbers[7] = new Square(7,SquareColor.RED);
			numbers[8] = new Square(8,SquareColor.BLACK);
			numbers[9] = new Square(9,SquareColor.RED);
			numbers[10] = new Square(10,SquareColor.BLACK);
			numbers[11] = new Square(11,SquareColor.BLACK);
			numbers[12] = new Square(12,SquareColor.RED);
			numbers[13] = new Square(13,SquareColor.BLACK);
			numbers[14] = new Square(14,SquareColor.RED);
			numbers[15] = new Square(15,SquareColor.BLACK);
			numbers[16] = new Square(16,SquareColor.RED);
			numbers[17] = new Square(17,SquareColor.BLACK);
			numbers[18] = new Square(18,SquareColor.RED);
			numbers[19] = new Square(19,SquareColor.RED);
			numbers[20] = new Square(20,SquareColor.BLACK);
			numbers[21] = new Square(21,SquareColor.RED);
			numbers[22] = new Square(22,SquareColor.BLACK);
			numbers[23] = new Square(23,SquareColor.RED);
			numbers[24] = new Square(24,SquareColor.BLACK);
			numbers[25] = new Square(25,SquareColor.RED);
			numbers[26] = new Square(26,SquareColor.BLACK);
			numbers[27] = new Square(27,SquareColor.RED);
			numbers[28] = new Square(28,SquareColor.BLACK);
			numbers[29] = new Square(29,SquareColor.BLACK);
			numbers[30] = new Square(30,SquareColor.RED);
			numbers[31] = new Square(31,SquareColor.BLACK);
			numbers[32] = new Square(32,SquareColor.RED);
			numbers[33] = new Square(33,SquareColor.BLACK);
			numbers[34] = new Square(34,SquareColor.RED);
			numbers[35] = new Square(35,SquareColor.BLACK);	
			numbers[36] = new Square(36,SquareColor.RED);	
	}

	private Random random = new Random();
	
	
	public int rollColorMartingal(Player player, int rounds, int startingBet){
		
		int bet = startingBet;
		//start bet
		SquareColor color = SquareColor.RED;
		
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= bet){
				break;
			}
			
			int tempInt = random.nextInt(37);
			SquareColor tempColor =  numbers[tempInt].getColor();
				
			if(color.equals(tempColor)) {
				player.add(bet);
				bet = startingBet;
				
			} else {				
				player.remove(bet);				
				bet *= 2;
			}
		}
		
		return player.getBankroll();
	}

	
	public int rollColorMartingalSmart(Player player, int rounds, int startingBet){
		
		int bet = startingBet;
		//start bet
		SquareColor color = SquareColor.RED;
		
		float redColorChance = 48.65f;
		float blackColorChance = 48.65f;
		
		/*
		 * Un numéro d'une couleur a 2.70% de chance d'être pris
		 */
		
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= bet){
				break;
			}
			
			if(redColorChance >= blackColorChance){
				color = SquareColor.RED;
			} else {
				color = SquareColor.BLACK;
			}
			
			int tempInt = random.nextInt(37);
			SquareColor tempColor =  numbers[tempInt].getColor();
			
			if(tempColor.equals(SquareColor.RED)){
				redColorChance -= 2.70f;
				blackColorChance += 2.70f;
			} else if(tempColor.equals(SquareColor.BLACK)){
				redColorChance += 2.70f;
				blackColorChance -= 2.70f;
			}
				
			if(color.equals(tempColor)) {
				player.add(bet);
				bet = startingBet;
				
			} else {				
				player.remove(bet);				
				bet *= 2;
			}
		}
		
		return player.getBankroll();
	}
	
	public int rollColorSuperMartingal(Player player, int rounds, int startingBet){
		
		int bet = startingBet;
		
		//start bet
		SquareColor color = SquareColor.RED;
		
		
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= bet){
				break;
			}
			
			int tempInt = random.nextInt(37);
			SquareColor tempColor =  numbers[tempInt].getColor();
				
			if(color.equals(tempColor)) {
				player.add(bet);
				bet = startingBet;
			} else {
				player.remove(bet);				
				bet = bet * 2 + 1;
			}
		}
		
		return player.getBankroll();
	}

	public int rollColorMartingalAlembert(Player player, int rounds, int startingBet){

		int bet = startingBet;
		//start bet
		SquareColor color = SquareColor.RED;
		
		
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= bet){
				break;
			}
			
			int tempInt = random.nextInt(37);
			SquareColor tempColor =  numbers[tempInt].getColor();
				
			if(color.equals(tempColor)) {
				player.add(bet);
				
				if(bet == 1){
					bet = startingBet;
				} else {
					bet -= 1;	
				}
				
			} else {
				player.remove(bet);				
				bet += bet;
			}
		}
		
		return player.getBankroll();
	}
	

	//Play ALWAYS on first douzaine
	public int roll12stMartingal(Player player, int rounds, int startingBet){
		int bet = startingBet;
		
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= bet){
				break;
			}
			
			int tempInt = random.nextInt(37);
			int number =  numbers[tempInt].getNumber();
				
			if(number > 0 && number < 13) {
				player.add(bet * 2);
				bet = startingBet;
			} else {
				player.remove(bet);				
				bet *= 2;
			}
		}
		
		return player.getBankroll();
	}
	
	
	
	public int roll12stMartingalSmart(Player player, int rounds, int startingBet){
		
		int bet = startingBet;
		
		Douzaine first = new Douzaine(1);
		Douzaine second = new Douzaine(2);
		Douzaine third = new Douzaine(3);
		
		/*
		 * Chance pour toucher une douzaine = 32.4% 
		 * Un numéro d'une douzaine a donc 2.85% de chance de sortir
		 */
		
		int biggerWinStreak = 0;
		int nbWins = 0;
		
		int biggerLostStreak = 0;
		int nbLost = 0;
		
		boolean continueUntilWin = false;
		for (int i = 0; i<rounds; i++) {
			

			if(player.getBankroll() <= startingBet){
				break;
			}

			
			Douzaine d = hasMostPercentChanceToBePicked(first, second, third);
			int part = d.getPart();
			
			int tempInt = random.nextInt(37);
			int number =  numbers[tempInt].getNumber();
			
			boolean win = false;

			if(part == 1){
				//mise entre 01 et 12
				if(number >= 1 && number <= 12){
					//gagné
					player.add(bet * 2);
					bet = startingBet;
					win=true;
					nbWins++;
					if(nbWins > biggerWinStreak){
						biggerWinStreak = nbWins;
					}
					nbLost=0;
					
					if(continueUntilWin){
						break;
					}
				} else {
					//perdu
					player.remove(bet);				
					bet *= 2;
					nbWins=0;

					nbLost++;
					if(nbLost > biggerLostStreak){
						biggerLostStreak = nbLost;
					}
				}
			} else if(part == 2){				
				//mise entre 13 et 24
				if(number >= 13 && number <= 24){
					//gagné
					player.add(bet * 2);
					bet = startingBet;
					win=true;
					nbWins++;
					if(nbWins > biggerWinStreak){
						biggerWinStreak = nbWins;
					}
					nbLost=0;
					
					if(continueUntilWin){
						break;
					}
				} else {
					//perdu
					player.remove(bet);				
					bet *= 2;
					nbWins=0;
					nbLost++;
					if(nbLost > biggerLostStreak){
						biggerLostStreak = nbLost;
					}
				}
			} else if(part == 3){
				//mise entre 25 et 36
				if(number >= 25 && number <= 36){
					//gagné
					player.add(bet * 2);
					bet = startingBet;
					win=true;
					nbWins++;
					if(nbWins > biggerWinStreak){
						biggerWinStreak = nbWins;
					}
					nbLost=0;
					
					if(continueUntilWin){
						break;
					}
				} else {
					//perdu
					player.remove(bet);				
					bet *= 2;
					nbWins=0;
					nbLost++;
					if(nbLost > biggerLostStreak){
						biggerLostStreak = nbLost;
					}
				}
			}
			

			
			System.out.println(number+" ["+win+"] ["+first.getPercentChanceToBePicked()+"] ["+second.getPercentChanceToBePicked()+"] ["+third.getPercentChanceToBePicked()+"] ["+i+"]");
			
			if(number >= 1 && number <= 12){
				
				first.setPercentChanceToBePicked(first.getPercentChanceToBePicked() - 2.85f);
				second.setPercentChanceToBePicked(second.getPercentChanceToBePicked() + 1.425f);
				third.setPercentChanceToBePicked(third.getPercentChanceToBePicked() + 1.425f);
				
			} else if(number >= 13 && number <= 24){
				
				first.setPercentChanceToBePicked(first.getPercentChanceToBePicked() + 1.425f);
				second.setPercentChanceToBePicked(second.getPercentChanceToBePicked() - 2.85f);
				third.setPercentChanceToBePicked(third.getPercentChanceToBePicked() + 1.425f);
				
			} else if(number >= 25 && number <= 36){

				first.setPercentChanceToBePicked(first.getPercentChanceToBePicked() + 1.425f);
				second.setPercentChanceToBePicked(second.getPercentChanceToBePicked() + 1.425f);
				third.setPercentChanceToBePicked(third.getPercentChanceToBePicked() - 2.85f);
				
			} else {
				//zero
			}
			
			if(i == rounds && !win){
				rounds = rounds *2;
				continueUntilWin = true;
			}
			
		}
		
		/*System.out.println("1 % ["+first.getPercentChanceToBePicked()+"] "
				+ "2 % ["+second.getPercentChanceToBePicked()+"] "
				+ "3 % ["+third.getPercentChanceToBePicked()+"]");*/
		System.out.println("nb wins ["+biggerWinStreak+"]  nb lost ["+biggerLostStreak+"]");
		
		return player.getBankroll();
	}
	
	
	public Douzaine hasMostPercentChanceToBePicked(Douzaine first, Douzaine second, Douzaine third){
		
		float firstP = first.getPercentChanceToBePicked();
		float secondP = second.getPercentChanceToBePicked();
		float thirdP = third.getPercentChanceToBePicked();
		
		if(firstP > secondP && firstP > thirdP){
			return first;
		}
		
		if(secondP > firstP && secondP > thirdP){
			return second;
		}
		
		if(thirdP > firstP && thirdP > secondP){
			return third;
		}
		
		return first;
	}
	
	
	public void roll(int rounds){
		
		Map<Integer, Integer> numbersPicked = new TreeMap<>();
		
		for (int i = 0; i<rounds; i++) {

			int tempInt = random.nextInt(37);
			
			if(numbersPicked.get(tempInt) == null){
				numbersPicked.put(tempInt, 1);
			} else {
				int nbTimePicked = numbersPicked.get(tempInt);
				numbersPicked.put(tempInt, ++nbTimePicked);
			}
			
		}
		
		for(Entry<Integer, Integer> entry : numbersPicked.entrySet()){
			System.out.println("Number ["+entry.getKey()+"] Picked "+entry.getValue()+" times");
		}
		
	}
	
	
	private class Douzaine {
		private int part;
		private float percentChanceToBePicked;
		
		public Douzaine(int part){
			this.part = part;
			this.percentChanceToBePicked = 32.43f;
		}
		
		public float getPercentChanceToBePicked() {
			return percentChanceToBePicked;
		}
		
		public void setPercentChanceToBePicked(float percentChanceToBePicked) {
			this.percentChanceToBePicked = percentChanceToBePicked;
		}
		
		public int getPart() {
			return part;
		}
	}

}
