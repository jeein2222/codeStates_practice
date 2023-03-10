package codeStates.inoutputstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try{
            String fileName = "C:\\javaPractice\\thisIsJava\\src\\main\\java\\codeStates\\inoutputstream\\codestates3.txt";
            FileWriter fileWriter = new FileWriter(fileName);

            String str = "written!";
            fileWriter.write(str);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
