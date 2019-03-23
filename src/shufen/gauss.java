package shufen;

import java.util.Scanner;

public class gauss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		juti ju =new juti();
		while(true) {
       System.out.println("Ô¤ÖÃ¾ØÕóÇëÊäÈë£º1");
       System.out.println("Ëæ»ú¾ØÕóÇëÊäÈë£º2");
       String s= new Scanner(System.in).next();  
       
       switch(s){
       case "1":
    	   ju.gauss1();
    	   break;
    	   
       case "2":
    	   ju.gauss2();
    	   break;
    	   
       }
          
		}
       
       }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
