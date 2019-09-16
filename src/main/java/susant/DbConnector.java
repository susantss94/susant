package susant;
import java.io.*;
import java.sql.*;
public class DbConnector {
	private Connection con=null;
	
	String emp_id=null;
	long mob=0;
	String name=null,degn=null;
    java.util.Date  Dob=null;
    java.util.Date join_date=null;
    java.sql.Date sqDob=null,sqjoin_date=null;
    long ms=0;
    long mss=0;
    
    public DbConnector()
    {
    	
    }
    public DbConnector(String emp_id,String name,long mob,java.util.Date join_date,java.util.Date Dob,String degn)
    {
    	this.emp_id=emp_id;
    	this.name=name;
    	this.mob=mob;
    	this.join_date=join_date;
    	this.Dob=Dob;
    	this.degn=degn;
    	mss=join_date.getTime();
    	ms=Dob.getTime();
    	sqDob=new java.sql.Date(ms);
    	sqjoin_date=new java.sql.Date(mss);
    	System.out.println(join_date);
    	System.out.println(sqDob);
    	
    	con=getConnection();
    	
    }
    
    
    public void sete_id(String emp_id)
    {
    	this.emp_id=emp_id;
    }
    
    public String getemp_id()
    {
    	return emp_id;
    }
    public void setname(String name)
    {
    	this.name=name;
    }
    public String getname()
    {
    return name;
    }
    public void setmob(long mob)
    {
    	this.mob=mob;
    }
    public long getmob()
    {
    	return mob;
    }
    public java.util.Date getDob() {
		return Dob;
	}
	public void setDob(java.util.Date dob) {
		Dob = dob;
	}
	public java.util.Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(java.util.Date join_date) {
		this.join_date = join_date;
	}
    public void setdegn(String degn)
    {
    	this.degn=degn;
    }
    public String getdegn()
    {
    	return degn;
    }
    public Connection getConnection()
    {
    	try
    	{
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/curd?autoReconnect=true&useSSL=false","root","admin");
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return con;
    }
    public boolean exists(String emp_id)
    {
    	PreparedStatement ps=null;
    	try {
    		ps=con.prepareStatement("SELECT COUNT(*) FROM EMP WHERE EMP_ID=?");
    		ps.setString(1,emp_id);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		
    		if(rs.getString(1).equals(null))
    			return false;
    		else
    			return true;
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
    	finally
    	{
    	 if(ps!=null)
    	 {
    		 try
    		 {
    			 ps.close();
    		 }
    		 catch(Exception e)
    		 {
    			 e.printStackTrace();
    		 }
    	 }
    	}
    }
    public int insert()
    {
    	PreparedStatement ps=null;
    	try
    	{
    		boolean alreadyPresent=exists(this.getemp_id());
    		if(! alreadyPresent)
    		{
    			ps=con.prepareStatement("INSERT INTO EMP VALUES(?,?,?,?,?,?)");
    			ps.setString(1,emp_id);
    			ps.setString(2,name);
    			ps.setLong(3,mob);
    			ps.setDate(4,sqjoin_date);
    			ps.setDate(5, sqDob);
    			ps.setString(6,degn);
    			int count=ps.executeUpdate();
    			System.out.println(count);
    			return 1;
    		}
    		else
    			return 2;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return 7;
    	}
    	finally
    	{
    		if(ps!=null)
    		{
    			try
    			{
    				ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }
    public int delete()
    {
    	PreparedStatement ps=null;
    	try
    	{
    		boolean alreadyPresent=exists(this.getemp_id());
    		if(! alreadyPresent)
    		{
    			ps=con.prepareStatement("DELETE FROM EMP WHERE EMP_ID=?");
    			ps.setString(1,emp_id);
    			ps.executeUpdate();
    			return 3;
    		}
    		else
    			return 4;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return 7;
    	}
    	finally
    	{
    		if(ps!=null)
    		{
    			try
    			{
    				ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }
    public int update()
    {
    	PreparedStatement ps=null;
    	try
    	{
    		boolean alreadyPresent=exists(this.getemp_id());
    		if(! alreadyPresent)
    		{
    			ps=con.prepareStatement("UPDATE EMP SET NAME=?, MOB=? WHERE EMP_ID=?");
    			ps.setString(1,name);
    			ps.setLong(2,mob);
    			ps.setString(3,emp_id);
    			ps.executeUpdate();
    			return 5;
    		}
    		else
    			return 4;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return 7;
    	}
    	finally
    	{
    		if(ps!=null)
    		{
    			try
    			{
    				ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }
    public int display()
    {
    	PreparedStatement ps=null;
    	try
    	{
    		boolean alreadyPresent=exists(this.getemp_id());
    		if(! alreadyPresent)
    		{
    			ps=con.prepareStatement("SELECT NAME,MOB FROM EMP WHERE EMP_ID=?");
    			ps.setString(1,emp_id);
    		    ResultSet rs=ps.executeQuery();
    		    if(rs.next())
    		    {
    		    	String nm=rs.getString(1);
    		    	this.setname(nm);
    		    	
    		        long nn=rs.getInt(2);
    		        this.setmob(nn);
    		    }
    		    	return 6;
    		}
    		else
    			return 4;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return 7;
    	}
    	finally
    	{
    		if(ps!=null)
    		{
    			try
    			{
    				ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	}
    }
	
}