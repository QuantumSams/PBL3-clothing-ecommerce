package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.AbstractDao;
import Entity.San_Pham.San_pham;
import Mapper.San_Pham.San_pham_Mapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoadProducts", urlPatterns = {"/LoadProducts"})

public class LoadProducts extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String query = "select from * from san_pham";
		List<San_pham> list_san_pham = new AbstractDao().query(query, new San_pham_Mapper());
		
		for(San_pham sp : list_san_pham) {
			System.out.println(sp.toString());
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
