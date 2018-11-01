package com.NKSA.dragon;


public class mainDragon {

	static dragon[] dragones= new dragon[144];
	public static void main(String[] args) {
		generateDrakes(100,0);
		System.out.println(dragones[(int)((Math.random())*100)].nombre);
		System.out.println(dragones[(int)((Math.random())*100)].nombre);
		drakeClass1(0,0);
		System.out.println(dragones[(int)((Math.random())*100)].clase);
		System.out.println(dragones[(int)((Math.random())*100)].clase);
		drakeAge1(0,0);
		System.out.println(dragones[(int)((Math.random())*100)].edad);
		System.out.println(dragones[(int)((Math.random())*100)].edad);
	}
	public static void generateDrakes(int cantidad, int cont) {
		if (cont==cantidad) {
			dragon drake= new dragon();
			dragones[cont]=drake;
		}else{
			dragon drake= new dragon();
			dragones[cont]=drake;
			generateDrakes(cantidad,++cont);
		}
	}
	public static void drakeClass1(int cont, int cont2) {
			dragon a=dragones[(int)((Math.random())*100)];
			if(cont2<100) {
				if(a.clase==null) {
					a.clase="infanteria";
					drakeClass1(cont,++cont2);
			}else {
				drakeClass1(cont,cont2);
				}
			}else {
				System.out.println("ya todos tienen clase");
			}
			dragones[0].clase="Comandante";
			dragones[1].clase="Capitan";
			dragones[2].clase="Capitan";
			dragones[3].clase="Capitan";
			dragones[4].clase="Capitan";
			dragones[5].clase="Capitan";
			dragones[6].clase="Capitan";
			dragones[7].clase="Capitan";
			dragones[8].clase="Capitan";
			dragones[9].clase="Capitan";
			dragones[10].clase="Capitan";
	}
	public static void drakeClass2(int cont, int cont2) {
		dragon a=dragones[(int)((Math.random())*120)];
		if(cont2<120) {
			if(a.clase==null) {
				a.clase="infanteria";
				drakeClass2(cont,++cont2);
		}else {
			drakeClass2(cont,cont2);
			}
		}else {
			System.out.println("ya todos tienen clase");
		}
		dragones[0].clase="Comandante";
		dragones[1].clase="Capitan";
		dragones[2].clase="Capitan";
		dragones[3].clase="Capitan";
		dragones[4].clase="Capitan";
		dragones[5].clase="Capitan";
		dragones[6].clase="Capitan";
		dragones[7].clase="Capitan";
		dragones[8].clase="Capitan";
		dragones[9].clase="Capitan";
		dragones[10].clase="Capitan";	
	}
	public static void drakeClass3(int cont, int cont2) {
		dragon a=dragones[(int)((Math.random())*120)];
		if(cont2<120) {
			if(a.clase==null) {
				a.clase="infanteria";
				drakeClass3(cont,++cont2);
		}else {
			drakeClass3(cont,cont2);
			}
		}else {
			System.out.println("ya todos tienen clase");
		}
		dragones[0].clase="Comandante";
		dragones[1].clase="Capitan";
		dragones[2].clase="Capitan";
		dragones[3].clase="Capitan";
		dragones[4].clase="Capitan";
		dragones[5].clase="Capitan";
		dragones[6].clase="Capitan";
		dragones[7].clase="Capitan";
		dragones[8].clase="Capitan";
		dragones[9].clase="Capitan";
		dragones[10].clase="Capitan";	
	}
	public static void drakeAge1(int i,int h) {
		if (i<100) {
		dragones[i].edad=h;
		drakeAge1(++i,h+7);
		}else {
			System.out.println("ya todos tienen edad");
		}
	}
	public static void drakeAge2(int i,int h) {
		if (i<120) {
		dragones[i].edad=h;
		drakeAge2(++i,h+7);
		}else {
			System.out.println("ya todos tienen edad");
		}
	}
	public static void drakeAge3(int i,int h) {
		if (i<144) {
		dragones[i].edad=h;
		drakeAge3(++i,h+7);
		}else {
			System.out.println("ya todos tienen edad");
		}
	}
}