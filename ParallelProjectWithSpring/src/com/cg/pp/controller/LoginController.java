package com.cg.pp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.pp.bean.Customer;
import com.cg.pp.bean.Transaction;
import com.cg.pp.exception.CustomerException;
import com.cg.pp.service.ServiceInterface;

@Controller
public class LoginController {
	@Autowired
	ServiceInterface service;

	public ServiceInterface getService() {
		return service;
	}

	public void setService(ServiceInterface service) {
		this.service = service;
	}

	Customer customer;

	@RequestMapping("/showLogin")
	public String showLogin(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "login";
	}

	@RequestMapping("/validateLogin")
	public String vaidateLogin(@ModelAttribute Customer customer, Model model) {
		boolean valid = false;
		try {
			valid = service.verifyPassword(customer.getAccno(), customer.getPassword());
			if (valid == true) {
				this.customer = service.getCustomer(customer.getAccno());
				model.addAttribute("customer", this.customer);
			} else
				throw new CustomerException("Invalid Password Please try again.");
		} catch (CustomerException e) {
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
		return "user";
	}

	@RequestMapping("/user")
	public String getUser() throws SQLException {
		customer = service.getCustomer(customer.getAccno());
		return "user";
	}

	@RequestMapping("/GetCustomer")
	public String getCustomer(Model model) {
		model.addAttribute("customer", this.customer);
		return "getcustomer";
	}

	@RequestMapping("/ShowBalanceWallet")
	public String showBalanceWallet(Model model) {
		model.addAttribute("customer", this.customer);
		return "showbalancewallet";
	}

	@RequestMapping("/ShowBalanceAccount")
	public String showBalanceAccount(Model model) {
		model.addAttribute("customer", this.customer);
		return "showbalanceaccount";
	}

	@RequestMapping("/DepositMoney")
	public String depositMoney() {
		return "depositmoney";
	}

	@RequestMapping("/DepositMoneyToWallet")
	public String depositMoneyToWallet(@RequestParam("amount") double amount, Model model) {
		try {
			Transaction txn = service.depositMoney(customer.getAccno(), amount);
			model.addAttribute("txn", txn);
		} catch (CustomerException e) {
			model.addAttribute("msg", e.getMessage());
			return "errorLogin";
		}
		return "transaction";
	}

	@RequestMapping("/WithdrawMoney")
	public String withdrawMoney() {
		return "withdrawmoney";
	}

	@RequestMapping("/WithdrawMoneyToWallet")
	public String withdrawMoneyToWallet(@RequestParam("amount") double amount, Model model) {
		try {
			Transaction txn = service.withdrawMoney(customer.getAccno(), amount);
			customer = service.getCustomer(customer.getAccno());
			model.addAttribute("txn", txn);
		} catch (CustomerException e) {
			model.addAttribute("msg", e.getMessage());
			return "errorLogin";
		}
		return "transaction";
	}

	@RequestMapping("/FundTransfer")
	public String fundTransfer() {
		return "fundtransfer";
	}

	@RequestMapping("/FundTransferToAccount")
	public String fundTransferToAccount(@RequestParam("amount") double amount, @RequestParam("tgtAcc") int tgtAcc,
			Model model) {
		try {
			Transaction txn = service.fundTransfer(customer.getAccno(), tgtAcc, amount);
			model.addAttribute("txn", txn);
		} catch (CustomerException e) {
			model.addAttribute("msg", e.getMessage());
			return "errorLogin";
		}
		return "transaction";
	}

	@RequestMapping("/PrintTransactions")
	public String printTransactions(Model model) {
		List<Transaction> transactions = service.printTransactions(customer.getAccno());
		model.addAttribute("transactions", transactions);
		return "printtransactions";
	}

}
