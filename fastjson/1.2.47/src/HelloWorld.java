// 导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.alibaba.fastjson.JSON;


// 扩展 HttpServlet 类
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {

    }

    String charReader(HttpServletRequest request) throws Exception {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        return wholeStr;
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        String jsonstr = request.getParameter("jsona");

        out.println(jsonstr);

        JSON.parseObject(jsonstr);

    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");

        String jsonstr = request.getParameter("json");
        out.println(jsonstr);
        JSON.parseObject(jsonstr);

//        try {
//            String body = charReader(request);
//            out.println(body);
//            JSON.parseObject(body);
//        }catch (Exception e){
//            out.println(e);
//        }


    }

    public void destroy()
    {
        // 什么也不做
    }
}