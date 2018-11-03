package com.NKSA.trees;

public class BTree<T> {
	private BNode<T> root;
	int order;
	
	public BTree(int t) {
		this.root = null;
		this.order = t;
	}
	
	public void traverse() {
		if(this.root != null) {
			root.traverse();
		}
	}
	
	public BNode<T> search(int k){
		return (this.root == null) ? null : root.search(k);
		
	}
	public void insert(int k) {
		if(this.root == null) {
			this.root = new BNode<>(order, true);
			this.root.getKeys().set(0, k);
			this.root.setN(1);
		} else {
			if(this.root.getN() == 2* this.order -1) {
				BNode<T> s = new BNode<>(this.order, false);
				s.getPointers().set(0, root);
				s.splitChild(0, root);
				int i = 0;
				if(s.getKeys().get(0) < k) {
					i++;
				}
				s.getPointers().get(i).insertNonFull(k);
				this.root = s;
				
			}else {
				this.root.insertNonFull(k);
			}
		}
	}
	
	public void remove(int k) {
		if(this.root == null) {
			System.out.println("The three is empty");
			return;
		}
		this.root.remove(k);
		if(this.root.getN() == 0) {
			@SuppressWarnings("unused")
			BNode<T> temp = root;
			if(this.root.isLeaf()) {
				this.root = null;
			}else {
				this.root = this.root.getPointers().get(0);
			}
		}
		return;
	}
}
