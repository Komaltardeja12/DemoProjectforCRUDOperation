package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class DemoController {
	@Autowired
	private EmployeeService employeeService;
	@Value("${server.port:8082}")
    private String serverPort;
	@GetMapping("/")
	public String home(){
		System.out.println("Welcome controller"+serverPort);
		return "home";
	}

	@GetMapping("/getEmployee")
	public String insertEmployee(){
		System.out.println("Data can be inserted..");
		return "employee";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@PathVariable Integer id,Employee employee,RedirectAttributes redirectAttributes){
		System.out.println("Employee details updated..");
		
		redirectAttributes.addFlashAttribute("msg", "Details are updated succesfully");
		employeeService.updateEmployee(employee);
		
		
		return "redirect:getEmployee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee, Model model,RedirectAttributes redirectAttributes){
		System.out.println("Save details"+employee);
		
		//employee.setAddress();
		employeeService.saveEmployee(employee);
		redirectAttributes.addFlashAttribute("msg", "Details are saved");
		return "redirect:/";
	}
	
	@GetMapping("/getEmployee-Details")
	public String getAllEmployees(Model model){
		
		System.out.println("Get all employee");
		List<Employee> allEmployee = employeeService.getAllEmployee();
		model.addAttribute("employees", allEmployee);
		//model.addAttribute("employee", newEmployee());
		System.out.println("get details"+allEmployee);
		return "all-employee";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id){
		System.out.println("----------->"+id);
		employeeService.deleteEmployeeById(id);
		return "redirect:/getEmployee-Details";
		
	}
	
	@GetMapping("/update/{id}")
	public String updateEmployee(@PathVariable Integer id,Model model){
		System.out.println("Update employee"+id);
		Employee employeeById = employeeService.getEmployeeById(id);
		System.out.println("Employee-"+employeeById);
		model.addAttribute("employee",employeeById);
		return "update-employee";
	}
	@PostMapping("/updateEmployee")
	public String updateEmp(Employee employee){
		
		System.out.println("employee details---->"+employee);
		
		employeeService.updateEmployee(employee);
		return "redirect:/getEmployee-Details";
	}
	
	
}
