package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.DepartmentModel;
import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
    
	@GetMapping("/dept")
	public String getAddDepartment(){
		return "add-department";	
		}
	
	@PostMapping("/save-dept")
	public String saveDepartment(DepartmentModel dept,RedirectAttributes redirectAttributes){
		System.out.println("Values"+dept);
		
		departmentService.saveDept(dept);
		System.out.println("dept service");
		redirectAttributes.addFlashAttribute("msg", "Department saved succesfully");
		return "redirect:/dept";
	}
	
	@GetMapping("/all-dept")
	public String getAllDepartment(Model model)
{
		
 List<DepartmentModel> allDepartment = departmentService.getAllDepartment();
 model.addAttribute("dept",allDepartment);
 
 System.out.println("All dept"+allDepartment);
	return "list-dept";
		}
	@GetMapping("/delete-dept/{id}")
	public String deleteDepartment(@PathVariable Integer id,RedirectAttributes redirectAttributes){
		System.out.println("delete"+id);
		
		departmentService.deleteDepartment(id);
		redirectAttributes.addFlashAttribute("msg", "Deleted successfully");
		return "redirect:/all-dept";
		
	}
	@GetMapping("/update-dept/{id}")
	public String updateDepartment(@PathVariable Integer id, Model model){
		System.out.println("update"+id);
		
		DepartmentModel deptById = departmentService.getDeptById(id);
		System.out.println("---"+deptById);
		
		//departmentService.saveDept(id);
		model.addAttribute("dept", deptById);
		return "update-dept";
		
		
	}
	@PostMapping("/update-dept")
	public String update(DepartmentModel dept){
		System.out.println("--"+dept);
		departmentService.saveDept(dept);
		return "redirect:all-dept";
		
	}
}
