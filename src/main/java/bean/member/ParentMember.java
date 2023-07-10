package bean.member;

public class ParentMember {
	protected String memberid;
	protected int numberofchild;
	
	public ParentMember() {}
	
	public ParentMember(String memberid, int numberofchild) {
		super();
		this.memberid = memberid;
		this.numberofchild = numberofchild;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getNumberofchild() {
		return numberofchild;
	}

	public void setNumberofchild(int numberofchild) {
		this.numberofchild = numberofchild;
	}

}
