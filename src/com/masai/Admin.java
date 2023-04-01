package com.masai;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends BusCreation{
	Admin(){
		super();
	}

public static void AddBus(int a) throws IOException, ClassNotFoundException {
	List<BusCreation> arr=new ArrayList<>();
	
	FileInputStream fis=new FileInputStream("busDetails.p");
    
    ObjectInputStream ois=new ObjectInputStream(fis);
    
    while(fis.available()>0){
    	BusCreation std=(BusCreation)ois.readObject();
  	 arr.add(std);
   }
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Bus Name");
	String busName=sc.next();
	
	System.out.println("Enter source Name");
	String source=sc.next();
	
	System.out.println("Enter Destination");
	String destination=sc.next();
	
	System.out.println("Enter busType");
	String busType=sc.next(); 
	
	System.out.println("Enter Departure Time");
	String departureTime=sc.next();
	
	System.out.println("Enter Arrival Time");
	String arrivalTime=sc.next();
	
	System.out.println("Enter Total Seats");
    int totalSeats=sc.nextInt();
    
    

    
    
	  arr.add(new BusCreation(busName,source,destination,busType,departureTime,arrivalTime,totalSeats));
	  System.out.println(arr);
	  
	  FileOutputStream fos=new FileOutputStream("busDetails.p");
      ObjectOutputStream oos=new ObjectOutputStream(fos);
      
      for(BusCreation st:arr){
          oos.writeObject(st);
      }

      fos.close();
      oos.close();
}

static void userData() throws ClassNotFoundException, IOException{
List<SignUp> arr=new ArrayList<>();
	
	FileInputStream fis=new FileInputStream("sudentdtata.p");
    
    ObjectInputStream ois=new ObjectInputStream(fis);
    
    while(fis.available()>0){
    	SignUp std=(SignUp)ois.readObject();
  	 arr.add(std);
   }
    for(SignUp p:arr){
        System.out.println("Name -> "+p.name+", Address -> "+p.add+", Mobile -> "+p.mobile+", Email -> "+p.email+", UserId -> "+p.ID+" ");
    }
}

static void Delete() throws  IOException, ClassNotFoundException{
	Scanner sc=new Scanner(System.in);
	
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
    
    FileOutputStream fos=new FileOutputStream("busDetails.p");
    ObjectOutputStream oos=new ObjectOutputStream(fos);
    System.out.println();
    System.out.println("Enter Bus Number");
    int s=sc.nextInt();
    for(BusCreation st:arr){
    	
    	if(st.busNumber!=s) {
    		 oos.writeObject(st);
    	}
       
    }

    fos.close();
    oos.close();
    
}

}
