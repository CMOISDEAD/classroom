public class Number {
	
	public static int generateRandomIntegerNumberBetween(int start, int upTo) {
		return start + Math.abs(((int) (Math.random()*upTo)-start));
	}
	
	public static int generateRandomIntegerNumberUpTo(int upTo) {
		return Number.generateRandomIntegerNumberBetween(0, upTo);
	}
	
	public static double generateRandomDoubleNumberBetween(double start, double upTo) {
		return start + Math.abs((Math.random()*upTo)-start);
	}
	
	public static double generateRandomDoubleNumberUpTo(double start, double upTo) {
		return Number.generateRandomDoubleNumberUpTo(0.0, upTo);
	}
}
