package model;

/**
 * @author Van_Thi
 *
 */
public class MonAn {
	private int mid;
	private String ten;
	private int lid;
	private String anh;
	private String meoVat;
	private String nguyenLieu;
	private String cachLam;
	private int yeuthich;
	private int thid;
	public MonAn(int mid, String ten, int lid, String anh, String meoVat,
			String nguyenLieu, String cachLam, int yeuthich, int thid) {
		super();
		this.mid = mid;
		this.ten = ten;
		this.lid = lid;
		this.anh = anh;
		this.meoVat = meoVat;
		this.nguyenLieu = nguyenLieu;
		this.cachLam = cachLam;
		this.yeuthich = yeuthich;
		this.thid=thid;
	}
	public MonAn() {
		this(0, "", 0, "", "", "", "", 0,0);
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMeoVat() {
		return meoVat;
	}
	public void setMeoVat(String meoVat) {
		this.meoVat = meoVat;
	}
	public String getNguyenLieu() {
		return nguyenLieu;
	}
	public void setNguyenLieu(String nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}
	public String getCachLam() {
		return cachLam;
	}
	public void setCachLam(String cachLam) {
		this.cachLam = cachLam;
	}
	public int isYeuthich() {
		return yeuthich;
	}
	public void setYeuthich(int yeuthich) {
		this.yeuthich = yeuthich;
	}
	
	public int getThid() {
		return thid;
	}
	public void setThid(int thid) {
		this.thid = thid;
	}
	@Override
	public String toString() {
		return "MonAn [mid=" + mid + ", ten=" + ten + ", lid=" + lid + ", anh="
				+ anh + ", meoVat=" + meoVat + ", nguyenLieu=" + nguyenLieu
				+ ", cachLam=" + cachLam + ", yeuthich=" + yeuthich + "]";
	}
	
	
}
