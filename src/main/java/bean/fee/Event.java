package bean.fee;

public class Event {
	protected String feeid;
	protected String eventid;
	protected String eventdescription;
	
	public Event() {}
	
	public Event(String feeid, String eventid, String eventdescription) {
		super();
		this.feeid = feeid;
		this.eventid = eventid;
		this.eventdescription = eventdescription;
	}

	public String getFeeid() {
		return feeid;
	}

	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getEventdescription() {
		return eventdescription;
	}

	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}

}
