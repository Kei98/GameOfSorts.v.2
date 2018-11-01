package com.NKSA.trees;

public class BinaryTree<T extends Comparable<T>> {
	/**
	 * Atributo
	 */
	private BinaryNode<T> root;

	/**
	 * Constructor
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * M�todo que se encarga de recibir un dato a almacenar en el �rbol.
	 * 
	 * @param data:
	 *            dato a ingresar al �rbol.
	 * @return
	 */
	public BinaryNode<T> insert(T data) {
		root = insert(root, data);
		return root;
	}

	/**
	 * M�todo que se encarga de agregar un nuevo nodo al �rbol.
	 * 
	 * @param node:
	 *            nuevo nodo con el dato a ingresar.
	 * @param data:
	 *            dato a ingresar �rbol.
	 * @return
	 */
	private BinaryNode<T> insert(BinaryNode<T> node, T data) {
		if (node == null)
			return new BinaryNode<T>(data);
		if (node.getData().compareTo(data) > 0) {
			node = new BinaryNode<T>(node.getData(), insert(node.getLeft(), data), node.getRight());
		} else if (node.getData().compareTo(data) < 0) {
			node = new BinaryNode<T>(node.getData(), node.getLeft(), insert(node.getRight(), data));
		}
		return node;
	}

	/**
	 * M�todo que se encarga de recibir un elemento que se desea eliminar.
	 * 
	 * @param data:
	 *            elemento que se desea eliminar.
	 * @return
	 */
	public BinaryNode<T> delete(T data) {
		if (this.root == null) {
			return null;
		} else {
			return delete(data, this.root);
		}
	}

	/**
	 * M�todo que se encarga de eliminar un dato del �rbol.
	 * 
	 * @param data:
	 *            dato a eliminar.
	 * @param current:
	 *            nodo a partir del cual se busca el elemento a eliminar.
	 * @return
	 */
	private BinaryNode<T> delete(T data, BinaryNode<T> current) {
		if (current == null) {
			return current;
		}
		if (current.getData().compareTo(data) > 0) {
			current.setLeft(delete(data, current.getLeft()));
		} else if (current.getData().compareTo(data) < 0) {
			current.setRight(delete(data, current.getRight()));
		} else if (current.getLeft() != null && current.getRight() != null) {
			current.setData(findMin(current.getRight()).getData());
			data = findMin(current.getRight()).getData();
			current.setRight(delete(data, current.getRight()));
		} else {
			current = current.getRight() != null ? current.getRight() : current.getLeft();
		}
		return current;
	}

	/**
	 * M�todo que se encarga de buscar un valor en el �rbol.
	 * 
	 * @param data:
	 *            dato que se desea encontrar.
	 * @return: verdadero o falso si el dato se encuentra en el �rbol.
	 */
	public boolean search(T data) {
		BinaryNode<T> local = root;
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
	 * M�todo que se encarga de encontrar el menor valor en el �rbol.
	 * 
	 * @return: menor valor encontrado.
	 */
	public BinaryNode<T> findMin() {
		return findMin(this.root);
	}

	/**
	 * M�todo que se encarga de encontrar el menor valor en el �rbol.
	 * 
	 * @param current:
	 *            nodo a partir del cual se busca el dato de menor valor.
	 * @return: menor valor encontrado.
	 */
	private BinaryNode<T> findMin(BinaryNode<T> current) {
		if (current == null) {
			return null;
		} else if (current.getLeft() == null) {
			return current;
		} else {
			return findMin(current.getLeft());
		}
	}

	/**
	 * M�todo que se encarga de encontrar el mayor valor en el �rbol.
	 * 
	 * @return: mayor valor encontrado.
	 */
	public BinaryNode<T> findmax() {
		return findMax(this.root);
	}

	/**
	 * M�todo que se encarga de encontrar el mayor valor en el �rbol.
	 * 
	 * @param current:
	 *            nodo a partir del cual se busca el dato de mayor valor.
	 * @return: mayor valor encontrado.
	 */
	private BinaryNode<T> findMax(BinaryNode<T> current) {
		if (current == null) {
			return null;
		} else if (current.getRight() == null) {
			return current;
		} else {
			return findMax(current.getRight());
		}
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
	private void inOrder(BinaryNode<T> r) {
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
	private void preOrder(BinaryNode<T> r) {
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
	private void postOrder(BinaryNode<T> r) {
		if (r != null) {
			postOrder(r.getLeft());
			postOrder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}

}
