package Round2Practice;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String[] toProcess = {"missionary","permissionary","discussionary","professionary","submissionary","dismissionary","obsessionary","passionary"};
		try {
		String commonString = longestSubString(toProcess);
		System.out.println(commonString);
		}
		catch(NullPointerException np) {
			System.out.println("Enter two or more strings");
		}
	}

	private static String longestSubString(String[] toProcess) {
		int currLongestLen=0;
		if(toProcess.length==0) {
			return null;
		}
		if(toProcess.length==1) {
			return toProcess[0];
		}
	
		String anchor = toProcess[0],token="",currLargestToken = null;
		boolean trip = true;
		for(int i=0;i<anchor.length();i++) {
		for(int j = anchor.length();j>i&&(j-i>currLongestLen);j--)
			{
				token=anchor.substring(i,j);
				System.out.println("Current token is "+ token);
				trip=false;
		checker:for(int it1=1;it1<toProcess.length;it1++) {
					if((toProcess[it1].indexOf(token)<0)) {
						trip = true;
						break checker;
					}
				}
				if(!trip) {
				currLongestLen=token.length();
				System.out.println(token+ " is common among all strings");
				currLargestToken=token;	
				}
				
			}
		}
		return currLargestToken;
	}
	}

