package javaprograms;

public class GivenNumberIsPalindrome {

	public static void main(String[] args) {
	String s = "Radar";
	String rev = "";
		 
	for(int i =s.length()-1; i>=0; i--) {
		rev = rev + s.charAt(i);
		 }
		System.out.println(rev);
	
	if(s.toLowerCase().equals(rev.toLowerCase())){
		System.out.println(s +   "-The given string is a palindrome");
	}
	else {
		System.out.println(s +  "-The given string is not a palindrome");
	}
	}
}
