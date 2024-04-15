package Control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import javax.imageio.ImageIO;

import DAO.AbstractDao;
import Entity.Nguoi_Dung.Nguoi_dung;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})

@MultipartConfig(
		fileSizeThreshold = 512 * 512 * 10,
		maxFileSize = 1024 *  1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)


public class Upload extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		Part filePath = req.getPart("file");
//		String fileName = filePath.getSubmittedFileName();
//		
//		HttpSession session = req.getSession();
//		
//		for(Part part : req.getParts()) {
//			part.write("img/anh_nguoi_dung/"+ fileName);
//		}
//		Nguoi_dung acc = (Nguoi_dung)session.getAttribute("acc");
//		acc.setAnh_dai_dien("img/anh_nguoi_dung/"+fileName);
//		try {
//			DAO_Nguoi_dung.cap_nhat_tai_khoan(acc);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("img/anh_nguoi_dung/"+fileName);
////		/*
////		 * try { //DAO.UploadBLOB(filePath, id); } catch (ClassNotFoundException e) {
////		 * System.out.println("loi"); }
////		 */
////		
////		session.setAttribute("id", id);
//		
//		
//		req.getRequestDispatcher("userInfor.jsp").forward(req, resp);;
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String path = "D:\\Language Program\\Java_web\\PBL3-clothing-ecommerce\\PBL3\\src\\main\\webapp\\img\\anh_nguoi_dung\\";
		
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for(Part part : request.getParts()) {
        	part.write(path + fileName);
        	// sử dụng đường dẫn tương đối vì không bt làm sao để dùng đường dẫn tương đối
        }
        HttpSession session = request.getSession();
        String imagePath = "img/anh_nguoi_dung/" + fileName;
        String image = imagePath;
        session.setAttribute("anh", image);
        System.out.println(image);
        request.getRequestDispatcher("userInfor.jsp").forward(request, response);
    }
}
