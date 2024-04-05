package Entity.San_Pham;

import java.util.List;

import Entity.Thong_tin;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Chat_lieu;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Mau_sac;
import Entity.San_Pham.Thuoc_Tinh_San_Pham.Size;

public class Thong_tin_chi_tiet_san_pham implements Thong_tin{
	protected int id_thong_tin_chi_tiet_san_pham;
	protected int id_san_pham;
	protected int so_luong_trong_kho;
	protected Mau_sac mau_sac_san_pham;
	protected Size kich_thuoc_san_pham;
	protected Chat_lieu chat_lieu_san_pham;
	protected List<String> anh_chi_tiet;
	protected String thong_tin_chi_tiet;
	
	public Thong_tin_chi_tiet_san_pham(int id_thong_tin_chi_tiet_san_pham, int id_san_pham, int so_luong_trong_kho,
			Mau_sac mau_sac_san_pham, Size kich_thuoc_san_pham, Chat_lieu chat_lieu_san_pham, List<String> anh_chi_tiet,
			String thong_tin_chi_tiet) {
		super();
		this.id_thong_tin_chi_tiet_san_pham = id_thong_tin_chi_tiet_san_pham;
		this.id_san_pham = id_san_pham;
		this.so_luong_trong_kho = so_luong_trong_kho;
		this.mau_sac_san_pham = mau_sac_san_pham;
		this.kich_thuoc_san_pham = kich_thuoc_san_pham;
		this.chat_lieu_san_pham = chat_lieu_san_pham;
		this.anh_chi_tiet = anh_chi_tiet;
		this.thong_tin_chi_tiet = thong_tin_chi_tiet;
	}

	@Override
	public void them_thong_tin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cap_nhat_thong_tin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoa_thong_tin() {
		// TODO Auto-generated method stub
		
	}
	
	public San_pham Lay_thong_tin_chung_san_pham() {
		return null;
	}
}
