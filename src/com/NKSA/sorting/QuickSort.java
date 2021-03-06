package com.NKSA.sorting;

import java.util.LinkedList;

import com.NKSA.dragon.dragon;



public class QuickSort {

    /**
     * Atributos
     */
    private int i;
    private int j;
    private int order = (int)(Math.random() * 2);
    private dragon pivot;
    private dragon temp;
    private LinkedList<dragon> list = new LinkedList<>();

    /**
     * Constructor 
     */
    public QuickSort(LinkedList<dragon> l) {
    	this.sort(l);
    }

    /**
     * M�todo que se encarga de ordenar una lista utilizando la l�gica del metodo de
     * ordenamiento QuickSort.
     * 
     * @param array:
     *            arreglo al cual se le desea ordenar mediante el m�todo QuickSort.
     */
    private void sort(LinkedList<dragon> array) {
    	sort(array, 0, array.size() - 1);
    }

    /**
     * M�todo que se encarga de ordenar una lista de la forma QuickSort
     * 
     * @param array:
     *            lista que se desea ordenar
     * @param first:
     *            primera posici�n en la lista
     * @param last:
     *            �ltima posici�n en la lista
     */
    private void sort(LinkedList<dragon> array, int first, int last) {
	i = first;
	j = last;
	pivot = array.get((int) ((i + j) / 2));

	do {
	    while (array.get(i).getAge().compareTo(pivot.getAge()) < 0) {
		i++;
	    }
	    while (array.get(j).getAge().compareTo(pivot.getAge()) > 0) {
		j--;
	    }
	    if (i <= j) {
		temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
		i++;
		j--;
	    }
	} while (i <= j);
	if (first < j) {
	    sort(array, first, j);
	}
	if (i < last) {
	    sort(array, i, last);
	}else if(first >= j && i >= last) {
		if(order == 1) {
			array = this.turn(array);
		}
		this.list = array;
	}
    }
    
    /**
     * M�todo para acomodar la lista de mayor a menor
     * @param l
     */
    private LinkedList<dragon> turn(LinkedList<dragon> l) {
    	LinkedList<dragon> l1 = new LinkedList<dragon>();
    	for(int i = l.size()-1; i > -1; i--) {
    		l1.add(l.get(i));
    	}
    	l = l1;
    	return l;
    }

    /**
     * M�todo que se encarga de mostrar en consola el arreglo.
     * 
     * @param array:
     *            arreglo que se desea imprimir en consola.
     */
    public void printL(LinkedList<dragon> array) {
	System.out.print("[");
	for (int i = 0; i < array.size() - 1; i++) {
	    System.out.print(array.get(i) + ", ");
	}
	System.out.print(array.get(array.size() - 1));
	System.out.print("]");
	System.out.println(" ");
    }
    
    public LinkedList<dragon> getList() {
    	this.printL(list);
		return list;
	}

///**
// * Prueba
// * @param args
// */
//	public static void main(String[] args) {
//    	LinkedList<Integer> array = new LinkedList<Integer>();
//    	array.add(1);
//    	array.add(8);
//    	array.add(93);
//    	array.add(53);
//    	array.add(762);
//    	array.add(4);
//    	array.add(0);
//    	
//    	QuickSort<Integer> q = new QuickSort<Integer>(array);
//    	q.getList();
//    }
}