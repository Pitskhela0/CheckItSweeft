import java.util.*;

public class MakeScienceTogether {

    public static int singleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();

        // we keep elements as key and their amount as value in map
        for (int number : nums){
            if(map.containsKey(number)){
                map.replace(number,2);
            }
            else
                map.put(number,1);
        }

        // iterate once more on entry set and return the value
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }

        // if not a single element throws exception
        throw new IllegalArgumentException("Not a single element in nums array");
    }

    static int minSplit(int amount){
        int res = 0;
        int[] tetris = new int[]{50,20,10,5};

        for (int coin : tetris) {
            while(amount/coin > 0){
                amount-=coin;
                res++;
            }
        }
        return res+amount;
    }

    static int notContains(int[] array){
        Set<Integer> set = new HashSet<>();

        for(int num : array)
            set.add(num);

        int count = 1;

        while(true){
            if(!set.contains(count)){
                return count;
            }
            count++;
        }
    }

    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;

        StringBuilder st = new StringBuilder();

        while (i >= 0 && j >= 0){
            int num1 = Character.getNumericValue(a.charAt(i));
            int num2 = Character.getNumericValue(b.charAt(j));
            st.insert(0,num1 ^ num2 ^ carry);
            carry = (num1 & num2) | (num1 & carry) | (num2 & carry);
            i--;
            j--;
        }

        if(carry == 0){
            if(i == j)
                return st.toString();
            else if(i > j){
                while( i >= 0){
                    int num = Character.getNumericValue(a.charAt(i));
                    st.insert(0,num);
                    i--;
                }
            }
            else {
                while(j >= 0){
                    int num = Character.getNumericValue(b.charAt(j));
                    st.insert(0,num);
                    j--;
                }
            }
        }
        else{
            if(i == j){
                st.insert(0,1);
                return st.toString();
            }
            else if(i > j){
                while(i >= 0){
                    int num = Character.getNumericValue(a.charAt(i));
                    st.insert(0,num ^ carry);
                    carry = num & carry;
                    i--;
                }
                if(carry > 0){
                    st.insert(0,1);
                }
            }
            else{
                while(j >= 0){
                    int num = Character.getNumericValue(b.charAt(j));
                    st.insert(0,num ^ carry);
                    carry = num & carry;
                    j--;
                }
                if(carry > 0){
                    st.insert(0,1);
                }
            }
        }
        return st.toString();
    }

    // one way is recursion which is really easy to understand but not really fast
    // so down there is another function that does exactly same thing

    int countVariants(int staresCount){
        if(staresCount==0 || staresCount==1)
            return 1;

        return countVariants(staresCount-1)+countVariants(staresCount-2);
    }

    // better with loop instead of recursion to save memory
    int countVariants1(int staresCount){
        if (staresCount == 0 || staresCount == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= staresCount; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}

