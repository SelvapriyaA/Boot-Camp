package javaprograms;

public class ReverseAString {

	public static void main(String[] args) {
		
String s = "Hello World";
/*int len = s.length(); //11
String rev = "";
System.out.println(len);

for(int i=len-1; i>=0; i--)
	rev = rev + s.charAt(i); //charAt- will return the character at the specified index in a string

System.out.println(rev);*/
		
	

StringBuffer s1 = new StringBuffer(s);
System.out.println(s1.reverse());
}
}