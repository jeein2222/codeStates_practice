package codeStates.inoutputstream;

import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\javaPractice\\thisIsJava\\src\\main\\java\\codeStates\\inoutputstream\\codestates2.txt");
            String word = "code";

            byte b[] = word.getBytes();
            fileOutputStream.write(b);
            fileOutputStream.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
