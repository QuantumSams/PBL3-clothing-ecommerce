package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import DAO.DAO;
import Entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(urlPatterns = {"/fileuploadservlet"})

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)


public class Upload extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part filePath = req.getPart("file");
		HttpSession session = req.getSession();
		Account acc = (Account)session.getAttribute("acc");
		String id = Integer.toString(acc.getId());
		System.out.println("ID: " + id);
		try {
			DAO.UploadBLOB(filePath, id);
		} catch (ClassNotFoundException e) {
			System.out.println("loi");
		}
		
		session.setAttribute("id", id);
		req.getRequestDispatcher("userInfor.jsp").forward(req, resp);;
	}

}
