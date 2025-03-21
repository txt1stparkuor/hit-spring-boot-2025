package com.txt1stparkuor.buoi2btvn.controller;

import com.txt1stparkuor.buoi2btvn.entity.Employees;
import com.txt1stparkuor.buoi2btvn.repository.EmployeesRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesRepository employeesRepository;
    @GetMapping("/select")
    public String select(HttpServletRequest request){
        ArrayList<Employees> employees = (ArrayList<Employees>) employeesRepository.findAll();
        request.setAttribute("employees" , employees);
        return "index" ;
    }
    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "redirect:select" ;
    }
    @GetMapping("/insert")
    public String insert(@ModelAttribute Employees employees , HttpServletRequest request , HttpServletResponse response) {
        employeesRepository.save(employees)  ;
        System.out.println(employees.toString());
        return "redirect:/employees/select" ;
    }

    @GetMapping(value="/delete")
    public String delete(@RequestParam String id){
        Employees employees = new Employees() ;
        employees.setId(Integer.parseInt(id));
        employeesRepository.delete(employees);
        return "redirect:/employees/select" ;
    }
    @GetMapping(value= "/edit")
    public String edit(@RequestParam String id , RedirectAttributes attributes){
        Employees employees = new Employees() ;
        employees.setId(Integer.parseInt(id));
        Employees employeesById = employeesRepository.findById(Integer.parseInt(id)).get();
        attributes.addFlashAttribute("employeesByID" , employeesById) ;
        return "redirect:/employees/select" ;
    }
    @GetMapping(value = "/update")
    public String update(@ModelAttribute Employees employees){
        employeesRepository.save(employees)  ;
        return "redirect:/employees/select" ;
    }
    @PostMapping(value = "/deleteAll")
    public String deleteAll(@RequestParam( required = false) ArrayList<Integer> ids){
        if(ids != null) {
            for(int i =  0 ; i < ids.size() ; i++){
                Employees employees = new Employees() ;
                employees.setId(ids.get(i));
                employeesRepository.delete(employees);
            }
        }

        return "redirect:/employees/select" ;
    }
}
