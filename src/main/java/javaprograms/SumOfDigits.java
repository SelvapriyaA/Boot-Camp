package javaprograms;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num = 123;
int sum = 0;

//Using while loop
/*int reminder = 0;
while(num!=0){
	reminder = num %10;
	sum= sum+reminder;
	num = num/10;
}*/

//using for loop
for(sum=0; num!=0; num/=10) {
	sum+=num%10;
	}
System.out.println(sum);
}}
