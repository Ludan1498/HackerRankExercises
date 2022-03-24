package ProgramFlowPractice;

public class PatternPrinting {

	public static void main(String[] args) {
//		printPattern(7) ;
		printPattern2(5);

	}

	private static void printPattern2(int i) {
	while(i-->-1) {
		int j=i;
		while(j-->i/2) {
			System.out.print("*");
		}
	}
	}
	private static void printPattern(int input) {
		boolean trip=true;
		System.out.println(0);
		for(int i = 0;i<input;i++) {
			if(trip) {
				for(int j=i+1;j>-1;j--) {
					System.out.print(j);
				
				}
			trip=false;
			}
			if(!trip) {
				for(int j=0;j<=i;j++) {
					System.out.print(j+1);
				}
				trip=true;
				}
			System.out.println();
		}
		
	}

}
