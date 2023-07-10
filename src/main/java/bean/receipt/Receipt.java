package bean.receipt;

import java.sql.Date;

public class Receipt {
	protected String receiptid;
	protected String memberid;
	protected String feeid;
	protected Date receiptdate;
	protected String receiptstatus;
	protected double receiptamount;
	
	public Receipt() {}
	
	public Receipt(String receiptid, String memberid, String feeid, Date receiptdate, String receiptstatus, Double receiptamount) {
		super();
		this.receiptid = receiptid;
		this.memberid = memberid;
		this.feeid = feeid;
		this.receiptdate = receiptdate;
		this.receiptstatus = receiptstatus;
		this.receiptamount = receiptamount;
	}
	
	public Receipt(String memberid, String feeid, String receiptstatus, Double receiptamount) {
		super();
		this.memberid = memberid;
		this.feeid = feeid;
		this.receiptstatus = receiptstatus;
		this.receiptamount = receiptamount;
	}
	
	public Receipt(String memberid, String feeid, Date receiptdate, String receiptstatus, Double receiptamount) {
		super();
		this.memberid = memberid;
		this.feeid = feeid;
		this.receiptdate = receiptdate;
		this.receiptstatus = receiptstatus;
		this.receiptamount = receiptamount;
	}
	
	public String getReceiptid() {
		return receiptid;
	}
	public void setReceiptid(String receiptid) {
		this.receiptid = receiptid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getFeeid() {
		return feeid;
	}
	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}
	public Date getReceiptdate() {
		return receiptdate;
	}
	public void setReceiptdate(Date receiptdate) {
		this.receiptdate = receiptdate;
	}
	public String getReceiptstatus() {
		return receiptstatus;
	}
	public void setReceiptstatus(String receiptstatus) {
		this.receiptstatus = receiptstatus;
	}
	public double getReceiptamount() {
		return receiptamount;
	}
	public void setReceiptamount(double receiptamount) {
		this.receiptamount = receiptamount;
	}

}
