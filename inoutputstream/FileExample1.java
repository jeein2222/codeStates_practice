package codeStates.inoutputstream;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file1 = new File("../codestates.txt");

        System.out.println(file1.getPath());//..\codestates.txt
        System.out.println(file1.getParent());//..
        System.out.println(file1.getCanonicalPath());//C:\javaPractice\codestates.txt
        System.out.println(file1.canWrite());//false

        /*
            파일 인스턴스를 생성하는 것이 곧 파일을 생성하는 것은 아님. 파일을 생성하기 위해서는
            파일 인스턴스를 생성할 때 다음과 같이 첫 번째 인자에 경로를, 두 번째 인자에 파일명을 작성,
            createNewFile() 메서드를 호출해주어야 함.
         */
        File file2 = new File("./", "newCodestates.txt");
        file2.createNewFile();


    }
}
