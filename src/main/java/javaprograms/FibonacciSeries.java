package javaprograms;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int n = 10;
		int previousNum= 0;
		int firstNum = 1;
		
		System.out.println("The fibonacco series is:" + n);
		
		for(int i=1; i<=n; i++) {
			
			System.out.println(previousNum);
			
			int sum= previousNum + firstNum;
			previousNum = firstNum;
			firstNum= sum;
			
			
			
		}
	}}


