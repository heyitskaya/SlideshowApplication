import java.util.ArrayList;
import java.util.Arrays;

public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T>
{
	//public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T>
	private ArrayList<T> arrayList;
	
	/** instructor that takes in an arrayList**/
	public BinaryHeapA(ArrayList<T> list)
	{
		
		arrayList=list;
	}
	
	public BinaryHeapA()
	{
		arrayList= new ArrayList<T>();
	}
	/** set the internal array to the arrayList passed in as a parameter**/
	public void setArray(ArrayList<T> arrayToSet)
	{
		arrayList=arrayToSet;
	}
	
	/** getter for the internal arrayList**/
	public ArrayList<T> getArrayList()
	{
		return arrayList;
	}
	/**the index given is the index of the element in the heap
		returns the index of element in the heap, purely working with the heap**/
	/** given the index as a parameter and return the index of the left child in the heap**/
	public int leftChild(int index) 
	{ 
		if(index==0)
		{
			return -1;
		}
		//first check if the array has the index
		if(inBounds(index) && inBounds(2*index))
		{
			return 2*index; //2*index+1
		}
		
		return -1;
	}
	/** given an index in the binary heap, return the value from the array**/
	public T retrieveFromArray(int index) 
	{
		if(inBounds(index))
		{
			return arrayList.get(index-1);
		}
		return null;
	}
	/** purely working with the index in the heap**/
	/** find the right child of the index passed in as a parameter**/
	public int rightChild(int index) 
	{
		if(index==0)
		{
			return -1;
		}
		//first check to see if the array has index 2*(index+1)+1;
		if(inBounds(index) && inBounds(2*index+1 ))

		{
			return 2*index+1 ;
		}
		return -1;
	}
	
	public String toString()
	{
	
		System.out.println(java.util.Arrays.toString(arrayList.toArray()));
		return java.util.Arrays.toString(arrayList.toArray());
	}
	/** maxHeapify assumes that left and right subtrees are already valid heaps**/
	/** some pseudocode ideas taken from CLRS**/
	public void maxHeapify(ArrayList<T> arrayList,int index) //index is index in heap
	{
		if(!inBounds(index))  //I CHANGED THIS SO BEWARE
		{
			return;
		}
		if(arrayList.size()<1) //I CHANGED THIS!!!!
		{
			return;
		}
		//int largest=-1;
		//System.out.println("largest is "+largest);
		if(inBounds(index)) //see if index is valid
		{
			int left=leftChild(index); //find the indexes of left and right children
			int right=rightChild(index);
			
			
				int max=findMaxChild(index); //find the index of the biggest out of the left and right child
				if(max!=-1)
				{
					swap(max, index);
					maxHeapify(arrayList,max);
				}
			
		}
	}
	public void swap(int index1, int index2) /** remember that we are swapping indexes FROM THE HEAP!!!!!!**/
	{
		if(inBounds(index1) && inBounds(index2))
		{
			T temp1=retrieveFromArray(index1); 
			int i1=index1-1; //i1 is the index
			T temp2=retrieveFromArray(index2);
			int i2=index2-1;
			arrayList.set(i1,temp2);
			arrayList.set(i2,temp1);
		}
	}
	/** given an index from the heap, return the index of the biggest child in the heap**/
	/** purely working with index stuff here**/
	public int findMaxChild(int index) /** find the child with the larger value, returns the index**/
	{
		int largest=-1;
		int left=leftChild(index);
		int right=rightChild(index);
		if(inBounds(left)&& inBounds(right) && inBounds(index)) //MUST CHECK IF LEFT AND RIGHT ARE IN BOUNDS
		{
			if(retrieveFromArray(left).compareTo(retrieveFromArray(index))>0 || retrieveFromArray(right).compareTo(retrieveFromArray(index))>0)
			{
			//find the biggest of left and right
				largest=left; //first set largest to left
				if(retrieveFromArray(left).compareTo(retrieveFromArray(right))>0) 
				{
					return largest;
				}
				else //when the right child has the larger value
				{
					return right;
				}
			}
			//if they have left and right child but both are smaller
			return -1;
		}
	
		else if(left!=-1 && right==-1&& inBounds(index)) //left isn't null but right is
		{
			if(retrieveFromArray(left).compareTo(retrieveFromArray(index))<0)
			{
				return -1;
			}
			if(retrieveFromArray(left).compareTo(retrieveFromArray(index))>0); 
			{
				
				return left;
			}
		}
		return -1;
	}
	
	/** check to see if an index in the heap is inBounds**/
	public boolean inBounds(int index) 
	{
		if(index>0 && index<=arrayList.size())
		{
			return true;
		}
		return false;
	}
	
	/** the heapSort method that makes use of the get() method which retrieves the largest element from the heap**/
	public void heapSort()
	{
		
		toString();
		ArrayList<T>  temp= new ArrayList<T>();
		int size=arrayList.size();
		for(int i=0;i<size;i++)
		{
			
			temp.add(0,get());
		}
		
		arrayList=temp;
		toString();
	
		
	}
	/** get the largest element in the heap and removes it from the heap**/
	public T get()
	{
		int currIndex=arrayList.size(); //get the last element in the heap, 
		//REALLY IMPORTANT, WE NEED TO FIRST CREATE A MAX HEAP
		if(arrayList.size()<1)  //I CHANGED THIS
		{
			return null;
		}
	
		T max=retrieveFromArray(1); //get the first element of the array which is the biggest
		swap(1,currIndex); //remember we swap indexes FROM THE HEAP
		//reduce the currNum 
		
		
		arrayList.remove(currIndex-1);
		
		maxHeapify(arrayList,1); //maybe there is something wrong with maxHeapify
		
		return max;
	}
	
	/** for creating a max heap by calling maxHeapify**/
	public void constructMaxHeap(ArrayList<T> arrayList)
	{
		int size=(arrayList.size()-1)/2; 
		for(int i=(arrayList.size())/2;i>0;i--) 
		{
			maxHeapify(arrayList,i);
		}
		
	}
	
	public void insert(T value)/** takes care of when it is a max heap and when its not a heap**/
	{
		arrayList.add(value); //add the value to the arrayList
		constructMaxHeap(arrayList);
		//toString();
	}

	
	public boolean isSorted()
	{
		if(arrayList.size()==1)
		{
			return true;
		}
		if(arrayList.size()==2)
		{
			if(arrayList.get(0).compareTo(arrayList.get(1))<0)
			{
				return true;
			}
			return false;
		}
		int i=2;
		T cursor=arrayList.get(i-1); //precursor cursor postcursor
		T precursor=arrayList.get(i-2);
		T postcursor=arrayList.get(i);
		while(i<=arrayList.size())
		{
			if(cursor.compareTo(precursor)<0 || cursor.compareTo(postcursor)>0 || precursor.compareTo(postcursor)>0)
			{
				return false;
			}
			i++;
			
		} 
		return true;
	}
	
	/** delete something at an index in the heap**/
	/** Must be index from the heap!!!!!**/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

