package model;

public class Loai {
	private int lid;
	private String ten;
	private String anh;
	private int mlid;
	public Loai(int lid, String ten, String pathAnh, int mlid) {
		super();
		this.lid = lid;
		this.ten = ten;
		this.anh = pathAnh;
		this.mlid = mlid;
	}
	public Loai() {
		this(0,"","",0);
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
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
	public void setAnh(String pathAnh) {
		this.anh = pathAnh;
	}
	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	@Override
	public String toString() {
		return "Loai [lid=" + lid + ", ten=" + ten + ", pathAnh=" + anh
				+ ", mlid=" + mlid + "]";
	}
	
	
	
	
}
