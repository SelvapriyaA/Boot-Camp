package javaprograms;

public class ArraySortion {

	public static void main(String[] args) {
	
		int[] array = {10,20,30,40,50};
		System.out.println(isSorted(array));
	}
	private static boolean isSorted(int[] array) {
	
		for(int i=1; i<array.length-1; i++) 
			if(array[i]< array[i+1]) 
					return true;
		return false;
					}			}