package cn.xxx.order.utils;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class StringUtils{

    /**
     * 生成订单号
     * @return
     */
    public static String createOrderNumber(){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        String result = date+"00001000"+getTwo()+"00"+seconds+getTwo();
        return result;
    }

    /**
     * * 产生随机的2位数
     * * @return
     * */
    public static String getTwo(){
        Random rad=new Random();
        String result  = rad.nextInt(100) +"";
        if(result.length()==1){
            result = "0" + result;
        }
        return result;
    }

    // 读取文件
    public static String readFileOfTxt(String path) {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            Resource resource = new ClassPathResource(path);
            is = resource.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String data = null;
            while((data = br.readLine()) != null) {
                sb.append(data);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                isr.close();
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return sb.toString();
    }



}