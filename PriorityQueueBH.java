import java.util.*;
public class PriorityQueueBH implements PriorityQueue
{
	private HashMap<Integer,String> map;
	private BinaryHeapA<Integer> heap;
	ArrayList<Integer> arrayList;
	private  int MAXTIME;
	
	/** constructor that takes in seconds as a parameter to set the duration of the slideshow**/
	public PriorityQueueBH(int seconds)
	{
		MAXTIME=seconds;
		arrayList= new ArrayList<Integer>();
		map=new HashMap<Integer,String>();
		heap= new BinaryHeapA<Integer>(arrayList);
		arrayList=heap.getArrayList();
	}
	
	public void insertIntoMap(Integer key, String value)
	{
			if(map.containsKey(key))
			{
				String s=map.get(key);
				s=s+" "+value;
				map.put(key, s);
				return;
			}
			else //when the map does not contain this key
			{
				map.put(key, value);
			}
		
	}
	
	public void insertIntoHeap(Integer i)
	{
		if(!arrayList.contains(i)) //if the ArrayList doesn't contains the key, insert it
		{
			heap.insert(i); //insert the Integer i into the heap
			arrayList=heap.getArrayList(); //update the arrayList
			
			return;
		}
	}
	
	public void insert(Integer i, String value)
	{
		
	
			insertIntoMap(MAXTIME-i,value);
			heap.insert(MAXTIME-i);
			//arrayList=heap.getArrayList();
		
	}
	
	public String maximum()
	{
		return map.get(arrayList.get(0));
	}
	
	 /** retrieves and deletes the max value**/
	/** deletes from both map and heap**/
	public String extractMax() 
	{
		Integer priority=getMaxPriority(); //this priority is gone after we call get(), so no need to update ArrayList
		//System.out.println("priority is "+priority);
		String s=map.get(priority); 
		heap.get();
		
		//map.remove(priority); //I JUST ADDED THIS
		//System.out.println("The string is "+s);
		return s;
	}
	
	public Integer getMaxPriority()
	{
		return heap.getArrayList().get(0);
	}
	

	
	public void increaseKey(Integer currKey, Integer newKey) 
	{
		String string=map.get(currKey); 
		map.put(newKey,string);
		//go into the heap and and find currKey, change it to new key and reaheapfiy
		int index=arrayList.indexOf(currKey);
		arrayList.set(index,newKey);
		heap.setArray(arrayList); //reset the underlying data structure in the heap
		heap.constructMaxHeap(arrayList);
		//construct max heap again
		//find the node in the heap with the currKey and change it to newKey and constructMaxHeap
	}
	public BinaryHeapA<Integer> getHeap()
	{
		return heap;
	}
	
	public HashMap<Integer,String> getMap()
	{
		return map;
	}
	public int getLength()
	{
		return getHeap().getArrayList().size();
	}
	public String toString()
	{
		return heap.toString();
		
	}
	

}
