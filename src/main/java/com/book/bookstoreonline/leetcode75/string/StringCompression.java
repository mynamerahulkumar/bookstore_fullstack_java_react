package com.book.bookstoreonline.leetcode75.string;

public class StringCompression {
    public int compress(char[] chars) {
        String res="";
        int n=chars.length;
        int i=0;
        while(i<n){
            int k=i;
            int cnt=1;
            while(k<n-1 && chars[k]==chars[k+1]){
                cnt++;
                k++;
            }
            res+=chars[i];
            i=k+1;
            res+=cnt;
        }
        chars=res.toCharArray();
        int len=res.length();
        return len;
    }
    public static void main(String[] args) {
        char[]chr={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        StringCompression stringCompression=new StringCompression();
        stringCompression.compress(chr);
    }
}
