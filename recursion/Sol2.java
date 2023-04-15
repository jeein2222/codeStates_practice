package codeStates.recursion;

//구구단
/*
    1*9=9
    2*9=18
    ..
    9*9=
 */
public class Sol2 {
    //반복문
    public void gugudan1(int level){
        for(int i=1;i<=9;i++)
            System.out.printf("%d X %d = %d\n",level,i,level*i);
    }

    //재귀
    public void gugudan2(int level,int count){
        if(count>9) return;
        System.out.printf("%d X %d = %d\n",level,count,level*count);
        gugudan2(level, ++count);
    }

    public static void main(String[] args) {
        Sol2 s = new Sol2();
        s.gugudan1(5);
        s.gugudan2(5,1);
    }
}
