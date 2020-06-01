<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.io.*" %>    
<%@ page import="java.net.*" %>    
<%@ page import="java.nio.charset.*"%>
<%@ page import="org.xml.sax.*" %>    
<%-- json-20180130.jar 라이브러리 필요 --%>
<%@ page import="org.json.*"%>
<% 
    request.setCharacterEncoding("UTF-8");
    
    //절대경로 확인
    String path = request.getContextPath(); 
    
    String pageStart_ = request.getParameter("pageStart");
    String pageCount_ = request.getParameter("maxResults");
    
    if (pageStart_== null || pageCount_== null) {
        pageStart_ = "1";
       pageCount_ = "10";
    }
    
    int pageCount = Integer.parseInt(pageCount_);
    int pageStart = Integer.parseInt(pageStart_);
   	
    String key = request.getParameter("book_key");
    String value = request.getParameter("book_value");
    
    if (value == null) {
        key = "";
        value = "";
    }
    
    String str = String.format(
    "http://book.interpark.com/api/search.api?key=7F02945A8E0D731BED5FF398D523FECB607FD3331AF4A91AEE19FF93D23884E6&query=%s&queryType=%s&maxResults=%s&inputEncoding=utf-8&output=json&start=%s",
    URLEncoder.encode(value, "UTF-8"), key, pageCount, pageStart);
    
    URL url = new URL(str);
    JSONTokener tokener = new JSONTokener(url.openStream());
    JSONObject json = new JSONObject(tokener);
 	System.out.println(json.toString());
    out.write(json.toString());
    
%>
 
