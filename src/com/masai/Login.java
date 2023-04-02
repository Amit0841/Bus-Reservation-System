package com.masai;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

	     
	      //Login *       *      *      *
		static void userLogin() throws IOException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email");
		String Email=sc.next();
		
		System.out.println("Enter Password");
		String Password=sc.next();
		//  write login code ***
		
		 List<SignUp> studentdata=new ArrayList<>();
	     
	     FileInputStream fis=new FileInputStream("sudentdtata.p");
	     
	     ObjectInputStream ois=new ObjectInputStream(fis);
	     
	     while(fis.available()>0){
	    	 SignUp std=(SignUp)ois.readObject();
	         studentdata.add(std);
	     }
	     System.out.println("deserialzation");
	     fis.close();
	     ois.close();


	     for(SignUp p:studentdata){
	    	 if(Email.equals(p.email)&&Password.equals(p.Password)) {
	    		 System.out.println("Login success");
	    		 
	    	 }else {
	    		 System.out.println("User name not exsit, you need to SingUp First.");
	    		 userLogin(); 
	    	 }
	         //System.out.println(p.name+" "+p.email+" "+p.Password+" "+p.add+" "+p.ID+" "+p.mobile);
	     }
		
		
	}
		 //Login *       *      *      *
		
		
	    static void userSignUpn() throws IOException, ClassNotFoundException {
	    	
	    	List<SignUp> sing=new ArrayList<>();
	    	
	    	Scanner sc=new Scanner(System.in);
	    	
	    	System.out.println("Enter Email");
	    	String Email=sc.next();
	    	
	    	System.out.println("Enter Mobile");
	    	String Mobile=sc.next();
	    	System.out.println("Enter name");
	    	String name=sc.next();
	    	
	    	System.out.println("Enter add");
	    	String add=sc.next();
	    	
	    	System.out.println("Create your Password");
	    	String Password=sc.next();
	    	
	    	sing.add( new SignUp(Email,Mobile,name,add,Password));
	    	
	    	FileOutputStream fos=new FileOutputStream("sudentdtata.p");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        
	        for(SignUp st:sing){
	            oos.writeObject(st);
	        }

	        System.out.println("Now you need to Login");
	       
	        fos.close();
	        oos.close();
	        
	        userLogin();
	    }

static void AdminLogin() {
	String AdminId="Admin";
	String Pass="Admin";
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Admin ID");
	String Id=sc.next();
	
	System.out.println("Enter Password");
	String Password=sc.next();
	
	if(AdminId.equals(Id)&&Pass.equals(Password)) {
		System.out.println("Welcome back Admin");
	}else {
		System.out.println("You are not Admin ");
	}
}
		
	}


