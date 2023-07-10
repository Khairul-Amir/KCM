package bean.member;

public class PublicMember {
	protected String memberid;
	protected String applicantstatus;
	
	public PublicMember(){}
	
	public PublicMember(String memberid, String applicantstatus){
		this.memberid = memberid;
		this.applicantstatus = applicantstatus;
	}
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getApplicantstatus() {
		return applicantstatus;
	}
	public void setApplicantstatus(String applicantstatus) {
		this.applicantstatus = applicantstatus;
	}

}
