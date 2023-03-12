package Clase1;

public class ejer1_d {

	public static void main(String[] args) {
		int a=2, b=12;
		for(int i=b;i>=a;i--) {
			if(i%2==0) {
				System.out.print(i);
				if(i!=a && i-1!=a) System.out.print("-");
			}
		}
	}

}
