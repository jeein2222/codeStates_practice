package codeStates.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    //1번
    public int computeSumOfAllElements(List<Integer> list){
//        return list.stream()
//                .reduce(0, (a,b) -> a+b);
        return list.stream()
                .mapToInt(a->a)
                .sum();

    }
    //2번
    public double computeAverageOfNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(a->a)
                .average()
                .orElse(0);
    }
    //3번
    public List<Integer> filterOddNumbers(List<Integer> list){
        return list.stream()
                .filter(e->e%2==0)
                .collect(Collectors.toList());
    }
    //4번
    public long computeCountOfFemaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender() 메소드로 해당 Member 클래스의 name, gender를 확인할 수 있습니다.
        return members.stream()
                .filter(e->e.gender.equals("Female"))
                .count();
    }
    //5번
    public double computeAverageOfMaleMember(List<Member> members) {
        //구현된 Member 클래스의 getName(), getGender(), getAge() 메소드로 해당 Member 클래스의 name, gender, age를 확인할 수 있습니다.
        return members.stream()
                .filter(e->e.gender.equals("Male"))
                .mapToDouble(Member::getAge)
                .average()
                .orElse(0);
    }
    //6번
    public String[] makeUniqueNameArray(List<String> names) {
        //TODO..
        return names.stream()
                .distinct()
                .sorted()
                .toArray(String[] :: new);
    }
    //7번
    public static String[] filterName(List<String> names) {
        return names.stream()
                .distinct()
                .filter(e -> e.startsWith("김"))
                .sorted()
                .toArray(String[] :: new);

    }
    //8번
    public Integer findBiggestNumber(int[] arr) {
        if(arr.length==0) return null;
        return Arrays.stream(arr)
                .max()
                .getAsInt();
    }
    //9번
    public int findLongestLength(String[] strArr) {
        return Arrays.stream(strArr)
                .reduce("",(s1,s2)->{
                    return s1.length()>s2.length() ? s1:s2;
                }).length();
    }
    //10번
    public List<String> mergeTwoStream(List<String> list1, List<String> list2) {
        Stream<String> stream1=list1.stream();
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }
    //11번
    public List<Integer> makeElementDouble(List<Integer> list) {
        return list.stream()
                .map(n->n*2)
                .collect(Collectors.toList());

    }
    //12번
    public boolean isHot(int[] temperature) {
        if(temperature.length!=7) return false;
        return Arrays.stream(temperature)
                .filter(e->e>=30)
                .count()>=3 ? true : false;
    }
    //13번
    public List<String> findPeople(List<String> male, List<String> female, String lastName) {
        //TODO..
        Stream<String> stream1=male.stream().distinct().filter(e->e.startsWith(lastName));
        Stream<String> stream2=female.stream().distinct().filter(e->e.startsWith(lastName));

        return Stream.concat(stream1,stream2).distinct().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }



    // 아래 코드는 변경하지 마세요.
    static class Member {
        String name;
        String gender;
        int age;

        public Member(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }
    }
}
