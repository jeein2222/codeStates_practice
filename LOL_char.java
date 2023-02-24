package codeStates;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @LoL_char() : 게임정보를 담는 클래스
 * @name : 유닛의 이름
 * @ad :   유닛의 공격력
 * @def :  유닛의 방어력
 * @hp :   유닛의 체력
 * */
class LoL_char {
    //TODO:
    // 사용자의 입력을 받기위한 객체 생성을 진행합니다.

    // 게임에 필요한 변수 타입을 사전 정의합니다.
    private String name;
    private String ad;
    private String def;
    private String hp;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @user_info : 생성된 유닛의 정보를 담는 메서드
     * @this : 해당 메서드가 입력받은 변수들은 this 를
     */
    void user_info(String name, String ad, String def, String hp) {
        this.name = name;
        this.ad = ad;
        this.def = def;
        this.hp = hp;
    }

    /**
     * @user_create() : 유닛을 생성하는 메서드이며, 입력된 값은 user_info() 메서드에게 전달 및 반환 처리합니다.
     * 반환된 값은 시스템 정보창에 출력되도록 합니다.
     */
    String[] user_create() {
        //TODO:
        Scanner sc = new Scanner(System.in);
        //입력 메시지와 함께, 게임에 필요한 유닛의 정보를 입력받습니다.
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 :");
        String name = sc.next();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요(Ex 5) :");
        String ad = sc.next();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요(Ex 1) :");
        String def = sc.next();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요(Ex 10) :");
        String hp = sc.next();

        // 입력된 값은 user_info()에 전달하여 줍니다.
        this.user_info(name, ad, def, hp);

        // 유저마다의 객체 생성을 위해 반환 과정 또한 정의하여 줍니다.
        return new String[]{this.name, this.ad, this.def, this.hp};
    }

    /**
     * @user_print() : 입력된 배열을 통해 유닛 정보 출력
     */
    void user_print(String[] user) {
        //TODO:
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + user[0] + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + user[1]+"("+ "🟦".repeat(Integer.parseInt(user[1]))+")");
        System.out.println("[방어력] : " + user[2]+"("+ "🟩".repeat(Integer.parseInt(user[2]))+")");
        System.out.println("[체력] : " + user[3] + "("+ "🟥".repeat(Integer.parseInt(user[3]))+")");
    }

    /**
     * @user_info_int() : 공격력과 방어력 등을 고려해 체력 감소를 위해 문자열을 정수형태로 전환합니다.
     * Integer.parseInt() : 정수형태로 전환합니다.
     */
    String[] get_user_info(){
        return new String[]{this.name, this.ad, this.def, this.hp};
    }

    int[] user_info_int(String[] info) {
        //TODO:
        // 같은 형식의 반환을 위해 배열 선언
        int[] strength=new int[3];
        for(int i=0;i<strength.length;i++){
            strength[i]=Integer.parseInt(info[i+1]);
        }
        // 배열의 값을 하나씩 꺼내 정수형태로 전환합니다.
        return strength;

    }


    /**
     * @attack() : 공격을 수행하는 메서드
     * 아군 유닛 정보와 상대의 정보를 입력받습니다.
     */
    void attack(int[] me_info_int, int[] enemy, LoL_char me ,LoL_char you) {
        // 조건 1. 적군의 체력이 0 이하면 [유닛 제거] 가 됩니다.
        // 조건 2. 적군 체력이 0 이하가 아니라면 공격을 성공적으로 수행합니다.
        // 공격 정책 수식 : 적군 체력 -= 아군 유닛 공격력 / 적군 유닛 방어력
        //TODO:
        if(me_info_int[2]==0){
            System.out.println("더 이상 공격할 수 없습니다.(체력:❌) 게임을 종료합니다.");
            System.exit(0);
        }
        else if(enemy[2]==0){
            System.out.println("[안내] 상대 유닛이 제거되었습니다.🤪 게임을 종료합니다.");
            System.exit(0);
        }else{
            System.out.println("[안내] "+me.getName()+"유닛이 [공격] 하였습니다.");
            enemy[2]-=me_info_int[0]/enemy[1];
            System.out.println("[안내] 상대 유닛 "+you.getName()+"의 남은 [체력]은 "+enemy[2]+" 입니다."
                    +"("+ "🟥".repeat(enemy[2])+")");
            you.setHp(Integer.toString(enemy[2]));
        }
    }
}