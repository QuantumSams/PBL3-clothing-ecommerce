package Model.BLL.Service.Doanh_Thu;

import java.util.List;

import Model.DAL.DAO.implemet.Doanh_thu_DAO;
import Model.DTO.Doanh_Thu.Doanh_thu;

public class Doanh_thu_Service {
	private Doanh_thu_DAO doanh_thu_DAO;
	
	public Doanh_thu_Service(Doanh_thu_DAO doanh_thu_DAO) {
		this.doanh_thu_DAO = doanh_thu_DAO;
	}
	
	public List<Doanh_thu> getDoanh_thu(){
		return doanh_thu_DAO.getALL();
	}
}
