package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);
		
		
		System.out.print("Nome do departamento: ");
		String nomeDepartamento=sc.next();
		System.out.print("Dia do pagamento: ");
		int diaPagamento=sc.nextInt();
		System.out.print("Email: ");
		String email=sc.next();
		System.out.print("Telefone: ");
		String telefone=sc.next();
		
		Department dep=new Department(nomeDepartamento, diaPagamento, new Address(email,telefone));
		
		System.out.print("Quantos funcionarios tem o departamento: ");
		int quant=sc.nextInt();
		
		for(int i=0;i<quant;i++) {
			System.out.println("Dados do funcionario "+(i+1)+":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome=sc.nextLine();
			System.out.print("Salario: ");
			double salario=sc.nextDouble();
			dep.addEmployee(new Employee(nome,salario));
		}
		    // pulando uma linha
		System.out.println();
		
		
		// mostrando o relatorio
		showReport(dep);
			
	
		
		
		
		
		sc.close();

	}

	private static void showReport(Department dep) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento de vendas: "+dep.payroll());
		System.out.println("Pagamento realizado no dia "+dep.getPayDay());
		System.out.println("Funcionarios");
		for(Employee e:dep.getEmployees())
			System.out.println(e.getName());
		
		System.out.print("Para dúvidas favor entrar em contato: "+dep.getAddress().getEmail());
	}

}
