package codeStates;

import java.util.*;

public class Collections {
    //Collection 연습문제
    public ArrayList<Integer> makeArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) list.add(i);
        return list;
    }

    public Integer getNthElement(ArrayList<Integer> arrayList, int index) {
        return arrayList.isEmpty() || index<0 || index>=arrayList.size() ? null: arrayList.get(index);
    }

    public String getLastElement(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) return null;
        return arrayList.get(arrayList.size() - 1);
    }

    public ArrayList<String> addLast(ArrayList<String> arrayList, String str) {
        arrayList.add(str);
        return arrayList;
    }

    public ArrayList<Integer> addNth(ArrayList<Integer> arrayList, int index, int n) {
        if (index < 0 || index >= arrayList.size()) return null;
        arrayList.add(index, n);
        return arrayList;
    }

    public ArrayList<String> modifyNthElement(ArrayList<String> arrayList, int index, String str) {
        if (index < 0 || index >= arrayList.size()) return null;
        arrayList.set(index, str);
        return arrayList;
    }

    public Integer removeFromFront(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) return null;
        return arrayList.remove(0);
    }

    public String removeFromNth(ArrayList<String> arrayList, int index) {
        if (index < 0 || index >= arrayList.size()) return null;
        return arrayList.remove(index);
    }

    public ArrayList<Integer> removeFromBackOfNew(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) return null;

        ArrayList<Integer> newArrayList = new ArrayList<>();
        newArrayList.addAll(arrayList.subList(0, arrayList.size() - 1));

        return newArrayList;
    }

    public List<String> arrayToArrayList(String[] arr) {
        if (arr.length == 0) return null;
        return new ArrayList<String>(Arrays.asList(arr));
    }

    public ArrayList<Integer> clearArrayList(ArrayList<Integer> arrayList) {
        //TODO..
        arrayList.clear();
        return arrayList;
    }
    public int sumAllElements(ArrayList<Integer> arrayList) {
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
    public int addOddValuesKey(HashMap<Character, Integer> hashMap) {
        //keySet을 이용해서 푸는 방법
        int sum=0;
        Set<Character> keySet=hashMap.keySet();
        Iterator<Character> it=keySet.iterator();

        while(it.hasNext()){
            int value=hashMap.get(it.next());
            if(value%2==0) sum+=value;
        }
        return sum;
    }
    public int addOddValuesEntrySet(HashMap<Character, Integer> hashMap) {
        //EntrySet으로 문제 풀기
        Set<Map.Entry<Character,Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        int sum=0;
        while(it.hasNext()){
            int value=it.next().getValue();
            if(value%2==0) sum+=value;
        }
        return sum;
    }
    public int addOddValuesValue(HashMap<Character, Integer> hashMap) {
        //Values
        int sum=0;
        Collection<Integer> values = hashMap.values();
        Iterator<Integer> it = values.iterator();

        while(it.hasNext()){
            int num=it.next();
            if(num%2==0) sum+=num;
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
        HashMap<String, Integer> newHashMap=new HashMap<>();

        for(String str:arr)
            if(hashMap.containsKey(str)) newHashMap.put(str,hashMap.get(str));

        return newHashMap;
    }
    public HashMap<Character, Integer> countAllCharacter(String str) {
        //TODO..
        if(str.length()==0) return null;
        HashMap<Character,Integer> hashMap=new HashMap<>();

        for(char c: str.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c, 0)+1);
        }

        return hashMap;
    }

    public static void main(String[] args) {
        Collections c=new Collections();
        System.out.println(c.countAllCharacter("abcddde"));
    }

}
