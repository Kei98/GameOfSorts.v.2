package com.NKSA.trees;

import java.util.ArrayList;

public class BNode<T> {
	private ArrayList<Integer> keys;  //Array que debe ser cambiado a chars
    private int order;      // minimo grado
    private ArrayList<BNode<T>> pointers; // pointers a otros nodos
    private int n;     // Numero actual de keys
    private boolean leaf;

    public BNode(int t, boolean leaf){
    	this.order = t;
    	this.leaf = leaf;
    	this.keys = new ArrayList<Integer>(2*t-1);
    	this.pointers = new ArrayList<BNode<T>>(2*t);
    	this.n = 0;

    }


    public int findKey(int k) {
    	int idx = 0;
    	while (idx < n && this.keys.get(idx) < k) {
    		++idx;
    	}
    	return idx;

    }

    public void remove(int k) {
    	 int idx = this.findKey(k);

    	    if (idx < n && this.keys.get(idx) == k) {

    	        if (leaf) {
    	        	removeFromLeaf(idx);
    	        } else {
    	        	removeFromNonLeaf(idx);
    	        }
    	    } else {

    	        if (leaf) {
    	            System.out.println("The key " + k + " does not exist in the tree");
    	            return;
    	        }

    	        boolean flag = ((idx == n) ? true : false);

    	        if (this.pointers.get(idx).n < this.order) {
    	        	fill(idx);
    	        }
    	        if (flag && idx > n) {
    	        	this.pointers.get(idx-1).remove(k);
    	        }else {
    	        	this.pointers.get(idx).remove(k);
    	        }
    	    }
    	    return;
    	
    }

    public void removeFromLeaf(int idx) {
    	for (int i = idx + 1; i < n; ++i) {
    		this.keys.set(i-1, this.keys.get(i));
    	}
        n--;
        return;
    }

    public void removeFromNonLeaf(int idx) {
    	 int k = this.keys.get(idx);

    	    if (this.pointers.get(idx).n >= this.order) {
    	        int pred = getPred(idx);
    	        this.keys.set(idx, pred);
    	        this.pointers.get(idx).remove(pred);
    	    }
    	    else if (this.pointers.get(idx + 1).n >= this.order) {
    	        int succ = getSucc(idx);
    	        this.keys.set(idx, succ);
    	        this.pointers.get(idx + 1).remove(succ);    	    }

    	    else {
    	        merge(idx);
    	        this.pointers.get(idx).remove(k);
    	    }
    	    return;
    }

    public int getPred(int idx) {
    	BNode<T> current = this.pointers.get(idx);
        while (!current.leaf) {
        	current = current.pointers.get(current.n);
        }
        return current.keys.get(current.n -1);
    }

    public int getSucc(int idx) {
    	BNode<T> current = this.pointers.get(idx + 1);
        while (!current.leaf) {
        	current = current.pointers.get(0);
        }
        return current.keys.get(0);
    }

    public void fill(int idx) {
    	if (idx != 0 && this.pointers.get(idx - 1).n >= this.order) {
    		borrowFromPrev(idx);
    	}
        else if (idx != n && this.pointers.get(idx + 1).n >= this.order) {
        	borrowFromNext(idx);
        }else {
            if (idx != n) {
            	merge(idx);
            }else {
            	merge(idx - 1);
            }
        }
        return;
    }

    public void borrowFromPrev(int idx) {
    	BNode<T> child = this.pointers.get(idx);
        BNode<T> sibling = this.pointers.get(idx - 1);

        for (int i = child.n -1 ; i >= 0; --i) {
        	child.keys.set(i + 1, child.keys.get(i));
        }

        if (!child.leaf) {
            for (int i = child.n; i >= 0; --i)
            	child.pointers.set(i + 1, child.pointers.get(i));
        }

        child.keys.set(0, child.keys.get(idx-1));

        if (!leaf) {
        	child.pointers.set(0, sibling.pointers.get(sibling.n));
        }
        this.keys.set(idx - 1, sibling.keys.get(sibling.n));
        child.n += 1;
        sibling.n -= 1;

        return;
    }

    public void borrowFromNext(int idx) {
    	BNode<T> child = this.pointers.get(idx);
        BNode<T> sibling = this.pointers.get(idx + 1);
        child.keys.set(child.n, this.keys.get(idx));
        if (!(child.leaf)) {
        	child.pointers.set(child.n + 1, sibling.pointers.get(0));
        }
        this.keys.set(idx, sibling.keys.get(0));
        for (int i = 1; i < sibling.n; ++i) {
        	sibling.keys.set(i-1, sibling.keys.get(i));
        }
        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; ++i) {
            	sibling.pointers.set(i-1, sibling.pointers.get(i));
            }
        }
        child.n += 1;
        sibling.n -= 1;

        return;

    }

    public void merge(int idx) {
    	BNode<T> child = this.pointers.get(idx);
        BNode<T> sibling = this.pointers.get(idx + 1);
        
        child.keys.set(this.order -1, this.keys.get(idx));

        for (int i = 0; i < sibling.n; ++i) {
        	child.keys.set(i + this.order, sibling.keys.get(i));
        }
        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; ++i) {
            	child.pointers.set(i + this.order, sibling.pointers.get(i));
            }
        }

        for (int i = idx + 1; i < n; ++i) {
        	this.keys.set(i - 1, this.keys.get(i));
        }
        for (int i = idx + 2; i <= n; ++i) {
        	this.pointers.set(i -1, this.pointers.get(i));
        }
        child.n += sibling.n + 1;
        n--;
        return;
    }
    
    public void insertNonFull(int k) {
    	int i = n - 1;
        if (leaf == true) {
            while (i >= 0 && this.keys.get(i) > k) {
            	this.keys.set(i + 1, this.keys.get(i));
                i--;
            }
            this.keys.set(i + 1, k);
            n = n + 1;
        } else {
            while (i >= 0 && this.keys.get(i) > k) {
            	i--;
            }
            if (this.pointers.get(i + 1).n == 2 * this.order - 1) {
                splitChild(i + 1, this.pointers.get(i + 1));
                if (this.keys.get(i + 1) < k) {
                	i++;
                }
            }
            this.pointers.get(i + 1).insertNonFull(k);
        }
    	
    }

	public void splitChild(int i, BNode<T> y) {
    	BNode<T> z = new BNode<>(y.order, y.leaf);
    	z.n = this.order -1;
    	
    	for (int j = 0; j < this.order - 1; j++) {
    		z.keys.set(j, y.keys.get(j + order));
    	}
        if (y.leaf == false) {
            for (int j = 0; j < order; j++) {
            	z.pointers.set(j, y.pointers.get(j + 1));
            }
        }
        y.n = this.order -1;
        for (int j = n; j >= i + 1; j--) {
        	this.pointers.set(j + 1, this.pointers.get(j));
        }
        this.pointers.set(i + 1, z);
        for (int j = n - 1; j >= i; j--) {
        	this.keys.set(j + 1, this.keys.get(j));
        }
        this.keys.set(i, y.keys.get(this.order - 1));
        n = n + 1;
    }
	
    public void traverse() {
    	int i;
        for (i = 0; i < n; i++) {
            if (leaf == false) {
            	this.pointers.get(i).traverse();
            }
            System.out.println(" " + this.keys.get(i));
        }
        if (leaf == false) {
        	this.pointers.get(i).traverse();
        }
    }
    
    public BNode<T> search(int k) {
    	int i = 0;
        while (i < n && k > this.keys.get(i)) {
        	i++;
        }
        if (this.keys.get(i) == k) {
        	return this;
        }
        if (leaf == true) {
        	return null;
        }
        return this.pointers.get(i).search(k);
    }


	public ArrayList<Integer> getKeys() {
		return keys;
	}


	public void setKeys(ArrayList<Integer> keys) {
		this.keys = keys;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public ArrayList<BNode<T>> getPointers() {
		return pointers;
	}


	public void setPointers(ArrayList<BNode<T>> pointers) {
		this.pointers = pointers;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public boolean isLeaf() {
		return leaf;
	}


	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

}
