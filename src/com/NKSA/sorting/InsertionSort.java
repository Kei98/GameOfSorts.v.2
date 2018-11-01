package com.NKSA.sorting;

import java.util.LinkedList;

public class InsertionSort<T extends Comparable<T>> {
	
	private int order = (int)(Math.random() * 2);
	private LinkedList<T> list;
	

	public InsertionSort(LinkedList<T> list) {
		this.sort(list);
	}
	
	private void sort(LinkedList<T> l){
		for(int i = 1; i < l.size(); i++) {
			if(l.get(i).compareTo(l.get(i-1)) < 0) {
				T temp = l.get(i);
				l.remove(i);
				int n = i-1;
				while(n >= 0 && temp.compareTo(l.get(n)) < 0) {
					n--;
				}
				l.add(n+1, temp);
			}
		}
		if(this.order == 1) {
			l = this.turn(l);
		}
		this.list = l;
		this.printL(list);
	}
	
	private LinkedList<T> turn(LinkedList<T> l) {
    	LinkedList<T> l1 = new LinkedList<>();
    	for(int i = l.size()-1; i > -1; i--) {
    		l1.add(l.get(i));
    	}
    	l = l1;
    	return l;
    }
	
	
	private void printL(LinkedList<T> list) {
		System.out.print("[");
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.print(list.getLast() + "]" + "\n");
	}
	
	public LinkedList<T> getList() {
		return list;
	}
	
//	public static void main(String[] args) {
//		LinkedList<Integer> l1 = new LinkedList<Integer>();
//		
//		l1.add(10);
//		l1.add(2);
//		l1.add(6);
//		l1.add(4);
//		l1.add(3);
//		
//		InsertionSort<Integer> i = new InsertionSort<Integer>(l1);
//		
//	}

}
