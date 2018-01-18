package others.down;
public class PictMsg {
    private String url;
    private String headline;

    public PictMsg(String url, String headline) {
        this.url = url;
        this.headline = headline;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return "网址："+url+"标题："+headline;
    }
}  