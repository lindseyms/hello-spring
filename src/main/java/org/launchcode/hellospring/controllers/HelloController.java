package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    // handles requests at path/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // handles requests at hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form hello/?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello'>" + //submit request to /hello/hello
                            "<input type='text' name='name'>" +
                             "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @GetMapping("form2")
    public String helloForm2(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + //submit request to /hello/hello
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @GetMapping("exerciseForm")
    public String greetingForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='helloInChosenLanguage' method='post'>" + //submit request to /hello/exerciseForm
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='arabic'>Arabic</option>" +
                                "<option value='japanese'>Japanese</option>" +
                            "</select>"+
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @PostMapping("helloInChosenLanguage")
    public static String createMessage(@RequestParam String language, @RequestParam String name){
        String hello = "";
        if(language.equals("english")){
            hello = "Hello, ";
        } else if (language.equals("french")){
            hello = "Bonjour, ";
        } else if (language.equals("spanish")){
            hello = "Hola, ";
        } else if (language.equals("arabic")){
            hello = "Marhaba ";
        } else if (language.equals("japanese")){
            hello = "Konnichiwa ";
        }
        return hello + name;
    }


}
