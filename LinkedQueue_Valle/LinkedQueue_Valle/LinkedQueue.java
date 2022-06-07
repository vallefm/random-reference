public class LinkedQueue<T> {
	
	public class Node<E>{ //we will create our Node objects in this class.
		private E data; //this encapsulates the value of the Node
		private Node<E> link; //this is the link or pathway to the next node.
		
		public Node(E data, Node<E> link) {
			this.data = data;
			this.link = null;
		}
		public E getData() {
			return data;
		}
		public Node<E> getLink() {
			return link;
		}
		
		public void setData(E data) {
			this.data = data;
		}
		
		public void setLink(Node<E> link) {
			this.link = link;
		}
	}
	
	
	private Node<T> headNode; //this will be the first node in my linked Queue
	private Node<T> tailNode; //this will be the last node in my linked Queue
	
	public LinkedQueue() {
		headNode = tailNode = null;
	}
		
		public Node<T> getHead() { //method to get the first node in the Queue
			return headNode;
		}
		public void setHead(Node<T> headNode) { //method to change the value field of the first node in the queue
			this.headNode = headNode;
		}
		public boolean isEmpty() { //method to check whether the queue is empty
			return headNode ==  null;
		}
		public void dequeue() { //this will delete the first node in our queue and shift up the next head node of the queue if the queue is not empty.
			if(isEmpty()) { //checks if our queue is empty
				System.out.println("Dequeue - failed (queue empty).");
			}
			else{ //queue is not empty. we will remove the first node in the queue and shift over the  next node to become the head of the queue.
				System.out.println("Dequeue() = " + headNode.getData());
				if(headNode.getLink() != null) {
					headNode = headNode.getLink(); //changes the value of the head node to the next node in the queue.
				}
				else {
					headNode = null; //if the node that we Dequeued was the head node, we can just reset the head node to null.
				}
				
			}	
		}
		
		public void enqueue(T data) { //this will add a new node into our queue with the value of the data variable.
			if(isEmpty()) { //we will set the value of data to the head node and the link to null if the queue is null to begin with
				headNode = new Node<T>(data, null);
				tailNode = headNode;
				System.out.println("Enqueue(" + data + ")");
			}
			else { //if there is already a head node in the queue, then we will change the link of our tail node (the last node in the queue) from null to a new node with the value of data and it's link to null.
				Node<T> newNode = new Node<T>(data, null);
				tailNode.setLink(newNode);
				System.out.println("Enqueue(" + data + ")");
				tailNode = newNode;
			}
		}
}