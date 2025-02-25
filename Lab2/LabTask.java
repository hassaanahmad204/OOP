import java.util.Scanner;

class LabTask{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		byte b;
		short s;
		int i;
		long l;
		
		float f;
		double d;
		
		char ch;
		String str1, str2;
		boolean bool;
		
		System.out.print("Enter a byte: ");
		b = input.nextByte();
		System.out.print("Enter a short: ");
		s = input.nextShort();
		System.out.print("Enter an integer: ");
		i = input.nextInt();
		System.out.print("Enter a long: ");
		l = input.nextLong();
		
		System.out.print("Enter a float: ");
		f = input.nextFloat();
		System.out.print("Enter a double: ");
		d = input.nextDouble();
		
		System.out.print("Enter first string: ");
		str1 = input.next();
		input.nextLine();
		System.out.print("Enter second string: ");
		str2 = input.nextLine();
		System.out.print("Enter a boolean: ");
		bool = input.nextBoolean();
		
		System.out.print("\n");
		
		System.out.println("Value of byte: " + b);
		System.out.printf("Value of short: %d\n", s);
		System.out.printf("Value of integer: %03d\n", i);
		System.out.printf("Value of long: %d\n", l);
		
		System.out.printf("Value of float: %.2f\n", f);
		System.out.printf("Value of double: %.2f\n", d);

        System.out.println("First String: " + str1);
		System.out.println("Second String : " + str2);
		ch = str1.charAt(0);
		System.out.println("First character: " + ch);
		System.out.printf("Value of boolean: %b\n", bool);	
	}
}
		
		
