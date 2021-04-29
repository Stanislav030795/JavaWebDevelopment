package com.luv2code.springdemo.controller;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Category;
import com.luv2code.springdemo.entity.DataOrderInterval;
import com.luv2code.springdemo.entity.Order;
import com.luv2code.springdemo.entity.Product;
import com.luv2code.springdemo.service.OrderService;

@Controller
@RequestMapping("/admin/order") 
public class AdminOrderController extends AdminBase{
	
	@Autowired
	OrderService orderService;
	@Autowired
	private HttpSession session;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping
	public String showOrderList(Model theModel) throws IOException {
		
		Integer userId = checkLogged();
		
		if(userId!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			theModel.addAttribute("dataFormat",formatter);
			List<Order> theOrders = orderService.getOrders();
			theModel.addAttribute("orders",theOrders);
			theModel.addAttribute("dataInterval",new DataOrderInterval());
		}
		
		return "admin_order/index";
	}
	
	
	@PostMapping
	public String showOrderInterval(Model theModel,@ModelAttribute("dataInterval") DataOrderInterval dataInterval) throws IOException {
		
		Integer userId = checkLogged();
		
		if(userId!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
			theModel.addAttribute("dataFormat",formatter);
			List<Order> theOrders = orderService.getOrdersFromInterval(dataInterval);
			theModel.addAttribute("orders",theOrders);
		}
		
		return "admin_order/index";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("orderId") int theId) {
		
		// delete the customer
		orderService.deleteOrder(theId);
		
		return "redirect:/admin/order";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("orderId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Order theOrder = orderService.getOrderById(theId);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("order", theOrder);
		System.out.println("Upd "+theOrder.getProducts());
		// send over to our form		
		return "admin_order/update";
	}
	
	@PostMapping("/save")
	public String saveProduct(Model theModel, @Valid @ModelAttribute("order") Order theOrder, 
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("order", theOrder);
		}
		else {
			orderService.saveOnlyThisOrder(theOrder);  
			return "redirect:/admin/order";
		}

		return "admin_order/update";
	}
	
	@GetMapping("/view")
	public String viewOrder(@RequestParam("orderId") int theId, Model theModel) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		theModel.addAttribute("dataFormat",formatter);
		Order theOrder = orderService.getOrderById(theId);	
		theModel.addAttribute("order", theOrder);
		theModel.addAttribute("orderService",orderService);
		theModel.addAttribute("totalPrice",orderService.totalPrice(theId));
		List<Product> products =  theOrder.getProducts();
		theModel.addAttribute("products", products);
		Map<Integer,Integer> quantityMap = orderService.getQuantity(theId);
		theModel.addAttribute("quantity", quantityMap);
		return "admin_order/view";
	}
	
	

}
