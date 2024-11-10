package com.penguins.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.penguins.mvc.Models.Course;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CourseController{
    Map<Integer,Course> courses = new HashMap<Integer,Course>();

    @GetMapping("/courses")
    public ModelAndView getCourses() {
        Map<String,Object> model = new HashMap();
        model.put("coursesList",courses.values());
        return new ModelAndView("courses",model);
    }
    @GetMapping("/course")
    public String courseDetails(Model model,Integer Id,Integer action) {
        Course targetCourse = new Course(0, "", "", 0);
        if(Id != null && action != null)
            targetCourse = courses.get(Id);
        model.addAttribute("course", targetCourse);
        return "course";
    }

    /**
     * @param course
     * @return
     */
    @PostMapping("/postCourse")
    public String postCourse(Course course) {
        if(course.getId() > 0)
            courses.replace(course.getId(), course);
        else if(course.getId() == 0){
            Integer newId = 0;
            if(courses.size() == 0)
                newId = 1;
            else
                newId = Collections.max(courses.keySet()) + 1;
            course.setId(newId);
            courses.put(newId, course);
        }
            
        return "redirect:/courses";
    }
    
    

}