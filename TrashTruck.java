
public class TrashTruck {
	public TrashTruck() {
		
	}
	class PrivateTruckData{
		Integer[] numTrashTypes = new Integer[5];
		public PrivateTruckData() {
		
		}
		
		public void print() {
			for(int i = 0; i < numTrashTypes.length(); i++) {
				System.out.println("Type = " + null +  " || collected = " + numTrashTypes[i]); //this is wrong, fix it.
			}
		}
	}
}
  