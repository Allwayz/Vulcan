package com.vulcan.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringToArrayUtil {
    public static ArrayList<String> StringToArray(String inputString,String delim){
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString,delim,false);
        while (stringTokenizer.hasMoreTokens()){
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

}