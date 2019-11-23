
public class Main {
	
	
	public static void main(String[] args) {
		
		
		long startTime = System.nanoTime();

		// code

		
		ReadFile readFile = new ReadFile();
		
		
	//	building[0] = new Building();
		
	//	building[0].setBuilding_nums(5);
		
	//	System.out.println(building[0].getBuilding_nums());
		
		readFile.openFile();
		readFile.readFile();
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		readFile.closeFile();
		
	}

}
