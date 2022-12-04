//package com.example.vp_a4.web.servlet;
//
//import com.example.vp_a4.service.CategoryService;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.NoSuchBeanDefinitionException;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.MessageSourceResolvable;
//import org.springframework.context.NoSuchMessageException;
//import org.springframework.core.ResolvableType;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.Resource;
//import org.springframework.web.context.WebApplicationContext;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.context.WebEngineContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Set;
//
//
//@WebServlet(name="thymeleaf-category-servlet", urlPatterns = "/servlet/thymeleaf/category")
//public class ThymeleafCategoryServlet extends HttpServlet {
//
//    private final CategoryService categoryService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ThymeleafCategoryServlet(CategoryService categoryService, SpringTemplateEngine springTemplateEngine) {
//        this.categoryService = categoryService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        WebContext context = new WebContext(req,resp,req.getServletContext());
//        context.setVariable("ipAddress",req.getRemoteAddr());
//        context.setVariable("clientAgent",req.getHeader("User-Agent"));
//        context.setVariable("categories",categoryService.listCategories());
//        this.springTemplateEngine.process("categories.html", context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String categoryName = (String)req.getParameter("name");
//        String categoryDesc = (String) req.getParameter("description");
//        categoryService.create(categoryName,categoryDesc);
//        resp.sendRedirect("/servlet/thymeleaf/category");
//    }
//
//}
