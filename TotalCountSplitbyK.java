package ProgramFlowPractice;

public class TotalCountSplitbyK {

	public static void main(String[] args) {
		int[] arr= {10, 2, 3, 4, 7};
		System.out.println(totalCountBySplit(arr,4));	
//		System.out.println(15/4);
	}

	private static int totalCountBySplit(int[] arr, int i) {
		int count=0;
		for(int entry:arr) {
			count+=findTotalcountAux(entry,i,0);
		}
		return count;
	}

	private static int findTotalcountAux2(int entry, int i,int currcount) {
	for(;i>0;i--) {
		currcount+=entry/i;
		entry=(entry/i)+(entry%i);
	}
	return currcount;
	}
	private static int findTotalcountAux(int entry, int i,int currcount) {
		if(entry==1||i==1) {
			if(i==1) {
				System.out.println("divider is one.. exiting with count: "+(currcount+entry));
				return currcount+entry;
				}
			System.out.println("found total count..exiting"+(currcount+1));
			return currcount+1;
		}
		else if(entry%i==0&&i>0) {
			if(entry==i) {return currcount+1;}
			System.out.println("Dividing by " + i+ " and proceeding");
			return findTotalcountAux(entry/i,i-1,currcount+(entry/i));
			 
		}
		else  {
			System.out.println("Dividing by " + i+ " and proceeding");
			return findTotalcountAux(entry%i,i-1,currcount+(entry/i));
		}
		
	}

}
