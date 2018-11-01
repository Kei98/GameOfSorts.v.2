package com.NKSA.trees;

public class BinaryNode<T extends Comparable<T>> {
	/**
     * Atributos
     */
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private int x;
    private int y;

    /**
     * Constructor 
     * 
     * @param data:
     *            dato que guardará el nodo
     */
    public BinaryNode(T data) {
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
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
	this.data = data;
	this.left = left;
	this.right = right;
    }

    /**
     * Getters y Setters
     */
    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }

    public BinaryNode<T> getRight() {
	return right;
    }

    public void setRight(BinaryNode<T> right) {
	this.right = right;
    }

    public BinaryNode<T> getLeft() {
	return left;
    }

    public void setLeft(BinaryNode<T> left) {
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
