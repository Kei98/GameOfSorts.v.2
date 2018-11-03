package com.NKSA.trees;

import java.util.LinkedList;

import java.util.Queue;
import com.NKSA.dragon.dragon;

public class AVLTree {
	/**
     * Variable de la clase.
     */
	private AVLNode<dragon> root;

	/**
	 * Constructor de la clase.
	 */
	public AVLTree() {
		root = null;
	}


	/**
	 * Método que se encarga de recibir un dato que se desea almacenar en el árbol.
	 * 
	 * @param data:
	 *            dato a ingresar al árbol.
	 * @return
	 */

	public AVLNode<dragon> insertAVL(dragon data) {
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
	private AVLNode<dragon> insertAVL(AVLNode<dragon> node, dragon data) {
		if (node == null)
			return new AVLNode<dragon>(data);
			if (node.getData().getAge().compareTo(data.getAge()) > 0) {
				node = new AVLNode<dragon>(node.getData(), insertAVL(node.getLeft(), data), node.getRight());
			} else if (node.getData().getAge().compareTo(data.getAge()) < 0) {
				node = new AVLNode<dragon>(node.getData(), node.getLeft(), insertAVL(node.getRight(), data));
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
	public AVLNode<dragon> deleteAVL(dragon data) {
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
	private AVLNode<dragon> deleteAVL(dragon data, AVLNode<dragon> current) {
		if (current == null) {
			return current;
		}
		if (current.getData().getAge().compareTo(data.getAge()) > 0) {
			current.setLeft(deleteAVL(data, current.getLeft()));
		} else if (current.getData().getAge().compareTo(data.getAge()) < 0) {
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
	public boolean search(dragon data) {
		AVLNode<dragon> local = root;
		while (local != null) {
			if (local.getData().getAge().compareTo(data.getAge()) == 0)
				return true;
			else if (local.getData().getAge().compareTo(data.getAge()) > 0)
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
	public AVLNode<dragon> findMin() {
		return findMin(this.root);
	}

	/**
	 * Método que se encarga de encontrar el menor valor en el árbol.
	 * 
	 * @param current:
	 *            nodo a partir del cual se busca el dato de menor valor.
	 * @return: menor valor encontrado.
	 */
	private AVLNode<dragon> findMin(AVLNode<dragon> current) {
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
	public AVLNode<dragon> findmax() {
		return findMax(this.root);
	}

	/**
	 * Método que se encarga de encontrar el mayor valor en el árbol.
	 * 
	 * @param current:
	 *            nodo a partir del cual se busca el dato de mayor valor.
	 * @return: mayor valor encontrado.
	 */
	private AVLNode<dragon> findMax(AVLNode<dragon> current) {
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
	private int depth(AVLNode<dragon> node) {
		if (node == null)
			return 0;
		return node.getDepth();
	}

	/**
	 * Método que se encarga de obtener el número de balance a partir de un nodo.
	 * 
	 * @param node:
	 *            nodo a partir del cual se desea conocer su balance.
	 * @return
	 */
	private int balanceNumber(AVLNode<dragon> node) {
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
	private AVLNode<dragon> rotateLeft(AVLNode<dragon> node) {
		AVLNode<dragon> q = node;
		AVLNode<dragon> p = q.getRight();
		AVLNode<dragon> c = q.getLeft();
		AVLNode<dragon> a = p.getLeft();
		AVLNode<dragon> b = p.getRight();
		q = new AVLNode<dragon>(q.getData(), c, a);
		p = new AVLNode<dragon>(p.getData(), q, b);
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
	private AVLNode<dragon> rotateRight(AVLNode<dragon> node) {
		AVLNode<dragon> q = node;
		AVLNode<dragon> p = q.getLeft();
		AVLNode<dragon> c = q.getRight();
		AVLNode<dragon> a = p.getLeft();
		AVLNode<dragon> b = p.getRight();
		q = new AVLNode<dragon>(q.getData(), b, c);
		p = new AVLNode<dragon>(p.getData(), a, q);
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
	private void inOrder(AVLNode<dragon> r) {
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
	private void preOrder(AVLNode<dragon> r) {
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
	private void postOrder(AVLNode<dragon> r) {
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
		Queue<AVLNode<dragon>> queue = new LinkedList<AVLNode<dragon>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			AVLNode<dragon> node = queue.poll();
			System.out.println(node);
			int level = node.level;
			AVLNode<dragon> left = node.getLeft();
			AVLNode<dragon> right = node.getRight();
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
