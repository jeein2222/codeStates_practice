package codeStates.inoutputstream;

import java.io.File;

//현재 디렉토리(.)에서 확장자가 .txt인 파일만을 대상으로, 파일명 앞에 “code”라는 문자열을 붙여줌
public class FileExample2 {
    public static void main(String[] args) {
        File parentDir = new File("./");
        File[] list = parentDir.listFiles();

        String prefix = "code";

        for(int i=0;i<list.length;i++){
            String fileName = list[i].getName();
            if(fileName.endsWith("txt") && !fileName.startsWith("code"))
                list[i].renameTo(new File(parentDir, prefix + fileName));
        }
    }
}
