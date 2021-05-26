package javaprograms;

public class ReverseAWord {

	public static void main(String[] args) {
		String str = "Java Programming";
		
		String a[] = str.split(" ");
		
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]  + " ");
		}
		System.out.println();
		for(int i=a.length-1; i>=0; i--) {
			System.out.print(a[i]  + " ");
		}

	}

}
