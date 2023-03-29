package com.masai;
	import java.io.Serializable;
public class SignUp implements Serializable{
	
		String email;
		String mobile;
		String name;
		String add;
		String Password;
		int ID;


		SignUp(String email,String mobile,String name,String add,String Password){
			this.email=email;
			this.mobile=mobile;
			this.name=name;
			this.add=add;
			this.Password=Password;
			this.ID=(int)(Math.random()*10000);
		}
		
	}




