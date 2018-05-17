package com.muntian.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Respond to user request</h1>");
        writer.println("<h2>Request method: </h2>" + "<p>" +req.getMethod() + "</p>");
        writer.println("<h2>Request headers:</h2>");

        Enumeration<String> headersName = req.getHeaderNames();
        while (headersName.hasMoreElements()) {
            String headerName = headersName.nextElement();
            writer.println("<p>Header: " + headerName + " value: " + req.getHeader(headerName) + "</p>");
        }

        writer.println("<h2>Request URI: " + req.getRequestURI() + "</h2>");
        writer.println("<h2>Request parameters:<h2>");
        for (Map.Entry<String, String[]> entry : req.getParameterMap().entrySet()){
            writer.println("<p>Parameter name: " + entry.getKey() + "</p>");
            writer.println("<p>Parameter value: " + Arrays.toString(entry.getValue()) + "</p>");

        }
        writer.println("<h2>QueryString:<h2>");
        writer.println("<p> " + req.getQueryString() + " </p>");
    }
}
