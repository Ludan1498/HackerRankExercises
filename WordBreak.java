package ProgramFlowPractice;

import java.util.ArrayList;

public class WordBreak {

	public static void main(String[] args) {
		String[] dict = {"i","like","tasting","apples"};
		String teststring= "ilikeapples";
		wordBreak(teststring,dict);
	}

	private static void wordBreak(String teststring, String[] dict) {
		wordBreakAux(new StringBuilder(teststring),dict);
	}

	private static void wordBreakAux(StringBuilder teststring, String[] dict) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for(int i = 0;i<dict.length;i++) {
			if(teststring.indexOf(dict[i])>-1) {
				teststring.delete(teststring.indexOf(dict[i]), teststring.indexOf(dict[i])+dict[i].length());
				indexes.add(i);
			}
		}
		for(int i:indexes) {
			System.out.print(dict[i]+" ");
		}
		
	}
	
	
}
