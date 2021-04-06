package ui;
import model.*;


import java.util.Scanner;
import exceptions.NoAgeException;
import exceptions.NoDayException;
import exceptions.NoValidOptionException;
public class Main {
	
	private static final String TARJETA_IDENTIDAD= "TI";
	private static final String CEDULA_CIUDADANIA = "CC";
	private static final String PASAPORTE = "PP";
	private static final String CEDULA_EXTRANJERIA = "CE";
	private static final int REGISTER = 1;
	private static final int EXIT = 2;
	
	
	public static void main(String[] args) {
		
		MiniMarket MiBarrio = new MiniMarket("Mi Barrio Te Quiere");
		int option = 0; 
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println("WELCOME TO THE MINIMARKET: " + MiBarrio.getName() + " " + "\n CHOOSE AN OPTION: " + "\n 1: REGISTER A USER " + "\n 2: EXIT ");
		System.out.println();
		System.out.println("                           " + "REGISTERED USERS OR REGISTRATION ATTEMPTS:  " + MiBarrio.getCount());
		option = sc.nextInt();
		sc.nextLine();
		switch(option){
			
			case REGISTER:
			MiBarrio.increaseCounter();
			System.out.println("TYPE IN YOUR ID NUMBER ");
			String number = sc.nextLine();
			System.out.println("SELECT YOUR DOCUMENT's TYPE: " + "\n 1:TARJETA DE IDENTIDAD " + "\n 2:CEDULA DE CIUDADANIA " + "\n 3:PASAPORTE " + "\n 4:CEDULA DE EXTRANJERIA");
			int type = sc.nextInt();
			sc.nextLine();
			User u = null;
			
			try {
			if(type == 1) {
				u = new User(number,TARJETA_IDENTIDAD);
			}else if(type == 2){
				u = new User(number,CEDULA_CIUDADANIA);	
			}else if(type == 3){
				u = new User(number,PASAPORTE);
			}else if(type == 4){
				u = new User(number,CEDULA_EXTRANJERIA);	
			}else {
				throw new NoValidOptionException();
				}
			}
			
			catch(NoValidOptionException v) {
				System.err.println(v.getMessage());
				System.out.println();
				v.printStackTrace();
			}try {
				MiBarrio.Register(u);
				System.out.println("USER WAS SUCCESFULLY REGISTERED");
			}catch(NoAgeException a) {
				System.err.print(a.getMessage());
				System.out.println();
			}catch(NoDayException d) {	
				System.err.println(d.getMessage());
				System.out.println();
			}
			break;
		}
		
	} while(option == REGISTER);		
		try {			
		if(option == EXIT) {		
			System.out.println("HAVE A GREAT ONE ");
		} else {
			throw new NoValidOptionException();
			}	
		} catch(NoValidOptionException valid) {
			System.err.println(valid.getMessage());
			System.out.println();
			valid.printStackTrace();
		}
		finally{
			sc.close();
		}
	}
}

