package ProgramFlowPractice;

import java.util.HashSet;
import java.util.Vector;

public class HighestContiguosSubArraySum {

	public static void main(String[] args) {
		int[] arr = {-1,200,-3,-4,3,-4,-7,3,-100,-9};
		kadanes(arr);
	}

	private static void kadanes(int[] arr) {
		int[] temp= {0,1};
		for(String x:kadanesaux(arr,0,1,temp,new Vector<String>())){
			System.out.println(x);
		}
	}
static int callcounter=0;
	private static Vector<String> kadanesaux(int[] arr, int currstart, int currend, int[] currlargest,Vector<String> memo) {
		if(!memo.contains(String.valueOf(currstart)+String.valueOf(currend))) {
		if(sumof(arr,currstart,currend)>sumof(arr,currlargest[0],currlargest[1])) {
//			System.out.println("Currently processing indexes: "+ currstart+ " "+ currend);
			currlargest[0]=currstart;
			currlargest[1]=currend;			
//			System.out.println("Greater element:  " + ++callcounter);
			memo.add(String.valueOf(currstart)+String.valueOf(currend));
		}
		if((currstart==arr.length-2)&&currend==arr.length-1) {
//			System.out.println("reached end: " + ++callcounter);
//			System.out.println(arr[currlargest[0]]+ " "+ arr[currlargest[1]-1]);
			memo.add(String.valueOf(currstart)+String.valueOf(currend));
			return memo;
		}
		
		if(currend<=arr.length-1)
		{	
//			System.out.println("branching to basicflow "+ currstart +" "+(currend+1));
			kadanesaux(arr,currstart,currend+1,currlargest,memo);
//			System.out.println(++callcounter);
			memo.add(String.valueOf(currstart)+String.valueOf(currend));
		}
		if(currstart<=arr.length-2&&currend<=arr.length-1)
			{
//			System.out.println("branching to recurrentflow "+ (currstart+1) +" "+(currstart+2));
			kadanesaux(arr,currstart+1,currstart+2,currlargest,memo);
//			System.out.println(++callcounter);
			memo.add(String.valueOf(currstart)+String.valueOf(currend));
			}
		}
		return memo;
	}

	private static int sumof(int[] arr, int start,int end) {
		int sum=0;
//		System.out.println("Summing up indexes" + start +" "+end);
		for(int i = start;i<end;i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
