package bean.member;

public class Child {
	protected String childid;
	protected String childname;
	protected int childage;
	protected String childcategory;
	protected String memberid;
	
	public Child() {}
	
	public Child(String childid, String childname, int childage, String childcategory, String memberid) {
		super();
		this.childid = childid;
		this.childname = childname;
		this.childage = childage;
		this.childcategory = childcategory;
		this.memberid = memberid;
	}
	
	public Child(String childname, int childage, String childcategory, String memberid) {
		super();
		this.childname = childname;
		this.childage = childage;
		this.childcategory = childcategory;
		this.memberid = memberid;
	}

	public String getChildid() {
		return childid;
	}

	public void setChildid(String childid) {
		this.childid = childid;
	}

	public String getChildname() {
		return childname;
	}

	public void setChildname(String childname) {
		this.childname = childname;
	}

	public int getChildage() {
		return childage;
	}

	public void setChildage(int childage) {
		this.childage = childage;
	}

	public String getChildcategory() {
		return childcategory;
	}

	public void setChildcategory(String childcategory) {
		this.childcategory = childcategory;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

}
