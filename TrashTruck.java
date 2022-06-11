import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;
/*
 * Create the outer class TrashTruck that acts as our Thread. It has the printAll() method where we 
 * should get the overall count of each TrashType collected from the TrashTrucks.
 */
public class TrashTruck extends Thread{
	LinkedQueue<TrashType> collection;
	LinkedQueue<PrivateTruckData> TruckData = new LinkedQueue<PrivateTruckData>();;
	TrashTruck truck;
	PrivateTruckData pvtData = new PrivateTruckData();
	int[] overallArray = new int[TrashType.values().length];
	private ReentrantLock collectTrashLock = new ReentrantLock();
	private ReentrantLock removeTrashLock = new ReentrantLock();
	private ReentrantLock trDataLock = new ReentrantLock();
	
	public TrashTruck(LinkedQueue<TrashType> collection) {
		this.collection = collection;
	}
	/*
     * Create the nested class PrivateTruckData that holds an integer array someArray[TrashType.length] 
     * to hold the count of each type of trash collected. Methods include print(), collectTrash()
     * where we increment someArray[i] where i is the corresponding index of the TrashType collected.
     */
	class PrivateTruckData {
	static //	TrashTruckInstance myTruck = new TrashTruckInstance();
		TrashTruck truck;
		int[] someArray = new int[TrashType.values().length];
		
		public PrivateTruckData() {
		}
		
				
		public void print() {
			for(int i = 0; i < someArray.length; i++) {
				System.out.println("Type = " + TrashType.values()[i]+  " || collected = " + someArray[i]); 
			}
			//System.out.println(myTruck.get());
		}
		
		public void collectTrash(TrashType someTrash) {
			int i = 0;
			collectTrashLock.lock();
			try {
			for(TrashType trashX: TrashType.values() ) {
				if(trashX.equals(someTrash)) {
					someArray[i] = someArray[i] + 1;
				}
				i++;
			}
			} finally {
				collectTrashLock.unlock();
			}
		}
		
		
		public int[] getCounts() {
			return someArray;
			}
		
		
			private static final ThreadLocal<PrivateTruckData> threadLocalValue = new ThreadLocal<PrivateTruckData>() {
				@Override
				protected PrivateTruckData initialValue() {
					return truck.new PrivateTruckData();
				}
				
				public PrivateTruckData get() {
					return threadLocalValue.get();
				}
			};
		
		
		
	}
	
	
	
	
	public void printAll() {
//		while(!TruckData.isEmpty()) {
//			TruckData.getHead().getData().print();
//			for(int i = 0; i < TruckData.getHead().getData().getCounts().length; i++) {
//				overallArray[i] = overallArray[i] + TruckData.getHead().getData().getCounts()[i];
//			}
//			TruckData.dequeue();
//		}
//		System.out.println("\nOverall Totals");
//		for(int i = 0; i < overallArray.length; i++) {
//			System.out.println("Type = " + TrashType.values()[i]+  " || collected = " + overallArray[i]); 
//		}
				
	}
	@Override
	public void run() {
	
		// TODO Auto-generated method stub
		//lock this process of collectTrash and dequeue
		removeTrashLock.lock();
		try {
			while(!collection.isEmpty()) {
			
			pvtData.collectTrash(collection.getHead().getData());
			collection.dequeue();
			}
			}finally {
				removeTrashLock.unlock();
			
		}
		trDataLock.lock();
		try {
			System.out.println("Truck " + Thread.currentThread().getName() + ":");
		pvtData.print();
		TruckData.enqueue(pvtData);
		}finally{
			trDataLock.unlock();
		}
		
	}
}
