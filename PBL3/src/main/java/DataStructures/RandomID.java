package DataStructures;

import java.util.Random;

public class RandomID {
	public static int ran() {
		int max = 9999999;
		int min = 1000000;
		return new Random().nextInt(max - min + 1) + min;
	}
}
