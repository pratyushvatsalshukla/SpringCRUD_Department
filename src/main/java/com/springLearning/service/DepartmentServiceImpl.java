package com.springLearning.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springLearning.entity.Department;
import com.springLearning.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository ;

	@Override
	public Department saveDepartment(Department department) {
		Department save = departmentRepository.save(department) ;
		return save;
		
	}

	@Override
	public java.util.List<Department> getDepartments() {
		
		java.util.List<Department> findAll = departmentRepository.findAll() ;
		return findAll ;
	}

	@Override
	public Department fetchDepartmentById(Long id) {
		Department department = departmentRepository.findById(id).get() ;
		return department;
	}

	@Override
	public void deleteDepartmentById(Long id) {
		try {
			
			departmentRepository.deleteById(id);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Department updateDepartment(Department department, Long id) {
		try {
			
			Department departmentOld = departmentRepository.findById(id).get() ;
			departmentOld.setDepartmentAddress(department.getDepartmentAddress());
			departmentOld.setDepartmentCode(department.getDepartmentCode());
			departmentOld.setDepartmentName(department.getDepartmentName());
			Department save = departmentRepository.save(departmentOld);
			return save ;
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			return department ; 
		}
	}

	@Override
	public Department getDepartmentByDepartmentName(String departmentName) {
		Department departmentByName = departmentRepository.findByDepartmentName(departmentName) ;
		return departmentByName;
	}

}
