package codeStates.inoutputstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try{
            String fileName = "C:\\javaPractice\\thisIsJava\\src\\main\\java\\codeStates\\inoutputstream\\codestates.txt";
            FileReader file = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(file);

            int data=0;
            while((data=bufferedReader.read())!=-1){
                System.out.println((char) data);
            }
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
