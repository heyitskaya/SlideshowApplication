
public interface PriorityQueue 
{
	
	public void insertIntoMap(Integer key,String value);
	
	public void insertIntoHeap(Integer key);
	
	
	public String maximum(); /** returns the String with the largest key**/
	
	public String extractMax(); /** returns and removes the string with the largest key**/
	
	public void increaseKey(Integer currKey, Integer newKey); /** changes the currKey to the newKey in both the map and heap **/
	
	public void insert(Integer i, String value);
	
	public BinaryHeapA<Integer> getHeap();
	
	public Integer getMaxPriority();
	
	
}
