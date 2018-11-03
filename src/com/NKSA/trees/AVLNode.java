package com.NKSA.trees;
import com.NKSA.dragon.dragon;

@SuppressWarnings("hiding")
public class AVLNode<dragon> {

    /**
     * Atributos
     */
    private dragon data;
    private AVLNode<dragon> left;
    private AVLNode<dragon> right;
    private int x;
    private int y;
    public int level;
    private int depth;

    /**
     * Constructor de la clase.
     * 
     * @param data:
     *            dato que recibirá el nodo del árbol.
     */
    public AVLNode(dragon data) {
    	this(data, null, null);
    }

    /**
     * Método que se encarga de agregar un nuevo nodo al árbol en conjunto con su
     * dato y los nodos izquierdo y derecho que tendrá.
     * 
     * @param data:
     *            dato a ingresar.
     * @param left:
     *            nodo derecho del nuevo nodo.
     * @param right:
     *            nodo izquierdo del nuevo nodo.
     */
    public AVLNode(dragon data, AVLNode<dragon> left, AVLNode<dragon> right) {
    	super();
    	this.data = data;
    	this.left = left;
    	this.right = right;

    	if (left == null && right == null) {
    		setDepth(1);
    	} else if (left == null) {
    		setDepth(right.getDepth() + 1);
    	} else if (right == null) {
    		setDepth(left.getDepth() + 1);
    	} else {
    		setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
    	}
    }

    /**
     * 
     */
    public int compareTo(AVLNode<dragon> o) {
    	return 0;
    }

    /**
     * 
     */
    @Override
    public String toString() {
    	return "Level " + level + ": " + data;
    }

    /**
     * Getters y Setters de la clase.
     * 
     * @return
     */
    public dragon getData() {
    	return data;
    }

    public void setData(dragon data) {
    	this.data = data;
    }

    public AVLNode<dragon> getLeft() {
    	return left;
    }

    public void setLeft(AVLNode<dragon> left) {
    	this.left = left;
    }

    public AVLNode<dragon> getRight() {
    	return right;
    }

    public void setRight(AVLNode<dragon> right) {
    	this.right = right;
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

    public int getDepth() {
    	return depth;
    }

    public void setDepth(int depth) {
    	this.depth = depth;
    }
}
