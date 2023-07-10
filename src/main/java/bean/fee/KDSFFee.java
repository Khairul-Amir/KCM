package bean.fee;

public class KDSFFee {
	protected String feeid;
	protected String category;
	
	public KDSFFee() {}
	
	public KDSFFee(String feeid, String category) {
		super();
		this.feeid = feeid;
		this.category = category;
	}

	public String getFeeid() {
		return feeid;
	}

	public void setFeeid(String feeid) {
		this.feeid = feeid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
