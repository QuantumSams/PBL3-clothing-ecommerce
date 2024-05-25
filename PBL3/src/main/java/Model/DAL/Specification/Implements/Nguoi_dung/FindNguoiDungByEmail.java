package Model.DAL.Specification.Implements.Nguoi_dung;

import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class FindNguoiDungByEmail implements Specification<Nguoi_dung>{

	private String email;
	private Object[] objects;
	
	public FindNguoiDungByEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, ");
		query.append(" thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_nguoi_dung");
		query.append(" INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");
		query.append(" WHERE email = ?");
		
		setParameters(email);
		
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
