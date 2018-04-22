package com.design.lease.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Random;

public class GeneratorUtils {

    private static final String LH = "LH";

    private static final String LO = "LO";

    public static String generatorOrderNo(Long uid){
        StringBuffer sb = new StringBuffer();
        sb.append(DateUtils.getReqDateyyyyMMddHHmmss(new Date()));
        sb.append(LO);
        sb.append(uid);
        sb.append(random());
        return sb.toString();
    }

    public static String generatorHouseNo(){
        StringBuffer sb = new StringBuffer();
        sb.append(LH);
        sb.append(DateUtils.getReqDateyyyyMMdd(new Date()));
        sb.append(random());
        return sb.toString();
    }

    /**
     * 获取5位随机数
     * @return
     */
    public static String random(){
        Random random = new Random();
        return StringUtils.leftPad(String.valueOf(random.nextInt(100000)),5,'0');
    }

    public static void main(String[] args){
        System.out.println(GeneratorUtils.generatorHouseNo());
        System.out.println(GeneratorUtils.generatorOrderNo(100023L));
    }

}
