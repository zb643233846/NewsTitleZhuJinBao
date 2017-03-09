package application;

/**
 * Created by LX-PC on 2017/2/27.
 */

public class VideoURL {
   public static String getVideoURL(String type,int startpager,int pager){

       String  url="http://c.3g.163.com/nc/video/list/"+type+"/n/"+startpager+"-"+pager+".html";

      return  url;
   }

}
