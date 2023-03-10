package codeStates.collection;

import java.util.*;

//JCK
public class JCKExample {
    public static void main(String[] args) {
        //List : ArrayList, LinkedList, Stack, Vector
        //ArrayList
        arrayListMethod();
//
//        //LinkedList
        linkedListMethod();
//
//        //Iterator
        iteratorMethod();

        //Set : HashSet, TreeSet
        //HashSet : 중복 허용하지 않고, 순서 X
        hashSetMethod();

        //TreeSet : 중복 허용하지 않고, 순서 X (자동으로 사전 편찬 순에 따라 오름차순으로 정렬됨)
        treeSetMethod();

        //Map : Hashtable, HashMap
        //HashMap
        hashMapMethod();

        //Hashtable
        hashTableMethod();
    }

    private static void hashTableMethod() {
        Hashtable<String, String> map = new Hashtable<>();
        map.put("Spring", "345");
        map.put("Summer", "678");
        map.put("Fall", "91011");
        map.put("Winter", "1212");

        //순회하기 위해 필요
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key=keyIterator.next();
            String value = map.get(key);
            System.out.println(key+":"+value);
        }

        map.remove("Summer");
        System.out.println("총 entry 수 : " + map.size());

        //순회하기 위해 필요
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, String> entry = entryIterator.next();
            String key= entry.getKey();
            String value = entry.getValue();
            System.out.println(key +":"+value);
        }

        map.clear();
    }

    private static void hashMapMethod() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("피카츄", 85);
        map.put("꼬부기", 95);
        map.put("야도란", 75);
        map.put("파이리", 65);
        map.put("피존투", 15);

        System.out.println("총 entry 수 : " + map.size());
        System.out.println("파이리 : " + map.get("파이리"));

        //순회하기 위해 필요
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key=keyIterator.next();
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }

        map.remove("피존투");
        System.out.println("총 entry 수 : " + map.size());

        //순회하기 위해 필요
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key= entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key +":"+value);
        }

        map.clear();
    }

    private static void treeSetMethod() {
        TreeSet<String> workers = new TreeSet<>();
        workers.add("java");
        workers.add("apple");
        workers.add("spring");
        workers.add("cake");
        workers.add("java");

        System.out.println(workers);//[apple, cake, java, spring]
        System.out.println(workers.first());//apple
        System.out.println(workers.last());//spring
        System.out.println(workers.higher("apple"));//cake
        System.out.println(workers.subSet("cake","spring"));//[cake, java]
    }

    private static void hashSetMethod() {
        HashSet<String> languages = new HashSet<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("C++");
        languages.add("Java");

        Iterator it = languages.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    private static void iteratorMethod() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "flower", "cake"));
        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("cake"))
                iterator.remove();
            else System.out.println(str);
        }
    }

    private static void linkedListMethod() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Java");
        linkedList.add("egg");
        linkedList.add("tree");

        System.out.println(linkedList.size());
        System.out.println(linkedList.get(0));

        for(int i=0;i<linkedList.size();i++){
            String str = linkedList.get(i);
            System.out.println(i + ":" + str);
        }

        linkedList.remove(0);

        for(String str:linkedList){
            System.out.println(str);
        }
    }

    private static void arrayListMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("egg");
        list.addAll(new ArrayList<String>(Arrays.asList("apple","banana")));


        System.out.println(list.size());//4
        System.out.println(list.get(0));//Java
        System.out.println(list.indexOf("egg"));//1

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i+":"+str);
        }

        list.remove(0);
        Object[] arr=list.toArray();

        for(String str:list){
            System.out.println(str);
        }
    }
}
