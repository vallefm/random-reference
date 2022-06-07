import java.lang.Math;
public class LinkedQueueDriver {
	public static <T> void main(String args[]){
		LinkedQueue<Integer> genericQueue = new LinkedQueue<Integer>(); //initializing our queue.
		for(int i = 0; i < 1000; i++) { //this will loop 1000 times and perform an Enqueue or Dequeue operation each time.
			double x = Math.random() * 100; //This randomly determines whether we will Enqueue or Dequeue (1/2)
			int someInt = (int)(Math.random() * 100); //This determines the value of the someInt variable that we will Enqueue if x is less than 50
			if(x < 50) {	//checks X value to see whether we will Enqueue or Dequeue (2/2)
				genericQueue.dequeue();
			}
			else{
				genericQueue.enqueue(someInt);
			}
		}
	}

}
