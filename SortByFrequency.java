package SearchingAndSorting;

import java.util.ArrayList;

public class SortByFrequency {
	static ArrayList<Integer> uniq = new ArrayList<Integer>();
	static ArrayList<Integer> freq = new ArrayList<Integer>();
	public static void main(String[] args) {
		int[] arr = {5,1,5,3,4,4,2,3,3,5,3,1,2,5,2,4,2,2,1,4,5,4,4,2,2};
		getUniqueVals(arr);
		for(int i=0;i<uniq.size();i++) {
			System.out.println(uniq.get(i)+ " has a frequency of "+ freq.get(i));
		}
		int times=0;
		int currhighest=getHighest(freq);
		int counter=0,toprint;
		while(counter<freq.size()) {
//			 System.out.println("Current highest is "+uniq.get(currhighest)+" with frequency "+freq.get(currhighest));
			toprint=uniq.get(currhighest);
			times=freq.get(currhighest);
			while(times-->0) {System.out.print(toprint);}
			System.out.print((counter+1)<freq.size()?" , ":".");
			currhighest=getSecondHighest(freq, currhighest);
			counter++;
		}
	}
	private static int getHighest(ArrayList<Integer> freq2) {
		int ret=0;
		for(int it1=1;it1<freq2.size();it1++) {
			if(freq2.get(it1)>ret) {
				ret=it1;
			}
		}
		return ret;
	}
	private static int getSecondHighest(ArrayList<Integer> freq2, int currHighestIndex) {
		int i=0,currelem;
		int secondHighestIndex=0,secondHighest=freq2.get(secondHighestIndex),lSize=freq2.size(),currhighest=freq2.get(currHighestIndex);
		while(++i<lSize) {
			currelem=freq2.get(i);
//			System.out.println("Comparing "+secondHighest+ " and " +currhighest);
			if(freq2.get(i)>=secondHighest&&
					(currelem<=currHighestIndex&&i!=currHighestIndex))
				secondHighestIndex=i;
			secondHighest=freq2.get(i);}

		return secondHighestIndex;
	}



	private static void getUniqueVals(int[] arr) {

		for(int x:arr) {
			int ind=uniq.indexOf(x);
			if(ind>-1) {
				freq.set(ind,freq.get(ind)+1);
			}
			else {
				uniq.add(x);
				freq.add(1);
			}
		}
	}

}
