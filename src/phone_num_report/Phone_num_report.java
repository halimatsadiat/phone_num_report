/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package phone_num_report;

import java.io.*;
import java.util.Arrays;
/**
 *
 * @author Ogidan Sadiat
 */
public class Phone_num_report {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getReport();
    }
    
    private static void getReport() {
    	     String tmp = null;
             int total_count = 0;
    	     int mtn_count = 0;
    	     int airtel_count = 0;
    	     int globacom_count = 0;
    	     int ninemobile_count = 0;
    	     int mtel_count = 0;
    	     
    	     
    	     String MTN[] = new String[]{"0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","07025","07026","0704"};
    	     String Airtel[] = new String[]{"0701","0708","0802","0808","0812","0901","0902","0904","0907","0912"};
    	     String Globacom[] = new String[]{"0705","0805","0807","0811","0815","0905","0915"};
    	     String NineMobile [] = new String[]{"0809","0817","0818","0909","0908"};
    	     String Mtel = "0804";
    	     
    	     if(Arrays.stream(MTN).anyMatch("hell"::equals)){
    	         System.out.println("There was a match!!!");
    	     }
	
	        try {
	            
	            BufferedReader bufferedReader = 
	                new BufferedReader(new FileReader("PhoneNumbers.txt"));
	
	            while((tmp = bufferedReader.readLine()) != null) {
	                String first_four = tmp.substring(0,4);
	                String first_five = tmp.substring(0,5);
                        
                        total_count++; 
	                
	                if(Mtel.equals(first_four)){
	                    mtel_count ++;
	                }else if(Arrays.stream(MTN).anyMatch(first_four::equals) || Arrays.stream(MTN).anyMatch(first_five::equals)){
	                    mtn_count ++;
	                }else if(Arrays.stream(Airtel).anyMatch(first_four::equals)){
	                    airtel_count ++;
	                }else if(Arrays.stream(Globacom).anyMatch(first_four::equals)){
	                    globacom_count ++;
	                }else if(Arrays.stream(NineMobile).anyMatch(first_four::equals)){
	                    ninemobile_count ++;
	                }
	                
	            }   
	
	            bufferedReader.close();  
                    
                    System.out.println("The file contains: ");
                    System.out.println(mtn_count + " MTN Phone Numbers");
                    System.out.println(airtel_count + " Airtel Phone Numbers");
                    System.out.println(globacom_count + " Globacom Phone Numbers");
                    System.out.println(ninemobile_count + " 9Mobile Phone Numbers");
                    System.out.println(mtel_count + " MTEL Phone Numbers");
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println("Unable to read file...");                
	        }
	        catch(IOException ex) {
	            System.out.println("Unable to read file...");
	        }
	        
	}
    
}
