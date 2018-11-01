package com.NKSA.application;
import javafx.application.Application;


public class DragonThread extends Thread {
	int posx = 100;
	int posy = 100;
	Main interfaz = new Main();
	
	
	public DragonThread(String msg) {
		super(msg);
	}
	public void run() {
		try {
			while (true) {
				Thread.sleep(50);
				posx = posx-5;
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
	
}
