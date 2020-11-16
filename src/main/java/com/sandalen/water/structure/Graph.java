package com.sandalen.water.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
    private Long V;
    private LinkedList<Integer>[] adj;
    private boolean[] visited;
    private List<List<String>> result;
    private Map<Integer,String> idAndStation;

    public Graph(Long V,List<List<Long>> data,Map<Integer,String> idAndStation){
        this.V = V;
        this.idAndStation = idAndStation;

        int num = Math.toIntExact(V);
        adj = new LinkedList[num+1];
        visited = new boolean[num+1];

        for(int i = 0;i < num + 1;i++){
            adj[i] = new LinkedList<>();
        }

        for(List<Long> d : data){
            int source = Math.toIntExact(d.get(0));
            int dest = Math.toIntExact(d.get(1));
            addEdge(source,dest);
        }

        result = new ArrayList<>();
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    public void dfs(int v,List<String> paths){
        visited[v] = true;
        paths.add(idAndStation.get(v));

        if(adj[v].size() == 0){
            List<String> tmp = new ArrayList<>(paths);
            result.add(tmp);
            visited[v] = false;
            paths.remove(paths.size() - 1);
            return;
        }

        for(int w : adj[v]){
            if(!visited[w]){
                dfs(w,paths);
            }

        }

        visited[v] = false;
        paths.remove(paths.size() - 1);
    }

    public List<List<String>> getResult() {
        return result;
    }

    public void setResult(List<List<String>> result) {
        this.result = result;
    }
}
