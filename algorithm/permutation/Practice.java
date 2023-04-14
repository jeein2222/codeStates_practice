package codeStates.algorithm.permutation;

import codeStates.practice.PracticeNaverCodingTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
    //순열 : n개의 원소를 가지는 배열에서 r개의 요소를 꺼내는 경우의 수, (중복 허락하지 않음, 순서 있음)
    public void permutation1(ArrayList<Integer[]> resultList, ArrayList<Integer> itemList, int[] result, int depth, int n, int r) {
        if (depth == r) {
            resultList.add(Arrays.stream(result.clone()).boxed().toArray(Integer[]::new));
            return;
        }
        for (int i = 0; i < n - depth; i++) {
            result[depth] = itemList.remove(i);
            permutation1(resultList, itemList, result, depth + 1, n, r);
            itemList.add(i, result[depth]);
        }
    }

    //조합 : n개의 원소를 가지는 배열에서 순서를 생각하지 않고 r개를 꺼냄.(중복 안됨)
    public void combination1(ArrayList<Integer[]> resultList, ArrayList<Integer> itemList, int[] result, int depth, int startIdx) {
        if (depth == result.length) {
            resultList.add(Arrays.stream(result.clone()).boxed().toArray(Integer[]::new));
            return;
        }
        for (int i = startIdx; i < itemList.size(); i++) {
            result[depth] = itemList.get(i);
            combination1(resultList, itemList, result, depth + 1, i + 1);
        }
    }

    //중복순열
    public void permutation_with_repetition1(ArrayList<Integer[]> resultList, ArrayList<Integer> itemList, int[] result, int depth, int r) {
        if (depth == r) {
            resultList.add(Arrays.stream(result.clone()).boxed().toArray(Integer[]::new));
            return;
        }
        for (int i = 0; i < itemList.size(); i++) {
            result[depth] = itemList.get(i);
            permutation_with_repetition1(resultList, itemList, result, depth + 1, r);
        }
    }

    public static void main(String[] args) {
        Practice pnct = new Practice();
        ArrayList<Integer> itemList = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer[]> resultList = new ArrayList<>();
        int[] result = new int[2];
        pnct.permutation1(resultList, itemList, result, 0, itemList.size(), result.length);
        for (int i = 0; i < resultList.size(); i++)
            System.out.print(Arrays.toString(resultList.get(i)) + " ");

        resultList.clear();

        System.out.println();
        System.out.println("-".repeat(60));

        pnct.combination1(resultList, itemList, result, 0, 0);
        for (int i = 0; i < resultList.size(); i++)
            System.out.print(Arrays.toString(resultList.get(i)) + " ");

        resultList.clear();

        System.out.println();
        System.out.println("-".repeat(60));

        pnct.permutation_with_repetition1(resultList, itemList, result, 0, result.length);
        for (int i = 0; i < resultList.size(); i++)
            System.out.print(Arrays.toString(resultList.get(i)) + " ");

    }
}