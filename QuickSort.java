package SearchingAndSorting;

import java.util.Arrays;
import java.util.Vector;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = {28,72,84,0,37,6,87,45,13,25,1,44,92,23,71,84,93,91,36,40};
		quickSort(arr,0,arr.length-1);
		printarray(arr,0,arr.length-1);
		
	}

	private static void quickSort(int[] arr,int start,int end) {
		try{if(start<end)
		{
			int pi = partition(arr,start,end);
			quickSort(arr,start,pi-1);
			quickSort(arr,pi,end);
		}}
		catch(StackOverflowError e) {
			System.out.println("Overflow");
		}
	}
	private static int partition(int[] arr, int start,int end) {
		if(end-start==1) {return end;}
		int pivot=arr[end],pivotpoint=end;
		for(int i=start;i<=end;) {
//			System.out.println("Pivot point, Iterator is : "+ pivotpoint+ " "+ i);
//			printarray(arr,start,end);
//			System.out.println("-----");
			
			if(arr[i]>pivot&&i<pivotpoint) {
//				System.out.println("Pivot point, Iterator is : "+ pivotpoint+ " "+ i);
				swap(arr,pivotpoint,pivotpoint-1);
				if(pivotpoint-1!=i)swap(arr,pivotpoint,i);
				pivotpoint--; 
				printarray(arr,start,end);
//				System.out.println("========================");
			continue;
			}
			i++;
		}
		System.out.println("Partitioning Done..");
		return pivotpoint;
	}
	@SuppressWarnings("unused")
	private static int partition2(int[] arr, int start, int end) {
		int pivot=arr[end],pivotpoint=end;
		outer:for(int j=start;j<=end;j++) {
			if((arr[j]>pivot)) {
//				if(j==pivotpoint) {
//					swap(arr,j,j+1);
//					break outer;
//				}
				swap(arr,pivotpoint,pivotpoint-1);
				printarray(arr,start,end);
				swap(arr,j,pivotpoint);
				pivotpoint--;
				j--;
				printarray(arr,start,end);
				System.out.println("Pivot point, Iterator is : "+ pivotpoint+ " "+ j);
			}
			}
		swap(arr,pivotpoint,pivotpoint-1);
		printarray(arr, start, end);
		return pivotpoint-1;
	}

	private static void printarray(int[] arr,int start,int end) {
		for(int i=start;i<=end;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		return;
		
	}

	static void swap(int arr[],int from,int to) {
		if(from==to) {return;}
		int temp=arr[from];
		arr[from]=arr[to];
		arr[to]=temp;
	}

}
