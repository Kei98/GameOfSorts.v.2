package com.NKSA.trees;


import com.NKSA.dragon.dragon;

@SuppressWarnings("hiding")
public class BinaryNode<dragon> {
	/**
     * Atributos
     */
    private dragon data;
    private BinaryNode<dragon> left;
    private BinaryNode<dragon> right;
    private int x;
    private int y;

    /**
     * Constructor 
     * 
     * @param data:
     *            dato que guardará el nodo
     */
    public BinaryNode(dragon data) {
	this.data = data;
	this.right = null;
	this.left = null;
    }

    /**
     * Constructor
     * 
     * @param data:
     *            dato que se almacenará en el nodo
     * @param left:
     *            nodo izquierdo del nuevo nodo
     * @param right:
     *            nodo derecho del nuevo nodo
     */
    public BinaryNode(dragon data, BinaryNode<dragon> left, BinaryNode<dragon> right) {
    	this.data = data;
    	this.left = left;
    	this.right = right;
    }
    
    
    
    /**
     * Getters y Setters
     */
    public dragon getData() {
	return data;
    }

    public void setData(dragon data) {
	this.data = data;
    }

    public BinaryNode<dragon> getRight() {
	return right;
    }

    public void setRight(BinaryNode<dragon> right) {
	this.right = right;
    }

    public BinaryNode<dragon> getLeft() {
	return left;
    }

    public void setLeft(BinaryNode<dragon> left) {
	this.left = left;
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
