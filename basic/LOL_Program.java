package codeStates;

import java.util.Scanner;

public class LOL_Program {
    public static void main(String[] args) {
            System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
            System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
            LoL_char p1 = new LoL_char();
            p1.user_print(p1.user_create());

            System.out.println("===================================");
            System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
            LoL_char p2 = new LoL_char();
            p2.user_print(p2.user_create());

            System.out.println("===================================");

        while(true){
            System.out.println("-----------------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.print("[안내] 공격할 유닛의 이름을 입력하세요.:");
            String name=sc.next();
            if(name.equals(p1.getName())){
                p1.attack(p1.user_info_int(p1.get_user_info()),p2.user_info_int(p2.get_user_info()),p1,p2);
            }else{
                p2.attack(p2.user_info_int(p2.get_user_info()),p1.user_info_int(p1.get_user_info()),p2,p1);
            }
        }

    }
}
