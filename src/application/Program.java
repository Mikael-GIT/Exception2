package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Informe os dados da conta");
		    System.out.print("Numero: ");
		    int number = scan.nextInt();
		    System.out.print("Titular: ");
		    scan.nextLine();
		    String holder = scan.nextLine();
		    System.out.print("Saldo inicial: ");
		    double balance = scan.nextDouble();
		    System.out.print("Limite de saque: ");
		    double withdrawLimit = scan.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println("Enter amount for withdraw: ");
            Double amount = scan.nextDouble();

            account.withdraw(amount);

            System.out.println("New balance: " + account.getBalance());
        } catch(DomainException e){
            System.out.println(e.getMessage());
        } catch(InputMismatchException e){
            System.out.println("Invalid input type");
        }
    }
}