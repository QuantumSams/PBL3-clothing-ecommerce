package Entity.Nguoi_Dung;

import java.sql.Date;

public class Nhan_vien extends Nguoi_dung{

	public Nhan_vien(int id_nguoi_dung, String ho_ten, boolean gioi_tinh, Date ngay_sinhDate, String dia_chi,
			String anh_dai_dien, String so_dien_thoai, String email, String phan_quyen_nguoi_dung) {
		super(id_nguoi_dung, ho_ten, gioi_tinh, ngay_sinhDate, dia_chi, anh_dai_dien, so_dien_thoai, email,
				phan_quyen_nguoi_dung);
	}

	public void xac_nhan_don_hang(int id_hoa_don) {
		
	}

	public void huy_hoa_don(int id_hoa_don) {
		
	}

}
