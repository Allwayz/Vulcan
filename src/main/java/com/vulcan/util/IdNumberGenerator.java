package com.vulcan.util;

import java.util.*;

public class IdNumberGenerator {
    /**
     * 生成身份证号
     * @return
     */
    public static String GenerateID_Number(){
        StringBuilder GenerateID_Number = new StringBuilder();
        GenerateID_Number.append(randomAreaCode());
        GenerateID_Number.append(randomBirthday());
        GenerateID_Number.append(randomCode());
        String temp = GenerateID_Number.toString();
        GenerateID_Number.append(CheckCode(temp));
        System.out.println(GenerateID_Number.toString());
        return GenerateID_Number.toString();
    }

    public static final Map<String, Integer> areaCode = new HashMap<String, Integer>();
    static {//可根据自己的需求放入需要的行政编码
        IdNumberGenerator.areaCode.put("钦南区", 450702);
        IdNumberGenerator.areaCode.put("钦北区", 450703);
        IdNumberGenerator.areaCode.put("灵山县", 450721);
        IdNumberGenerator.areaCode.put("浦北县", 450722);
        IdNumberGenerator.areaCode.put("贵港市", 450800);
        IdNumberGenerator.areaCode.put("市辖区", 450801);
        IdNumberGenerator.areaCode.put("港北区", 450802);
        IdNumberGenerator.areaCode.put("港南区", 450803);
        IdNumberGenerator.areaCode.put("覃塘区", 450804);
        IdNumberGenerator.areaCode.put("平南县", 450821);
        IdNumberGenerator.areaCode.put("桂平市", 450881);
        IdNumberGenerator.areaCode.put("玉林市", 450900);
        IdNumberGenerator.areaCode.put("市辖区", 450901);
        IdNumberGenerator.areaCode.put("玉州区", 450902);
        IdNumberGenerator.areaCode.put("容　县", 450921);
        IdNumberGenerator.areaCode.put("陆川县", 450922);
        IdNumberGenerator.areaCode.put("博白县", 450923);
        IdNumberGenerator.areaCode.put("兴业县", 450924);
        IdNumberGenerator.areaCode.put("北流市", 450981);
        IdNumberGenerator.areaCode.put("百色市", 451000);
        IdNumberGenerator.areaCode.put("市辖区", 451001);
        IdNumberGenerator.areaCode.put("右江区", 451002);
        IdNumberGenerator.areaCode.put("田阳县", 451021);
        IdNumberGenerator.areaCode.put("田东县", 451022);
        IdNumberGenerator.areaCode.put("平果县", 451023);
        IdNumberGenerator.areaCode.put("德保县", 451024);
        IdNumberGenerator.areaCode.put("靖西县", 451025);
        IdNumberGenerator.areaCode.put("那坡县", 451026);
        IdNumberGenerator.areaCode.put("凌云县", 451027);
        IdNumberGenerator.areaCode.put("乐业县", 451028);

    }


    /**
     * 生成随机地区
     * @return
     */
    public static int randomAreaCode() {
        int index = (int) (Math.random() * IdNumberGenerator.areaCode.size());
        Collection<Integer> values = IdNumberGenerator.areaCode.values();
        Iterator<Integer> it = values.iterator();
        int i = 0;
        int code = 0;
        while (i < index && it.hasNext()) {
            i++;
            code = it.next();
        }
        return code;
    }

    /**
     * 生成随机生日
     * @return
     */
    public static String randomBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 60) + 1950);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        return builder.toString();
    }


    public static String randomCode() {
        int code = (int) (Math.random() * 1000);
        if (code < 10) {
            return "00" + code;
        } else if (code < 100) {
            return "0" + code;
        } else {
            return "" + code;
        }
    }

    /**
     * 生成校验码
     * @param input
     * @return
     */
    public static String CheckCode(String input){
        char[] charArray = input.toCharArray();
        int[] ID_Array = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++)
        {
            ID_Array[i] = charArray[i] - '0';
        }
        double Sum = 0;
        int count = 0;
        for (int i = 0; i < ID_Array.length; i++)
        {
            double Wi = Math.pow(2, 18 - (i + 1)) % 11;
            Sum += Wi * ID_Array[i];
            count++;
        }
        double CheckCode = (12 - Sum % 11) % 11;
        int i = (int) CheckCode;

        if(i == 10){
            return "x";
        }else{
            String CC;
            return CC = String.valueOf(i);
        }
    }
}
