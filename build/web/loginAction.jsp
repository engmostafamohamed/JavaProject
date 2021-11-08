
<%@page import="com.mysql.jdbc.Driver ,java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>
<%
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    if(email==null||email.isEmpty()||password==null||password.isEmpty())
    {
        response.sendRedirect("login.jsp?msg=Please Enter Email And Password");
    }
    else{
        //connect to database
        try{
        System.out.println("Connection created");  
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connection closed"); 
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolsdb"," "," ");
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
%>
