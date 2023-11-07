package controller;

import java.util.List;

import entity.WorkSlot;


public class ViewWorkslotsController {
	private WorkSlot workSlot;
	
	public ViewWorkslotsController(WorkSlot workSlot) {
		this.workSlot = workSlot;
	}
	
	public List<WorkSlot> viewWorkSlot(){
		return workSlot.view();
	}

}
