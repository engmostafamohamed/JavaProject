<%@page import="com.mysql.jdbc.Driver,java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Manage Service</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,700,800" rel="stylesheet">

        <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/ionicons.min.css">

        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/jquery.timepicker.css">


        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/icomoon.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a href="index.jsp" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="services.jsp" class="nav-link">Services</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="portfolio.jsp" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Portfolio</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown04">
                                <a class="dropdown-item" href="portfolio.jsp">Portfolio</a>
                                <a class="dropdown-item" href="portfolio-single.jsp">Portfolio Single</a>
                            </div>
                        </li>
                        <li class="nav-item"><a href="blog.jsp" class="nav-link">Case Studies</a></li>
                        <li class="nav-item active"><a href="contact.jsp" class="nav-link">Contact</a></li>
                        <li class="nav-item cta"><a href="contact.jsp" class="nav-link"><span>Get in touch</span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <div class="hero-wrap js-fullheight">
            <div class="overlay"></div>
            <div id="particles-js"></div>
            <div class="container">
                <div class="row no-gutters slider-text align-items-center justify-content-center" data-scrollax-parent="true">
                    <div class="col-md-6 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">
                        <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.jsp">Home</a></span> <span>Contact</span></p>
                        <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Register Page</h1>
                    </div>
                </div>
            </div>
        </div>

        <section class="ftco-section contact-section ftco-degree-bg">
            <div class="container bg-light">

                <div class="row block-9">
                    <div class="col-md-6 pr-md-5">
                        <%
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolsdb", "hr", "hr");
                                Statement st = conn.createStatement();
                                String sql = "select * from services order by SERVICE_ID";
                                ResultSet rs = st.executeQuery(sql);
                                if (rs.next()) {
                                    String serviceName = rs.getString("SERVICE_NAME");
                                    String serviceDescription = rs.getString("SERVICE_DESC");
                                    String serviceIcon = rs.getString("SERVICE_ICON");
                        %>
                        <table cellpadding="10" border="1" width="100%">
                            <tr>
                                <td width="100%">
                                    <img src="images/servicesPhotos/<%= serviceIcon%>" width="40%" height="40%" /><br>
                                    <strong><font size="4"><b>Service Name:</b></font></strong><%= serviceName%><br>
                                    <strong> <font size="4"><b>Service Description:</b></font></strong><%= serviceDescription%>
                                </td>
                            </tr>
                            <%
                                while (rs.next()) {
                                    serviceName = rs.getString("SERVICE_NAME");
                                    serviceDescription = rs.getString("SERVICE_DESC");
                                    serviceIcon = rs.getString("SERVICE_ICON");

                            %>
                            <tr>
                                <td width="100%">
                                    <img src="images/servicesPhotos/<%= serviceIcon%>" width="40%" height="40%" /><br>
                                    <strong><font size="4"><b>Service Name:</b></font></strong><%= serviceName%><br>
                                    <strong> <font size="4"><b>Service Description:</b></font></strong><%= serviceDescription%>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <%        
                                } else {
                                    out.println("<strong><font color='red'> No Data Found</font></strong>");
                                }
                            } catch (ClassNotFoundException e) {
                                response.sendRedirect("manageService.jsp?msg=Database Not Found");
                            } catch (SQLException e) {
                                response.sendRedirect("manageService.jsp?msg=SQL Error");
                            }
                        %>

                    </div>
                    <div class="col-md-6 pr-md-5">
                        <form action="manageServiceAction" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Service Name" name="service_name" required="required">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Service Discription" name="service_description">
                            </div>

                            <div class="form-group">
                                <input type="file" class="form-control" name="service_icon" >
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Add New Service" class="btn btn-primary py-3 px-5">
                            </div>
                            <%        
                                if (request.getParameter("msg") != null) {%>
                            <font color="blue"> <strong><%= request.getParameter("msg")%> </strong> </font>
                            <%
                                }
                            %>
                        </form>

                    </div>

                </div>
            </div>
        </section>


        <footer class="ftco-footer ftco-bg-dark ftco-section">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Snipp.</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Quick Links</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">Home</a></li>
                                <li><a href="#" class="py-2 d-block">About</a></li>
                                <li><a href="#" class="py-2 d-block">Services</a></li>
                                <li><a href="#" class="py-2 d-block">Portfolio</a></li>
                                <li><a href="#" class="py-2 d-block">Contact</a></li>
                                <li><a href="#" class="py-2 d-block">Privacy</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Contact Information</h2>
                            <ul class="list-unstyled">
                                <li><a href="#" class="py-2 d-block">198 West 21th Street, Suite 721 New York NY 10016</a></li>
                                <li><a href="#" class="py-2 d-block">+ 1235 2355 98</a></li>
                                <li><a href="#" class="py-2 d-block">info@yoursite.com</a></li>
                                <li><a href="#" class="py-2 d-block">email@email.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md">
                        <div class="ftco-footer-widget mb-4">
                            <ul class="ftco-footer-social list-unstyled float-md-left float-lft">
                                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.animateNumber.min.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.timepicker.min.js"></script>
        <script src="js/particles.min.js"></script>
        <script src="js/particle.js"></script>
        <script src="js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="js/google-map.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>