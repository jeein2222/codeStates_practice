package codeStates.dailycoding;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Sol {
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        if(arr.length==0) return null;
        HashMap<String, String> map=new HashMap<>();
        map.put(arr[0],arr[arr.length-1]);
        return map;
    }
    public int computeWhenDouble(double interestRate) {
        // TODO:
        /*
            money*(1+interestRate)*(1+interestRate)
         */
        double money=1;
        int year=0;
        while(money<2){
            money=money*(1+interestRate/100);
            year++;
        }
        return year;
    }

    public boolean powerOfTwo(long num) {
        // TODO:
        while(num>1){
            if(num%2==0)
                num=num/2;
            else break;
        }
        return num==1;
    }

    public String firstCharacter(String str) {
        // TODO:
        if(str=="") return str;
        String answer="";
        String[] arr=str.split(" ");
        for(int i=0;i<arr.length;i++){
            answer+=arr[i].charAt(0);
        }
        return answer;
    }

    public String firstReverse(String str) {
        // TODO:
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }

    public String letterCapitalize(String str) {
        String result = "";
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i].isEmpty()){
                arr[i] = arr[i];
            }else{
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
            }
        }

        result = String.join(" ", arr);
        return result;

    }

    public HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:
        HashMap<String,String> map=new HashMap<>();
        if(arr.length==0) return map;

        for(int i=0;i<arr.length;i++){
            if(arr[i].length==0) continue;
            else {
                if(!map.containsKey(arr[i][0])) map.put(arr[i][0],arr[i][1]);
            }
        }
        return map;
    }
    public String convertDoubleSpaceToSingle(String str) {
        String[] arr = str.split(" ");
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(!arr[i].isEmpty()){
                list.add(arr[i].trim());
            }
        }
        return String.join(" ",list);
    }

    public boolean ABCheck(String str) {
//        str = str.toLowerCase();
//        System.out.println(str);
//        Pattern pattern1= Pattern.compile("[a]"+"..."+"[b]");
//        Pattern pattern2= Pattern.compile("[b]"+"..."+"[a]");
//        Matcher matcher1=pattern1.matcher(str);
//        Matcher matcher2=pattern2.matcher(str);
//        System.out.println(matcher1.find());
//        System.out.println(matcher2.find());
//
//        return matcher1.find()||matcher2.find();
        if(str.length()==0) return false;
        str = str.toLowerCase();
        for(int i=4;i<str.length();i++){
            if((str.charAt(i)=='a' && str.charAt(i-4)=='b') || (str.charAt(i)=='b' && str.charAt(i-4)=='a')){
                return true;
            }
        }
        return false;
    }

    public String insertDash(String str) {
//        if(str.length()==0) return null;
//        String[] arr = str.split("");
//
//        for(int i=0;i<arr.length-1;i++){
//            int cur = Integer.valueOf(arr[i]);
//            int next = Integer.valueOf(arr[i+1]);
//
//            if(cur %2 !=0 && next %2 !=0){
//                arr[i] = arr[i] + "-";
//            }
//        }
//        str = String.join("", arr);
//
//        return str;
        if(str.length()==0) return null;
        String result = ""+str.charAt(0);
        for(int i=0;i<str.length()-1;i++){
            int cur = Character.getNumericValue(str.charAt(i));
            int next = Character.getNumericValue(str.charAt(i + 1));
            if(cur%2!=0 && next%2!=0) {
                result += "-";
            }
            result += str.charAt(i+1);
        }
        return result;
    }
    public String[] removeExtremes(String[] arr) {
        if(arr.length==0) return null;
        String[] newArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArr, (s1, s2) -> s1.length() - s2.length());

        int minLen = newArr[0].length();
        int maxLen = newArr[newArr.length - 1].length();
        boolean min=false;
        boolean max=false;

        ArrayList<String> list = new ArrayList<>();

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()==minLen && min==false){
                min=true;
            }
            else if(arr[i].length()==maxLen && max==false){
                max=true;
            }else{
                list.add(arr[i]);
            }
        }

        Collections.reverse(list);
        return list.stream().toArray(String[]::new);

    }

    public int[] reverseArr(int[] arr){
//        if(arr.length==0) return new int[] {};
//        else if(arr.length==1) return new int[]{arr[0]};
//        else{
//            int[] newArr = new int[arr.length];
//            newArr[newArr.length-1] = arr[0];
//            arr = Arrays.copyOfRange(arr, 1, arr.length);
//            System.arraycopy(reverseArr(arr), 0, newArr, 0, arr.length);
//            return newArr;
//        }
        if(arr.length==0) return new int[] {};
        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        int[] dest = new int[head.length + tail.length];
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(tail, 0, dest, head.length, tail.length);
        return dest;
    }

    public String readVertically(String[] arr) {
        int maxLength = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();
        String result = "";
        for(int i=0;i<maxLength;i++){
            for(int j=0;j<arr.length;j++){
                try{
                    result += arr[j].charAt(i);
                }catch (StringIndexOutOfBoundsException e){
                }

            }
        }
        /*
            "hello"
            "world"
            "nice"
            "hi"
         */
        return result;
    }

    public boolean superIncreasing(int[] arr){
        int[] newArr;
        for(int i=arr.length-1;i>0;i--){
            newArr = Arrays.copyOfRange(arr, 0, i);
            if(arr[i]<=Arrays.stream(newArr).sum()) return false;
        }
        return true;

//        if(arr.length == 0) return false;
//        int sum = arr[0];
//
//        for(int i = 1; i < arr.length; i++) {
//            if(arr[i] <= sum) {
//                return false;
//            }
//            sum = sum + arr[i];
//        }
//        return true;
    }

    public Integer modulo(int num1, int num2) {
        if(num2 ==0 ) return null;
        else if(num1==0) return 0;
        else{
            while(num1>=num2){
                num1 -= num2;
            }
            return num1;
        }
    }

    public boolean isIsogram(String str) {
//        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
//        long cnt=0;
//        boolean result=true;
//        for(int i=0;i<arr.length;i++){
//            int finalI = i;
//            cnt=str.toLowerCase().chars().filter(c->c==arr[finalI]).count();
//            if(cnt>=2) {
//                result=false;
//                break;
//            }
//        }
//        return result;

        if(str.length()==0) return true;
        HashMap<Character, String> cache = new HashMap<>();
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(cache.containsKey(str.charAt(i))){
                return false;
            }
            cache.put(str.charAt(i), "Exists");
        }
        return true;
    }
    public String computeSquareRoot(int num) {
        return String.format("%.2f", sqrt(num));
    }

    public double sqrt(int num){
        double x = 10;
        for (int i = 0; i < 10; i++) {
            x = 0.5 * (num / x + x);
        }
        return x;
    }

    public int numberSearch(String str) {
        double sum = str.chars().filter(c -> Character.isDigit(c))
                        .map(c->Character.getNumericValue(c)).sum();
        long len = str.chars().filter(c -> !Character.isDigit(c) && c!=' ')
                .count();
        return (int) Math.round(sum / len);
    }

    public boolean checkBoundary(char c){
        if(c>=97 && c<=122) return true;
        else return false;
    }
    public String decryptCaesarCipher(String str, int secret) {
        String result = "";
        for(char c:str.toCharArray()){
            if(c!=' '){
                char newChar= (char) (c-secret);
                if(!checkBoundary(newChar)){
                    newChar+=26;
                }
                result+=newChar;
            }else{
                result+=c;
            }
        }
        return result;
    }

    public String compressString(String str) {
        String result = "";
        if(str.length()==0) return result;

        char[] arr = str.toCharArray();
        int cnt=0;
        char tmp = arr[0];


        for(int i=0;i<str.length();i++){
            if(arr[i]==tmp) cnt++;
            else{
                if(cnt>=3){
                    result+=+cnt+""+tmp;
                }else{
                    for(int j=0;j<cnt;j++){
                        result+=tmp;
                    }
                }
                tmp = arr[i];
                cnt=1;
            }
        }

        //마지막 요소
        if(cnt>=3){
            result+=+cnt+""+tmp;
        }else{
            for(int j=0;j<cnt;j++){
                result+=tmp;
            }
        }

        return result;
    }

    public int largestProductOfThree(int[] arr) {
        Arrays.sort(arr);
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                cnt++;
            }
        }

        if(cnt>=2 && cnt!=arr.length){
            return arr[0] * arr[1] * arr[arr.length - 1];
        }


        return arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
    }

    /*
        2 1 5 4 3
        1 2 4 3 5
        1 2 3 4 5


     */
    public int[] bubbleSort(int[] arr) {
        int tmp=0;
        boolean isSorted=true;
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=tmp;
                    isSorted=false;
                }
            }
            if(isSorted) return arr;
        }
        return arr;
    }

    //
    /*
        num=5  0 1 1 2 3 5
        dp = {0,1, , , }
     */
    public int fibonacci(int num){
        if(num==0 || num==1) return num;
        int[] dp = new int[num+1];
        dp[0]=0;
        dp[1]=1;
        return fibo(num, dp);
    }

    public int fibo(int num,int[] dp){
        if(num==0 || num==1|| dp[num]>0) return dp[num];
        else return dp[num]=fibo(num - 1,dp) + fibo(num - 2,dp);
    }

    public boolean isSubsetOf(int[] base, int[] sample) {
        ArrayList<Integer> baseList = (ArrayList<Integer>) Arrays.stream(base).boxed().collect(Collectors.toList());
        boolean isSubset=true;
        for(int i=0;i<sample.length;i++){
            if(!baseList.contains(sample[i])){
                isSubset=false;
                return isSubset;
            }
        }
        return isSubset;
    }

    //거듭제곱 구하기
    public long power(int base, int exponent) {
        int result=1;
        for(int i=0;i<exponent;i++){
            if(result>=94906249) result=result%94906249;
            result*=base;
        }
        if(result>=94906249) result=result%94906249;
        return result;
    }

    public long power2(int base, int exponent){
        //재귀함수로 동작합니다.
        //exponent변수가 0이 될때까지 재귀를 돈 이후, 나머지 연산을 계산하고,
        //해당 결과값을 사용하여 홀수일 경우 다시 연산하여 리턴합니다.
        if(exponent == 0) return 1;

        int half = exponent / 2;
        long temp = power(base, half);
        long result=(temp*temp)%94906249;

        if(exponent%2==1) return (base*result)%94906249;
        else return result;
    }
    /*
                   1
               2       3
           4     5  7
       6
        */
    public ArrayList<String> dfs(tree node) {
        ArrayList<String> result = new ArrayList<>();
        result.add(node.getValue());

        if(node.getChildrenNode()!=null){
            for(int i=0;i<node.getChildrenNode().size();i++){
                ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
                result.addAll(curList);
            }
        }
        return result;
    }

    public ArrayList<String> bfs(tree node) {
        ArrayList<String> result = new ArrayList<>();
        Queue<tree> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            tree curr = q.poll();
            result.add(curr.getValue());
            if(curr.getChildrenNode()!=null){
                for(int i=0;i<curr.getChildrenNode().size();i++){
                    q.add(curr.getChildrenNode().get(i));
                }
            }
        }
        return result;
    }



    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }

    /*
        (ab))
     */

    public boolean balancedBrackets(String str){
        if(str.length()==0) return true;
        String[] arr = str.split("");
        String s = "";
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(")")){
                if(stack.isEmpty()) return false;
                while(!stack.peek().equals("(")){
                    s=stack.pop();
                    if(s.equals("[")||s.equals("]")||s.equals("{")||s.equals("}")) return false;
                }
                stack.pop();
            }else if(arr[i].equals("]")){
                if(stack.isEmpty()) return false;
                while(!stack.peek().equals("[")){
                    stack.pop();
                    if(s.equals("{")||s.equals("}")||s.equals("(")||s.equals(")")) return false;

                }
                stack.pop();
            }else if(arr[i].equals("}")){
                if(stack.isEmpty()) return false;
                while(!stack.peek().equals("{")){
                    stack.pop();
                    if(s.equals("[")||s.equals("]")||s.equals("(")||s.equals(")")) return false;

                }
                stack.pop();
            }
            else{
                stack.add(arr[i]);
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    /*
        2Xn 보드에 타일을 놓는 방법
        1,2로 n을 만드는 가지수.

     */
    public int tiling(int num) {//피보나치
        int[] dp = new int[num + 1];
        dp[0]=1;
        dp[1]=1;
        return dfs(dp, num);
    }

    public int dfs(int[] dp, int num){
        if(dp[num]>0) return dp[num];
        else return dp[num] = dfs(dp, num - 1) + dfs(dp, num - 2);
    }

    public int rotatedArraySearch(int[] rotated, int target) {
        int lt=0;
        int rt = rotated.length - 1;

        while(lt<=rt){
            int mid = (lt + rt) / 2;
            if(rotated[mid]==target) return mid;
            else if(rotated[lt]<rotated[mid]){
                if(target < rotated[mid] && rotated[lt]<=target){
                    rt = mid - 1;
                }else{
                    lt = mid + 1;
                }
            }else{
                if(target<=rotated[rt] && rotated[mid]<target){
                    lt=mid+1;
                }else{
                    rt=mid-1;
                }
            }
        }
        return -1;

    }

    public ArrayList<String> powerSet(String str) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            set.add(Character.toString(str.charAt(i)));
        }
        ArrayList<String> target = new ArrayList<>();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            target.add(it.next());
        }
        target.sort(Comparator.naturalOrder());

        ArrayList<String> result = new ArrayList<>();
        dfs(target, target.size(),0,result,new boolean[target.size()]);
        result.sort(Comparator.naturalOrder());
        return result;
    }
    public void dfs(ArrayList<String> target, int n,int k, ArrayList<String> result, boolean[] visited){
        if(k==n){
            String r = "";
            for(int i=0;i<n;i++){
                if(visited[i]) r += target.get(i);
            }
            result.add(r);
            return;
        }
        visited[k]=false;
        dfs(target, n,k + 1, result, visited);
        visited[k]=true;
        dfs(target, n,k + 1, result, visited);
    }

    public int orderOfPresentation(int N, int[] K) {
        //발표 순서를 담는 변수
        int order = 0;

        boolean[] isUsed = new boolean[N + 1];

        for (int i = 0; i < K.length; i++) {
            int num = K[i];
            isUsed[num]=true;
            boolean[] candidates=Arrays.copyOfRange(isUsed, 1,num);
            int validCnt=0;
            for(boolean candidate:candidates){
                if(!candidate) validCnt++;
            }
            int formerCnt = validCnt * factorial(N - i - 1);
            order = order + formerCnt;
        }

        return order;

    }
    public int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Sol s = new Sol();
        System.out.println(s.orderOfPresentation(3, new int[]{2,3,1}));

    }

}
