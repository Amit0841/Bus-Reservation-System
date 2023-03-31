package com.masai;

import java.io.Serializable;

public class BusCreation implements Serializable{
String busName;
String source;
String destination;
String busType; 
String departureTime;
String arrivalTime;
int totalSeats;
BusCreation(){
	
}
BusCreation(String busName,String source,String destination,String busType,String departureTime,String arrivalTime,int totalSeats){
	this.busName=busName;
	this.source=source;
	this.destination=destination;
	this.busType=busType;
	this.departureTime=departureTime;
	this.arrivalTime=arrivalTime;
	this.totalSeats=totalSeats;
}

}
