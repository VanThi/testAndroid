package model;

public class MucLuc {
	private int mlid;
	private String ten;
	private String anh;
	public MucLuc(int mlid, String ten, String anh) {
		super();
		this.mlid = mlid;
		this.ten = ten;
		this.anh = anh;
	}
	public MucLuc() {
		this(0, "", "");
	}
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	@Override
	public String toString() {
		return "MucLuc [mlid=" + mlid + ", ten=" + ten + ", anh=" + anh + "]";
	}
	
	
	
}
