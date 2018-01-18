package others.down;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lewis on 2016/10/20.
 */
public class DownLoad {

    public static CloseableHttpClient httpClient = HttpClients.custom().build();

    public static String downloadHtml(String url) {

        CloseableHttpResponse response = null;
        BufferedReader br=null;
        HttpGet httpGet = new HttpGet(url);

        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            InputStreamReader isr = new InputStreamReader(entity.getContent(),"gb2312");

            StringBuilder stringBuilder =new StringBuilder();
            br =new BufferedReader(isr);
            String line =null;
            while((line=br.readLine())!=null){
                stringBuilder.append(line+'\n');
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void downloadPict(PictMsg pictMsg,int count) {
        String url=pictMsg.getUrl();
        CloseableHttpResponse response;
        OutputStream out = null;
        InputStream in=null;
        BufferedReader br=null;
        byte buffer[] = new byte[1024];
        if(url!=null){
            try {
                HttpGet httpGet = new HttpGet(url);
                response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                in = entity.getContent();
                CreateDir("D:\\youmzi"+File.separator+pictMsg.getHeadline());
                String suffix;
                if(url.charAt(url.length()-1)=='g') {
                    suffix=".jpg";
                }
                else{
                    suffix=".gif";
                }
                System.out.print("正在下载："+"D:\\youmzi"+File.separator+pictMsg.getHeadline()+File.separator+count+suffix+":");
                out = new FileOutputStream(new File("D:\\youmzi"+File.separator+pictMsg.getHeadline()+File.separator+count+suffix));
                int index=0;
                while((index=in.read(buffer))!=-1){
                    out.write(buffer,0,index);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (br!=null){
                        br.close();
                    }
                    if(out!=null){
                        out.close();
                    }
                    if(in!=null){
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void downloadPict(ArrayList<PictMsg> Pict_link){

        for(int i = 0;i< Pict_link.size();i++){
            // Main.print(Pict_link.get(i));
            if(Pict_link.get(i)!=null)
                DownLoad_All_PictSoruce(Pict_link.get(i));
        }
        Pict_link.clear();
    }

    public static void CreateDir(String dir){
        File file = new File(dir);
        if(!file.exists()){
            file.mkdir();
        }
    }

    public static void DownLoad_All_PictSoruce(PictMsg pictMsg){
        ArrayList<String> All_Pict_Soruce = new ArrayList<String>();
        String  url =pictMsg.getUrl();
        All_Pict_Soruce.add(url);

        while(Find_Link.Add_Page_Link(url,All_Pict_Soruce)){     //通过循环一直找到最后一个页面
            url=All_Pict_Soruce.get(All_Pict_Soruce.size()-1);
        }

        for(int i =0;i<All_Pict_Soruce.size();i++){
            //Main.print(Pict_down_Soruce(All_Pict_Soruce.get(i)));
            if(All_Pict_Soruce.get(i)!=null){
                String link=Pict_down_Soruce(All_Pict_Soruce.get(i));
                if(!Main.set.contains(link)) {
                    downloadPict(new PictMsg(link, pictMsg.getHeadline()), i);
                    System.out.println("一共有："+All_Pict_Soruce.size()+","+"还剩下："+(All_Pict_Soruce.size()-i));
                    Main.set.add(link);
                }
            }
        }
        All_Pict_Soruce.clear();
    }

    public static String Pict_down_Soruce(String url){
        String context = DownLoad.downloadHtml(url);
        String pa;
        Pattern r;
        Matcher m ;
        pa="<img src='(.+?)' alt=";
        r= Pattern.compile(pa);
        m = r.matcher(context);
        if(m.find(0)){
            return m.group(1);
        }
        return null;
    }
}




