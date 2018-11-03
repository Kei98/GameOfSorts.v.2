package com.NKSA.sorting;

import java.util.LinkedList;

import com.NKSA.dragon.dragon;


/**
 * 
 * @author NKSA
 *
 */
public class SelectionSort {
	
	/**
	 * Atributos de la clase
	 * order: si es 0 indica que la lista se ordene de menor a mayor,
	 * 		  si es 1 se ordena de mayor a menor
	 */
	
	private int size;
	private int order = (int) (Math.random() * 2);
	private LinkedList<com.NKSA.dragon.dragon> list;
	
	/**
	 * Constructor
	 * @param l
	 */
	public SelectionSort(LinkedList<dragon> l) {
		this.size = l.size();
		this.sort(l);
	}
	
	/**
	 * Método para ordenar los elementos de una lista
	 * @param l
	 */
	private void sort(LinkedList<dragon> l){
		dragon temp;
		while(this.size > 0) {
			temp = findMin(l, this.size);
			l.addLast(temp);
			l.removeFirstOccurrence(temp);
			this.size--;
		}
		if(this.order == 1) {
			l = turn(l);
		}
		this.list = l;
	}
	
	/**
	 * Método para hallar el mínimo elemento de una lista
	 * @param l
	 * @param size
	 * @return
	 */
	private dragon findMin(LinkedList<dragon> l, int size) {
		dragon min;
		min = l.get(0);
		for(int i = 1; i < size; i ++) {
			if(l.get(i).getAge().compareTo(min.getAge()) < 0) {
				min = l.get(i);
			}
		}
		return min;
	}
	
	/**
	 * Método para acomodar la lista de mayor a menor
	 * @param l
	 * @return
	 */
	private LinkedList<dragon> turn(LinkedList<dragon> l){
		LinkedList<dragon> l1 = new LinkedList<dragon>();
		for(int i = l.size() -1; i > -1; i--) {
			l1.add(l.get(i));
		}
		return l1;
	}
	
	/**
	 * Imprime la lista que devuelve
	 */
	public void printL(LinkedList<dragon> list) {
		System.out.print("[");
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.print(list.getLast() + "]" + "\n");
	}
	
	/**
	 * Getter de la lista que se pasó
	 * @return
	 */
	public LinkedList<dragon> getList() {
		return list;
	}
	
//	/**
//	 * Método de prueba del SelectionSort
//	 * @param args
//	 */
//	
//	public static void main(String[] args) {
//		LinkedList<Integer> l = new LinkedList<Integer>();
//		l.add(10);
//		l.add(2);
//		l.add(6);
//		l.add(4);
//		l.add(3);
//		l.add(5);
//		l.add(7);
//		l.add(8);
//		l.add(9);
//		l.add(1);
//		l.add(11);
//		SelectionSort<Integer> ss = new SelectionSort<>(l);
//		
//		LinkedList<Integer> l1 = new LinkedList<Integer>();
//		l1.add(10);
//		l1.add(2);
//		l1.add(6);
//		l1.add(4);
//		l1.add(3);
//		SelectionSort<Integer> p = new SelectionSort<>(l1);
//		
//		LinkedList<Integer> l2 = new LinkedList<Integer>();
//		l2.add(5);
//		l2.add(7);
//		l2.add(8);
//		l2.add(9);
//		l2.add(1);
//		l2.add(11);
//		SelectionSort<Integer> q = new SelectionSort<>(l2);
//	}

}
