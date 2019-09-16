package susant;

import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import susant.DbConnector;

public class empdemo extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		
		HttpSession session=null;
		int flag=0;
		int forward=0;
		int output=0;
		String store=null;
		String value=null;
		String pt="yyyy-MM-dd";
		SimpleDateFormat sdf=new SimpleDateFormat(pt);
		String dispval1,dispval2,dispval3,dispval4,dispval5,dispval6;
		DbConnector dbc;
		try
		{
			session=req.getSession(true);
			PrintWriter out=res.getWriter();
			res.setContentType("text/html");
			
			String e_id=req.getParameter("emp_id");
			String name=req.getParameter("name");
			System.out.println(Long.parseLong(req.getParameter("mob")));
			long mob=Long.parseLong(req.getParameter("mob"));
		    String date=req.getParameter("join_date");
		    Date join_date=sdf.parse(date);
		    System.out.println(join_date);
		    Date Dob=sdf.parse(req.getParameter("Dob"));
		    System.out.println(Dob);
		    String degn=req.getParameter("degn");
		    
		    String checkAction=req.getParameter("sub");
		    dbc=new DbConnector(e_id,name,mob,join_date,Dob,degn);
		    
		    if(checkAction.equals("insert"))
		    	output=dbc.insert();
		    else if(checkAction.equals("delete"))
		    	output=dbc.delete();
		    else if(checkAction.equals("update"))
		    	output=dbc.update();
		    else if(checkAction.equals("display"))
		    {
		    	output=dbc.display();
		    	
		    	dispval1=dbc.getemp_id();
		    	dispval2=dbc.getname();
		    	dispval3=String.valueOf(dbc.getmob());
		    	dispval4=String.valueOf(dbc.getJoin_date());
		    	dispval5=String.valueOf(dbc.getDob());
		        dispval6=dbc.getdegn();
		        
		        req.setAttribute("emp_id",dispval1);
		        req.setAttribute("name",dispval2);
		        req.setAttribute("mob",dispval3);
		        req.setAttribute("join_date",dispval4);
		        req.setAttribute("Dob",dispval5);
		        req.setAttribute("degn",dispval6);
		    }
		    
		      value=String.valueOf(output);
		      req.setAttribute("msg",value);
		      RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		      rd.forward(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		try {
			doPost(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
