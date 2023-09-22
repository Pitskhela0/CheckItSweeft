import java.util.*;

public class MyStruct<T>{
    // we will use hashmap since it uses hashing and remove and put is basicly O(1) time complexity
    // and we use arraylist since several ops are O(1) ,

    private List<T> list = new ArrayList<>();
    private Map<T , Integer> map = new HashMap<>();

    private int pointer = 0;
    private int size = 0;

    public void insert( T element){
        list.add(pointer,element);
        map.put(element,pointer);
        pointer++;
        size++;
    }

    public boolean remove(T element){
        try{
            int index = map.get(element);

            int lastIndex = size-1;

            T lastElement = list.get(lastIndex);

            // remove element from map
            map.remove(element);
            // swap last element to removed index
            map.put(lastElement,index);
            //
            list.set(index,lastElement);

            // remove last element is O(1) because it starts traversing from closest end
            list.remove(lastIndex);

            pointer--;
            size--;

            return true;
        }
        catch (Exception ignored){
            return false;
        }
    }

    public String toString(){
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < list.size()-1; i++) {
            st.append(list.get(i)).append(",");
        }
        st.append(list.get(list.size()-1));
        return st.toString();
    }

}
