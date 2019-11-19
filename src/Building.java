/* Building.java
 * Keenal Shah
 * This is a building Object class that stores the building number, execution time and the total time, 
 * 		can use this class to retrieve its instance variables.
 * */
public class Building {
	
	// instance variables
	private int building_nums = 0;
	private int execution_time = 0;
	private int total_time = 0;
	
	// default constructor
	public Building() {
		
	}
	
	// parameterized constructor
	public Building(int building_nums, int execution_time, int total_time) {
		super();
		this.building_nums = building_nums;
		this.execution_time = execution_time;
		this.total_time = total_time;
	}
	
	// getters and setters 
	public int getBuilding_nums() {
		return building_nums;
	}
	public void setBuilding_nums(int building_nums) {
		this.building_nums = building_nums;
	}
	public int getExecution_time() {
		return execution_time;
	}
	public void setExecution_time(int execution_time) {
		this.execution_time = execution_time;
	}
	public int getTotal_time() {
		return total_time;
	}
	public void setTotal_time(int total_time) {
		this.total_time = total_time;
	}

}
