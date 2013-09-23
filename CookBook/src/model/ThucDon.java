package model;

import java.util.ArrayList;

/**
 * @author Van_Thi
 *
 */
public class ThucDon {
	private int thid;
	private String ten;
	private String ghiChu;
	private String ngayTao;
	private String ngayThucHien;
	private ArrayList<MonAn> dsMonAn;
	
	public ThucDon(int thid, String ten, String ghiChu, String ngayTao,
			String ngayThucHien, ArrayList<MonAn> ds) {
		super();
		this.thid = thid;
		this.ten = ten;
		this.ghiChu = ghiChu;
		this.ngayTao = ngayTao;
		this.ngayThucHien = ngayThucHien;
		this.dsMonAn =ds;
	}

	public ThucDon() {
		this(0,"","","","",new ArrayList());
	}

	public int getThid() {
		return thid;
	}

	public void setThid(int thid) {
		this.thid = thid;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	
	public ArrayList<MonAn> getDsMonAn() {
		return dsMonAn;
	}

	public void setDsMonAn(ArrayList<MonAn> dsMonAn) {
		this.dsMonAn = dsMonAn;
	}

	@Override
	public String toString() {
		return "ThucDon [thid=" + thid + ", ten=" + ten + ", ghiChu=" + ghiChu
				+ ", ngayTao=" + ngayTao + ", ngayThucHien=" + ngayThucHien
				+ "]";
	}
	
	
	
	
}
