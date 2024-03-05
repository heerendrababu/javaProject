package com.techpalle.jdbc;

import java.sql.*;

public class StudentServices 
{
  // In multiple methods we will use these varibles so declared it first outside a method
  private static Connection cn=null;
  private static Statement stm=null;
  private static PreparedStatement ps=null;
  private static ResultSet rs=null;
  
  private static Connection myConnection() throws ClassNotFoundException, SQLException
  {   // Step 1 :Load Driver class
	  Class.forName("com.mysql.cj.jdbc.Driver"); // i just throw exception and i will handle that error in wherever i call this method.
	  
	  // Step 2 : Establish Connection
	cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/palledb","root","Babu@123"); // same  like above exception used throws.
	
	//return connection
	return cn;  
  } 
  //Reading
  public static void reading()
  {
	try
	{
		cn = myConnection();
		stm = cn.createStatement();
		String qry = "select * from student100";
	rs = stm.executeQuery(qry);
	while(rs.next())
	{
		System.out.println(rs.getInt("sno"));
		System.out.println(rs.getString("sname"));
		System.out.println(rs.getString("sub"));
		System.out.println(rs.getString("email")+"\n");
	  }
	} 
	catch (ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	finally
    {
    	if(rs!=null)
		{
			try 
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
    	if(stm!=null)
		{
			try 
			{
				stm.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
	     }		
		if(cn!=null)
		{
			try 
			{
				cn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
	     }		
    }
	
  }
  
  // updating
   public static void updating(int sno,String email,String sub)
   {
	   try 
	   {
		cn = myConnection();
		String qry = " update Student100 set email = ?,sub = ?,sno = ?";
	      ps = cn.prepareStatement(qry);
	      ps.setString(1,email); // Here question mark order is important not the method parameter order.
	      ps.setString(2,sub);
	      ps.setInt(3, sno); 
	      ps.executeUpdate();
		} 
	    catch (ClassNotFoundException | SQLException e)
	    {
			e.printStackTrace();
		}
	    finally
	    {
	    	if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		     }		
	    }
   }
  
  // deleting
  public static void deleting(int sno)
  {
	  try 
		{
			cn = myConnection();
			String qry = "delete from student100 where sno = ?";
            ps = cn.prepareStatement(qry);
			ps.setInt(1, sno);
			ps.executeUpdate();	
		} 
		catch (ClassNotFoundException | SQLException e) // 'e' variable handling multiple errors
		{
			e.printStackTrace(); // Based on exception printStackTrace will print 'error message'.
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
		     }	
          }
  }// deleting method closing
  public static void inserting(String name,String sub,String email)
  {
	  try 
		{
			cn = myConnection();
			String qry = "insert into student100(sname,sub,email)values(?,?,?)";
            ps = cn.prepareStatement(qry);
			ps.setString(1, name); // calling setter methods for inserting data.
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();	
		} 
		catch (ClassNotFoundException | SQLException e) // 'e' variable handling multiple errors
		{
			e.printStackTrace(); // Based on exception printStackTrace will print 'error message'.
		}
		finally
		{
			if(ps!=null)
			{
				try 
				{
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try 
				{
					cn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		} 
  }
  
  // Creating method
  public static void creating() // it is public because we need to call it in another package.
  {
	try 
	{
		cn = myConnection();
		stm = cn.createStatement(); // static query so we consider 'statement interface'.
		
		// it is static  because all queries written by programmer himself not user.
		String qry = "create table student100(sno int primary key auto_increment,sname varchar(40),sub varchar(40),email varchar(40) unique)";
		stm.executeUpdate(qry);	
	} 
	catch (ClassNotFoundException | SQLException e) // 'e' variable handling multiple errors
	{
		e.printStackTrace(); // Based on exception printStackTrace will print 'error message'.
	}
	finally
	{
		if(stm!=null) 
		{
			try 
			{
				stm.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(cn!=null)
		{
			try 
			{
				cn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
  }
  
  
}
