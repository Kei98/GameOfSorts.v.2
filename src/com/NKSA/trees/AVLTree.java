package com.NKSA.trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	/**
     * Variable de la clase.
     */
    private AVLNode<T> root;

    /**
     * Constructor de la clase.
     */
    public AVLTree() {
	root = null;
    }

    // private T Maximum() {
    // Node<T> local = root;
    // if (local == null)
    // return null;
    // while (local.getRight() != null)
    // local = local.getRight();
    // return local.getData();
    // }
    //
    // private T Minimum() {
    // Node<T> local = root;
    // if (local == null)
    // return null;
    // while (local.getLeft() != null) {
    // local = local.getLeft();
    // }
    // return local.getData();
    // }

    /**
     * Método que se encarga de recibir un dato que se desea almacenar en el árbol.
     * 
     * @param data:
     *            dato a ingresar al árbol.
     * @return
     */
    public AVLNode<T> insertAVL(T data) {
	root = insertAVL(root, data);
	switch (balanceNumber(root)) {
	case 1:
	    root = rotateLeft(root);
	    break;
	case -1:
	    root = rotateRight(root);
	    break;
	default:
	    break;
	}
	return root;
    }

    /**
     * Método que se encarga de agregar un nuevo nodo al árbol.
     * 
     * @param node:
     *            nuevo nodo con el dato a ingresar.
     * @param data:
     *            dato a ingresar árbol.
     * @return
     */
    private AVLNode<T> insertAVL(AVLNode<T> node, T data) {
	if (node == null)
	    return new AVLNode<T>(data);
	if (node.getData().compareTo(data) > 0) {
	    node = new AVLNode<T>(node.getData(), insertAVL(node.getLeft(), data), node.getRight());
	    // node.setLeft(insert(node.getLeft(), data));
	} else if (node.getData().compareTo(data) < 0) {
	    // node.setRight(insert(node.getRight(), data));
	    node = new AVLNode<T>(node.getData(), node.getLeft(), insertAVL(node.getRight(), data));
	}
	switch (balanceNumber(node)) {
	case 1:
	    node = rotateLeft(node);
	    break;
	case -1:
	    node = rotateRight(node);
	    break;
	default:
	    return node;
	}
	return node;
    }

    /**
     * Método que se encarga de recibir un elemento que se desea eliminar.
     * 
     * @param data:
     *            elemento que se desea eliminar.
     * @return
     */
    public AVLNode<T> deleteAVL(T data) {
	if (this.root == null) {
	    return null;
	} else {
	    return deleteAVL(data, this.root);
	}
    }

    /**
     * Método que se encarga de eliminar un dato del árbol.
     * 
     * @param data:
     *            dato a eliminar.
     * @param current:
     *            nodo a partir del cual se busca el elemento a eliminar.
     * @return
     */
    private AVLNode<T> deleteAVL(T data, AVLNode<T> current) {
	if (current == null) {
	    return current;
	}
	if (current.getData().compareTo(data) > 0) {
	    current.setLeft(deleteAVL(data, current.getLeft()));
	} else if (current.getData().compareTo(data) < 0) {
	    current.setRight(deleteAVL(data, current.getRight()));
	} else if (current.getLeft() != null && current.getRight() != null) {
	    current.setData(findMin(current.getRight()).getData());
	    data = findMin(current.getRight()).getData();
	    current.setRight(deleteAVL(data, current.getRight()));
	} else {
	    current = current.getRight() != null ? current.getRight() : current.getLeft();
	}
	return current;
    }

    /**
     * Método que se encarga de buscar un valor en el árbol.
     * 
     * @param data:
     *            dato que se desea encontrar.
     * @return: verdadero o falso si el dato se encuentra en el árbol.
     */
    public boolean search(T data) {
	AVLNode<T> local = root;
	while (local != null) {
	    if (local.getData().compareTo(data) == 0)
		return true;
	    else if (local.getData().compareTo(data) > 0)
		local = local.getLeft();
	    else
		local = local.getRight();
	}
	return false;
    }

    /**
     * Método que se encarga de encontrar el menor valor en el árbol.
     * 
     * @return: menor valor encontrado.
     */
    public AVLNode<T> findMin() {
	return findMin(this.root);
    }

    /**
     * Método que se encarga de encontrar el menor valor en el árbol.
     * 
     * @param current:
     *            nodo a partir del cual se busca el dato de menor valor.
     * @return: menor valor encontrado.
     */
    private AVLNode<T> findMin(AVLNode<T> current) {
	if (current == null) {
	    return null;
	} else if (current.getLeft() == null) {
	    return current;
	} else {
	    return findMin(current.getLeft());
	}
    }

    /**
     * Método que se encarga de encontrar el mayor valor en el árbol.
     * 
     * @return: mayor valor encontrado.
     */
    public AVLNode<T> findmax() {
	return findMax(this.root);
    }

    /**
     * Método que se encarga de encontrar el mayor valor en el árbol.
     * 
     * @param current:
     *            nodo a partir del cual se busca el dato de mayor valor.
     * @return: mayor valor encontrado.
     */
    private AVLNode<T> findMax(AVLNode<T> current) {
	if (current == null) {
	    return null;
	} else if (current.getRight() == null) {
	    return current;
	} else {
	    return findMax(current.getRight());
	}
    }

    /**
     * Método que se encarga de obtener el nivel del nodo.
     * 
     * @param node:
     *            nodo al cual se le desea conocer su nivel o profundidad.
     * @return
     */
    private int depth(AVLNode<T> node) {
	if (node == null)
	    return 0;
	return node.getDepth();
	// 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    /**
     * Método que se encarga de obtener el número de balance a partir de un nodo.
     * 
     * @param node:
     *            nodo a partir del cual se desea conocer su balance.
     * @return
     */
    private int balanceNumber(AVLNode<T> node) {
	int L = depth(node.getLeft());
	int R = depth(node.getRight());
	if (L - R >= 2)
	    return -1;
	else if (L - R <= -2)
	    return 1;
	return 0;
    }

    /**
     * Método que se encarga de realiar una rotación izquierda en caso de que el
     * árbol se encuentre desbalanceado.
     * 
     * @param node:
     *            nodo a partir del cuál se desea realizar la rotación.
     * @return
     */
    private AVLNode<T> rotateLeft(AVLNode<T> node) {
	AVLNode<T> q = node;
	AVLNode<T> p = q.getRight();
	AVLNode<T> c = q.getLeft();
	AVLNode<T> a = p.getLeft();
	AVLNode<T> b = p.getRight();
	q = new AVLNode<T>(q.getData(), c, a);
	p = new AVLNode<T>(p.getData(), q, b);
	return p;
    }

    /**
     * Método que se encarga de realiar una rotación derecha en caso de que el árbol
     * se encuentre desbalanceado.
     * 
     * @param node:
     *            nodo a partir del cuál se desea realizar la rotación.
     * @return
     */
    private AVLNode<T> rotateRight(AVLNode<T> node) {
	AVLNode<T> q = node;
	AVLNode<T> p = q.getLeft();
	AVLNode<T> c = q.getRight();
	AVLNode<T> a = p.getLeft();
	AVLNode<T> b = p.getRight();
	q = new AVLNode<T>(q.getData(), b, c);
	p = new AVLNode<T>(p.getData(), a, q);
	return p;
    }

    /**
     * 
     */
    public void inOrder() {
	inOrder(root);
    }

    /**
     * 
     * @param r
     */
    private void inOrder(AVLNode<T> r) {
	if (r != null) {
	    inOrder(r.getLeft());
	    System.out.print(r.getData() + " ");
	    inOrder(r.getRight());
	}
    }

    /**
     * 
     */
    public void preOrder() {
	preOrder(root);
    }

    /**
     * 
     * @param r
     */
    private void preOrder(AVLNode<T> r) {
	if (r != null) {
	    System.out.print(r.getData() + " ");
	    preOrder(r.getLeft());
	    preOrder(r.getRight());
	}
    }

    /**
     * 
     */
    public void postOrder() {
	postOrder(root);
    }

    /**
     * 
     * @param r
     */
    private void postOrder(AVLNode<T> r) {
	if (r != null) {
	    postOrder(r.getLeft());
	    postOrder(r.getRight());
	    System.out.print(r.getData() + " ");
	}
    }

    /**
     * 
     */
    @Override
    public String toString() {
	return root.toString();
    }

    /**
     * Método que se encarga de imprimir en consola el árbol AVL.
     */
    public void PrintTree() {
	root.level = 0;
	Queue<AVLNode<T>> queue = new LinkedList<AVLNode<T>>();
	queue.add(root);
	while (!queue.isEmpty()) {
	    AVLNode<T> node = queue.poll();
	    System.out.println(node);
	    int level = node.level;
	    AVLNode<T> left = node.getLeft();
	    AVLNode<T> right = node.getRight();
	    if (left != null) {
		left.level = level + 1;
		queue.add(left);
	    }
	    if (right != null) {
		right.level = level + 1;
		queue.add(right);
	    }
	}
    }
}
