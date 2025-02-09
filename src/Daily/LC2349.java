package Daily;

import java.util.*;

public class LC2349 {


    public static void main(String[] args) {

    }

    class NumberContainersNaive {

        HashMap<Integer,Integer> map = null;
        HashMap<Integer, TreeSet<Integer>> indexMap = null;

        public NumberContainersNaive() {
            map = new HashMap<>();
            indexMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if(map.containsKey(index)){
                int prevNumber = map.get(index);
                TreeSet<Integer> tempSet  = indexMap.get(prevNumber);
                tempSet.remove(index);
                indexMap.put(prevNumber,tempSet);
            }
            map.put(index,number);
            TreeSet<Integer> list  = indexMap.getOrDefault(number,new TreeSet<>());
            list.add(index);
            indexMap.put(number,list);
        }

        public int find(int number) {
            TreeSet<Integer> tempSet  = indexMap.getOrDefault(number,new TreeSet<>());
            if(tempSet.isEmpty()) return -1;
            return tempSet.first();
        }

//        public int findSmallestElem(List<Integer> list){
//            int min = Integer.MAX_VALUE;
//            for(int i=0;i<list.size();i++){
//                min = Math.min(list.get(i),min);
//            }
//            return min;
//        }
    }



    class NumberContainers {

        HashMap<Integer,Integer> map = null;
        HashMap<Integer, PriorityQueue<Integer>> indexMap = null;

        public NumberContainers() {
            map = new HashMap<>();
            indexMap = new HashMap<>();
        }

        public void change(int index, int number) {
            map.put(index,number);
            indexMap.computeIfAbsent(number,k-> new PriorityQueue<>()).add(index);
        }

        public int find(int number) {
            if(!indexMap.containsKey(number)) return -1;

            PriorityQueue<Integer> minHeap = indexMap.get(number);
            while(!minHeap.isEmpty()){

                int index = minHeap.peek();
                if(map.get(index)==number){
                    return index;
                }
                minHeap.poll();
            }
            return -1;
        }
    }
}
