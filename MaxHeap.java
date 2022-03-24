package RecursionPractice;
import java.util.List;
import RecursionPractice.Graphv2.Node;

public class MaxHeap<T> {
	MaxHeap(Integer[] inp,T[] inp1){
		arr=inp;
		elements=inp1;
	}
	MaxHeap(Integer[] inp){
		arr=inp;
	}
	public Integer[] arr;
	public T[] elements;
	public int numOfElements = arr.length;

//	public static void main(String[] args) {
//		buildHeap(arr,false);
//		printarray(arr);
//		
//		System.out.println(extractMin(arr));
//		printarray(arr);
//	}
	private void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void buildHeap(boolean buildAsMax) {
		int len =arr.length;
		int currpointer=(len/2)-1;
		for(;currpointer>=0;currpointer--) 
		{
			if(buildAsMax) {
				maxHeapify(currpointer,len);
			}
			else {
				minHeapify(currpointer,len);
			}
				}
	}
	private void minHeapify( int currpointer, int len) {
		int root=currpointer;
		int left=2*currpointer+1;
		int right = (2*currpointer)+2;
		int smallest=root;
		if(left<len&&arr[left]<arr[smallest])
		{
			smallest=left;
		}	
		if (right<len&&arr[right]<arr[smallest]) 
			{smallest=right;}
		if(arr[smallest]<arr[root]) {
			swap(smallest,root);
			minHeapify(smallest,arr.length);
		}

	}
	
	private void maxHeapify( int currpointer, int len) {
		int root=currpointer;
		int left=2*currpointer+1;
		int right = (2*currpointer)+2;
		int largest=root;
		if(left<len&&arr[left]>arr[largest])
		{
			largest=left;
		}	
		if (right<len&&arr[right]>arr[largest]) 
			{largest=right;}
		if(arr[largest]>arr[root]) {
			swap(largest,root);
			maxHeapify(largest,arr.length);
		}

	}
	private int extractMax() {
		int ret = arr[0];
		arr[0]=arr[arr.length-1];
		arr[arr.length-1]=0;
		maxHeapify(0,arr.length);
		return ret;
	}
	private  int extractMin() {
		int ret = arr[0];
		arr[0]=arr[arr.length-1];
		arr[arr.length-1]=0;
		minHeapify(0,arr.length);
		return ret;
	}
	private  T extractMinElement() {
		arr[0]=arr[arr.length-1];
		arr[arr.length-1]=0;
		T ret = elements[0];
		elements[0]=elements[elements.length-1];
		elements[elements.length-1]=null;
		minHeapify(0,arr.length);
		return ret;
	}
	private  void swap( int smallest, int root) {
		if(root==smallest) {return;}
		int temp= arr[root];
		arr[root]=arr[smallest];
		arr[smallest]=temp;
		T temp1= elements[root];
		elements[root]=elements[smallest];
		elements[smallest]=temp1;
	}
}
