package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.CreateSellerDao();
		
		System.out.println("===== Test 1: seller findById =====");
		Seller sell = sellerDao.findById(3);
		System.out.println(sell);
		
		System.out.println();
		System.out.println("===== Test 2: seller findByDepartment =====");
		Department dep = new Department(1, "Computers");
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		
		sellerList.forEach(System.out::println);
		
	}

}
