package com.lti.mainservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;


public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custId=Integer.parseInt(request.getParameter("c_id"));
		PrintWriter out=response.getWriter();
		
		Customer c=new Customer();
		
		CustomerDao dao=new CustomerDao();
		c=dao.fetch(custId);
		
		HttpSession session=request.getSession();
		session.setAttribute("customer", c);
		
		response.sendRedirect("viewCustomerDetails.jsp");
		 
	}

}
