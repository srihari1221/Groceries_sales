package com.hari.control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hari.entity.Customer;
import com.hari.entity.Items;
import com.hari.entity.Seller;
import com.hari.service.customer.ICustomerService;
import com.hari.service.item.IItemsService;
import com.hari.service.seller.ISellerService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;




@Controller
public class Control {
	private static Logger logger = LoggerFactory.getLogger(Control.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ICustomerService customerServie;
	@Autowired
	private ISellerService sellerService;
	@Autowired
	private IItemsService itemService;

	
	@GetMapping("/")
	public String home() {
		System.out.println("displaying home page");
		return "home";																																	
	}
	
	@GetMapping("/sample")
	public String sample() {
		System.out.println("displaying home page");
		return "sample";																																	
	}
	@GetMapping("/signin")
	public String singin(@ModelAttribute("customer") Customer customer) {
		return "signin_page";
	}
	@PostMapping("/signin")
	public String signInCust(@ModelAttribute("customer")Customer customer,Model model) {
		String result = customerServie.insertCustomer(customer);
		model.addAttribute("ResultMsg", result);
		return "confirmation_signup";
	}
	@GetMapping("/sellers_login")
	public String sellerLogin(@ModelAttribute("seller")Seller seller) {
	
		return "seller_login";
	}
	@PostMapping("/validateSeller")
	public String validateSeller(@ModelAttribute("seller")Seller seller) {
		//boolean flag = false;
		logger.debug("user entered credentials "+seller);
		System.out.println("---------"+seller);
		AtomicBoolean flag = new AtomicBoolean(false);
		List<Seller> sellersList = sellerService.getAllSellers();
		sellersList.forEach(seller1->{
			if(seller1.getUserName().equalsIgnoreCase(seller.getUserName())) {
				if(seller1.getPassword().equals(seller.getPassword()))
					flag.set(true);
			}
		});
		if(flag.get())
			return "confirm_validation";
		else 
			return "errors/error_msg";
	}
	@GetMapping("/insert_items")
	public String insertItems(@ModelAttribute("item")Items item,Model model) {
		System.out.println("insert_items control get method executing-------------");
		
		return "insert_item";
	} 
	
	@PostMapping("/insert_items")
	public String insertItem(@ModelAttribute("item")Items item,RedirectAttributes attr, 
														@RequestParam("file")MultipartFile file, BindingResult error,
																HttpServletRequest request) throws IOException, ServletException, SQLException {
		if(error.hasErrors()) {
			System.out.println("Error occured while inserting items !!!!!!!!!!");
			attr.addFlashAttribute("errorMsg",error);
			return "redirect:insert_items";
		}
		
		Part filePart = request.getPart("file");
		
		InputStream imageStream = filePart.getInputStream();
	//	String imageString = imageStream.readAllBytes().toString();
		
		int itemId = itemService.insertItem(item).getId();
		
		Connection con;
		con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("update  items set image = ? where id = ?");
		ps.setBytes(1, imageStream.readAllBytes());
		ps.setInt(2, itemId);
		
		int count  = ps.executeUpdate();
		String result = null;
		if(count != 0)
			result = "item is inserted with image and id no ::"+itemId;
		else 
			result = "item inserted but image insertion is failed";
		
		attr.addFlashAttribute("resultMsg", result);
		return "redirect:insert_items";
	}
	
	
	@GetMapping("/store")
	public String gotoStore(Model model ) {
		List<Items> items = itemService.getAllItems();
		model.addAttribute("itemsList", items);
		return "show_items";
	}

}
