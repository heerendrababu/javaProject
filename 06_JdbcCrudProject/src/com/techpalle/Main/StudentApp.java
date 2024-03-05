package com.techpalle.Main;
import com.techpalle.jdbc.*; // we will be calling jdbc methods in this class.

public class StudentApp
{

	public static void main(String[] args)
	{
//	  create student table
//      StudentServices.creating();
		
//		insert two students into table
//		StudentServices.inserting("Raju","java", "raju1@gmail.com"); // if you wont comment this line before performing deleting operation it will again try to insert and email
		                                                             // has unique constraint so it shows error i.e., duplicate value
//     	StudentServices.inserting("Manju","java", "manju2@gmail.com");
//     	StudentServices.inserting("Irfan","Python", "irfan786@gmail.com");

		
//		 Delete second row from table
//		 StudentServices.deleting(2);
		
//		 Update Raju's email and subject
//		StudentServices.updating(1, "kanugalaRaju221@gmail.com","Java Full Stack" );
		
//		Display all student in table :
		StudentServices.reading();
	}

}
