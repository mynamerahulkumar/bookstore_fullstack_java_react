package com.book.bookstoreonline.utils;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath74Ms {
    public String getSimplePath(String path){
        /**
         * a -count // then remove from index
         * b-split into array
         */
       path= path.replaceAll("//","/");
       path=path.trim();

        List<String>paths= List.of(path.split("/"));

        System.out.println(path);

        int n=paths.size();
        List<String> resList=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<paths.size();i++){
//            System.out.println(paths.get(i)+"-"+i);
//            System.out.println(paths.get(i).equals("..")+"-"+i);
            String p=paths.get(i);
            if(cnt-1>=0 && paths.get(i).equals("..")){
                System.out.println(paths.get(i)+"-"+i);
                resList.remove(cnt-1);
                cnt--;
                continue;

            }
             if(paths.get(i).length()>=1 && !paths.get(i).equals("..")&& !paths.get(i).equals(".")){
              String  resPath="/"+paths.get(i);
                 resList.add(resPath);
                 cnt++;
            }

        }
        if(resList.size()==0){
            String   resPath="/";
            return  resPath;

        }
        String res="";
        for(int i=0;i<resList.size();i++){
            res+=resList.get(i);
        }
        return res;

    }
    public static void main(String[] args) {
        SimplifyPath74Ms path74Ms=new SimplifyPath74Ms();
        String path = "/a/./b/../../c/";
      String res=  path74Ms.getSimplePath(path);
        System.out.println("result-"+res);

    }
}
