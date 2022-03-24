package RecursionPractice;

import java.util.ArrayList;

public class PermutationsUsingRecursion {

	public static void main(String[] args) {
		StringBuffer toProcess=new StringBuffer("abcde");
		boolean[] maskData=new boolean[toProcess.length()];
		permutations(toProcess, maskData);
		for(String s:perm) {
			System.out.println(s);
		}
	}
	static ArrayList<String> perm= new ArrayList<String>();

	private static void permutations(StringBuffer toProcess,boolean[] maskData) {
		for(int anchor=0;anchor<toProcess.length();anchor++) {
			setMask(maskData,anchor);
			perm.add(permutationsAux(new StringBuffer(),new StringBuffer(toProcess.substring(anchor)),anchor,toProcess.length(),toProcess.substring(anchor, anchor)).toString());
		}
	}


	private static StringBuffer permutationsAux(StringBuffer currBuffer,StringBuffer toProcess, int startAt,int orgLen,String anchor) {
		if(toProcess.length()==2) {return toProcess.reverse();}
		else if(currBuffer.length()<orgLen) {
			return currBuffer.append(permutationsAux(new StringBuffer(),new StringBuffer(toProcess.substring(startAt+1)),startAt,orgLen,anchor));
		}
		else if (currBuffer.length()==orgLen) {
			return currBuffer;
		}
		return new StringBuffer(anchor+currBuffer.toString());
		
	}


	private static void setMask(boolean[] maskData, int anchor) {
		for(int i =0;i<maskData.length;i++) {
			if(i!=anchor) {
				maskData[anchor]=false;
			}
		}
		maskData[anchor]=true;
	}

}
