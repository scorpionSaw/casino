package casino.model;

public class Player {
	
	private int bankroll;
	
	public Player(int bankroll) {
		this.bankroll = bankroll;
	}
	
	public int getBankroll() {
		return bankroll;
	}
	
	public void setBankroll(int bankroll) {
		this.bankroll = bankroll;
	}
	
	public void add(int bet){
		this.bankroll += bet;
	}
	
	public void remove(int bet){
		this.bankroll -= bet;
	}

}
