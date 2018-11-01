package com.NKSA.application;
	
import java.util.ArrayList;


import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


@SuppressWarnings("unused")
public class Main extends Application  {
	String[] nombres= {"Steven","Daniel","David","Gabriel","Benjamín","Samuel","Lucas","Ángel","José","Adrián","Sebastián","Xavier","Juan","Luis","Diego","Óliver","Carlos","Jesús","Alex","Max","Alejandro","Antonio","Miguel","Víctor","Joel","Santiago","Elías","Iván","Óscar","Leonardo","Eduardo","Alan","Nicolás","Jorge","Omar","Paúl","Andrés","Andrés","Josué","Román","Fernando","Javier","Abraham","Ricardo","Francisco","César","Mario","Manuel","Édgar","Alexis","Israel","Mateo","Héctor","Sergio","Emiliano","Simón","Rafael","Martín","Marco","Roberto","Pedro","Emanuel","Abel","Rubén","Fabián","Emilio","Joaquín","Marcos","Lorenzo","Armando","Adán","Raúl","Julio","Enrique","Gerardo","Pablo","Jaime","Saúl","Esteban","Gustavo","Rodrigo","Arturo","Mauricio","Orlando","Hugo","Salvador","Alfredo","Maximiliano","Ramón","Ernesto","Tobías","Abram","Guillermo","Ezequiel","Lucián","Alonzo","Felipe","Matías","Tomás","Jairo"};
	private int wave = 1;
	public ImageView img,bala,fondo,fondomenu,Titulo,lifeimg,lifeimg2,lifeimg3;
	Stage window;
	shoot playerShoot;
	shoot drakeShoot;
	Stage info = new Stage();
	Stage menu = new Stage();
	Pane root = new Pane();
	Pane infoPane = new Pane();
	Pane menuPane = new Pane();
	String actualAction = "drakefly";
	Label drakeName,drakeAge,drakeX,drakeY,drakeRes,drakeAttack,drakeFather,drakeType;
	static Image dragonimg = new Image("/Multi/dragon.gif");
	static Image b = new Image("/Multi/bala.gif");
	TextField searchTF;
	int x;
	int y;
	int father = 0;
	int son = 1;
	int actualDrake = 0;
	int life = 3;
	int balaon = 0;
	boolean pause = false;
	dragongui drake1;
	ArrayList<dragongui> drakeslist = new ArrayList<dragongui>();
	ArrayList<shoot> drakesShoots = new ArrayList<shoot>();
	ArrayList<shoot> playerShoots = new ArrayList<shoot>();
	ArrayList<Integer> poslist = new ArrayList<Integer>();
	AnimationTimer timer = new AnimationTimer() {
			public void handle(long arg0) {
				if (actualAction.equals("updatepos")) {
					for (int i = 0; i<drakeslist.size(); i++) {
						double a = Math.random()*(1200-800)+800;
						double b = Math.random()*700;
						updatepos(a,b,i);
					}actualAction = "drakefly";	
				}
				else if(actualAction.equals("drakefly")) {
					if (drakesShoots.size() == 0){
					drakeShoot();
					update();
					updatebala();
					}else if (drakesShoots.size()>0){
						drakeShootUpdate();
						drakeShoot();
						updatebala();
						update();
					}
				}else if(actualAction.equals("updatelist")){
					fillpos();
					int w = 0;
					for (int i = 0; i<drakeslist.size(); i++) {
						int a = poslist.get(w);
						int b = poslist.get(w+1);
						System.out.println(i);
						w = w+2;
						updatepos(a,b,i);
					}actualAction = "drakefly";
				}else if(actualAction.equals("disparoGrifo")) {
					if (drakesShoots.size() == 0){
						update();
						drakeShoot();
						updatebala();
						}else if (drakesShoots.size()>0){
							drakeShootUpdate();
							drakeShoot();
							updatebala();
							update();
						}
				}else if(actualAction.equals("drakeShoot")) {
					
				}
		}	
	};
//	AnimationTimer balatimer = new AnimationTimer() {
//		public void handle(long arg0) {
//			while(playerShoot.getTranslateX()<1500) {
//				updatebala();
//			}
//			balatimer.stop();
//			balaon = true;
//			}
//		};
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			Scene infoScene = new Scene(infoPane,300,300);
			Scene scene = new Scene(root,root.getMaxWidth(),root.getMaxHeight());
			Scene menuScene = new Scene(menuPane,400,400);
			Image grifo = new Image("/Multi/grifo.gif");
			Image fondoimg = new Image("/Multi/fondo.jpeg");
			Image menuimg = new Image("/Multi/fondomenu.jpg");
			Image lifecount = new Image("/Multi/life.gif");
			Label titulo = new Label("Game of Sorts");
			titulo.setStyle("-fx-background-color: transparent;-fx-text-fill: red; -fx-font-size: 40");
			titulo.relocate(80, 100);
			fondo = new ImageView();
			fondo.setImage(fondoimg);
			lifeimg = new ImageView(lifecount);
			lifeimg2 = new ImageView(lifecount);
			lifeimg3 = new ImageView(lifecount);
			lifeimg.relocate(10, 10);
			lifeimg2.relocate(20, 10);
			lifeimg3.relocate(30, 10);
			fondomenu = new ImageView();
			fondomenu.setImage(menuimg);
			bala = new ImageView();
			bala.setImage(b);
			bala.setLayoutX(-1000);
			bala.setLayoutY(-1000);
			img = new ImageView();
			y = 100;
			x = 100;
//			Botones
			Button gamebtn = new Button();
			gamebtn.setOnAction(e->{
				menu.close();
				drakespam();
				types();
				timer.start();
				setLabels();
				window.show();
			});
			gamebtn.setText("Play");
			gamebtn.relocate(300, 300);
			
			Button next = new Button();
			next.setText("NextDrake");
			next.relocate(220, 260);
			next.setOnAction(e->{
				actualDrake = actualDrake + 1;
				setLabels();
			});
			Button prev = new Button();
			prev.setText("PrevDrake");
			prev.relocate(5, 260);
			prev.setOnAction(e->{
				actualDrake = actualDrake - 1;
				setLabels();
			});
			
			Button search = new Button();
			search.relocate(115, 260);
			search.setText("Search Drake");
			search.setOnAction(e->{
				actualDrake = Integer.parseInt(searchTF.getText());
				setLabels();
			});
			
			Button infoBtn = new Button();
			infoBtn.relocate(5, 730);
			infoBtn.setText("Information");
			infoBtn.setOnAction(e->{
				info.show();
				window.show();
			});
			
//			
			
//			InfoText
			searchTF = new TextField();
			searchTF.relocate(85, 260);
			searchTF.setMaxWidth(30);
			drakeName = new Label("Drake Name");
			drakeName.relocate(10, 10);
			drakeRes = new Label("Drake Life");
			drakeRes.relocate(10, 40);
			drakeAttack = new Label("Drake Attack Speed");
			drakeAttack.relocate(10, 70);
			drakeX = new Label("Drake Pos X");
			drakeX.relocate(10, 100);
			drakeY = new Label("Drake Pos Y");
			drakeY.relocate(10, 130);
			drakeAge = new Label("Drake Age");
			drakeAge.relocate(10, 160);
			drakeFather = new Label("Drake`s Father");
			drakeFather.relocate(10, 190);
			drakeType = new Label("Drake Type");
			drakeType.relocate(10, 220);
//			
			img.setFocusTraversable(true);
			img.setLayoutX(100);
			img.setLayoutY(100);
			img.setImage(grifo);
			window.setFullScreen(true);
			root.getChildren().addAll(fondo,img,lifeimg,lifeimg2,lifeimg3,infoBtn);
			infoPane.getChildren().addAll(drakeName,drakeRes,drakeAttack,drakeAge,drakeX,drakeY,drakeFather,drakeType,next,prev,search,searchTF);
			menuPane.getChildren().addAll(fondomenu,gamebtn,titulo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			menu.setScene(menuScene);
			info.setScene(infoScene);
			menu.show();
			
			root.setOnMouseClicked(e->{
				drakeslist.forEach(drake->{
					System.out.println(drake.name);
				});
			});
			
			img.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent move) {
				if (pause == false) {
				if (move.getCode().equals(KeyCode.RIGHT) || move.getCode().equals(KeyCode.D)) {
					if (x<1300 && y>=0 && y<720) {
						x = x+5;
					}
				}else if(move.getCode().equals(KeyCode.LEFT) || move.getCode().equals(KeyCode.A)) {
					if (x>=0 && y>=0 && y<720) {
						x = x-5;
					}
				}else if (move.getCode().equals(KeyCode.UP) || move.getCode().equals(KeyCode.W)) {
					if (x<1300 && x>=0 && y>=-10) {
						y = y-5;
					}
				}else if(move.getCode().equals(KeyCode.DOWN) || move.getCode().equals(KeyCode.S)) {
					if (x<1300 && x>=0 && y<720) {
						y = y+5;
					}
				}else if(move.getCode().equals(KeyCode.E)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y-5;
						x = x+5;
					}
				}else if(move.getCode().equals(KeyCode.C)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y+5;
						x = x+5;
					}
				}else if(move.getCode().equals(KeyCode.Z)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y+5;
						x = x-5;
					}
				}else if(move.getCode().equals(KeyCode.Q)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y-5;
						x = x-5;
					}
				}else if(move.getCode().equals(KeyCode.SPACE)) {
					if (balaon < 3) {
						playerShoot = new shoot(x+5,y,"balaGrifo");
						playerShoots.add(playerShoot);
						root.getChildren().addAll(playerShoot);
						actualAction = "disparoGrifo";
						balaon = balaon+1;
					}
				}
				updateimg();
				}
			}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		root.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent run) {
				if (run.getCode().equals(KeyCode.P)) {
					if (pause == false) {
						pause = true;
						timer.stop();
					}else if (pause == true) {
						pause = false;
						timer.start();
					}
				}
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void updateimg() {
		img.relocate(x, y);
	}

	public static class dragongui extends ImageView {
		boolean dead;
		String name;
		String father;
		String type;
		int res;
		int aSpeed;
		double actualA;
		int Age;
		dragongui(int x, int y, String name, int res, int aSpeed, int Age){
			super(dragonimg);
			this.name = name;
			this.res = res;
			this.aSpeed = aSpeed;
			this.actualA = aSpeed;
			this.Age = Age;
			setTranslateX(x);
			setTranslateY(y);
		}
		public void drakefly() {
			setTranslateX(getTranslateX()-0.1);
		}
		public String getName() {
			return name;
		}
		public Integer getaSpeed() {
			return aSpeed;
		}
		public Integer getAge() {
			return Age;
		}
	}
	
	private static class shoot extends ImageView{
		boolean dead;
		String who;
		shoot (int x, int y, String who){
			super(b);
			who = this.who;
			setTranslateX(x);
			setTranslateY(y);
		}
		public void balamove() {
			setTranslateX(getTranslateX()+5);
		}
		public void enemyshootmove(){
			setTranslateX(getTranslateX()-3);
			
		}
	}

	
	
//	@Override
//	public void run() {
//			try {
//				while(true) {
//						while(x1<1500) {
//							Thread.sleep(25);
//							x1 = x1+5;
//							bala.relocate(x1,y1);
//						}
//						hilo.getState();
//						balaon = true;
//						bala.relocate(-100000, -1000000);
//						hilo = null;
//					}
//				
//			}catch(Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//	public void start1() {
//		hilo = new Thread(this);
//		hilo.start();
	

	
	public void drakespam() {
		int w = 9;
		for(int i=0; i <= 20; i++) {
			int Age = (int) ((Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1)+(Math.random()*(100)+1));
			double randomres =  Math.random()*(4-1)+1;
			double aSpeed = Math.random()*(100-15)+15;
			String name = nombres[(int)((Math.random())*100)];
			if (i<10) {
				dragongui drake = new dragongui(800, w*80, name ,(int) randomres,(int) aSpeed, Age);
				root.getChildren().addAll(drake);
				drakeslist.add(drake);
				w=w-1;
			}if(i == 10) {
				w = 9;
			}
			
			if(i>10) {
				dragongui drake = new dragongui(900, w*80, name ,(int) randomres,(int) aSpeed, Age);
				root.getChildren().addAll(drake);
				drakeslist.add(drake);
				w=w-1;
			}
			
			
		}
		
	}
	private void update() {
		drakeslist.forEach(drake ->{ 
				drake.drakefly();
//				if (balazo.getBoundsInParent().intersects(drake.getBoundsInParent()));
//				root.getChildren().removeAll(balazo,drake);
		});
	}
	private void updatepos(double a, double b, int i) {
				TranslateTransition randommove = new TranslateTransition();
				randommove.setToX(a);
				randommove.setToY(b);
				randommove.setNode(drakeslist.get(i));
				randommove.setDuration(Duration.seconds(1));
				randommove.play();
	}
	private void updatebala() {
		playerShoots.forEach(playerShoot->{
			if(playerShoot.getTranslateX()<1400) {
				playerShoot.balamove();
				drakeslist.forEach(drake->{
					if(playerShoot.getBoundsInParent().intersects(drake.getBoundsInParent())) {
						playerShoots.remove(playerShoot);
						balaon = balaon - 1;
						if (drake.res == 1) {
						drakeslist.remove(drake);
						root.getChildren().removeAll(drake,playerShoot);
						actualAction = "updatepos";
							if (drakeslist.size()==1 && wave<3) {
								drakespam();
								wave = wave +1;
							}
						}else {
							drake.res = drake.res -1;
							root.getChildren().removeAll(playerShoot);
						}
					}
				});
			
			}else{
				balaon = balaon - 1;
				playerShoots.remove(playerShoot);
				root.getChildren().remove(playerShoot);
			}
		});
	}
	private void drakeShoot() {
		drakeslist.forEach(drake->{
			if (drake.actualA < 0) {
				drake.actualA = drake.aSpeed;
				drakeShoot = new shoot((int) drake.getTranslateX()-20, (int) drake.getTranslateY(), "drakeshoot");
				drakeShoot.setRotate(180);
				drakesShoots.add(drakeShoot);
				root.getChildren().addAll(drakeShoot);
			}else {
				drake.actualA = drake.actualA-0.1;
			}
			
		});
	}
	public void drakeShootUpdate(){
		drakesShoots.forEach(drakeShoot->{
			if (drakeShoot.getTranslateX()>0) {
				drakeShoot.enemyshootmove();
				if(drakeShoot.getBoundsInParent().intersects(img.getBoundsInParent())) {
					if (life == 1) {
						drakesShoots.remove(drakeShoot);
						root.getChildren().removeAll(drakeShoot,img,lifeimg);
						gameover();
					}else if (life == 2){
						drakesShoots.remove(drakeShoot);
						life = life-1;
						root.getChildren().removeAll(drakeShoot,lifeimg2);
					}else if (life == 3) {
						drakesShoots.remove(drakeShoot);
						life = life-1;
						root.getChildren().removeAll(drakeShoot,lifeimg3);
					}
				}
			}else {
				drakesShoots.remove(drakeShoot);
				root.getChildren().remove(drakeShoot);
			}
		});
		
	}
	private void gameover() {
		timer.stop();
		root.getChildren().addAll(img);
		x = 100;
		y = 100;
		img.relocate(x, y);
		menu.show();
		
	}

	private void fillpos() {
		for (int i=0; i<20; i++) {
			poslist.add(i*100+50);
			poslist.add(i*100);
		}
	}
	private void setLabels() {
		if (actualDrake == drakeslist.size()) {
			actualDrake = -1;
		}else {
			drakeName.setText("Drake Name:  "+ drakeslist.get(actualDrake).name);
			drakeAge.setText("Drake Age:  "+ drakeslist.get(actualDrake).Age);
			drakeRes.setText("Drake Life:  "+ drakeslist.get(actualDrake).res);
			drakeX.setText("Drake Pos X:  "+ (int) drakeslist.get(actualDrake).getTranslateX());
			drakeY.setText("Drake Pos Y:  "+ (int) drakeslist.get(actualDrake).getTranslateY());
			drakeAttack.setText("Drake Attack Speed:  "+ drakeslist.get(actualDrake).aSpeed);
			drakeFather.setText("Drake Father:  "+ drakeslist.get(actualDrake).father);
			drakeType.setText("Drake Type:  "+ drakeslist.get(actualDrake).type);
//		}if(actualDrake < 0){
//			actualDrake = drakeslist.size()-1;
		}
	}
	private void types() {
		int i = 0;
		while(i < drakeslist.size()) {
			if (i == 0) {
				drakeslist.get(i).type = "Comandante";
				i = i+1;
			}else if(i % 7 == 0) {
				drakeslist.get(i).type = "Capitan";
				i = i+1;
			}else {
				drakeslist.get(i).type = "Infanteria";
				i = i+1;
			}
		}
	}
//	private void fathers() {
//		while (son < drakeslist.size()-1) {
//			if(son % 2 == 0) {
//				drakeslist.get(son).father = drakeslist.get(father).name;
//				son = son + 1;
//				father = father + 1;
//				
//			}else {
//				drakeslist.get(son).father = drakeslist.get(father).name;
//				son = son + 1;
//			}
//		}
//	}
//	private void updatepos(double a, double b, int i,ArrayList<Integer> posList) {
//		TranslateTransition randommove = new TranslateTransition();
//		randommove.setToX(a);
//		randommove.setToY(b);
//		randommove.setNode(drakeslist.get(i));
//		randommove.setDuration(Duration.seconds(1));
//		randommove.play();
//}
//	public void automove(int dirx, int diry){
//		while(dirx != posx) {
//			if(posx>dirx) {
//				posx = posx-5;
////				dragon.relocate(posx, posy);
//			}else if(posx<dirx) {
//				posx = posx+5;
////				dragon.relocate(posx, posy);
//			}
//			
//			}while(diry != posy) {
//				if(posy>diry) {
//					posy = posy-5;
////					dragon.relocate(posx, posy);
//					hilo2=null;
//				}else if(posy<diry) {
//					posy = posy+5;
////					dragon.relocate(posx, posy);
//					hilo2=null;
//				}
//			}
//		}
//	public static double randomX() {
//		double a = Math.random()*1200;
//		if (a<800) {
//			randomX();
//		}else {
//			return a;
//		}
//		
//	}


	
	
	
		
	
}