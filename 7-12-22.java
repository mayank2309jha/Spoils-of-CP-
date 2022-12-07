package com.code;

import java.util.*;

public class Main {
    //A boring string is a string where all teh letters are same.
    //We have to find the length of the longest boring string that occurs more than once.

    /**
     Examples input:-
     4
     3
     aaa
     3
     abc
     5
     bcaca
     6
     caabaa
     Example output:-
     2
     0
     1
     2
     */
    public static void creation(ArrayList<ArrayList<Integer>> a){
        for(int i=0;i<26;i++){
            ArrayList<Integer> toAdd = new ArrayList<>();
            a.add(toAdd);
        }
    }
    public static void print(ArrayList<ArrayList<Integer>> a){
        for(int i=0;i<26;i++){
            System.out.println(a.get(i).size()+" is the size at this index i.e, "+i);
            for(int item: a.get(i)){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }
    public static int getSecondHighest(ArrayList<Integer> a){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0;i<a.size();i++){
            if(a.get(i) > max){
                max = a.get(i);
                maxIndex = i;
            }
        }
        a.set(maxIndex,Integer.MIN_VALUE);
        max = Integer.MIN_VALUE;
        for(int item: a){
            if(item> max){
                max = item;
            }
        }
        return max;
    }
    public static int getBoringStrings(ArrayList<ArrayList<Integer>> a){
        int max = Integer.MIN_VALUE;
        for(ArrayList<Integer> item: a){
            if(item.size()>1){
                int answer = getSecondHighest(item);
                if(answer> max){
                    max = answer;
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(input.nextLine());
            String string = input.nextLine();
            char[] stringArray = string.toCharArray();
            int[] longestSubstring = new int[n];
            //This array stores the length of the longest boring substring starting at that position.
            //Now we will make an arraylist of arraylists of length 26 which will stores all the longest
            // boring substrings starting with the letters according to their appropriate indices.
            ArrayList<ArrayList<Integer>> a = new ArrayList<>();
            creation(a);

            longestSubstring[n-1] = 1;
            a.get(stringArray[n-1]-97).add(1);

            for(int j=n-2;j>=0;j--){
                int index = stringArray[j]-97;
                if(stringArray[j] == stringArray[j+1]){
                    longestSubstring[j] = longestSubstring[j+1]+1;
                }
                else{
                    longestSubstring[j] = 1;
                }
                a.get(index).add(longestSubstring[j]);
            }
            //print(a);
            int answer = getBoringStrings(a);
            ans.add(answer);
        }
        for(int item: ans){
            System.out.println(item);
        }
    }
}
