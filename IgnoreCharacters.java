package ProgramFlowPractice;

import java.util.Arrays;

public class IgnoreCharacters {

	public static void main(String[] args) {
		System.out.println(removeChars("testingString","aeiou"));
	}

	private static String removeChars(String input, String toremove) {
		char[] process = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char a:process) {
			if(!(toremove.indexOf(a)>0))
			{
				sb.append(a);
			}
		}
		return sb.toString();
	}

}
