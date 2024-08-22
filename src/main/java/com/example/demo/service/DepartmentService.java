package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DepartmentModel;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository deptrepo;

	public DepartmentModel saveDept(DepartmentModel dept){
		return deptrepo.save(dept);
		
	}

	public List<DepartmentModel>getAllDepartment(){
		return deptrepo.findAll();
	}
	public void deleteDepartment(Integer id){
		deptrepo.deleteById(id);
	}

	public DepartmentModel getDeptById(Integer id){
		return deptrepo.findById(id).get();
		
	}
	
	
	
}
