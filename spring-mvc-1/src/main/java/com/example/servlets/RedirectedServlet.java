package com.example.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 1:26 PM
 **/
@WebServlet("/redirected")
public class RedirectedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ما پارامتر "name" را با یک مقدار در هر دو مورد ارسال کردیم. به زبان ساده، درخواست‌های ارسال‌شده همچنان دارای این مقدار هستند، اما درخواست‌های هدایت‌شده این مقدار را ندارند.
//این به این دلیل است که، با تغییر مسیر، شی درخواست با نمونه اصلی متفاوت است. اگر همچنان می خواهیم از این پارامتر استفاده کنیم، باید آن را در شی HttpSession ذخیره کنیم.


//        درخواست به منبع دیگری هدایت می شود
//مشتری بعد از تغییر مسیر، تغییر URL را مشاهده خواهد کرد
//یک درخواست جدید ایجاد می شود
//تغییر مسیر معمولاً در الگوی توسعه وب Post/Redirect/Get استفاده می شود
        PrintWriter out=response.getWriter();
        out.write("In redirected servlet page.");
        out.write("\nWelcome:" + request.getParameter("name"));
    }
}
