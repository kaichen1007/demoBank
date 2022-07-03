package astoyw.kai.demobank.tools;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {
    /**
     * 获取ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) {
                // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress="";
        }
        return ipAddress;
    }



    public static String MD5(String data)  {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;

    }

    /**
     * 随机验证码
     */
    public static String getRandomCode(int length){
        String sourceNum = "0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0 ;i<length;i++){
            stringBuilder.append(sourceNum.charAt(random.nextInt(9)));
        }
        return stringBuilder.toString();
    }

    /**
     * 返回当前时间戳
     */
    public static long getCurrentTimestamp(){
        return System.currentTimeMillis();
    }

    /**
     * 获取32位随机uuid
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-","").substring(0,32);
    }

    /**
     * 生成指定长度随机字母和数字
     *
     * @param length
     * @return
     */
    private static final String ALL_CHAR_NUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String getStringNumRandom(int length) {
        //生成随机数字和字母,
        Random random = new Random();
        StringBuilder saltString = new StringBuilder(length);
        for (int i = 1; i <= length; ++i) {
            saltString.append(ALL_CHAR_NUM.charAt(random.nextInt(ALL_CHAR_NUM.length())));
        }
        return saltString.toString();
    }


    /**
     * 响应前端json数据
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response,Object obj){

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        try(PrintWriter writer = response.getWriter()) {
            writer.print(objectMapper.writeValueAsString(obj));
            response.flushBuffer();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * 获取两个时间之间的全部日期
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat dateFormat1 = new SimpleDateFormat(fmt);
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }


    /**
     * 获取指定数量日期
     * @param num
     * @return
     */
    public static List<String> getDayByTow(int num){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = df.format(new Date().getTime()-1000*60*60*24*num);
        String endTime = df.format(new Date());
        List<String> days = getDays(startTime, endTime);
        return days;
    }

}
