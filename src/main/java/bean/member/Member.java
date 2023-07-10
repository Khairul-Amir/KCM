package bean.member;

public class Member {
	protected String memberid;
	protected String membername;
	protected String memberaddress;
	protected int memberpostcode;
	protected String memberstate;
	protected String memberphoneno;
	protected String membergender;
	protected String membericno;
	protected String memberstatus;
	protected String memberpassword;
	protected String membertype;
	
	public Member() {}
	
	public Member(String membername, String memberaddress, int memberpostcode, String memberstate, String memberphoneno, String membergender, 
				String membericno, String memberstatus, String memberpassword, String membertype) {
		super();
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.memberpostcode = memberpostcode;
		this.memberstate = memberstate;
		this.memberphoneno = memberphoneno;
		this.membergender = membergender;
		this.membericno = membericno;
		this.memberstatus = memberstatus;
		this.memberpassword = memberpassword;
		this.membertype = membertype;
	}
	
	public Member(String memberid, String membername, String memberaddress, int memberpostcode, String memberstate, String memberphoneno, String membergender, 
			String membericno, String memberstatus, String memberpassword, String membertype) {
		super();
		this.memberid = memberid;
		this.membername = membername;
		this.memberaddress = memberaddress;
		this.memberpostcode = memberpostcode;
		this.memberstate = memberstate;
		this.memberphoneno = memberphoneno;
		this.membergender = membergender;
		this.membericno = membericno;
		this.memberstatus = memberstatus;
		this.memberpassword = memberpassword;
		this.membertype = membertype;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}

	public int getMemberpostcode() {
		return memberpostcode;
	}

	public void setMemberpostcode(int memberpostcode) {
		this.memberpostcode = memberpostcode;
	}

	public String getMemberstate() {
		return memberstate;
	}

	public void setMemberstate(String memberstate) {
		this.memberstate = memberstate;
	}

	public String getMemberphoneno() {
		return memberphoneno;
	}

	public void setMemberphoneno(String memberphoneno) {
		this.memberphoneno = memberphoneno;
	}

	public String getMembergender() {
		return membergender;
	}

	public void setMembergender(String membergender) {
		this.membergender = membergender;
	}

	public String getMembericno() {
		return membericno;
	}

	public void setMembericno(String membericno) {
		this.membericno = membericno;
	}

	public String getMemberstatus() {
		return memberstatus;
	}

	public void setMemberstatus(String memberstatus) {
		this.memberstatus = memberstatus;
	}

	public String getMemberpassword() {
		return memberpassword;
	}

	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	
	
}
