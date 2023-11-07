package controller;

import entity.WorkSlot;

public class CreateWorkSlotController {

	private WorkSlot workSlot;
	//constructor
    public CreateWorkSlotController(WorkSlot workSlot) {
        this.workSlot = workSlot;
    }
     
	public boolean createWorkSlot(WorkSlot workSlot) {

        boolean created = workSlot.createWorkSlot(workSlot);
        return created;

    }
}