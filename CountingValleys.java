package testing;

public class CountingValleys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "UDDDUDUU";
		System.out.println(countValleys(8, path));
	}

	private static int countValleys(int n, String s) {
		if(n!=s.length()|| n >1000000)
		{
			throw new IllegalArgumentException();
		}
		if(s.isEmpty() || s==null)
		{
			throw new NullPointerException();
		}
		if(n<2) {
			return 1;
		}
		s = s.toLowerCase();
		int count = 0;
		char[] pathTaken = s.toCharArray();
		int currentLevel = 0;
		for (int i = 0;i<n;i++) {
			
			if (pathTaken[i] == 'u' && currentLevel == -1) {
				count++;
			}
			else {
				if(pathTaken[i]=='d')
				{
					currentLevel--;
				}
				if(pathTaken[i]=='u')
				{
					currentLevel++;
				}
			}
		}

		return count;

	}

}
