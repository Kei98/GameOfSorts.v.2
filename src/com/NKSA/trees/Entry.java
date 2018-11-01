package com.NKSA.trees;

public class Entry<T> {
	private Comparable<T> key;
	private final Object val;
	private BNode<T> next;
	
	public Entry(Comparable<T> key, Object val, BNode<T> next) {
		this.key = key;
		this.val = val;
		this.next = next;
	}
	
	public Comparable<T> getKey() {
		return key;
	}
	
	public void setKey(Comparable<T> key) {
		this.key = key;
	}
	
	public Object getVal() {
		return val;
	}


	public BNode<T> getNext() {
		return next;
	}
	
	public void setNext(BNode<T> next) {
		this.next = next;
	}
}
