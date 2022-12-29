/*Avigayil Marcus
 * 2/21/22
 * Program2 */
import java.util.Scanner; 
public class Program2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Collect account number
		System.out.println("Enter your account number:");
		int account = input.nextInt();
		
		//Collect service code
		char service;
		do {
		System.out.println("Please enter your service code.\nType R for regular service, P for premium service:");
		service = input.next().toUpperCase().charAt(0);
		}while (service!='R' && service != 'P');
		
		//Service code R
		if (service == 'R') {
			regularbill(input);
		}
		
		//Service code P
		else {
			premiumbill(input);
		}
		
		//Display account and service code
		displayinfo(account,service);
	}
	
	//Regular service
	//$10 charge, first 50 minutes free
	public static void regularbill(Scanner input) {
		System.out.println("Enter the amount of minutes of telephone service:");
		double minutes = input.nextDouble();
		double charge;
		if (minutes>50) {
			charge = .20*(minutes-50)+10;
		}
		else
			charge = 10;
		
		//Print minutes and charge
		System.out.printf("Total Minutes: %.2f\nTotal Charge: %.2f\n",minutes,charge);	
	}
	
	//Premium service
	//$25 charge plus 10 cent per minute after 75 minutes. 5 cents per minute after 100 minutes.
	public static void premiumbill(Scanner input) {
		double dayminutes,charge,nightminutes;
		System.out.println("Enter the amount of minutes of telephone service from 6am-6pm:");
		dayminutes = input.nextDouble();
		if (dayminutes >75) {
			charge = .10*(dayminutes-75)+25;
		}
		else
			charge = 25;
		System.out.println("Enter the amount of minutes of telephone service from 6pm-6am:");
		nightminutes = input.nextDouble();
		if (nightminutes > 100) {
			charge += .05*(nightminutes-100);
		}
		else
			charge +=0; 
		System.out.printf("Total Minutes: %.2f\nTotal Charge: %.2f\n",dayminutes + nightminutes,charge);
	}
	
	//Display info account number and service code.
	public static void displayinfo(int account, char service) {
		String rate;
		if (service == 'R') {
			rate = "Regular"; 
		}
		else 
			rate = "Premium";
		System.out.printf("Account number:%d\nService:%s",account,rate);
		
	}
}
