    package com.masai;
	import java.io.IOException;
	import java.util.Scanner;

	public class Main extends Login{
		
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			Scanner sc=new Scanner(System.in);
			System.out.println("For LogIn type - 1, For SingUp type - 2,For Admin Login type - 3");
			int a=sc.nextInt();
			switch(a){
			case 1:
				userLogin();
				
				break;
			case 2:
				userSignUpn();
				
				break;
			case 3:
				AdminLogin();
				
				break;
			}
			System.out.println("For type - 1, For SingUp type - 2,For Admin Login type - 3");
			
		}

	}


