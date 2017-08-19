package A;

public class HelloWorld {

	private int a ;
	protected static double b;
	static final int c = 5;
	
	{
		a=3;
		b=6;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world!");
	}
	
	public int inc(int i){
		return i+1;
	}

}
