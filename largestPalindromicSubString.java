package RecursionPractice;

import java.util.Stack;

public class largestPalindromicSubString {

	public static void main(String[] args) {
		int[] temp=new int[2];
		temp[0]=0;
		temp[1]=1;
		String s="abccccccddd";
		largestPalindromicSubStringRec(s,0,s.length()-1,temp);
		System.out.println(s.substring(temp[0], temp[1]));
	}

	private static int[] largestPalindromicSubStringRec(String work,int currStart,int currEnd,int currLargest[]) {
		if(isPalindrome(work,currStart,currEnd)&&currEnd-currStart>currLargest[1]-currLargest[0]) {
	
			currLargest[0]=currStart;//if curr substring is longer and is a palindrome
			currLargest[1]=currEnd;
		}
		if(currStart==work.length()-2&&currEnd==work.length()-1) {//end case
			return currLargest;
		}
		if(currEnd-currStart>1) {//base recurse case,starting from 0 and decreing currEnd
			return largestPalindromicSubStringRec(work,currStart,currEnd-1,currLargest);//shrinking from bottom
		}
		if(currEnd==currStart+1) {
			return largestPalindromicSubStringRec(work,currStart+1,work.length()-1,currLargest);//shrinking from top
		}
		return currLargest;
	}

	private static boolean isPalindrome(String work, int s, int e) {
		boolean ret=true;
		for(int i=s,j=e;i<j;i++,j--) {
			System.out.println("Comparing "+i + " "+j);
			if((work.charAt(i)!=work.charAt(j))) {
				return false;
			}
		}
		System.out.println(work.substring(s,e)+ " is "+ret);
		return true;
	}

}
