package Model.DAL.Specification.Implements.Nguoi_dung;

import Model.DAL.Specification.Specification;
import Model.DTO.Nguoi_Dung.Nguoi_dung;

public class FindNhanVienByName  implements Specification<Nguoi_dung>{

	private String name;
	private Object[] objects;
	
	public FindNhanVienByName(String name) {
		this.name = name;
	}
	
	@Override
	public String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append(" SELECT thong_tin_dang_nhap.id, ho_ten, gioi_tinh, ngay_sinh, dia_chi, anh_dai_dien,");
		query.append(" thong_tin_dang_nhap.so_dien_thoai, thong_tin_dang_nhap.email, phan_quyen_nguoi_dung.ten_phan_quyen");
		query.append(" FROM thong_tin_nguoi_dung");
		query.append(" INNER JOIN thong_tin_dang_nhap ON thong_tin_nguoi_dung.id = thong_tin_dang_nhap.id");
		query.append(" INNER JOIN phan_quyen_nguoi_dung ON phan_quyen_nguoi_dung.id = thong_tin_dang_nhap.id_phan_quyen_nguoi_dung");
		query.append(" WHERE id_phan_quyen_nguoi_dung = 2 AND ho_ten LIKE ?");
		
		String search = "%" + name + "%";
		setParameters(search);
		
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