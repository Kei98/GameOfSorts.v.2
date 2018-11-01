package com.NKSA.trees;

public class BNode<T> {
	private int childNumb;
	@SuppressWarnings("rawtypes")
	public Entry[] children;


	public BNode(int order, int child) {
		childNumb = child;
		children = new Entry[order];
	}
	
	public int getChildNumb() {
		return childNumb;
	}
	
	public void setChildNumb(int childNumb) {
		this.childNumb = childNumb;
	}

	@SuppressWarnings("rawtypes")
	public Entry[] getChildren() {
		return children;
	}
	
	
}
