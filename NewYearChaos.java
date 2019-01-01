package testing;

public class NewYearChaos {

	public static void main(String[] args) {
		System.out.println(calculateMinimumBribes(5,"25143"));

	}
	
	static int calculateMinimunBribes(int n,String s){
		
	}
	
	int[] calculateRelativeDistance(int length,String queue) {
		int[] relativeDistance = new int[length];
		for(int i = 0;i<length;i++) {
			relativeDistance[i] = Integer.parseInt(queue.charAt(i) - (i+1));
		}
	}

}
