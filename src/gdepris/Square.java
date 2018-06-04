package gdepris;

public class Square {
	
	private int number;
	private SquareColor color;
	
	public Square(int number, SquareColor color) {
		this.number = number;
		this.color = color;
	}
	
	public int getNumber() {
		return number;
	}
	
	public SquareColor getColor() {
		return color;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setColor(SquareColor color) {
		this.color = color;
	}

	//pair
	public boolean isEven(){
		return getNumber() % 2 == 0;
	}
	
	//impair
	public boolean isOdd(){
		return !isEven();
	}
	
	public boolean isRed(){
		return color.equals(SquareColor.RED);
	}
	
	public boolean isBlack(){
		return color.equals(SquareColor.BLACK);
	}
	
	public boolean isGreen(){
		return color.equals(SquareColor.GREEN);
	}
	
}
