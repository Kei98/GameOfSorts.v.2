package com.NKSA.dragon;


public class dragon {
	String nombre;
	int velocidad_recarga;
	int edad;
	int resistencia;
	dragon padre;
	String clase;
	String[] nombres= {"Steven","Daniel","David","Gabriel","Benjamín","Samuel","Lucas","Ángel","José","Adrián","Sebastián","Xavier","Juan","Luis","Diego","Óliver","Carlos","Jesús","Alex","Max","Alejandro","Antonio","Miguel","Víctor","Joel","Santiago","Elías","Iván","Óscar","Leonardo","Eduardo","Alan","Nicolás","Jorge","Omar","Paúl","Andrés","Andrés","Josué","Román","Fernando","Javier","Abraham","Ricardo","Francisco","César","Mario","Manuel","Édgar","Alexis","Israel","Mateo","Héctor","Sergio","Emiliano","Simón","Rafael","Martín","Marco","Roberto","Pedro","Emanuel","Abel","Rubén","Fabián","Emilio","Joaquín","Marcos","Lorenzo","Armando","Adán","Raúl","Julio","Enrique","Gerardo","Pablo","Jaime","Saúl","Esteban","Gustavo","Rodrigo","Arturo","Mauricio","Orlando","Hugo","Salvador","Alfredo","Maximiliano","Ramón","Ernesto","Tobías","Abram","Guillermo","Ezequiel","Lucián","Alonzo","Felipe","Matías","Tomás","Jairo"};
	
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