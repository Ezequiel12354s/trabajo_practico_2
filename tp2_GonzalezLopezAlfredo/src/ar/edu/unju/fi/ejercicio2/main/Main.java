package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	private static Scanner sc;
	private static ArrayList<Efemeride> efemerides;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		efemerides = new ArrayList<>();
		byte op=0;
		do {
			try {
				op=menu();
				switch(op) {
				case 1: System.out.println("***Creación Efeméride***");
				crearEfemeride();
				System.out.println("---------------");
				break;
				case 2: System.out.println("***Mostrar Efemérides***");
				mostrarEfemeride();
				System.out.println("---------------");
				break;
				case 3: System.out.println("***Eliminar Efeméride");
				eliminarEfemeride();
				System.out.println("---------------");
				break;
				case 4: System.out.println("***Modificación Efeméride***");
				modificarEfemeride();
				System.out.println("---------------");
				break;
				case 5: System.out.println("Fin del Programa!");
				System.out.println("---------------");
				break;
				default: System.out.println("Opción Incorrecta!");
				}
			}catch(Exception e) {
				System.out.println("Verifique que haya ingresado bien los datos");
			}
		}while(op!=5);
		
		
	}
	
	
	public static byte menu() {
		System.out.println("***MENU DE OPCIONES***");
		System.out.println("1 - Crear efeméride");
		System.out.println("2 - Mostrar efemérides");
		System.out.println("3 - Eliminar efemérides");
		System.out.println("4 - Modificar efeméride");
		System.out.println("5 - Salir");
		System.out.print("Ingrese su opción: ");
		byte op = sc.nextByte();
		sc.nextLine();
		return op;
	}
	
	
	public static int numeroMes() {
		int num;
		while(true) {
			try {
				System.out.println("***OPCIONES DE MESES***");
				System.out.println("1 - Enero");
				System.out.println("2 - Febrero");
				System.out.println("3 - Marzo");
				System.out.println("4 - Abril");
				System.out.println("5 - Mayo");
				System.out.println("6 - Junio");
				System.out.println("7 - Julio");
				System.out.println("8 - Agosto");
				System.out.println("9 - Septiembre");
				System.out.println("10 - Octubre");
				System.out.println("11 - Noviembre");
				System.out.println("12 - Diciembre");
				System.out.print("Ingrese su opción: ");
				num = sc.nextByte();
				sc.nextLine();
				if(num>=1 && num<=12) {
					System.out.println("Valor ingresado correctamente");
					num=num-1;
					break;
				}else {
					System.out.println("Error en el ingreso");
					System.out.println("Debe ingresar numero entero entre 1 y 12");
				}
			}catch(InputMismatchException e) {
				System.out.println("Debe ingresar un numero entero");
				sc.nextLine();
			}
		}
	return num;
	}
	
	public static Mes mesBuscado() {
		Mes auxnn;
		int aux=numeroMes();
		Mes[] meses = Mes.values();
		auxnn = meses[aux];
		return auxnn;
	}
	
	public static byte diaBuscado(Mes aux) {
		byte num;
		while(true) {
			try {
				System.out.print("Ingrese dia: ");
				num = sc.nextByte();
				sc.nextLine();
				if((aux == Mes.FEBRERO) && (num>28)) {
					System.out.println("Febrero tiene 28 dias");
				}else {
					if(num>31){
						System.out.println("Debe ingresar numero entero menor a 32 ");
					}else {
						System.out.println("Dato ingresado correctamente");
						break;
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Debe ingresar un valor numérico");
				sc.nextLine();
			}
		}
		return num;
	}
	
	public static void crearEfemeride() {
		System.out.println("---------------");
		System.out.print("Ingrese código de efeméride: ");
		Integer codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese mes de la efeméride");
		Mes month = mesBuscado();
		System.out.println("Ingrese dia de la efeméride");
		byte day = diaBuscado(month);
		System.out.print("Ingrese detalle de efeméride: ");
		String detalle = sc.nextLine();
		efemerides.add(new Efemeride(codigo, month, day, detalle));
	}
	
	public static void mostrarEfemeride() {
		if(efemerides.isEmpty()) {
			System.out.println("No hay efemérides para mostrar");
		}else {
			for(Efemeride efem: efemerides) {
				System.out.println(efem);
			}
		}
	}
	
	public static void eliminarEfemeride() {
		if(efemerides.isEmpty()) {
			System.out.println("No hay efeméride para eliminar!");
		}else {
			System.out.print("Ingrese código de Efeméride: ");
			Integer cod = sc.nextInt();
			sc.nextLine();
			Iterator<Efemeride> iterator = efemerides.iterator();
			while(iterator.hasNext()) {
				Efemeride efem = iterator.next();
				if(efem.getCodigo().equals(cod)) {
					iterator.remove();
					System.out.println("Se elimina la efeméride "+cod);
				}else {
					System.out.println("No hay efeméride a eliminar");
				}
			}
		}
	}
	
	public static void modificarEfemeride() {
		int cont=0;
		System.out.print("Ingrese código de efeméride a modificar: ");
		Integer cod = sc.nextInt();
		sc.nextLine();
		for(Efemeride efem: efemerides) {
			if(efem.getCodigo().equals(cod)) {
				boolean aux = false;
				do {
					System.out.println("Ingrese mes de la efeméride");
					Mes month = mesBuscado();
					efem.setMesEfem(month);
					System.out.println("Ingrese dia de la efeméride");
					byte day = diaBuscado(month);
					efem.setDia(day);
					System.out.print("Ingrese detalle de efeméride: ");
					String detalle = sc.nextLine();
					efem.setDetalle(detalle);
					cont++;
					aux=true;
					break;
				}while(aux==false);
			}
		}
		if(cont==1) {
			System.out.println("Se modificó Efemérido código "+cod);
		}else {
			System.out.println("No hay Efeméride para modificar");
		}
	}
	
}
