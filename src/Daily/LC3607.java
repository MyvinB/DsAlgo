package Daily;

import java.util.*;

public class LC3607 {

    static class DSU{
        int[] parent;
        DSU(int size){
            parent = new int[size];
            for(int i =1;i<=size;i++){
                parent[i] = i;
            }
        }
        private int find(int x){
            return parent[x]==x?x:find(parent[x]);
        }

        private void join(int u,int v){
            parent[find(v)]=find(u);
        }
    }





    public static void main(String[] args) {

    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c+1);
        for(int[] con: connections){
            dsu.join(con[0],con[1]);
        }
        Boolean[] online = new Boolean[c+1];
        int[] offline = new int[c+1];
        Arrays.fill(online,true);
        HashMap<Integer,Integer> onlineStation = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        //Marking offline stations
        for(int[] q: queries){
            int op = q[0];
            int st = q[1];
            if(op==2){
                online[st] = false;
                offline[st]++;
            }
        }

        //Iter through all the stations and find minimum Online stations
        for(int i=1;i<=c;i++){
            int root = dsu.find(i);
            if(!onlineStation.containsKey(root)){
                onlineStation.put(root,-1);
            }
            int station = onlineStation.get(root);
            if(online[i]){
                if(station == -1 ||station>i){
                    onlineStation.put(root,i);
                }
            }
        }


        //Iter from the back of the queries
        for(int i=queries.length-1;i>=0;i--){
            int op = queries[i][0];
            int x = queries[i][1];
            int station = onlineStation.get(x);
            int root = dsu.find(x);
            if(op==1){
                if(online[x]){
                    ans.add(x);
                }else{
                    ans.add(station);
                }
            }
            if(op==2){
                if(offline[x]>1){
                    offline[x]--;
                }
                else{
                    online[x] = true;
                    if(station == -1 || station>x){
                        onlineStation.put(root,x);
                    }
                }
            }
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
