package Topics.DSU;

import java.util.ArrayList;
import java.util.List;

public class LC3600 {

    class DSU{

        int[] parent;
        int[] rank;
        int components;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int findParent(int x){
            if(parent[x]==x){
                return x;
            }
            return parent[x] = findParent(parent[x]);
        }

        public boolean union(int x, int y){
            int x_parent = findParent(x);
            int y_parent = findParent(y);

            if(x_parent==y_parent) return false;

            if(rank[x_parent]>rank[y_parent]){
                parent[y_parent] = x_parent;
            }else if(rank[x_parent]<rank[y_parent]){
                parent[x_parent] = y_parent;
            }else{
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
            return true;
        }
    }

    private boolean check(int n, int[][] edges, int k, int mid){
        DSU dsu = new DSU(n);
        List<int[]> upgradeCandidates = new ArrayList<>();

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if(m==1){
                if(s<mid){
                    return false;
                }
                dsu.union(u,v);
            }else{
                if(s>=mid){
                    dsu.union(u,v);
                }else if(s*2>=mid){
                    upgradeCandidates.add(new int[]{u,v});
                }
            }
        }

        for(int[] edge: upgradeCandidates){
            int u = edge[0];
            int v = edge[1];
            //if they have the same parents there is no need of upgrade just discard them
            if(dsu.findParent(u)!=dsu.findParent(v)){
                if(k<=0){
                    return false;
                }
                dsu.union(u,v);
                k--;
            }
        }

        int root = dsu.findParent(0);
        for(int node =1 ;node<n;node++){
            if(dsu.findParent(node)!=root){
                return false;
            }
        }
        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {
        //Check for cycle


        //If cyclic it is not a spanning tree we need to return -1;
        DSU dsu = new DSU(n);
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];
            //Only checking for one if m==0 we can remvoe the edge
            if(m==1){
                if(dsu.findParent(u)==dsu.findParent(v)){
                    return -1;
                }
                dsu.union(u,v);
            }
        }

        int res = -1;
        int l = 1;
        int r = (int)2e5;
        int result = -1;
        while(l<=r){
            int mid = l+ (r-l)/2;
            if(check(n,edges,k,mid)){
                result = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return result;
    }
}
