package com.springLearning.service;

import com.springLearning.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	java.util.List<Department> getDepartments();

	Department fetchDepartmentById(Long id);

	void deleteDepartmentById(Long id);

	Department updateDepartment(Department department, Long departmentId);

	Department getDepartmentByDepartmentName(String departmentName);

}
