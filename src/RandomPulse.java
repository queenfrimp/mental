/**
 * 
 */
import java.lang.Math;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Queen and Velma
 *
 */
public class RandomPulse {

	public RandomPulse() {
		
	}

	public static void main(String[] args) {
		usingThreadLocalClass();

	}
	
	static void usingThreadLocalClass() {
		int randomInt = ThreadLocalRandom.current().nextInt(40, 220);
		System.out.println("Random number generated is : " + randomInt);
	}
	
}
