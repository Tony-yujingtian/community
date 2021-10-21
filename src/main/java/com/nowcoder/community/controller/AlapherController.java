package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlapherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/Alapher")
public class AlapherController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Springboot.";
    }

    @Autowired
    public AlapherService alapherService;

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {return alapherService.find();}

    @RequestMapping("/http")
    public void http (HttpServletRequest request, HttpServletResponse response) {
        //请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
        System.out.println(request.getParameter("code"));
        //响应数据
        response.setContentType("text/html;charset = utf-8");
        try (
                PrintWriter writer = response.getWriter();
                ){

            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  /student?current = 1 & limit = 20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudets(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                              @RequestParam(name = "limit",required = false,defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "someStudent";

    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age","12");
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name","CSU");
        model.addAttribute("age",19);
        return "demo/view";
    }

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp() {
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",12);
        emp.put("salary",8000.00);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",12);
        map.put("salary","8000");
        list.add(map);
        map = new HashMap<>();
        map.put("name","李四");
        map.put("age",11);
        map.put("salary","8000");
        list.add(map);
        map = new HashMap<>();
        map.put("name","三七");
        map.put("age",15);
        map.put("salary","8000");
        list.add(map);
        return list;
    }
}
