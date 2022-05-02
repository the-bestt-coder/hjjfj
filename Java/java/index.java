package java;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner;  // Import the Scanner class

import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;  

public class index {
  public static void main(String[] args) {
    try {
      //LocalDate formatDateTime = LocalDate.now(); // Create a date object
      System.out.println("File name:");
      
      Scanner inputObj = new Scanner(System.in);//closed in the end
      Scanner inputObj1 = new Scanner(System.in);

      LocalDateTime datetime1 = LocalDateTime.now();  
      DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
      String formatDateTime = datetime1.format(format);   
      

      String fileName = inputObj1.nextLine();  // Read user input
      File myObj = new File(fileName);
      System.out.println("File created" + myObj.getName() + " action completed at " + formatDateTime);

      if (myObj.createNewFile()) {
        System.out.println("Type the text you want to put in the file:");

        try {
            String userName = inputObj.nextLine();  // Read user input
            FileWriter myWriter = new FileWriter(myObj);//"filename.txt"
            myWriter.write(userName);
            myWriter.close();
            System.out.println("Successfully wrote to the file!" + " action completed at " + formatDateTime);
          } catch (IOException e) {
            System.out.println("An error occurred" + " action done at " + formatDateTime);
            e.printStackTrace();
        }

      } else {//this is to delet the file

        if (myObj.delete()) { 
            System.out.println("Deleted the file: " + myObj.getName() + "! action completed at " + formatDateTime);
            System.out.println("Type the text you want to put in the file:");

            try {
                String userName = inputObj.nextLine();  // Read user input
                FileWriter myWriter = new FileWriter(myObj);//"filename.txt"
                myWriter.write(userName);
                myWriter.close();
                System.out.println("Successfully wrote to the file." + " action completed at " + formatDateTime);
              } catch (IOException e) {
                System.out.println("An error occurred" + " action completed at " + formatDateTime);
                e.printStackTrace();
            }
    
          } else {
            System.out.println("Failed to delete the file.");
          } 
      }

      inputObj.close();//scanner closed
      inputObj1.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}