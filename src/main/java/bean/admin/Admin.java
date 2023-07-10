package bean.admin;

public class Admin {
	protected String adminid;
	protected String managerid;
	protected String adminname;
	protected String adminphoneno;
	
	public Admin() {}
	
	public Admin(String adminid, String managerid, String adminname, String adminphoneno) {
		super();
		this.adminid = adminid;
		this.managerid = managerid;
		this.adminname = adminname;
		this.adminphoneno = adminphoneno;
	}
	
	public Admin(String managerid, String adminname, String adminphoneno) {
		super();
		this.managerid = managerid;
		this.adminname = adminname;
		this.adminphoneno = adminphoneno;
	}
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminphoneno() {
		return adminphoneno;
	}
	public void setAdminphoneno(String adminphoneno) {
		this.adminphoneno = adminphoneno;
	}
	
	

}
