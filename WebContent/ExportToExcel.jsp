  <%@ page import="java.io.PrintWriter" %>
<%@ page contentType="application/excel" language="java" %>
 
<%
    
    response.reset();
    response.setHeader("Content-type","application/xls");
 
     
    String fileName =  request.getParameter("fileName");
    response.setHeader("Content-disposition","inline; filename=" + fileName+".xls");
 
    PrintWriter op = response.getWriter();
    String data = request.getParameter("tableHTML");
    if (data == null)
    {
        data="NO DATA";
    }
    if (fileName == null)
{
    data="NO FILE NAME SPECIFIED";
}
 
op.write(data);
%>