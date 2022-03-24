package ProgramFlowPractice;

import java.util.Arrays;

public class printNtimes {

	public static void main(String[] args) {
		String w="a11b2c10";
		printNTimesRec(w,0,-1,'a');
	}
	private static void printNtimes(String w) {
		int currindex=0,times;
		char toPrint=' ';
		char[] work=w.toCharArray();
		for(;currindex<work.length;) {
			if(Character.isAlphabetic(work[currindex])) {
				toPrint=work[currindex];
				System.out.print("Current character is " + toPrint);
				currindex++;
				if(currindex<work.length-1&&Character.isDigit(work[currindex+1])) {
					times=Character.getNumericValue((work[currindex]))*10+Character.getNumericValue(work[currindex+1]);
					currindex+=2;
				}
				else {
					times=Character.getNumericValue(work[currindex]);
					currindex++;
				}
				System.out.println("Printing times: "+times);
				while(times>0) {
					System.out.print(toPrint);
					times--;
				}
				System.out.println();
				times=0;
			}
		}		
	}
	static void printNtimes2(String w) {
		int idx=0,times=0;
		char toPrint='q';
		while(idx<w.length()) {
			//char set
			if(Character.isAlphabetic(w.charAt(idx))) {
				toPrint=w.charAt(idx);
				idx++;
				System.out.println("char = "+toPrint);
				continue;
			}
			//times set
			 if(Character.isDigit(w.charAt(idx))) {
				if(Character.isDigit(w.charAt(idx+1))) {
					times=(Character.getNumericValue(w.charAt(idx)))*10+Character.getNumericValue(w.charAt(idx+1));
					
					idx+=2;
					System.out.println("Times = "+times);
				}
				else {
					times=Character.getNumericValue(w.charAt(idx));
					idx+=1;
					System.out.println("Times = "+times);
				}
				//print
				
//				times=0;
			}
			while(times-->0) {
				System.out.print(toPrint);
				continue;
			}
System.out.println();
		}
	}
	//recursive implementation
	static void printNTimesRec(String w,int idx,int times,char toPrint) {
		if(Character.isAlphabetic(w.charAt(idx))){
			printNTimesRec(w,idx+1,-1,w.charAt(idx));
		}
		if(Character.isDigit(w.charAt(idx))){
			if(Character.isDigit(w.charAt(idx+1))) {
				times=(Character.getNumericValue(w.charAt(idx)))*10+Character.getNumericValue(w.charAt(idx+1));
				printNTimesRec(w,idx+2,times,toPrint);
				System.out.println("Times = "+times);
			}
			else {
				times=Character.getNumericValue(w.charAt(idx));
				printNTimesRec(w,idx+1,times,toPrint);
				System.out.println("Times = "+times);
			}
		}
		if(times>-1) {
			times=times-1;
			while(times-->-2) {
				System.out.print(toPrint);
			}
			
		}
	}
	static void findProbableIndex(int[] arr,int tofind,int currIndex) {
		if(arr[currIndex]==tofind) {
			System.out.println(currIndex);
		}
		else if(arr[currIndex]>tofind) {
			System.out.println(currIndex);
		}
		else if(arr[currIndex]<tofind) {
			findProbableIndex(arr,tofind,currIndex+1);
		}
	}

}
