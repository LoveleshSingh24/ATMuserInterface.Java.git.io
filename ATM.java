package com.ATM;
import java.util.Scanner;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.Templates;
// we have taken 100 rupee as the initial amount in bank account 
// Now in public class ATM we haves created the four method which are display balance,amountWithdraw ,amountDeposit
// amountTranfer which will provide certain functionality to our ATM user-interface 
// now we will call the function from the main class after scanning the withdrawal amount or deposit amount or the transfer amount
// according to user input by using switch case with while loop
// to know about the transaction history we will use the java.util.ArrayList which will maintain the 
// record just after any transaction to be done 
// and at the end we will print the transaction related information with current balance 
import org.jcp.xml.dsig.internal.MacOutputStream;
public class ATM{
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> trasectionHistoryArrayList =new ArrayList<String>();
	
	public static void displayBalance (int balance ) {
		System.out.println("CURRENT BALANCE                : "+ balance+"$");
		
	}
	public static int amountWithdraw(int balance ,int withdrawalAmount) {
		System.out.println();
		System.out.println("WITHDRAWAL TRANSECTION !");
		System.out.println();
		
		if(balance>=withdrawalAmount) {
			System.out.println("Withdrawal Amount              : "+withdrawalAmount+"$");
			balance=balance-withdrawalAmount;
			displayBalance(balance);
			trasectionHistoryArrayList.add("WAITDRAWAL TRANSECTION AMOUNT  : "+ withdrawalAmount+"$");
			System.out.println("Please collect your cash and remove card !");
		}
		else {
			System.out.println("SORRY INSUFFICIANT BALANCE ! ");
		}
		return balance;
		
	}
	public static int amountDeposit(int balance,int depositAomount) {
		System.out.println();
		System.out.println("DEPOSITE TRASECTRION !");
		System.out.println();
		System.out.println("DEPOSITE AMOUNT                : "+ depositAomount+"$");
		balance=balance+depositAomount;
		displayBalance(balance);
		System.out.println("CASH IS SUCCESSFULLY DEPOSITE !");
		trasectionHistoryArrayList.add("DEPOSITE TRANSECTION AMOUNT    : "+ depositAomount+"$");
		return balance;
	}
	public static int amountTransfer(int balance ,int TransferableAmount) {
		System.out.println();
		System.out.println("TRANFER TRANSECTION !");
		System.out.println();
		
		if(balance>=TransferableAmount) {
			System.out.println("TRASECTION OF TRANFER          : "+TransferableAmount+"$");
			balance=balance-TransferableAmount;
			displayBalance(balance);
			System.out.println("TRANSECTION IS SUCCESSFULL !");
			trasectionHistoryArrayList.add("TRANSFER TRANSECTION AMOUNT    : "+TransferableAmount+"$");
		}
		else {
			System.out.println();
			System.out.println("SORRY INSUFFICIANT BALANCE !");
			System.out.println();
		}
		return balance;
	}
	public static void main(String args[]){
		
		int balance =100;
		trasectionHistoryArrayList.add("INTIAL BALANCE                 : "+balance+"$");
		System.out.println();
		int option =0;
		boolean quite=false;
		while(!quite){
			//main menu
			System.out.println("======================================================================");
			System.out.println();
			System.out.println();
			System.out.println("ENTER THE OPTION");
			System.out.println("press 1. TO CHECK BALANCE ");
			System.out.println("press 2. TO DEPOSITE ");
			System.out.println("press 3. TO WITHDRAW ");
			System.out.println("press 4. TO TRANSFER ");
			System.out.println("press 5. TO VIEW TRANSECTION HISTORY ");
			System.out.println("press 6. TO EXIT ");
			System.out.println("=======================================================================");
			  
			System.out.println();
			System.out.println();
			System.out.print("Enter you choice               : ");
			option=scanner.nextInt();
			switch(option) {
			case 1:
				System.out.println("==================================================================");
				System.out.println();
				displayBalance(balance);
				System.out.println();
				System.out.println("==================================================================");
				break;
			case 2:
				System.out.println("==================================================================");
				System.out.println();
				System.out.print("Enter amount to deposite       : ");
				int depositeAmount=scanner.nextInt();
				balance=amountDeposit(balance,depositeAmount);
				System.out.println();
				System.out.println("==================================================================");
			
				break;
			case 3:
				System.out.println("==================================================================");
				System.out.println();
				System.out.print("Enter amout to Withdraw        : ");
				depositeAmount=scanner.nextInt();
				balance=amountWithdraw(balance, depositeAmount);
				System.out.println();
				System.out.println("==================================================================");
				break;
			case 4:
				System.out.println("==================================================================");
				System.out.println();
				System.out.print("Enter amount to Transfer       : ");
				int TransferAmount=scanner.nextInt();
				balance=amountTransfer(balance,TransferAmount);
				System.out.println();
				System.out.println("==================================================================");
				break;
			case 5:
				System.out.println("==================================================================");
				System.out.println();
				System.out.println("TRANSECTION HISTORY ");
				System.out.println();
				for(String transection:trasectionHistoryArrayList) {
					System.out.println(transection);
					System.out.println();
				}
				System.out.println();
				System.out.println("==================================================================");
				break;
			case 6:
				System.out.println("==================================================================");
				System.out.println();
				System.out.println("THANKYOU FOR VISISTING ATM !");
				System.out.println();
				quite=true;
				System.out.println("==================================================================");
				break;
			default:
				System.out.println("==================================================================");
				System.out.println();
				System.out.println("INVALID OPTION");
				System.out.println();
				System.out.println("==================================================================");
				break;
				
			}
			System.out.println("Press Any Key To Continue...");
			new java.util.Scanner(System.in).nextLine(); 
		}
	}
}