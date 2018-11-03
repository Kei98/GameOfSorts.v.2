package com.NKSA.sorting;

import java.util.LinkedList;
import com.NKSA.dragon.dragon;
/**
 * 
 * @author NKSA
 *
 */
public class InsertionSort {
	
	private int order = (int)(Math.random() * 2);
	private LinkedList<dragon> list;
	

	public InsertionSort(LinkedList<dragon> list) {
		this.sort(list);
	}
	
	private void sort(LinkedList<dragon> l){
		for(int i = 1; i < l.size(); i++) {
			if(l.get(i).getaSpeed().compareTo(l.get(i-1).getaSpeed()) < 0) {
				dragon temp = l.get(i);
				l.remove(i);
				int n = i-1;
				while(n >= 0 && temp.getaSpeed().compareTo(l.get(n).getaSpeed()) < 0) {
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
	
	private LinkedList<dragon> turn(LinkedList<dragon> l) {
    	LinkedList<dragon> l1 = new LinkedList<dragon>();
    	for(int i = l.size()-1; i > -1; i--) {
    		l1.add(l.get(i));
    	}
    	l = l1;
    	return l;
    }
	
	
	private void printL(LinkedList<dragon> list) {
		System.out.print("[");
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.print(list.getLast() + "]" + "\n");
	}
	
	public LinkedList<dragon> getList() {
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
