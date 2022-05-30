package springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springdemo.dao.CustomerDAO;
import springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the custome dao
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get customer from dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		// add the customer to the model
		theModel.addAttribute("customer",theCustomers);
		// 
		return "list-customers";
	}
}
