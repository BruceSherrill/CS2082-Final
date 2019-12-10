

public class linkedList {
	
	//cursor varibles to keep track of head and tail of linkedlist
	private linkNode head = null;
	private linkNode tail = null;
	
	/** Action performed: Adds a new node to list
	 * Parameters: A String containing node data
	 * Precondition: None
	 * PostCondition: A new node will be added 
	 * Throws: None 
	 */
	public void add(String data) {
		
		if (tail == null) {
			head = new linkNode(data, null);
			tail = head;
		} else {
			linkNode newNode = new linkNode(data, null);
			tail.setLink(newNode);
			tail = newNode;
		}
		
	}
	
	/** Action performed: Will remove a node from linkedlist
	 * Parameters: A String containing the target data of node you want gone
	 * Precondition: None
	 * PostCondition: A node will be removed from linked list
	 * Throws: None
	 */
	public boolean remove(String target) {
		linkNode cursor;
		linkNode precursor;
		
		for(precursor = null, cursor = head; cursor != null;
				precursor = cursor, cursor = cursor.getLink()) {
			
			if (cursor.getData().equals(target)) {
				if (precursor == null) {
					head = head.getLink();
				} else {
					precursor.setLink(cursor.getLink());
				}
				return true;
			}
		}
		return false;
	}
	
	/** Action performed: Tests for duplicate of node trying to be added to list
	 * Parameters: None
	 * Precondition: None
	 * PostCondition: No same nodes will exist in linkedlist
	 * Throws: None
	 */
	public boolean doublesTester() {
		linkNode sub = head;
		
		while (sub.getLink() != null)  
	    {  
	        // Starting from the next node  
	        linkNode ptr = sub.getLink();  
	        while (ptr != null)  
	        {  
	            // If some duplicate node is found  
	            if (sub.getData().equalsIgnoreCase(ptr.getData()))  
	            {  
	                return true;   
	            }  
	            ptr = ptr.getLink();  
	        }  
	        sub = sub.getLink();  
	    } 
		return false;
	}
	
	//Basic to String method
	@Override
	public String toString() {
		
		String listInfo = "{ ";
		linkNode cursor = head;
		
		while (cursor != null) {
			listInfo += cursor.getData() + ((cursor.getLink() != null) ? " -> " : "");
			cursor = cursor.getLink();
		}
		
		listInfo += " }";
		
		return listInfo;
	}
	
}

