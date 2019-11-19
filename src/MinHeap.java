import java.util.Collections;

public class MinHeap{
	
	
	public int maxsize = 2000;
	public int heapsize = 0;
	int parent(int i) {
		return (i-1)/2;
	}

	int left(int i) {
		return (2*i + 1);
	}

	int right(int i) {
		return (2*i + 2);
	}

	public void printHeap(Building[] building) {
		for(int i = 0; i < heapsize; i++) {
			System.out.println("bn " + building[i].getBuilding_nums() + " et " + building[i].getExecution_time() + " tt " + building[i].getTotal_time());
		}
	}

	
	void heapify(Building[] building, int n, int i) 
	{ 
		int smallest = i; // Initialize largest as root 
		int l = 2*i + 1; // left = 2*i + 1 
		int r = 2*i + 2; // right = 2*i + 2 

		
		if (r < n && building[r].getExecution_time() == building[l].getExecution_time() && 
				building[r].getExecution_time() == building[i].getExecution_time()) {
			if(building[r].getBuilding_nums()<building[l].getBuilding_nums() &&
					building[r].getBuilding_nums() < building[i].getBuilding_nums()) {
				smallest=r;
			}
			else if(building[l].getBuilding_nums() < building[r].getBuilding_nums() &&
					building[l].getBuilding_nums() < building[i].getBuilding_nums()){
				smallest=l;
			}
			else {
				smallest = i; 
			}

		}
		
		else if(r < n && building[r].getExecution_time() == building[i].getExecution_time()) {
			if(building[r].getBuilding_nums() < building[i].getBuilding_nums()) {
				smallest = r;
			}
			else {
				smallest = i;
			}
		}
		
		else if(l < n && building[l].getExecution_time() == building[i].getExecution_time()) {
			if(building[l].getBuilding_nums() < building[i].getBuilding_nums()) {
				smallest = l;
			}
			else {
				
				smallest = i;
			}
		}
		
		
		// If left child is larger than root 
				if (l < n && building[l].getExecution_time() < building[smallest].getExecution_time()) 
					smallest = l; 

				// If right child is larger than largest so far 
				if (r < n && building[r].getExecution_time() < building[smallest].getExecution_time()) 
					smallest = r; 
		
		// If largest is not root 
		if (smallest != i) 
		{ 
			Building temp = building[i];
			building[i] = building[smallest];
			building[smallest] = temp;	  
			// Recursively heapify the affected sub-tree 
			heapify(building, n, smallest); 
		} 
	} 
	
	
/*
	public int deleteRoot(Building[] building) {
		if(heapsize == 1) {
			//System.out.println("Deleted Element = " + building[0].getBuilding_nums() + " Global Counter = " + rf.globalCounter);
			heapsize = 0;
			return building[0].getExecution_time();
		}
		var lastElement = building[heapsize - 1];
		//System.out.println("Deleted Element = " + building[0].getBuilding_nums() + " Global Counter = " + rf.globalCounter);
		building[0] = lastElement;
		heapsize = heapsize - 1; 
		heapify(building, heapsize, 0);
		return 1;
	}
	 */

	public void insertKey(Building[] building, int building_nums, int total_time) {


		if (heapsize >= maxsize) { 
			return; 
		} 

		heapsize++;


		int lastHeap = heapsize - 1;
		building[lastHeap]= new Building();
		building[lastHeap].setBuilding_nums(building_nums);
		building[lastHeap].setExecution_time(0);
		building[lastHeap].setTotal_time(total_time);		


		while (lastHeap != 0 && (building[parent(lastHeap)].getExecution_time() >= building[lastHeap].getExecution_time())) {
			Building temp = building[lastHeap];
			building[lastHeap] = building[parent(lastHeap)];
			building[parent(lastHeap)] = temp; 

			if(building[parent(lastHeap)].getExecution_time() ==  building[lastHeap].getExecution_time()) {
				if(building[parent(lastHeap)].getBuilding_nums() > building[lastHeap].getBuilding_nums()) { 
					Building temp2 = building[lastHeap];
					building[lastHeap] = building[parent(lastHeap)]; 
					building[parent(lastHeap)] =  temp2; 
					lastHeap = parent(lastHeap); 
				} 
				else { 
					lastHeap = parent(lastHeap);
				}
			} 

		}

	}

}


