package Clase3;

public class ejer1_b {

	public static void main(String[] args) {
		int a=4, b=2, c=7;
		int vectorOrdenado[] = new int[3];
		boolean asc = false;
		if (asc) {
			if (a<b && a<c) {
				vectorOrdenado[0]=a;
				if (b<c){
					vectorOrdenado[1]=b;
					vectorOrdenado[2]=c;
				}else {
					vectorOrdenado[2]=b;
					vectorOrdenado[1]=c;
				}
			}else {
				if (b<a && b<c) {
					vectorOrdenado[0]=b;
					if (a<c){
						vectorOrdenado[1]=a;
						vectorOrdenado[2]=c;
					}else {
						vectorOrdenado[2]=a;
						vectorOrdenado[1]=c;
					}
				}else {
					vectorOrdenado[0]=c;
					if (b<a){
						vectorOrdenado[1]=b;
						vectorOrdenado[2]=a;
					}else {
						vectorOrdenado[2]=b;
						vectorOrdenado[1]=a;
					}
				}
			}
		}else {
			if (a>b && a>c) {
				vectorOrdenado[0]=a;
				if (b>c){
					vectorOrdenado[1]=b;
					vectorOrdenado[2]=c;
				}else {
					vectorOrdenado[2]=b;
					vectorOrdenado[1]=c;
				}
			}else {
				if (b>a && b>c) {
					vectorOrdenado[0]=b;
					if (a>c){
						vectorOrdenado[1]=a;
						vectorOrdenado[2]=c;
					}else {
						vectorOrdenado[2]=a;
						vectorOrdenado[1]=c;
					}
				}else {
					vectorOrdenado[0]=c;
					if (b>a){
						vectorOrdenado[1]=b;
						vectorOrdenado[2]=a;
					}else {
						vectorOrdenado[2]=b;
						vectorOrdenado[1]=a;
					}
				}
			}
		}
		System.out.println(vectorOrdenado[0]+" "+vectorOrdenado[1]+" "+vectorOrdenado[2]);
	}

}
