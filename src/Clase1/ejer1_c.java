package Clase1;

public class ejer1_c {

	public static void main(String[] args) {
		int a=3, b=11;
		boolean mostrarPares=false;
		while(a<=b) {
			if(mostrarPares) {
				if(a%2==0) {
					System.out.print(a);
					if(a!=b && a+1!=b) System.out.print("-");
				}
			}else {
				if(a%2==1) {
					System.out.print(a);
					if(a!=b && a+1!=b) System.out.print("-");
				}
			}	
			a++;
		}
	}

}
