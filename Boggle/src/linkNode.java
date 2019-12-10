
public class linkNode {

	 
	/** Action performed:
		 * Parameters: 
		 * Precondition: 
		 * PostCondition:
		 * Throws: None
		 */
	
	//Basic node varibles
	private String data;
	private linkNode link;
	
	/** Action perform: Overriden Constructor that creates a node
	 * Parameters: A String and a linkNode
	 * Precondition: None
	 * PostCondition: Newly created linkNode object made
	 * Throws: None
	 */
	public linkNode(String data, linkNode link) {
		this.data = data;
		this.link = link;
	}
	
	//Getters and setters
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public linkNode getLink() {
		return link;
	}
	
	public void setLink(linkNode link) {
		this.link = link;
	}
	
	/** Action performed: Will add a node after previous one in list
	 * Parameters: A String containing node data 
	 * Precondition: None
	 * PostCondition: A new node is added to link list
	 * Throws: None
	 */
	public void addNodeAfter(String data) {
		link = new linkNode(data, link);
	}
	
	/** Action performed: Will remove a node from link list
	 * Parameters: None
	 * Precondition: None
	 * PostCondition: A node will be removed from the link list
	 * Throws: None
	 */
	public void removeNodeAfter() {
		link = link.link;
	}
	
}
