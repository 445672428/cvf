package others.down;
import java.util.ArrayList;
import java.util.regex.Pattern;
import  java.util.regex.Matcher;

/**
 * Created by lewis on 2016/10/20.
 */
public class Find_Link {



    public static boolean Add_Page_Link(String Context, ArrayList<String> Page_link) {
        String link=null;
        String fa="<a href=(['\"]?)(?!http)((?!js|css)[^\"' \\r\\n])+\\1>下一页";
        Pattern r= Pattern.compile(fa);
        Matcher m = r.matcher(DownLoad.downloadHtml(Context));
        if (m.find(0)) {
            link = m.group();
            String pa = "<a href='(.+?)'>下一页";
            r = Pattern.compile(pa);
            m = r.matcher(link);
            if (m.find(0)) {
                link = m.group(1);
                if (!link.equals("#") && link != null&&!Main.set.contains(link)) {
                    Main.set.add(link);
                    Page_link.add("http://www.99mm.me/" + link);                     //获得捕获组1，一共2个组，被匹配的字符算一个组
                }
            }
        }
        return m.find(0)&&(!link.equals("#"))&&link!=null;
    }

    public static void Add_Pict_Link(String Context,ArrayList<PictMsg> Pict_link) {
        String pa;
        Pattern r;
        Matcher m ;
        pa="<a href=\"(.+?)\" title=\"(.+?)\" target=\"_blank\">(.+?)<\\/a>";
        r= Pattern.compile(pa);
        m = r.matcher(DownLoad.downloadHtml(Context));
        while(m.find()) {
            String url=m.group(1);
            String head=m.group(2);
            if(!Main.set.contains(url)){
                Pict_link.add(new PictMsg(url,head));
                Main.set.add(url);
            }
        }
    }

}
