package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // [status-line] 200
        response.setStatus(HttpServletResponse.SC_OK);
//        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 에러보내도 잘감~


        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        // [Header 편의 메서드 활용하기]
        content(response);
        cookie(response);
//        redirect(response);

        // [message body]
        PrintWriter writer = response.getWriter();
        // 아래 두 메서드 다 가능
        writer.write("Ok");
        writer.println("ok");

    }

    // 편의 메서드 1
    private void content(HttpServletResponse response) {
        // 1. 방법 1
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");

        // 2. 방법2 (위 아래가 같은 결과)
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(기본은 2고, 생략시 자동으로 계산하여 생성)
    }

    // 편의 메서드 2
    private void cookie(HttpServletResponse response) {
        // 1. 방법 1
        // Set-Cookie: myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        // 2. 방법 2 (위 아래가 같은 결과)
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    // 편의 메서드 3
    private void redirect(HttpServletResponse response) throws IOException {
        // 1. 방법 1
        // Status Code 302
        // Location: /basic/hello-form.html
        // response.setStatus(HttpServletResponse.SC_FOUND); //302
        // response.setHeader("Location", "/basic/hello-form.html");

        // 2. 방법 2 (위 아래가 같은 결과)
        response.sendRedirect("/basic/hello-form.html");
    }
}
