package ProgramFlowPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] mat= {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int[][] emat= {{1,2,3},{4,5,6},{7,8,9}};
		Arrays.asList(emat).stream().forEach((s)->{
			for(int x:s) {
				System.out.print(x+ " ");
			}
			System.out.println();
		});
		mat = rotate(mat,1);
		inplaceRotate(mat,1);
//		Arrays.asList(mat).stream().forEach((s)->{
//			for(int x:s) {
//				System.out.print(x+ " ");
//			}
//			System.out.println();
//		});
		System.out.println("=================");
		for(int[] x:emat) {
			for(int a:x) {
				System.out.print(a);
			}
		System.out.println();
		}

	}

	private static void inplaceRotate(int[][] emat, int times) {
		if(emat.length!=emat[0].length){
			System.out.println("Invalid Dimensions");
			return;
		}
		ArrayList<Integer> alreadySwapped =new ArrayList<Integer>();
		int holder;
		for(;times>0;--times) {
			for(int i=0;i<emat.length;i++) {
				for(int j=0;j<emat[0].length;j++) {
					if(!alreadySwapped.contains(i+j)) {
						alreadySwapped.add(i+j);
					holder = emat[i][j];
					emat[i][j]=emat[j][i];
					emat[j][i]=holder;}
				}
			}
		}
	}

	private static int[][] rotate(int[][] mat, int times) {
		ArrayList<Integer> alreadySwapped =new ArrayList<Integer>();
		int[][] retmat = new int[mat[0].length][mat.length];
		for(;times>0;--times) {
			for(int i=0;i<retmat.length;i++) {
				for(int j=0;j<retmat[0].length;j++) {
					retmat[i][j]=mat[j][i];

				}
			}
		}
		return retmat;
	}
}