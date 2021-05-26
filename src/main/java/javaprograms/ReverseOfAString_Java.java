package javaprograms;

public class ReverseOfAString_Java {

	public static void main(String[] args) {
	String str = "Java";
	int a = str.length();
	String rev= "";
	
	
	for(int i =a-1; i>=0; i--) {
	rev = rev + str.charAt(i);
	}
	System.out.println(rev);
	}
}
