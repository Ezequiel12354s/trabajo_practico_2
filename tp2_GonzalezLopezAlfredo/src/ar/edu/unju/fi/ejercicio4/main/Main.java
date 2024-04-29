package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	private static Scanner sc;
	private static ArrayList<Jugador> jugadores;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		jugadores = new ArrayList<>();
		
		byte op=0;
		do {
			try {
				op=menu();
				switch(op) {
				case 1: System.out.println("***Cargar Jugador***");
				cargarJugador();
				break;
				case 2: System.out.println("***Mostrar Jugadores***");
				mostrarJugadores();
				break;
				case 3: System.out.println("***Modificar Posición Jugador***");
				modificarJugador();
				break;
				case 4: System.out.println("***Eliminar Jugador***");
				eliminarJugador();
				break;
				case 5: System.out.println("FIN DEL PROGRAMA!");
				break;
				default: System.out.println("Opción Incorrecta!");
				}
			}catch(Exception e) {
				System.out.println("Verifique que ingrese bien los datos");
				sc.nextLine();
			}
		}while(op!=5);
	}
	
	public static byte menu() {
		System.out.println("***MENU DE OPCIONES***");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar jugadores");
		System.out.println("3 - Modificar posición de un jugador");
		System.out.println("4 - Eliminar un jugador");
		System.out.println("5 - Salir");
		System.out.print("Ingrese su opción: ");
		byte op = sc.nextByte();
		sc.nextLine();
		return op;
	}
	
	public static Posicion posicionJug() {
		Posicion posicion = null;
		while(true) {
			try {
				System.out.println("**POSICIÓN DE JUGADOR***");
				System.out.println("1 - DELANTERO");
				System.out.println("2 - MEDIO");
				System.out.println("3 - DEFENSA");
				System.out.println("4 - ARQUERO");
				System.out.print("Ingrese su opción: ");
				byte opt = sc.nextByte();
				switch(opt) {
				case 1: posicion = Posicion.DELANTERO;
				break;
				case 2: posicion = Posicion.MEDIO;
				break;
				case 3: posicion = Posicion.DEFENSA;
				break;
				case 4: posicion = Posicion.ARQUERO;
				break;
				default: System.out.println("Opción Incorrecta");
				}
				if(opt>=1 && opt<=4) {
					break;
				}
			}catch(Exception e){
				System.out.println("ERROR en el ingreso de datos");
				sc.nextLine();
			}
		}
		return posicion;
	}
	
	public static void cargarJugador() {
		while(true) {
			try {
				System.out.print("Ingrese nombre: ");
				String name = sc.nextLine();
				System.out.print("Ingrese apellido: ");
				String ape = sc.nextLine();
				System.out.println("Ingrese fecha de nacimiento");
				System.out.print("Dia: ");
				byte day = sc.nextByte();
				sc.nextLine();
				System.out.print("Mes: ");
				byte month = sc.nextByte();
				sc.nextLine();
				System.out.print("Año: ");
				short year = sc.nextShort();
				sc.nextLine();
				System.out.print("Ingrese nacionalidad: ");
				String nacio = sc.nextLine();
				System.out.print("Ingrese estatura en Centímteros: ");
				Integer altura = sc.nextInt();
				sc.nextLine();
				System.out.print("Ingrese peso (redondeando): ");
				Integer peso = sc.nextInt();
				sc.nextLine();
				System.out.println("Posición Jugador");
				Posicion pos = posicionJug();
				sc.nextLine();
				jugadores.add(new Jugador(name, ape, LocalDate.of(year, month, day), nacio, altura, peso, pos));
				System.out.println("Se dio de alta al jugador");
				break;
			}catch(Exception e) {
				System.out.println("ERROR en el ingreso de datos");
			}
		}
		
	}
	
	public static void mostrarJugadores() {
		if(jugadores.isEmpty()) {
			System.out.println("No hay jugadores para mostrar");
		}else {
			jugadores.forEach(j->System.out.println(j));
		}
	}
	
	public static void modificarJugador() {
		int cont=0;
		System.out.print("Ingrese nombre jugador: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese apellido jugador: ");
		String apellido = sc.nextLine();
		for(Jugador player: jugadores) {
			if(player.getNombreJug().equals(nombre) && player.getApellidoJug().equals(apellido)) {
				boolean aux = false;
				do {
					System.out.println("Eliga nueva posición");
					Posicion pos = posicionJug();
					player.setPosicionJug(pos);
					aux=true;
					cont++;
					break;
				}while(aux == false);
			}
		}
		if(cont==1) {
			System.out.println("Se modifico posición del jugador");
		}else {
			System.out.println("No existe jugador a modificar");
		}
		
	}
	
	public static void eliminarJugador() {
		if(jugadores.isEmpty()) {
			System.out.println("No hay jugadores a eliminar");
		}else {
			System.out.print("Ingrese nombre jugador: ");
			String nombre = sc.nextLine();
			System.out.print("Ingrese apellido jugador: ");
			String apellido = sc.nextLine();
			Iterator<Jugador> iterator = jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador player = iterator.next();
				if(player.getNombreJug().equals(nombre) && player.getApellidoJug().equals(apellido)) {
					iterator.remove();
					System.out.println("Se elimino el jugador "+apellido +" " +nombre);
				}
			}
		}
		
	}
	
}