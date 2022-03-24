package RecursionPractice;

import java.util.*;


public class LetterCombinations {

	public static void main(String[] args) {
		String test = "abcde";
		
	
permutations(test);
	}
static Vector<String> ret= new Vector<String>();
	private static void  permutations(String test) {
		 Boolean[] mask= {false,false,false,false,false};
		 permutationsAux(test.toCharArray(),0,0,mask,new StringBuilder());
		 for(String s:ret) {
			 System.out.println(s);
		 }
	}

//	private static void permutationsAux(char[] data, int iterLen,int pointer, Boolean[] mask,StringBuilder curr) 
//	{
//	if(curr.length()==data.length-1) {
//		ret.add(curr.toString());
//		return;
//	}
//	if(pointer<data.length-1&&iterLen==0){
//		mask[pointer]=false;
//		mask[pointer+1]=true;
//		permutationsAux(data,0,pointer+1,mask,new StringBuilder(data[pointer+1]));
//		mask[pointer]=true;
//		mask[pointer+1]=false;
//	}
//	if(iterLen<data.length&&!mask[iterLen]) {
//		curr.append(data[iterLen]);
//		mask[iterLen]=true;
//		permutationsAux(data,iterLen+1,pointer,mask,curr);
//	}
//	else {
//		int temp=0;
//		while(mask[temp]) {
//			temp++;
//			if(temp>=data.length) {temp=0;}
//		}
//		permutationsAux(data,temp,pointer,mask,curr);}
//	}
	private static void permutationsAux(char[] data, int iterLen,int pointer, Boolean[] mask,StringBuilder curr)
	{
		if(pointer==data.length-1&&curr.length()==data.length) {
			ret.add(curr.toString());
			System.out.println("adding "+curr+ " to the list and closing");
			return;
		}
		if(curr.length()==data.length&&pointer<data.length) {
			ret.add(curr.toString());
			System.out.println("adding "+curr+ " to the list");
			permutationsAux(data,iterLen+1,pointer+1,resetMask(mask,pointer+1),new StringBuilder(data[pointer+1]));
			
		}
		if(iterLen<=data.length&&curr.length()<data.length) {
			
				curr.append(data[iterLen]);
				mask[iterLen]=true;
				System.out.println("adding "+data[iterLen]+ " to "+curr);
				permutationsAux(data,cyclicNext(iterLen,data.length-1),pointer,mask,curr);
		}
	}
private static int cyclicNext(int curr,int limit) {
	if(curr+1>limit) {return 0;}
	return curr+1;
}
private static Boolean[]  resetMask(Boolean[] mask,int skip) {
	for(int i=0;i<mask.length;i++) {
		if(i!=skip) {
			mask[i]=false;
		}
	}
	return mask;
}
}