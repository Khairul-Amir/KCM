package bean.fee;

import java.sql.Date;

public class Membership {
	protected String feeid;
	protected Date startdate;
	protected Date enddate;
	
	public Membership() {}
	
	public Membership(String feeid, Date startdate, Date enddate) {
		super();
		this.feeid = feeid;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public String getFeeid() {
		return feeid;
	}

	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	

}
