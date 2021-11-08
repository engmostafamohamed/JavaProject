/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import static org.apache.commons.fileupload.FileUploadBase.CONTENT_TYPE;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.mysql.jdbc.Driver;
/**
 *
 * @author Eng.mostafa
 */
public class ManageServiceAction extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        if(session.getAttribute("id") == null){
            response.sendRedirect("login.jsp");
            return;
        }
        
        String serviceName = "";
        String serviceDescription = "";
        String servicePhotoPath = "";
        // int companyId = Integer.parseInt(session.getAttribute("companyId").toString());
        
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
                if(isMultiPart){
            ServletFileUpload upload = new ServletFileUpload();
            try{
                FileItemIterator itr = upload.getItemIterator(request);
                while(itr.hasNext()){
                    FileItemStream item = itr.next();
                    if(item.isFormField()){
                        // Do field spesefic process
                        String fieldName = item.getFieldName();
                        InputStream is = item.openStream();
                        byte[] b = new byte[is.available()];
                        is.read(b);
                        String value = new String(b);
                        
                        if(fieldName.equals("service_name")){
                            serviceName = value;
                        }
                        else if(fieldName.equals("service_description")){
                            serviceDescription = value;
                        }
                    }
                    else{
                        // Do file upload spesefic process
                        servicePhotoPath = getServletContext().getRealPath("/") + File.separator + "images" + File.separator + "servicesPhotos";
                        
                        // Call a method to upload a file
                        UploadFile fileUpload = new UploadFile();
                        if(fileUpload.processFile(servicePhotoPath, item)){
                            // Rename the uploaded file
                            File file = new File(servicePhotoPath + File.separator + item.getName());
                            // Rename the uploaded file
                            Calendar calendar = Calendar.getInstance();
                            // 2020_04_30_19_11_05_500_desert.jpg
                            String newFileName = calendar.get(Calendar.YEAR) + "_" + calendar.get(Calendar.MONTH) + "_" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + calendar.get(Calendar.HOUR) + "_" + calendar.get(Calendar.MINUTE) + "_" + calendar.get(Calendar.SECOND) + "_" + calendar.get(Calendar.MILLISECOND) + "_" + item.getName();
                            file.renameTo(new File(servicePhotoPath + File.separator + newFileName));
                            
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                String databaseName = "schoolsdb";
                                String dbURL = "jdbc:mysql://localhost:3306/" + databaseName;
                                String dbUserName = "hr";
                                String dbPassword = "hr";
                                Connection con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
                                Statement st1 = con.createStatement();
                                String sql = "INSERT INTO services(SERVICE_NAME, SERVICE_DESC, SERVICE_ICON) VALUES('" + serviceName + "', '" + serviceDescription + "', '" + newFileName + "')";
                                st1.executeUpdate(sql);
                                st1.close();
                                con.close();
                                response.sendRedirect("manageService.jsp?msg=sucsess");
                            }catch(ClassNotFoundException e1){
                                response.sendRedirect("manageService.jsp?msg=database not found");
                                return;
                            }catch(SQLException e2){
                                response.sendRedirect("manageService.jsp?msg=sql error");
                                return;
                            }
                        
                        }
                        else{
                            response.sendRedirect("manageService.jsp?msg=Could't upload file");
                            return;
                        }
                    }
                }
            }catch(FileUploadException fue){
                response.sendRedirect("manageService.jsp?msg=File uploade exception");
                return;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
