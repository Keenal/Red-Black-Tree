import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	MinHeap minheap = new MinHeap();
	Building[] building = new Building[2000];
	public static int globalCounter = 0;
	
	

	private Scanner scan;
	private Scanner scan1;
	public void openFile() {
		try {
			scan = new Scanner(new File("C:\\Users\\Keena\\eclipse-workspace\\ADS\\src\\input1.txt"));
			scan1 = new Scanner(new File("C:\\Users\\Keena\\eclipse-workspace\\ADS\\src\\input1.txt"));
		}
		catch(Exception e) {
			System.out.println("File could not be found.");
		}

	}

	public void constructing(Building[] building) {
		//building[0]= new Building();

	//	System.out.println(building[0].getTotal_time());
		if(building[0].getTotal_time() > 5) {
			building[0].setTotal_time(building[0].getTotal_time()-5);
			building[0].setExecution_time(building[0].getExecution_time()+5);

			globalCounter=globalCounter + 5;
			System.out.println("Global Counter from " + globalCounter);
	//		System.out.println(building[0].getTotal_time());

		}
		else {
			globalCounter=globalCounter+building[0].getTotal_time();
	//		System.out.println(building[0].getTotal_time());
			building[0].setExecution_time(building[0].getExecution_time()+building[0].getTotal_time());
			building[0].setTotal_time(0);
	//		System.out.println(building[0].getTotal_time());
			System.out.println("Global Counter from1 " + globalCounter);
			deleteRoot(building);


		}
	}
	
	
	public int deleteRoot(Building[] building) {
		if(minheap.heapsize == 1) {
			System.out.println("Deleted Element = " + building[0].getBuilding_nums() + " Global Counter = " + globalCounter);
			minheap.heapsize = 0;
			return building[0].getExecution_time();
		}
		var lastElement = building[minheap.heapsize - 1];
		System.out.println("Deleted Element = " + building[0].getBuilding_nums() + " Global Counter = " + globalCounter);
		building[0] = lastElement;
		minheap.heapsize = minheap.heapsize - 1; 
		minheap.heapify(building, minheap.heapsize, 0);
		return 1;
	}

		public void readFile() {
			int c = 0;
			int j = 1;
			int[] numOfDays = new int[2000];
			while(scan.hasNext()) {
				String line = scan.nextLine();
				int a = line.indexOf(':');
				numOfDays[c]= Integer.parseInt(line.substring(0, a));
				//System.out.println(numOfDays[c]);
				c++;
			}
			while(scan1.hasNext()) {
				String line = scan1.nextLine();
				if(line.contains("Insert")) {
					int leftP = line.indexOf('(');
					int rightP = line.indexOf(')');
					int comma = line.indexOf(',');
					int buildingNums = Integer.parseInt(line.substring(leftP+1, comma));
					int total_time = Integer.parseInt(line.substring(comma+1, rightP)); 
					minheap.insertKey(building, buildingNums, total_time);
					System.out.println("After insertion");
					minheap.printHeap(building);
					minheap.heapify(building, minheap.heapsize, 0);
					System.out.println("heapify");
					while(numOfDays[j]-globalCounter > 0 && j < c) {
						constructing(building);
						System.out.println("after constructing");
						minheap.printHeap(building);
						minheap.heapify(building, minheap.heapsize, 0);
						System.out.println("after heapify");
						minheap.printHeap(building);
					}
					j++;

					//	System.out.println("bn" + buildingNums + "tt" + total_time);

				}


				else {

					if(line.contains("Print") && line.contains(",")) {
						// RBT 
					}

				}
			}
			
			while(minheap.heapsize > 0) {
				constructing(building);
				System.out.println("after constructing");
				minheap.printHeap(building);
				minheap.heapify(building, minheap.heapsize, 0);
				System.out.println("after heapify");
				minheap.printHeap(building);
			}


			


		}

		public void closeFile() {
			scan.close();
		}

	}
