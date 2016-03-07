import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class BinaryHeapATest 
{
	BinaryHeapA<Integer> heap;
	ArrayList<Integer> arrayList;
	
	@Test
	public void constructor()
	{
		ArrayList<Integer> arrayList= new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		BinaryHeapA<Integer> heap= new BinaryHeapA<Integer>(arrayList);
		heap.getArrayList().equals(arrayList);
		assertEquals("The following should evaluate to true",true, heap.getArrayList().equals(arrayList));
	}
	
	@Test
	public void setArray()
	{
		ArrayList<Integer> arrayList= new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		BinaryHeapA<Integer> heap= new BinaryHeapA<Integer>();
		heap.setArray(arrayList);
		assertEquals("The following should evaluate to true",true, heap.getArrayList().equals(arrayList));
	}
	
	@Test
	public void getArray()
	{
		ArrayList<Integer> arrayList= new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		BinaryHeapA<Integer> heap= new BinaryHeapA<Integer>(arrayList);
		assertEquals("The following should be evaluated to true",true,heap.getArrayList().equals(arrayList));
	}
	
	@Before
	public void createArrayList()
	{
	
		arrayList= new ArrayList<Integer>();
		arrayList.add(16);
		arrayList.add(4);
		arrayList.add(10);
		arrayList.add(14);
		arrayList.add(7);
		arrayList.add(9);
		arrayList.add(3);
		arrayList.add(2);
		arrayList.add(8);
		arrayList.add(1);
		heap= new BinaryHeapA<Integer>(arrayList);
	}
	
	@Test
	public void getLeftChild()
	{
		//get left child when the left child exists
		assertEquals("The left child is at index 2 in the heap",2,heap.leftChild(1));
		//get left child when the left child does not exist
		assertEquals("We should get -1",-1,heap.leftChild(10));
	}
	
	@Test
	public void getRightChild()
	{
		//get right child when the right child exists
		assertEquals("The right child is at index 3 in the heap",3,heap.rightChild(1));
		//get right child when the right child doesn't exist
		assertEquals("We should get -1 because the right child does not exist",-1,heap.rightChild(5));
	}
	
	@Test
	public void retrieveFromArray()
	{
		//retrieve the value from the array, the value actually exists in the array
		heap.retrieveFromArray(1);
		assertEquals("The following statement should be evaluated to true",true,heap.retrieveFromArray(1).equals(16));
		//retrieve a value from the array when the index given is invalid
		assertEquals("We should get null",null,heap.retrieveFromArray(0));
		assertEquals("We should also get null",null,heap.retrieveFromArray(arrayList.size()+1));
	}
	
	@Test
	public void swapValid()
	{
		//when swapping with two valid indexes in the heap
		heap.swap(1,2);
		assertEquals("The following statement should evaluate to true",true,heap.toString().equals("[4, 16, 10, 14, 7, 9, 3, 2, 8, 1]"));
	}
	@Test
	public void swapInvalid()
	{
		//when swapping with an invalid index in the heap
		heap.swap(1, arrayList.size()+1);
		assertEquals("The heap should not be changed",true,heap.toString().equals(arrayList.toString()));
	}
	@Test
	public void findMaxChild()
	{
		//find the max child when the node actually has a max child, this method should return to us the index of that max child
		//purely working with heap indexes here
		assertEquals("We should get the index of the max child",4,heap.findMaxChild(2));
		
		//when it has no max child, we should get -1
		assertEquals("We should get -1",-1, heap.findMaxChild(1));
		
		//when the node only has one child and that child is not greater than the parent, we should get -1
		assertEquals("We should get -1",-1,heap.findMaxChild(5));
		//when the node has no children we should also get -1
		assertEquals("We should still get -1",-1,heap.findMaxChild(6));
	}
	
	@Test
	public void inBounds()
	{
		//returns true if the index is within bounds
		//we are purely working with heap indexes people
		assertEquals("This should evaluate to true",true,heap.inBounds(1));
		//when it isn't in bounds
		assertEquals("This should evaluate to false",false,heap.inBounds(0));
		assertEquals("This should also evaluate to false",false,heap.inBounds(arrayList.size()+1));
	}
	
	//then we move on to testing more insane stuff
	@Test
	public void maxHeapifyValid()
	{
		//max heapify on a valid index
		heap.maxHeapify(arrayList,2);
		assertEquals("This should evaluate to true",true,heap.toString().equals("[16, 14, 10, 8, 7, 9, 3, 2, 4, 1]"));
	}
	
	@Test
	public void maxHeapidyInvalid()
	{
		//max heapify on an invalid index
		heap.maxHeapify(arrayList,0);
		assertEquals("Nothing should be changed",true,heap.getArrayList().equals(arrayList));
	}
	
	
	@Test
	public void constructMaxHeap()
	{
		heap.constructMaxHeap(arrayList);
		assertEquals("Now it should be a max heap",true,heap.toString().equals("[16, 14, 10, 8, 7, 9, 3, 2, 4, 1]"));
	}
	
	@Test
	public void insertNonEmpty()
	{
		//insert into a non empty arraylist
		heap.insert(20);
		assertEquals("The following should be evaluated to true",true,heap.toString().equals("[20, 16, 10, 14, 7, 9, 3, 2, 8, 1, 4]"));
	}
	
	@Test
	public void insertEmpty()
	{
		BinaryHeapA<Integer> emptyHeap= new BinaryHeapA<Integer>();
		emptyHeap.insert(10);
		assertEquals("the following should be evaluated to true",true,emptyHeap.toString().equals("[10]"));
	}
	
	@Test
	public void get()
	{
		heap.constructMaxHeap(arrayList);
		//get the largest element out of a non empty heap
		assertEquals("Should get us the largest element",true,heap.get().equals(16));
		//check the arrayList
		assertEquals("Should evaluate to true",true,heap.getArrayList().toString().equals("[14, 8, 10, 4, 7, 9, 3, 2, 1]"));
		
		//when we call get() on an emptyHeap, should get us null
		BinaryHeapA<Integer> emptyHeap= new BinaryHeapA<Integer>();
		assertEquals("Should return null",null, emptyHeap.get());
		
	}
	
	@Test
	public void heapSort()
	{
		heap.constructMaxHeap(arrayList);
		heap.heapSort();
		assertEquals("Should return true",true,heap.getArrayList().toString().equals("[1, 2, 3, 4, 7, 8, 9, 10, 14, 16]"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
