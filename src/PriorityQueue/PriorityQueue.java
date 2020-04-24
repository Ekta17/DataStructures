package PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {

	public enum HEAP_TYPE {
		MAX_HEAP, MIN_HEAP
	};

	List<T> heap;
	HEAP_TYPE heapType;

	public HEAP_TYPE getHeapType() {
		return heapType;
	}

	public void setHeapType(HEAP_TYPE heapType) {
		switch (heapType) {
		case MAX_HEAP:
			this.heapType = HEAP_TYPE.MAX_HEAP;
			break;
		case MIN_HEAP:
			this.heapType = HEAP_TYPE.MIN_HEAP;
			break;
		}
	}

	public PriorityQueue(HEAP_TYPE typeOfHeap) {
		setHeapType(typeOfHeap);
		this.heap = new ArrayList<>();
	}

	public PriorityQueue(int size, HEAP_TYPE typeOfHeap) {
		setHeapType(typeOfHeap);
		this.heap = new ArrayList<>(size);
	}

	public PriorityQueue(T[] elem, HEAP_TYPE typeOfHeap) {
		setHeapType(typeOfHeap);
		for (int i = 0; i < elem.length; i++)
			this.heap.add(elem[i]);
		heapify(0);
	}

	T getElementAt(int i) {

		if (isEmpty() || i > this.heap.size() - 1)
			return null;
		else
			return this.heap.get(i);
	}

	boolean isEmpty() {
		return this.heap.size() == 0;
	}

	int getSize() {
		return this.heap.size();
	}

	T peek() {
		if (!isEmpty())
			return this.heap.get(0);
		else
			return null;
	}

	T poll() {
		return removeAt(0);
	}

	boolean contains(T elem) {
		if (!isEmpty()) {
			for (int i = 0; i < this.heap.size(); i++) {
				if (this.heap.get(i).equals(elem))
					return true;
			}
		}
		return false;
	}

	void add(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();

		this.heap.add(elem);
		heapify(0);
	}

	boolean remove(T elem) {
		if (elem == null)
			throw new IllegalArgumentException();

		if (!isEmpty()) {
			for (int i = 0; i < this.heap.size(); i++) {
				if (this.heap.get(i) == elem) {
					removeAt(i);
					return true;
				}
			}
		}
		return false;
	}

	T removeAt(int i) {
		if (isEmpty())
			return null;

		T removedElement = this.heap.get(i);
		swap(i, this.heap.size() - 1);
		this.heap.remove(this.heap.size() - 1);
		heapify(0);
		return removedElement;

	}

	void heapify(int i) {
		switch (getHeapType()) {
		case MAX_HEAP:
			maxHeapify(i);
			break;
		case MIN_HEAP:
			minHeapify(i);
			break;
		}
	}

	private void maxHeapify(int i) {
		int leftChild = getIndexOfLeftChild(i);
		int rightChild = getIndexOfRightChild(i);

		int indexOfLargerElem;
		if (leftChild < this.heap.size() && greaterThan(leftChild, i))
			indexOfLargerElem = leftChild;
		else
			indexOfLargerElem = i;
		if (rightChild < this.heap.size() && greaterThan(rightChild, indexOfLargerElem))
			indexOfLargerElem = rightChild;

		if (indexOfLargerElem != i) {
			swap(i, indexOfLargerElem);
			maxHeapify(indexOfLargerElem);
		}
	}

	void swap(int i, int j) {
		T temp = this.heap.get(i);
		this.heap.set(i, this.heap.get(j));
		this.heap.set(j, temp);
	}

	private void minHeapify(int i) {
		int leftChild = getIndexOfLeftChild(i);
		int rightChild = getIndexOfRightChild(i);

		int indexOfSmallerElem;
		if (leftChild < this.heap.size() && lessThan(leftChild, i))
			indexOfSmallerElem = leftChild;
		else
			indexOfSmallerElem = i;
		if (rightChild < this.heap.size() && lessThan(rightChild, indexOfSmallerElem))
			indexOfSmallerElem = rightChild;

		if (indexOfSmallerElem != i) {
			swap(i, indexOfSmallerElem);
			minHeapify(indexOfSmallerElem);
		}
	}

	private boolean lessThan(int i, int j) {
		T elemAtI = this.heap.get(i);
		T elemAtJ = this.heap.get(j);
		return elemAtI.compareTo(elemAtJ) < 0;
	}

	private boolean greaterThan(int i, int j) {
		T elemAtI = this.heap.get(i);
		T elemAtJ = this.heap.get(j);
		return elemAtI.compareTo(elemAtJ) > 0;
	}

	private int getIndexOfLeftChild(int i) {
		return 2 * i + 1;
	}

	private int getIndexOfRightChild(int i) {
		return 2 * i + 2;
	}

	@Override
	public String toString() {
		return "PriorityQueue [heap=" + heap + ", heapType=" + heapType + "]";
	}

}
