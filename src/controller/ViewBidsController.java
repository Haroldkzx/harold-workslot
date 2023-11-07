package controller;

import java.util.List;
import entity.Bid;

public class ViewBidsController {
	
	private Bid bid;
	
	public ViewBidsController(Bid bid) {
		this.bid = bid;
	}
	
	public List<Bid> viewBids(){
		return bid.view();
	}
	

}
