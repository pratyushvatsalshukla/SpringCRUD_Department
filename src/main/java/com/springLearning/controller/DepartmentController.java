package com.springLearning.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springLearning.entity.Department;
import com.springLearning.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService ;
	
	@GetMapping("/departments")
	public java.util.List<Department> getDepartments() {
		return departmentService.getDepartments() ;
	}

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department) ;
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId) ;
	}
	
	@DeleteMapping("/departments/{id}")
	public String  deleteDepartmentById(@PathVariable Long id) {
		departmentService.deleteDepartmentById(id);
		return "Department Deleted SuccessFully" ;
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department, departmentId) ;
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		
		return departmentService.getDepartmentByDepartmentName(departmentName) ;
		
	}
	

	
}
