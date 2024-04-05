package Entity.Nguoi_Dung;

import java.sql.Date;

public class Chu_cua_hang extends Nguoi_dung{

	
	public Chu_cua_hang(int id_nguoi_dung, String ho_ten, boolean gioi_tinh, Date ngay_sinhDate, String dia_chi,
			String anh_dai_dien, String so_dien_thoai, String email, String phan_quyen_nguoi_dung) {
		super(id_nguoi_dung, ho_ten, gioi_tinh, ngay_sinhDate, dia_chi, anh_dai_dien, so_dien_thoai, email,
				phan_quyen_nguoi_dung);
	}

	public void them_nhan_vien(Nhan_vien nhan_vien) {
		
	}
	
	public void sua_thong_tin_nhan_vien(int id_nhan_vien) {
		
	}
	
	public void xoa_nhan_vien(int id_nhan_vien) {
		
	}
	
	public void them_danh_muc_nhan_vien() {
		
	}
	
	@Override
	public void cap_nhat_thong_tin() {
		
	}

	@Override
	public void xoa_thong_tin() {
		
	}

	@Override
	public void them_thong_tin() {
		
	}

}
