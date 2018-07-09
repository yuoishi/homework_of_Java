package dto;

public class ExMana {
	private String date;
	private String sno;
	private String sname;
	private String qname;
	private String sorf;

	public ExMana(){}

	public ExMana(String date, String sno, String sname, String qname, String sorf) {
		this.date = date;
		this.sno = sno;
		this.sname = sname;
		this.qname = qname;
		this.sorf = sorf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getSorf() {
		return sorf;
	}

	public void setSorf(String sorf) {
		this.sorf = sorf;
	}
}