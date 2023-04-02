    package com.masai;
	import java.awt.Color;
import java.awt.PageAttributes.ColorType;
import java.io.IOException;
	import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

	public class Main extends Login{
		
		static void user() throws ClassNotFoundException, IOException {
			Scanner sc=new Scanner(System.in);
			System.out.println("For LogIn press - 1, For SingUp press - 2,For Admin Login press - 3");
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
				default:
					System.out.println("Wrong Credendial");
					user();
					break;
			}
		}
		
		static void Admin() throws ClassNotFoundException, IOException{
			Scanner sc=new Scanner(System.in);
			System.out.println("For Show All Bus press - 1, For Show Your Tecket press - 2,For logout press - 3");
			int b=sc.nextInt();
			switch(b){
			case 1:
				userBusDetails();
				
				break;
			case 2:
				userTecket();
				
				break;
			case 3:
				System.out.println("Logout Successful");
				
				break;
			default:
				System.out.println("Wrong Credendial");
				Admin();
				break;
			}
		}
		
		public static void main(String[] args) throws IOException, ClassNotFoundException {
			
			user();
			Admin();
		}

	}


