package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author CHEN YANJIN
 * @date 2022/6/15 10:04
 */
@RestController
@RequestMapping("alpha")
public class AlphaController {

    @RequestMapping("/hello")
    //@ResponseBody
    public String sayHello(){
        return "Hello spring boot";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            String header = request.getHeader(element);
            System.out.println(element +": "+ header);
        }
        System.out.println(request.getParameter("code"));

        //返回数据
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GET请求
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id){
        return "a student";
    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    //@ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    //响应html
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","lisa");
        mav.addObject("age",45);
        mav.setViewName("/demo/view");
        return mav;
    }
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","福井大学");
        model.addAttribute("age","110");
        return "/demo/view";
    }
    

}
