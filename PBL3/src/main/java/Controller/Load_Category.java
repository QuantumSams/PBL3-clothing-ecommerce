package Controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Model.BLL.Service.Danh_Muc.Danh_muc_Service;
import Model.DAL.DAO.implemet.Danh_muc_DAO;
import Model.DTO.San_Pham.Danh_muc_san_pham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/load_category"})
public class Load_Category extends HttpServlet{
	private static final long serialVersionUID = 4L;

	Danh_muc_Service danh_muc_Service = new Danh_muc_Service(new Danh_muc_DAO());
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Danh_muc_san_pham> list = danh_muc_Service.load_category_by_json(req, resp);
		
		ObjectMapper mapper = new ObjectMapper();
	    String json = mapper.writeValueAsString(list);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}
}
