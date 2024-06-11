package Model.DAL.Specification.Implements.Nguoi_dung;

import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class FindAllNhanVien implements Specification<Nguoi_dung>{

	private Object[] objects;
	
	public FindAllNhanVien() {
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien, ");
		query.append(" so_dien_thoai, email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_dang_nhap");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");
		query.append(" WHERE id_phan_quyen_nguoi_dung = 2 ");
		
		return query.toString();
	}

	@Override
	public void setParameters(Object... objects) {
		this.objects = objects;
	}

	@Override
	public Object[] getParameters() {
		return objects;
	}

}