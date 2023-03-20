package codeStates.datastructure;

//백트레킹 문제
public class Sol7 {
    public String barcode(int len){
        return backtracking("", len);
    }
    public boolean isValid(String str){//1232
        StringBuilder sb = new StringBuilder(str);
        String reversedString = sb.reverse().toString();//2321

        for(int i=1;i<=str.length()/2;i++){//갯수가 같은 것만
            if(reversedString.substring(0,i).equals(reversedString.substring(i,i+i))) return false;
        }
        return true;
    }
    public String backtracking(String str, int len){//"12",4
        String chr = "123";
        if(str.length()==len) return str;
        for(int i=0;i<chr.length();i++){
            String currentStr = str + chr.charAt(i);//123
            System.out.println("currentStr :"+currentStr);
            if(isValid(currentStr)){
                String founded = backtracking(currentStr, len);//1,4
                System.out.println("founded :"+founded);
                if(founded!=null) return founded;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Sol7 s = new Sol7();
        System.out.println(s.barcode(8));

    }



}
