package in.co.rays.ctl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;


@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	int rollNo = Integer.parseInt(req.getParameter("rollNo"));
	int physics = Integer.parseInt(req.getParameter("physics"));
	int chemistry = Integer.parseInt(req.getParameter("chemistry"));
	int maths = Integer.parseInt(req.getParameter("maths"));		
			
	MarksheetBean bean = new MarksheetBean();
	bean.setName(name);
	bean.setRollNo(rollNo);
	bean.setPhysics(physics);
	bean.setChemistry(chemistry);
	bean.setMaths(maths);
	 MarksheetModel model = new MarksheetModel();
	 try {
		model.testAdd(bean);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 resp.sendRedirect("Marksheet.jsp");
	}
}
