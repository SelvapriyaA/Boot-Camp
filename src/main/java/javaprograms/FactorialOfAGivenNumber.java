package javaprograms;

public class FactorialOfAGivenNumber {

	public static void main(String[] args) {
	//for loop	
		/*int num= 5;
		int fact= 1;
		
		for(int i =1; i<=num; i++) {
			
			fact=fact*i;
		}
		System.out.println(fact);
		}*/

	//While loop
		int num= 4;
		int fact= num;
	
		while(num>1) {
		num--;
		fact= fact*num;
		}
		System.out.println(fact);
}}
