package ProgramFlowPractice;

public class reverseUsingRecursion {

	public static void main(String[] args) {
		reverse("abcde");
		palindromeOrNot("abccba");

	}

	private static void palindromeOrNot(String string) {
		palindromeorNotAux(string,0,string.length()-1);
	}

	private static void palindromeorNotAux(String string, int i, int j) {
	if()
		
	}

	private static void reverse(String string) {
		reverseAux(string,string.length()-1);
	}

	private static void reverseAux(String string,int iter) {
		if(iter>=0) {
			System.out.print(string.charAt(iter));
		reverseAux(string,iter-1);
		}
		
	}

}
