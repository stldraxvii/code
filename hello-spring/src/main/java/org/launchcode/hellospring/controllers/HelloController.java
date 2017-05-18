package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


/**
 * Created by Matt on 5/15/2017.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String createMessage() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language' />" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Japanese'>Japanese</option>" +
                "<option value='Korean'>Korean</option>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public static String createMessage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        HashMap<String, String> hello = new HashMap<>();
        hello.put("English", "Hello ");
        hello.put("Spanish", "Hola ");
        hello.put("French", "Bonjour ");
        hello.put("Japanese", "Konichiwa ");
        hello.put("Korean", "Annyong ");

        if (name == ""){
            name = "World";
        }
        return hello.get(language) + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public static String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");

        if (name == ""){
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
