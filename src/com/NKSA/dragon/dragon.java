package com.NKSA.dragon;


public class dragon {
	String nombre;
	int velocidad_recarga;
	int edad;
	int resistencia;
	dragon padre;
	String clase;
	String[] nombres= {"Steven","Daniel","David","Gabriel","Benjam�n","Samuel","Lucas","�ngel","Jos�","Adri�n","Sebasti�n","Xavier","Juan","Luis","Diego","�liver","Carlos","Jes�s","Alex","Max","Alejandro","Antonio","Miguel","V�ctor","Joel","Santiago","El�as","Iv�n","�scar","Leonardo","Eduardo","Alan","Nicol�s","Jorge","Omar","Pa�l","Andr�s","Andr�s","Josu�","Rom�n","Fernando","Javier","Abraham","Ricardo","Francisco","C�sar","Mario","Manuel","�dgar","Alexis","Israel","Mateo","H�ctor","Sergio","Emiliano","Sim�n","Rafael","Mart�n","Marco","Roberto","Pedro","Emanuel","Abel","Rub�n","Fabi�n","Emilio","Joaqu�n","Marcos","Lorenzo","Armando","Ad�n","Ra�l","Julio","Enrique","Gerardo","Pablo","Jaime","Sa�l","Esteban","Gustavo","Rodrigo","Arturo","Mauricio","Orlando","Hugo","Salvador","Alfredo","Maximiliano","Ram�n","Ernesto","Tob�as","Abram","Guillermo","Ezequiel","Luci�n","Alonzo","Felipe","Mat�as","Tom�s","Jairo"};
	
	public dragon() {
		this.nombre= nombres[(int)((Math.random())*100)];
		this.resistencia= (int)(((Math.random())*3)+1);
		this.velocidad_recarga= (int)(((Math.random())*100)+1);
		
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public dragon getPadre() {
		return padre;
	}

	public void setPadre(dragon padre) {
		this.padre = padre;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

}