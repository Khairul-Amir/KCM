package bean.fee;

public class Fee {
	protected String feeid;
	protected double feeamount;
	protected String feedesc;
	protected String feetype;
	protected String adminid;
	
	public Fee() {}
	
	public Fee(String feeid, double feeamount, String feedesc, String feetype, String adminid) {
		super();
		this.feeid = feeid;
		this.feeamount = feeamount;
		this.feedesc = feedesc;
		this.feetype = feetype;
		this.adminid = adminid;		
	}
	
	public Fee(double feeamount, String feedesc, String feetype, String adminid) {
		super();
		this.feeamount = feeamount;
		this.feedesc = feedesc;
		this.feetype = feetype;
		this.adminid = adminid;		
	}
	
	public String getFeeid() {
		return feeid;
	}
	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}
	public double getFeeamount() {
		return feeamount;
	}
	public void setFeeamount(double feeamount) {
		this.feeamount = feeamount;
	}
	public String getFeedesc() {
		return feedesc;
	}
	public void setFeedesc(String feedesc) {
		this.feedesc = feedesc;
	}
	public String getFeetype() {
		return feetype;
	}
	public void setFeetype(String feetype) {
		this.feetype = feetype;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

}
