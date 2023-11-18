package com.octanet.atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtmInterface {
	private int balance = 0;
	private int deposit = 0;
	private int withdraw = 0;
	private String name = " ";
	static Scanner scan = new Scanner(System.in);
	List<Transaction> transactions = new ArrayList<Transaction>();

	public static void main(String[] args) {
		AtmInterface atm = new AtmInterface();
		atm.start();
	}
	
	public void start() {
		System.out.print("Please enter your Name :");
		name = scan.nextLine();
		System.out.println("Welcome to Octanet ATM " + name);
		
		action();
	}
	
	public void action() {
		System.out.println("Press 1 : Deposit");
		System.out.println("Press 2 : Withdraw");
		System.out.println("Press 3 : Check Balance");
		System.out.println("Press 4 : Mini Statement");
		System.out.println("Press 5 : Exit");
		System.out.print("Choose the action you want to perform : ");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			deposit();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			checkBalance();
			break;
		case 4:
			miniStatement();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.print("Please choose a valid action.");
			action();
		}
	}

	// Method to deposit
	public void deposit() {
		System.out.print("Please enter the amount you want to deposit: ");
		deposit = scan.nextInt();
		if(deposit>0) {
			balance += deposit;
			System.out.println("You have deposited :" + deposit);
			System.out.println("Your available balance is " + balance);
			Transaction transaction = new Transaction();
			transaction.setAction("Deposite");
			transaction.setAmount(deposit);
			transaction.setRemaining(balance);
			transactions.add(transaction);
		}else {
			System.out.println("Invalid deposit amount. Please enter a positive value.");
		}
		action();
	}

	// Method to withdraw
	public void withdraw() {
		System.out.print("Please enter the amount you want to withdraw : ");
		withdraw = scan.nextInt();
		if (withdraw > 0 && withdraw <= balance) {
			balance -= withdraw;
			System.out.println("You have withdraw " + withdraw);
			System.out.println("Your available balance is " + balance);
			Transaction transaction = new Transaction();
			transaction.setAction("Withdraw");
			transaction.setAmount(withdraw);
			transaction.setRemaining(balance);
			transactions.add(transaction);
		} else {
			System.out.println("Invalid withdrawl amount or insufficient funds to perform this action.");
		}
		action();
	}

	// Method to check balance
	public void checkBalance() {
		System.out.println("Available balance in your account is " + balance);
		action();
	}
	
	//Method to get Mini Statement
	public void miniStatement() {
		System.out.println("Action"+ "\t\t" + "Amount" + "\t\t" + "Remaining");

		for(Transaction transaction : transactions) {
			System.out.println(transaction.getAction() + "\t" + transaction.getAmount() + "\t\t" + transaction.getRemaining());
		}
		System.out.println("Available Balance : "+balance);
		action();
	}
	
	
	//Method to exit code
	public void exit() {
		System.out.println("Thank you "+name+" for using Octanet ATM ");
		System.out.println("Please visit again");
		scan.close();
	}
}
