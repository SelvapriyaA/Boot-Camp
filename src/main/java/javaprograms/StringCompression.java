package javaprograms;

public class StringCompression {
	String s = "aaabbccd";
	
	public void compress(String s) {
	
	int count = 0;
	char temp = s.charAt(0);
	for(int i =0; i<s.length(); i++) {
			if(s.charAt(i) == temp)
				count++;
			else
			{
				System.out.print(temp+""+count);
				count = 1;
				temp = s.charAt(i);
			}
	}
	System.out.print(temp+""+count);
	}
	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		obj.compress(obj.s);
		
	}

}
