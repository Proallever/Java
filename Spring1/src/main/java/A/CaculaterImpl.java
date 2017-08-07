package A;

import org.springframework.stereotype.Component;

@Component
public class CaculaterImpl implements Caculater{

	public int add(int x, int y) {
		return x+y;
	}

	public int minus(int x, int y) {
		return x-y;
	}

	public int mul(int x, int y) {
		return x*y;
	}

	public int div(int x, int y) {
		return x/y;
	}
	
}
