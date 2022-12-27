package com.example.demo11;

import java.io.*;

import jakarta.servlet.http.*;


public class HelloServlet extends HttpServlet {
    static final String TEMPLATE = "<html>" +  //в виде константы добавляем шаблон HTML
            "<head><title>com.example.homeWork1</title></head>" + //идет HTML-документ, далее %s-определенный
            "<body><h1>Hello, %s</h1></body></html>"; // модификатор от String.format() для конкатенации строки
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException { //переопределяем метод
        //doPost чтобы наши данные не было видно в корне
        String name = req.getParameter("name"); //создаем переменную для обращения к request вызываем getParameter
        // и по названию параметра в эту переменную получаем значение в виде строки

        resp.setContentType("text/html"); //для response устанавливаем тип контента - текст/html
        PrintWriter printWriter = resp.getWriter(); //пишем данные (в нашем случае текст) в переменную
        printWriter.println(String.format(TEMPLATE, name)); //и выводим клиенту на экран

    }
}