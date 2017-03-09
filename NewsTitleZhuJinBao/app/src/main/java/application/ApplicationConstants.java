package application;

/**
 * Created by LX-PC on 2017/2/20.
 */

public class ApplicationConstants {
    public static final String URL_PICTURE ="http://c.m.163.com/nc/article/headline/";
   public static String getURL(String title,int startPage,int  endPage){

       return String.valueOf(URL_PICTURE+title+"/"+startPage+"-"+endPage+".html");
   }
}
