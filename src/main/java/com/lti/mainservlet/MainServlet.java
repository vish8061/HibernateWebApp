package com.lti.mainservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MainServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		Customer c=new Customer();
		CustomerDao dao=new CustomerDao();
		 PrintWriter out=response.getWriter();
		if(method!=null) {
		if(method.equals("register")) {
		
		
		c.setName(request.getParameter("c_name"));
		c.setEmail(request.getParameter("c_email"));
		c.setCity(request.getParameter("c_city"));
		
		
		dao.add(c);
		}
		else if(method.equals("view")) {
			int custId=Integer.parseInt(request.getParameter("c_id"));
			 c=dao.fetch(custId);
			
			 out.println("Id "+c.getId());
			 out.println("Name "+c.getName());
			 out.println("City "+c.getCity());
			 out.println("Email "+c.getEmail());
			 
		}
		
		else  {
			List<Customer> list=dao.fetchAll();
			out.println("Details of all customers are:");
			for(int i=0;i<list.size();i++) {
				out.print(list.get(i).getId()+" ");
				out.print(list.get(i).getName()+" ");
				out.print(list.get(i).getEmail()+" ");
				out.print(list.get(i).getCity()+" ");
				out.println("");
			}
			
		}
		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
