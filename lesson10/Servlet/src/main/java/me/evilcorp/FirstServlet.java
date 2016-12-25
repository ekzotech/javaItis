package me.evilcorp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ekzotech on 05.12.16.
 */
public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<p> Hello! </p>");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
