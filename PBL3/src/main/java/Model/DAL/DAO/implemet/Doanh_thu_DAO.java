package Model.DAL.DAO.implemet;

import java.util.List;

import Model.DAL.DAO.AbstractDao;
import Model.DAL.Mapper.Doanh_Thu.Doanh_thu_Mapper;
import Model.DAL.Mapper.San_Pham.Danh_muc_san_pham_Mapper;
import Model.DAL.Repository.Repository;
import Model.DAL.Specification.Specification;
import Model.DTO.Doanh_Thu.Doanh_thu;
import Model.DTO.San_Pham.Danh_muc_san_pham;

public class Doanh_thu_DAO  extends AbstractDao implements Repository<Doanh_thu>{

	@Override
	public void add(Doanh_thu t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Doanh_thu> getALL() {
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT SUM(chi_tiet_don_hang.so_luong) AS 'tong_san_pham',");
		query.append("COUNT(DISTINCT chi_tiet_don_hang.id_don_hang) AS 'tong_so_don',");
		query.append("SUM(chi_tiet_don_hang.so_luong * chi_tiet_don_hang.gia_tien) AS 'doanh_thu'");
		query.append("FROM chi_tiet_don_hang");
		
		return query(query.toString(), new Doanh_thu_Mapper());
	}

	@Override
	public List<Doanh_thu> findBySpacification(Specification<Doanh_thu> specification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Doanh_thu t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Doanh_thu t) {
		// TODO Auto-generated method stub
		
	}

}
