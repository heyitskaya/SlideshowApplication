import java.util.ArrayList;
public interface BinaryHeap<T extends Comparable<T>>
{
	
	
	/**returns the priority element**/
	public T get(); 
	
	/**given an array and an index maxHeapify the heap**/
	public void maxHeapify(ArrayList<T> array, int index); 
	
	/** sort the heap**/
	public void heapSort(); 
	
	/**returns the index of left child of the ith element at index i in the heap**/
	public int leftChild(int i); 
	
	/**returns the index of right child of the ith element at index i in the heap**/
	public int rightChild(int i); 
	
	/**prints a string representation of the heap, for debugging**/
	public String toString(); 
	
	/** find the child with the greatest value that's bigger than the element at the index in the heap**/
	public int findMaxChild(int index);
	
	/** swap two elements at indexes index1 and index2 in the heap**/
	public void swap(int index1, int index2);
	
	/** check to see if index is a valid index in the heap**/
	public boolean inBounds(int index);
	
	/** create a maxHeap when we pass in an arrayList**/
	public void constructMaxHeap(ArrayList<T> array); 
	
	/** given the index in the heap return the value at the corresponding index (i-1) in the array**/
	public T retrieveFromArray(int i);
	
	/** setter for the arrayList**/
	public void setArray(ArrayList<T> array);
	
	/** getter for the arrayList**/
	public ArrayList<T> getArrayList();
	
	/**method for checking if the arrayList is sorted, returns true if sorted, returns false otherwise**/
	public boolean isSorted();
	
		
	
}
