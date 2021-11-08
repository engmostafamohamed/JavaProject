package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mysql.jdbc.Driver;
import java.sql.*;

public final class loginAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    String email=request.getParameter("email");
    String password=request.getParameter("password");
    if(email==null||email.isEmpty()||password==null||password.isEmpty())
    {
        response.sendRedirect("login.jsp?msg=Please Enter Email And Password");
    }
    else{
        //connect to database
        try{
        out.print("11111111111111111111");
        Class.forName("com.mysql.jdbc.Driver");
        out.print("11111111111111111111");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolsdb", "hr", "hr");
        Statement st=conn.createStatement();
        String sql="select * from users where email='"+email+"' and password='"+password+"'";
        ResultSet rs=st.executeQuery(sql);
        if(rs.next()){
            //put information user to database
            session.setAttribute("id",rs.getString("USER_ID"));
            session.setAttribute("firstName", rs.getString("FIRST_NAME"));
            session.setAttribute("lastName", rs.getString("LAST_NAME"));
            session.setAttribute("role", rs.getString("ROLE"));
            if(session.getAttribute("role").toString().equals("Admin"))
            {
                rs.close();
                st.close();
                conn.close();
                response.sendRedirect("admin.jsp?");
            }
        }
        else{
            rs.close();
            st.close();
            conn.close();
            response.sendRedirect("login.jsp?msg=Invalied Email and Password");
        }
        }        catch(ClassNotFoundException e){
            response.sendRedirect("login.jsp?msg=Database not found");
        }
        catch(SQLException e){
            response.sendRedirect("login.jsp?msg=Connection failed to database");
        }
        
    }

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
