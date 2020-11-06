package servs;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;

public class Prod extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("Product Information<br>");
        String n =request.getParameter("prodname");
        String b=request.getParameter("barcode");
        String c=request.getParameter("color");
        String d=request.getParameter("description");

        out.println("<br> product name: " + n +" <br> barcode: " +b+ "<br> color: "+c+"<br> description: "+d);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodlist", "root", "1012");
 
            PreparedStatement ps = con.prepareStatement("insert into prod values('"+n+","+b+","+c+","+d+")");
            
 
            int i = ps.executeUpdate();
            if (i > 0)
            out.println("Product registered successfully");
          
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
}
