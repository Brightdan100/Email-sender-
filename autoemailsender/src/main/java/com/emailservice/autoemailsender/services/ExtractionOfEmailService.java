package com.emailservice.autoemailsender.services;



import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Service
public class ExtractionOfEmailService {


    public List<String> getEmailInFileAsList(String fileName) throws IOException {

        FileReader fileReader = new FileReader(fileName);
        List<String> outputList = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(fileReader);
            String str;

            while ((str = file.readLine()) != null) {
                String [] strList = str.split(",");
                outputList.addAll(Arrays.asList(strList));
            }
            file.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File Not Found");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File Read Error");
        }
        return outputList;
    }

}
