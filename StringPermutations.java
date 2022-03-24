package RecursionPractice;

import java.util.ArrayList;

public class StringPermutations {

	public static void main(String[] args) {
		String test = "abcde";
		 for(String x:permutate(test)) {
			 System.out.println(x);
		 }

	}

	private static ArrayList<String> permutate(String test) {
		ArrayList<String> saved = new ArrayList<String>();
		saved = permutate(test, 0,1,saved);
		return saved;
	}
	private static ArrayList<String> permutate(String test,int currstart,int currend,ArrayList<String> savehere) {
		if(currstart==test.length()-2&&currend==test.length()-1) {
			savehere.add(test.substring(currstart, currend));			
			return savehere;
}
		if(!savehere.contains(test.substring(currstart, currend)))
		if(currend<=test.length()-1) {
			savehere.add(test.substring(currstart, currend));
			permutate(test,currstart,currend+1,savehere);
			if(currstart<=test.length()-2) {
				permutate(test,currstart+1,currend+1,savehere);
			}
		}
		return savehere;
	}

}
