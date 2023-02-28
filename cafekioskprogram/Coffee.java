package codeStates.cafekioskprogram;

import java.util.Scanner;

public class Coffee extends Product{

    private boolean addtionalShot;
    public Coffee(int id, String name, int price,boolean addtionalShot) {
        super(id, name, price);
        this.addtionalShot = addtionalShot;
    }

    private void setAddtionalShot(boolean addtionalShot) {
        this.addtionalShot = addtionalShot;
    }

    @Override
    public void applyOption() {
        System.out.println("샷을 추가하시겠습니까? (1)_예 (2)_아니오");
        Scanner sc = new Scanner(System.in);
        int option = Integer.parseInt(sc.nextLine());
        if(option==1) setAddtionalShot(true);
    }

    @Override
    public String getOptionToString() {
        return addtionalShot ? "(샷 추가)" : "";
    }
}
