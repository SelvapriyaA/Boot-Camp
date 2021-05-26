package javaprograms;

public class GetCharacterOccurence {

	public static void main(String[] args) {
	String s = "Selenium Boot Camp";
	
	int count = 0;
	for(char c: s.toCharArray()) {
		if(c == 'l')
	count++;
	}
	System.out.println(count);
	}}
