package ProgramFlowPractice;

import java.util.Arrays;

public class LeadersOfArray {

	public static void main(String[] args) {
		int[] arr = {14,10,1526,7,98,96,70,32,28,1};
//		leadersOfArray(arr);
		sortByFactors(arr);
	}

	private static void sortByFactors(int[] arr) {
		int[] numOfFactors = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			numOfFactors[i]=numFactors(arr[i]);
		}
		sortByFactorsAux(arr,numOfFactors);
	}
	
	private static void sortByFactorsAux(int[] arr, int[] numOfFactors) {
		//using heap sort
		for(int i=(numOfFactors.length/2)-1;i>=0;i--) {
			heapify(arr,numOfFactors,i);
		}
		for(int x:numOfFactors) {
			System.out.print(x+" ");
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(extractMax(arr,numOfFactors)+", ");
		}
		
	}

	private static int extractMax(int[] arr, int[] numOfFactors) {
		int ret=arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = 0;
		numOfFactors[0] = numOfFactors[numOfFactors.length-1];
		numOfFactors[numOfFactors.length-1] = 0;
		heapify(arr,numOfFactors,0);
		return ret;
		
	}

	private static void heapify(int[] arr, int[] numOfFactors,int root) {
		int left = (2*root)+1;
		int right = (2*root)+2;
		int largest = root;
		if(left<numOfFactors.length&&numOfFactors[left]>numOfFactors[largest]) {
			largest = left;
		}
		 if(right<numOfFactors.length&&numOfFactors[right]>numOfFactors[largest]) {
			largest=right;
		}
		if(numOfFactors[largest]>numOfFactors[root]) {
		swap(arr,numOfFactors,largest,root);
		heapify(arr,numOfFactors,largest);
		}
	return;
	}

	private static void swap(int[] arr1,int[] arr2,int largest, int root) {
		if(root==largest) {return;}
		int temp1=arr1[largest],temp2=arr2[largest];
		arr1[largest]=arr1[root];
		arr2[largest]=arr2[root];
		arr1[root]=temp1;
		arr2[root]=temp2;
	}

	private static int numFactors(int i) {
		int ret=1;
		for(int it=2;it<i/2;it++) {
			if(i%it==0) {
				ret++;
			}
		}
		return ret;
	}

	private static void leadersOfArray(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]<arr[i+1]) {
				System.out.print(arr[i+1]+ ", ");
			}
		}
		
	}

}
