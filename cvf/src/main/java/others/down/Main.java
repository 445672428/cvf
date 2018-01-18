package others.down;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static Set<String> set =null;
    public static void main(String[] args) {
        DownLoad.CreateDir("D:\\youmzi");                   //图片保存路径
        set = new HashSet<String>();
        ArrayList<String> Page_Link = new ArrayList<String>();
        ArrayList<PictMsg> Pict_Link =new ArrayList<PictMsg>();

        Page_Link.add("http://www.99mm.me/meitui/");
        Page_Link.add("http://www.99mm.me/xinggan/");
        Page_Link.add("http://www.99mm.me/qingchun/");//                 gif图
        Page_Link.add("http://www.99mm.me/hot/");

        while(Page_Link.size()>0){
            String url=Page_Link.get(0);
            Find_Link.Add_Page_Link(url,Page_Link);
            Find_Link.Add_Pict_Link(url,Pict_Link);
            DownLoad.downloadPict(Pict_Link);
            Page_Link.remove(0);
        }
    }
}

