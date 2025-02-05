package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.CreateDepartmentDao();
		
		System.out.println("\n====== Test 1: department findById ======");
		Department dep = depDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n====== Test 2: department findAll ======");
		List<Department> allDepartments = depDao.findAll();
		allDepartments.forEach(System.out::println);
		
		System.out.println("\n====== Test 3: department insert ======");
		Department newDep = new Department(null, "Games");
		depDao.insert(newDep);
		System.out.println("Inserted! new id = " + newDep.getId());
		
		System.out.println("\n====== Test 4: department update ======");
		dep.setName("Foods");
		depDao.update(dep);
		System.out.println(dep);
		
		System.out.println("\n====== Test 5: department deleteById ======");
		System.out.print("Enter id to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		depDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
	}

}
