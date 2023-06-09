public enum Direction {
	UP(0), 
	LEFT(1), 
	DOWN(2), 
	RIGHT(3);

	private final int num;

	private Direction(int x){
		this.num = x;
	}

	public int getValue(){
		return num;
	}
	
}
