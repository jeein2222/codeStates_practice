package codeStates;

import java.util.Scanner;

public class LOL_Program {
    public static void main(String[] args) {
            System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
            System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");
            LoL_char player1 = new LoL_char();
            player1.user_print(player1.user_create());

            System.out.println("===================================");
            System.out.println("[안내] 상대 유닛 정보를 입력해 주세요.");
            LoL_char player2 = new LoL_char();
            player2.user_print(player2.user_create());

            System.out.println("===================================");

        while(true){
            System.out.println("-----------------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.print("[안내] 공격할 유닛의 이름을 입력하세요.");
            String name=sc.next();
            if(name.equals(player1.getName())){
                player1.attack(player1.user_info_int(player1.get_user_info()),player2.user_info_int(player2.get_user_info()),player1,player2);
            }else{
                player2.attack(player2.user_info_int(player2.get_user_info()),player1.user_info_int(player1.get_user_info()),player2,player1);
            }
        }

    }
}
