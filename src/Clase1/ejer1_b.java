package Clase1;

public class ejer1_b {

	public static void main(String[] args) {
		int a=3, b=11;
		while(a<=b) {
			if(a%2==0) {
				System.out.print(a);
				if(a!=b && a+1!=b) System.out.print("-");
			}
			a++;
		}
	}

}
