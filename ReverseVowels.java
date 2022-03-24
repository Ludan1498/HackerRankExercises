package ProgramFlowPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ReverseVowels {

	public static void main(String[] args) {
//		ReverseVowels("practice");
		String s= "aeiousdfaidu";
		
System.out.println(ReverseVowels2(s.toCharArray(),0,s.length()));
	}

	private static String ReverseVowels2(char[] work,int front, int end) {
		if(front<=work.length||end>=work.length/2) {
			for(char c:work)
				System.out.print(c);
			return work.toString();
		}
		
		if(isVowel(work[front])&&!isVowel(work[end])){
			return ReverseVowels2(work,front,end--);
		}
		if(!isVowel(work[front])&&isVowel(work[end])){
			return ReverseVowels2(work,front++,end);
		}
//		if(isVowel(work[front])&&isVowel(work[end])){
			
		else{swap(work,front,end);
		
			return ReverseVowels2(work,front++,end--);
		}
		
	}
private static void swap(char[] work, int toSwap1, int toSwap2) {
	System.out.println("Swapping ");	
	char temp=work[toSwap1];
		work[toSwap1] = work[toSwap2];
		work[toSwap2] = temp;
	}

//todo
	private static boolean isVowel(char c) {
		c=Character.toLowerCase(c);
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		return false;
	}

	private static void ReverseVowels(String toprocess) {
		ArrayList<Character> vowelHolder= new ArrayList<Character>();
		char[] strHolder = new char[toprocess.length()];
//		char[] vowelHolder=new char[];
		int place=0;
		char[] vowels= {'a','e','i','o','u'};
		
		for(char letter:toprocess.toCharArray()) {
			if(Arrays.binarySearch(vowels,letter)>-1) {
				strHolder[place]='_';
				vowelHolder.add(letter);
			}
			else {
				strHolder[place]=letter;
			}
			place++;
		}
		ListIterator<Character> it1=vowelHolder.listIterator(vowelHolder.size());
		for(char c:strHolder) {
			if(c=='_') {
				System.out.print(it1.previous());
			continue;
			}
			System.out.print(c);
		}
	}

}
