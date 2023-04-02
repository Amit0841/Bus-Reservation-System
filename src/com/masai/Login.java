package com.masai;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        public class Login extends Admin{

	      //Login *       *      *      *
		static void userLogin() throws IOException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email");
		String Email=sc.next();
		
		System.out.println("Enter Password");
		String Password=sc.next();
		
		//  write login code  *     *     *
		            
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
	    		 return;
	    	 }
	     }
	     
    		 System.out.println("User name not exsit, you need to SingUp First.");
    		 userSignUpn();
	}
		 //Login *    *    *.^.^.^.^.^.^.^.^.^.^.^.*
		
		
	    static void userSignUpn() throws IOException, ClassNotFoundException {
	    	
	    	List<SignUp> sing=new ArrayList<>();
	    	
	    	FileInputStream fis=new FileInputStream("sudentdtata.p");
		     
		     ObjectInputStream ois=new ObjectInputStream(fis);
		     
		     while(fis.available()>0){
		    	 SignUp std=(SignUp)ois.readObject();
		    	 sing.add(std);
		     }
		    
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
	    	
	    	sing.add(new SignUp(Email,Mobile,name,add,Password));

			FileOutputStream fos=new FileOutputStream("sudentdtata.p");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        
	        for(SignUp st:sing){
	            oos.writeObject(st);
	        }
	        fos.close();
	        oos.close();
	        userLogin();
	    }
  // Admin login- .*.  *  .*.  *  .*.  *  .*.
static void AdminLogin() throws IOException, ClassNotFoundException {
	
	String Pass="Admin";
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Admin ID");
	String Id=sc.next();
	
	System.out.println("Enter Password");
	String Password=sc.next();
	
	if(Pass.equals(Password)) {
		System.out.println("Welcome back "+Id);
		System.out.println();
		
		System.out.println("For Add press - 1, For see all users press - 2, For Delete press - 3");
		int a=sc.nextInt();
		
		switch(a) {
		case 1:
			
			AddBus(a);
			break;
		case 2:
			userData();
			break;
		case 3:
			Delete();
			break;
		}
	}else {
		System.out.println("You are not Admin");
	}
}
//Admin login- .*. ^ * ^ .*. ^ * ^ .*. ^ * ^ .*.  ^ 

    //User book bus  *.*   *.*
static void userBusDetails() throws ClassNotFoundException, IOException{
	
	List<BusCreation> arr=new ArrayList<>();

	FileInputStream fis=new FileInputStream("busDetails.p");
    
    ObjectInputStream ois=new ObjectInputStream(fis);
     
    while(fis.available()>0){
    	BusCreation std=(BusCreation) ois.readObject();
  	 arr.add(std);
   }
    
    for(BusCreation p:arr){
        System.out.println("Bus Number -> "+p.busNumber+", Name -> "+p.busName+", Type -> "+p.busType+", Seats -> "+p.totalSeats+", Arrival Time -> "+p.arrivalTime+", Departure Time -> "+p.departureTime+" ");
    }
    System.out.println("For booking Enter Bus Number");
    Scanner sc=new Scanner(System.in);
	
	int BusNumber=sc.nextInt();
	System.out.println("Number of passenger");
	int Pasenger_Count=sc.nextInt();
	System.out.println("Your total price is - "+Pasenger_Count*350);
	 System.out.println();
	System.out.println("For pay now Press 1");
	int c=sc.nextInt();
	
	if(c==1) {
		FileOutputStream fos=new FileOutputStream("User_Booking.p");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    
    for(BusCreation st:arr){
    	if(BusNumber==st.busNumber) {
        oos.writeObject(st);
    	}
    }
    fos.close();
    oos.close();
    System.out.println("Payment Successful, Happy Journey.");
    System.out.println();
    System.out.println("For check bookings press 1, For Logout press 2");
    
    int ab=sc.nextInt();
    switch (ab) {
    case 1:
    	userTecket();
    	break;
    case 2:
    	System.out.println("Logout Successful");
    	Main d1=new Main();
    	d1.user();
    	break;
    	default:
    		
    		break;
    }
    
	}
	
  }
//   User book bus  ^^ .*. ^^ .*. ^^

static void userTecket() throws ClassNotFoundException, IOException{
	List<BusCreation> arr=new ArrayList<>();

	FileInputStream fis=new FileInputStream("User_Booking.p");
    
    ObjectInputStream ois=new ObjectInputStream(fis);
     
    while(fis.available()>0){
    	BusCreation std=(BusCreation) ois.readObject();
  	 arr.add(std);
   }
    
    for(BusCreation p:arr){
        System.out.println("Bus Number -> "+p.busNumber+", Name -> "+p.busName+", Type -> "+p.busType+", Seats -> "+p.totalSeats+", Arrival Time -> "+p.arrivalTime+", Departure Time -> "+p.departureTime+" ");
    }
   Main d1=new Main();
   d1.Admin();
 }

}


