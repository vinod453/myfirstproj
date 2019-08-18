package com.cg.pp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.pp.bean.Address;
import com.cg.pp.bean.Customer;
import com.cg.pp.service.ServiceInterface;

@Controller
public class RegisterController {
	@Autowired
	ServiceInterface service;

	public ServiceInterface getService() {
		return service;
	}

	public void setService(ServiceInterface service) {
		this.service = service;
	}

	@RequestMapping("/showRegister")
	public String showLogin(Model model) {
		Customer customer = new Customer();
		model.addAttribute(customer);
		Address address = new Address();
		model.addAttribute("address", address);
		return "register";
	}

	@RequestMapping("/ValidateUser")
	public String validate(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
			@ModelAttribute("address") @Valid Address address, BindingResult result1, Model model) {
		int accno = 0;
		if (result.hasErrors() || result1.hasErrors()) {
			return "register";
		}
		customer.setAddress(address);
		accno = service.addCustomer(customer);
		model.addAttribute("accno", accno);
		model.addAttribute("customer", customer);
		return "success";
	}
}
