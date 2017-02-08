
package challenge302_spellingwithchemistry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Challenge302_SpellingWithChemistry {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);     
        String input = sc.next();      
        File file = new File("./periodic.txt");    
     
        String output = "";
        ArrayList elements = new ArrayList();
        int index = 0;
        
        while(index < input.length()) {          
           System.out.println("Index: " + index);
           BufferedReader br = new BufferedReader(new FileReader(file));
           
           while(br.ready()) {

                String line = br.readLine();
                String[] lineArray = line.split("\\|");
                //ArrayList elements = new ArrayList();
                String element = lineArray[1];
                String symbol = lineArray[0]; 
                int remainingIndices = input.length() - index - 1;

                switch (remainingIndices) {
                    case 0:
                        if (input.substring(index).equalsIgnoreCase(symbol)) {
                            output += symbol;
                            elements.add(element);
                            System.out.println("Add element: " + element);
                        }
                        break;

                    case 1:
                        if (input.substring(index, (index + 1)).equalsIgnoreCase(symbol) || input.substring(index).equalsIgnoreCase(symbol)) {
                            output += symbol;
                            elements.add(element);
                            System.out.println("Add element: " + element);
                        }
                        break;

                    default:
                        //System.out.println("Default");
                        if(input.substring(index, (index +1)).equalsIgnoreCase(symbol) || input.substring(index, (index + 2)).equalsIgnoreCase(symbol)) {
                           if (input.substring(index, (index +1)).equalsIgnoreCase(symbol)) {
                               output += symbol;
                           } else {
                               output += symbol;
                               index += 1;
                           }

                            elements.add(element);
                            System.out.println("Add element: " + element);
                        }
                        break;
                }
           }
           
          br.close();
          index++;
       }
        
        output += " (" + (String) elements.get(0);
        int j = 1;
        while (j < elements.size()) {
            String el = (String) elements.get(j);
            output += ", " + el;
            j++;
        }
        output += ")";
        System.out.println("Output: " + output);
    }
}
