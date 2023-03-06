package codeStates;

import java.util.*;

public class Collections {
    //Collection 연습문제
    public ArrayList<Integer> makeArrayList() {
//        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            list.add(i);
        return list;
    }

    public Integer getNthElement(ArrayList<Integer> arrayList, int index) {
        //TODO..
        if (arrayList.size() == 0) return null;
        return arrayList.get(index);

    }

    public String getLastElement(ArrayList<String> arrayList) {
        //TODO..
        if (arrayList.size() == 0) return null;
        return arrayList.get(arrayList.size() - 1);
    }

    public ArrayList<String> addLast(ArrayList<String> arrayList, String str) {
        //TODO..
        arrayList.add(str);
        return arrayList;
    }

    public ArrayList<Integer> addNth(ArrayList<Integer> arrayList, int index, int n) {
        //TODO..
        if (index < 0 || index >= arrayList.size()) return null;
        arrayList.add(index, n);
        return arrayList;
    }

    public ArrayList<String> modifyNthElement(ArrayList<String> arrayList, int index, String str) {
        //TODO..
        if (index < 0 || index >= arrayList.size()) return null;
        arrayList.set(index, str);
        return arrayList;
    }

    public Integer removeFromFront(ArrayList<Integer> arrayList) {
        //TODO..
        if (arrayList.size() == 0) return null;
        return arrayList.remove(0);
    }

    public String removeFromNth(ArrayList<String> arrayList, int index) {
        //TODO..
        if (index < 0 || index >= arrayList.size()) return null;
        return arrayList.remove(index);
    }

    public ArrayList<Integer> removeFromBackOfNew(ArrayList<Integer> arrayList) {
        //TODO..
        if (arrayList.size() == 0) return null;

        ArrayList<Integer> newArrayList = new ArrayList<>();
        newArrayList.addAll(arrayList.subList(0, arrayList.size() - 1));

        return newArrayList;
    }

    public List<String> arrayToArrayList(String[] arr) {
        //TODO..
        if (arr.length == 0) return null;
        return new ArrayList<String>(Arrays.asList(arr));
    }

    public ArrayList<Integer> clearArrayList(ArrayList<Integer> arrayList) {
        //TODO..
        arrayList.clear();
        return arrayList;
    }
    public int sumAllElements(ArrayList<Integer> arrayList) {
        //TODO..
        if(arrayList.size()==0) return 0;
        int sum=0;
        Iterator it=arrayList.iterator();
        while(it.hasNext()){
            sum+=(int)it.next();
        }
        return sum;
    }
    public Integer getValue(HashMap<String, Integer> hashMap, String key) {
        //TODO..
        return hashMap.get(key);
    }
    public HashMap<String, Integer> addKeyAndValue(HashMap<String, Integer> hashMap, String key, int value) {
        //TODO..
        hashMap.put(key,value);
        return hashMap;
    }
    public void removeEntry(HashMap<String, Integer> hashMap, String key) {
        //TODO..
        hashMap.remove(key);
    }
    public void clearHashMap(HashMap<Integer, Boolean> hashMap) {
        //TODO..
        hashMap.clear();
    }
    public int getSize(HashMap<Integer, Integer> hashMap) {
        //TODO..
        return hashMap.size();
    }
    public int addOddValues(HashMap<Character, Integer> hashMap) {
        //TODO..
        Set<Character> keySet=hashMap.keySet();
        Iterator it=keySet.iterator();
        int sum=0;
        while(it.hasNext()){
            int value=hashMap.get(it.next());
            if(value%2==0)
                sum+=value;
        }
        return sum;
    }
    public HashMap<String, String> addFullNameEntry(HashMap<String, String> hashMap) {
        //TODO..
        String fullName=hashMap.get("firstName")+hashMap.get("lastName");
        hashMap.put("fullName",fullName);
        return hashMap;
    }
    public boolean isContain(HashMap<String, Integer> hashMap, String key) {
        //TODO..
        return hashMap.containsKey(key);
    }
    public String getElementOfListEntry(HashMap<String, List<String>> hashMap, String key, int index) {
        //TODO..
        if(index<0 || index>=hashMap.size() || !hashMap.containsKey(key)) return null;
        else{
            List<String> values=hashMap.get(key);
            return values.get(index);
        }
    }
    public boolean isMember(HashMap<String, String> member, String username, String password) {
        //TODO..
        if(member.containsKey(username)){
            if(member.get(username).equals(password)) return true;
        }
        return false;
    }
    public HashMap<String, Integer> select(String[] arr, HashMap<String, Integer> hashMap) {
        //TODO..
        HashMap<String, Integer> newHashMap=new HashMap<>();

        for(String str:arr){
            if(hashMap.containsKey(str)){
                newHashMap.put(str,hashMap.get(str));
            }
        }

        return newHashMap;
    }
    public HashMap<Character, Integer> countAllCharacter(String str) {
        //TODO..
        if(str.length()==0) return null;
        HashMap<Character,Integer> hashMap=new HashMap<>();


        for(char c: str.toCharArray()){
            if(hashMap.containsKey(c)) hashMap.put(c,hashMap.get(c)+1);
            else hashMap.put(c,1);
        }

        return hashMap;
    }
}
