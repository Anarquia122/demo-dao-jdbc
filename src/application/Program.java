package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.CreateSellerDao();
		
		System.out.println("===== Test 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("===== Test 2: seller findByDepartment =====");
		Department dep = new Department(1, "Computers");
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		
		sellerList.forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("===== Test 3: seller findAll =====");
		List<Seller> allSellers = sellerDao.findAll();
		
		allSellers.forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("===== Test 4: seller insert =====");
		Seller newSeller = new Seller(null, "Kratos", "godofemail@email.com", new Date(), 20000.00, new Department(1, null));
		//sellerDao.insert(newSeller);
		
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		
		System.out.println();
		System.out.println("===== Test 5: seller update =====");
		seller.setName("Thomas Wayne");
		sellerDao.update(seller);
		
		System.out.println(seller);
	}

}
