package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mysql.jdbc.Driver;
import java.sql.*;

public final class manageService_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <title>Manage Service</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,700,800\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/open-iconic-bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/animate.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/aos.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/ionicons.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.timepicker.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/flaticon.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/icomoon.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light\" id=\"ftco-navbar\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">Home</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#ftco-nav\" aria-controls=\"ftco-nav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"oi oi-menu\"></span> Menu\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"ftco-nav\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                        <li class=\"nav-item\"><a href=\"index.jsp\" class=\"nav-link\">Home</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"about.jsp\" class=\"nav-link\">About</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"services.jsp\" class=\"nav-link\">Services</a></li>\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"portfolio.jsp\" id=\"dropdown04\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Portfolio</a>\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdown04\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"portfolio.jsp\">Portfolio</a>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"portfolio-single.jsp\">Portfolio Single</a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\"><a href=\"blog.jsp\" class=\"nav-link\">Case Studies</a></li>\n");
      out.write("                        <li class=\"nav-item active\"><a href=\"contact.jsp\" class=\"nav-link\">Contact</a></li>\n");
      out.write("                        <li class=\"nav-item cta\"><a href=\"contact.jsp\" class=\"nav-link\"><span>Get in touch</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- END nav -->\n");
      out.write("\n");
      out.write("        <div class=\"hero-wrap js-fullheight\">\n");
      out.write("            <div class=\"overlay\"></div>\n");
      out.write("            <div id=\"particles-js\"></div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row no-gutters slider-text align-items-center justify-content-center\" data-scrollax-parent=\"true\">\n");
      out.write("                    <div class=\"col-md-6 ftco-animate text-center\" data-scrollax=\" properties: { translateY: '70%' }\">\n");
      out.write("                        <p class=\"breadcrumbs\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\"><span class=\"mr-2\"><a href=\"index.jsp\">Home</a></span> <span>Contact</span></p>\n");
      out.write("                        <h1 class=\"mb-3 bread\" data-scrollax=\"properties: { translateY: '30%', opacity: 1.6 }\">Register Page</h1>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <section class=\"ftco-section contact-section ftco-degree-bg\">\n");
      out.write("            <div class=\"container bg-light\">\n");
      out.write("\n");
      out.write("                <div class=\"row block-9\">\n");
      out.write("                    <div class=\"col-md-6 pr-md-5\">\n");
      out.write("                        ");

                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolsdb", "admin", "admin");
                                Statement st = conn.createStatement();
                                String sql = "select * from services order by SERVICE_ID";
                                ResultSet rs = st.executeQuery(sql);
                                if (rs.next()) {
                                    String serviceName = rs.getString("SERVICE_NAME");
                                    String serviceDescription = rs.getString("SERVICE_DESC");
                                    String serviceIcon = rs.getString("SERVICE_ICON");
                        
      out.write("\n");
      out.write("                        <table cellpadding=\"20\" border=\"1\" width=\"100%\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td width=\"100%\">\n");
      out.write("                                    <img src=\"images/services/");
      out.print( serviceIcon);
      out.write("\"  /><br>\n");
      out.write("                                    Service Name:");
      out.print( serviceName);
      out.write("<br>\n");
      out.write("                                    Service Description:");
      out.print( serviceDescription);
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                while (rs.next()) {
                                    serviceName = rs.getString("SERVICE_NAME");
                                    serviceDescription = rs.getString("SERVICE_DESC");
                                    serviceIcon = rs.getString("SERVICE_ICON");

                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td width=\"100%\">\n");
      out.write("                                    <img src=\"images/services/");
      out.print( serviceIcon);
      out.write("\"  /><br>\n");
      out.write("                                    Service Name:");
      out.print( serviceName);
      out.write("<br>\n");
      out.write("                                    Service Description:");
      out.print( serviceDescription);
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                        ");
        
                                } else {
                                    System.out.println("<font color='red'> No Data Found</font>");
                                }
                            } catch (ClassNotFoundException e) {
                                response.sendRedirect("manageService.jsp?msg=Database Not Found");
                            } catch (SQLException e) {
                                response.sendRedirect("manageService.jsp?msg=SQL Error");
                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 pr-md-5\">\n");
      out.write("                        <form action=\"manageServiceAction\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Service Name\" name=\"service_name\" required=\"required\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Service Discription\" name=\"service_description\">\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"file\" class=\"form-control\" name=\"service_icon\" >\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"submit\" value=\"Add New Service\" class=\"btn btn-primary py-3 px-5\">\n");
      out.write("                            </div>\n");
      out.write("                            ");
        
                                if (request.getParameter("msg") != null) {
      out.write("\n");
      out.write("                            <font color=\"blue\"> <strong>");
      out.print( request.getParameter("msg"));
      out.write(" </strong> </font>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"ftco-footer ftco-bg-dark ftco-section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row mb-5\">\n");
      out.write("                    <div class=\"col-md\">\n");
      out.write("                        <div class=\"ftco-footer-widget mb-4\">\n");
      out.write("                            <h2 class=\"ftco-heading-2\">Snipp.</h2>\n");
      out.write("                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md\">\n");
      out.write("                        <div class=\"ftco-footer-widget mb-4\">\n");
      out.write("                            <h2 class=\"ftco-heading-2\">Quick Links</h2>\n");
      out.write("                            <ul class=\"list-unstyled\">\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">Home</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">About</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">Services</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">Portfolio</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">Contact</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">Privacy</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md\">\n");
      out.write("                        <div class=\"ftco-footer-widget mb-4\">\n");
      out.write("                            <h2 class=\"ftco-heading-2\">Contact Information</h2>\n");
      out.write("                            <ul class=\"list-unstyled\">\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">198 West 21th Street, Suite 721 New York NY 10016</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">+ 1235 2355 98</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">info@yoursite.com</a></li>\n");
      out.write("                                <li><a href=\"#\" class=\"py-2 d-block\">email@email.com</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md\">\n");
      out.write("                        <div class=\"ftco-footer-widget mb-4\">\n");
      out.write("                            <ul class=\"ftco-footer-social list-unstyled float-md-left float-lft\">\n");
      out.write("                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-twitter\"></span></a></li>\n");
      out.write("                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-facebook\"></span></a></li>\n");
      out.write("                                <li class=\"ftco-animate\"><a href=\"#\"><span class=\"icon-instagram\"></span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12 text-center\">\n");
      out.write("\n");
      out.write("                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n");
      out.write("                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class=\"icon-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\n");
      out.write("                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- loader -->\n");
      out.write("        <div id=\"ftco-loader\" class=\"show fullscreen\"><svg class=\"circular\" width=\"48px\" height=\"48px\"><circle class=\"path-bg\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke=\"#eeeeee\"/><circle class=\"path\" cx=\"24\" cy=\"24\" r=\"22\" fill=\"none\" stroke-width=\"4\" stroke-miterlimit=\"10\" stroke=\"#F96D00\"/></svg></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.easing.1.3.js\"></script>\n");
      out.write("        <script src=\"js/jquery.waypoints.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.stellar.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("        <script src=\"js/aos.js\"></script>\n");
      out.write("        <script src=\"js/jquery.animateNumber.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datepicker.js\"></script>\n");
      out.write("        <script src=\"js/jquery.timepicker.min.js\"></script>\n");
      out.write("        <script src=\"js/particles.min.js\"></script>\n");
      out.write("        <script src=\"js/particle.js\"></script>\n");
      out.write("        <script src=\"js/scrollax.min.js\"></script>\n");
      out.write("        <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false\"></script>\n");
      out.write("        <script src=\"js/google-map.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
