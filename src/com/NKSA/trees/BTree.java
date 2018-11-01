package com.NKSA.trees;

public class BTree<T extends Comparable<T>, Value> {
	
	private final int order;
	private BNode<T> root;
	private int height;
	private int pair;
	
	public BTree(int order) {
		this.order = order;
		this.root = new BNode<>(order, 0);
		
	}
	
	
	public boolean isEmpty() {
		return this.getPair() == 0;
	}
	
	public Value get(T key) {
		if(key == null) {
			throw new IllegalArgumentException("argument to get() is null");
		}
		return this.search(root, key, height);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Value search(BNode<T> node, T key, int ht) {
		Entry[] children = node.getChildren();
		
		if(ht == 0) {
			for(int i = 0; i < node.getChildNumb(); i++) {
				if(eq(key, children[i].getKey())) {
					return (Value) children[i].getVal();
				}
			}
		}else {
			for(int i = 0; i < node.getChildNumb(); i++) {
				if(i+1 == node.getChildNumb() || less(key, children[i+1].getKey())) {
					return (Value) search(children[i].getNext(), key, ht-1);
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void put(T key, Value val) {
		if(key == null) {
			throw new IllegalArgumentException("argument key to put() is null");
		}else {
			BNode<T> node = insert(root, key, val, height);
			this.pair++;
			if(node == null) {
				return;
			}else {
				BNode<T> temp = new BNode<>(order, 2);
				temp.children[0] = new Entry<>(root.children[0].getKey(), null, root);
				temp.children[1] = new Entry<>(node.children[0].getKey(), null, node);
				root = node;
				this.height++;
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private BNode<T> insert(BNode<T> node, T key, Value val, int ht){
		int i;
		Entry<T> temp = new Entry<>(key, val, null);
		if(ht == 0) {
			for(i = 0; i < node.getChildNumb(); i++) {
				if(less(key, node.children[i].getKey())) {
					break;
				}
			}
		}else {
			for(i = 0; i < node.getChildNumb(); i++) {
				if((i+1 == node.getChildNumb() || less(key, node.children[i+1].getKey()))) {
					BNode<T> bn = insert(node.children[i++].getNext(), key, val, ht-1);
					if(bn == null) {
						return null;
					}else {
						temp.setKey(bn.children[0].getKey());
						temp.setNext(bn);
						break;
					}
					
				}
			}
		}
		
		for(int j = node.getChildNumb(); j < i; j--) {
			node.children[j] = node.children[j-1];
		}
		node.children[i] = temp;
		node.setChildNumb(node.getChildNumb() + 1);
		if(node.getChildNumb() < this.order) {
			return null;
		}else {
			return split(node);
		}		
	}
	
	
	private BNode<T> split(BNode<T> node){
		BNode<T> temp = new BNode<>(order, order/2);
		node.setChildNumb(order/2);
		for(int k = 0; k < order/2; k++) {
			temp.children[k] = node.children[order/2 + k];
		}
		return temp;
	}
	
	
	public String toString() {
		return toString(root, height, "") + " ";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String toString(BNode<T> node, int ht, String indent) {
		StringBuilder b = new StringBuilder();
		Entry[] children = node.children;
		
		if(ht == 0) {
			for(int j = 0; j < node.getChildNumb(); j++) {
				b.append(indent + children[j].getKey() + " " + children[j].getVal() + "\n");
			}
		}else {
			for(int j = 0; j < node.getChildNumb(); j++) {
				b.append(toString(children[j].getNext(), ht-1, indent + "   "));
			}
		}
		return b.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean less(Comparable t, Comparable t1) {
		return (t.compareTo(t1) < 0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean eq(Comparable t, Comparable t1) {
		return (t.compareTo(t1) == 0);
	}
	
	public int getHeight() {
		return height;
	}

	public int getPair() {
		return pair;
	}
	
	public int getOrder() {
		return order;
	}
	
	
	public static void main(String[] args) {
		BTree<Integer, Integer> bt1 = new BTree<>(10);
		bt1.put(0, 100);
		bt1.put(0, 105);
		bt1.put(0, 120);
		bt1.put(0, 150);
		bt1.put(0, 180);
		bt1.put(0, 200);
		bt1.put(0, 300);
		bt1.put(0, 800);
		bt1.put(0, 500);
		bt1.put(0, 900);
		bt1.put(3, 600);
		bt1.put(2, 400);
		bt1.put(2, 700);
		bt1.put(0, 1000);
		bt1.toString();
	}
}
