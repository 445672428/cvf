package others.demo.dom;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DirtyWordsFilter implements Filter{

    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        // TODO Auto-generated method stub
        
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

}
//脏词过滤器
class DirtyWordHttpServletRequest extends HttpServletRequestWrapper{
    private String strs[] = {"猪","狗","毛"};
    public DirtyWordHttpServletRequest(HttpServletRequest request) {
        super(request);
        // TODO Auto-generated constructor stub
    }
    
}