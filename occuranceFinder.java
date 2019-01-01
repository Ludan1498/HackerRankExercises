package testing;

public class occuranceFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numOfOccs(62, "abbabc"));
	}

	static public int numOfOccs(int reps, String in) {
		int multiplier = 0, totalAs = 0;
		char[] input = in.toCharArray();
		short tlength = (short) in.length();
		if (input[0] == 'a' && input[1] != 'a') {
			multiplier++;
			
		}
		for (int i = 1; i < tlength - 1; i++) {
			if (input[i - 1] != 'a' && input[i] == 'a' && input[i + 1] != 'a') {
				multiplier++;
				
			}
		}
		if (input[input.length - 1] == 'a' && input[input.length - 2] != 'a') {
			multiplier++;
		}
		if (input[0] == 'a' && input[input.length - 1] == 'a') {
			multiplier--;
		} else {
		}
		if (reps % tlength == 0) {
			totalAs = (reps ) * multiplier;
		} else {
			totalAs = (reps) * multiplier;

			for (int i = 1; i < tlength - (reps % tlength); i++) {
				if (input[i - 1] != 'a' && input[i] == 'a' && input[i + 1] != 'a') {
					totalAs++;
				}
			}

		}
		return totalAs;
	}
}
