import java.util.Scanner;
public class Temperature_Converter{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the temprature value=");
		double temp =scan.nextDouble();
		
		scan.nextLine();
		
		System.out.print("Enter the unit of the temprature (C for Celsius or F for Fahrenheit)=");
		char unit=scan.next().charAt(0);
		
		if(unit =='C' || unit =='c'){
			double fahrenheit =(temp * 9 / 5) + 32;
			System.out.println(temp + "Celsius is equal to " + fahrenheit +"'F");
		}
		else if(unit =='F' || unit =='f'){
			double celsius =(temp -32) *5/9;
			System.out.println(temp + "F is equal to " + celsius +"'C");
		}
		else {
			System.out.println("Invalid unit. Please enter C for Celsius or F for °F");
		}
		scan.close();
    }
}




