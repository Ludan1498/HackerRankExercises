package ProgramFlowPractice;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		// TODO Auto-LongestPalindromicSubString method stub
		LongestPalindromicSubString("abcdbbbbbbksjdflkj");
	}

	private static void LongestPalindromicSubString(String string) {
		LongestPalindromicSubString(string,0,string.length(),-1,-1);
	}

	private static void LongestPalindromicSubString(String w, int currHead, int currTail, int maxHead, int maxTail) {
		if(currHead==w.length()-1) {
			System.out.println(w.substring(maxHead,maxTail));
		}
		if(isPalindrome(w,currHead,currTail)) {//todo
			if(currTail-currHead>maxHead-maxTail) {
				maxHead= currHead;
				maxTail=currTail;
			}
		}
		  {
			LongestPalindromicSubString(w,currHead,currTail--,maxHead,maxTail);
		}
			
		}
	}

	private static boolean isPalindrome(String w, int currHead, int currTail) {
		// TODO Auto-generated method stub
		return false;
	}

}
