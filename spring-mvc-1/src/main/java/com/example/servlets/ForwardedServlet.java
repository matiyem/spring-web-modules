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
 * Time: 12:59 PM
 **/
@WebServlet("/forwarded")
public class ForwardedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //در اینجا ریکوِست از طریق forward شدن dispach میشود
        //از طریق کلاس HelloServlet این عملیات انجام میشود
        //برای مشاهده فرق بین redirect و forward است
        //وقتی یک صفحه forward میشود url آن تغییر نمیکند و به url صفحه اصلی باقی میماند

        //درخواست بیشتر در سمت سرور پردازش خواهد شد
        //مشتری تحت تأثیر فوروارد قرار نمی گیرد، URL در مرورگر یکسان می ماند
        //اشیاء درخواست و پاسخ پس از فوروارد کردن همان شیء باقی خواهند ماند. اشیاء محدوده درخواست همچنان در دسترس خواهند بود
        PrintWriter out= res.getWriter();
        out.write("In forwarded servlet page.");
        out.write("\nwelcome:" + req.getParameter("name"));
    }
}
