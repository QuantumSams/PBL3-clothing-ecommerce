package Model.DAL.Specification.Implements.Nguoi_dung;

import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class FindNguoiDungByMailOrNumber implements Specification<Nguoi_dung>{

	private String email;
	private String so_dien_thoai;
	private String password;
	private Object[] objects;
	
	public FindNguoiDungByMailOrNumber(String email, String so_dien_thoai, String password) {
		this.email = email;
		this.so_dien_thoai = so_dien_thoai;
		this.password = password;
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, ");
		query.append(" so_dien_thoai, email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_dang_nhap");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");
		query.append(" WHERE (so_dien_thoai = ? OR email = ?) AND mat_khau = ?");
		
		setParameters(so_dien_thoai, email, password);
		
		return query.toString();
	}

	@Override
	public Object[] getParameters() {
		return objects;
	}

	@Override
	public void setParameters(Object... objects) {
		this.objects = objects;
	}

}
