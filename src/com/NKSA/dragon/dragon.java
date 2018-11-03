package com.NKSA.dragon;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Dragon")
@XmlType

public class dragon {
	boolean dead;
	String name;
	String father;
	private Integer id;
	String type;
	int res;
	Integer aSpeed;
	double actualA;
	Integer Age;
	private int xpos;
	private int ypos;
	
	public dragon(int x, int y, String name, int res, int aSpeed, int Age) {
		this.name = name;
		this.res = res;
		this.aSpeed = aSpeed;
		this.actualA = aSpeed;
		this.Age = Age;
		this.xpos = x;
		this.ypos = y;
	}
	
	public dragon(int x, int y, String name, int res, int aSpeed, int Age, int id) {
		this.name = name;
		this.res = res;
		this.aSpeed = aSpeed;
		this.actualA = aSpeed;
		this.Age = Age;
		this.xpos = x;
		this.ypos = y;
		this.setId(id);
	}
	
	public dragon() {}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public Integer getaSpeed() {
		return aSpeed;
	}

	public void setaSpeed(Integer aSpeed) {
		this.aSpeed = aSpeed;
	}

	public double getActualA() {
		return actualA;
	}

	public void setActualA(double actualA) {
		this.actualA = actualA;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

