package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		byte opcion;
		String codigoProducto = null;
		String descipcionProducto = null;
		double precioUnitarioProducto = 0;
		OrigenFabricacion origenProducto = null;
		Categoria categoriaProducto = null;
		Producto producto = new Producto();
		List<Producto> listaProductos = new ArrayList<>();

		Scanner leer = new Scanner(System.in);

		do {
			System.out.println("-----------------------");
			System.out.println("---MENU---");
			System.out.println("1-Crear Producto");
			System.out.println("2-Mostrar Productos:");
			System.out.println("3-Modificar producto");
			System.out.println("4-Salir");
			try {
				System.out.print("Ingrese opcion: ");
				opcion = leer.nextByte();
				if (opcion < 1 || opcion > 4) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				do {
					try {
						System.out.print("Ingrese codigo: ");
						codigoProducto = leer.next();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoProducto = "";
						leer.nextLine();
					}
				} while (codigoProducto.isEmpty());
				do {
					leer.nextLine();
					try {
						System.out.print("Ingrese descripcion: ");
						descipcionProducto = leer.nextLine();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						descipcionProducto = "";
						leer.nextLine();
					}
				} while (descipcionProducto.isEmpty());
				do {
					try {
						System.out.print("Ingrese precio unitario: ");
						precioUnitarioProducto = leer.nextDouble();
						if (precioUnitarioProducto <= 0) {
							throw new IllegalArgumentException("El precio debe ser un real positivo");
						}
					} catch (Exception e) {
						System.out.println("Error: debe ingresar numeros reales");
						leer.nextLine();
						precioUnitarioProducto = 0;
					}
				} while (precioUnitarioProducto <= 0);
				leer.nextLine();
				// control origen controlado en la clase Producto
				System.out.println("Ingrese origen de fabricacion: ");
				origenProducto = producto.menuOrigenDeFabricacion(leer);
				// control categoria controlado en la clase Producto
				System.out.println("Ingrese categoria: ");
				categoriaProducto = producto.menuCategoria(leer);
				// cargo la lista con un nuevo producto
				listaProductos.add(new Producto(codigoProducto, descipcionProducto, precioUnitarioProducto,
						origenProducto, categoriaProducto));
				System.out.println("Se creo el objeto con exito");
				break;
			case 2:// mostrar productos
				if (listaProductos.isEmpty()) {
					System.out.println("La lista de productos esta vacia");
				} else {
					listaProductos.forEach(p -> System.out.println("Producto: " + p));
				}
				break;
			case 3:
				if (listaProductos.isEmpty()) {
					System.out.println("La lista de productos esta vacia");
				} else {
					System.out.print("Ingrese codigo del producto a modificar:");
					codigoProducto = leer.next();
					for (int i = 0; i < listaProductos.size(); i++) {
						producto = listaProductos.get(i);
						if (producto.getCodigo().equals(codigoProducto)) {
							System.out.println("Modificar producto " + producto.getCodigo());
							do {
								leer.nextLine();
								try {
									System.out.print("Ingrese descripcion: ");
									descipcionProducto = leer.nextLine();
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									descipcionProducto = "";
									leer.nextLine();
								}
							} while (descipcionProducto.isEmpty());
							do {
								try {
									System.out.print("Ingrese precio unitario: ");
									precioUnitarioProducto = leer.nextDouble();
									if (precioUnitarioProducto <= 0) {
										throw new IllegalArgumentException("El precio debe ser un real positivo");
									}
								} catch (Exception e) {
									System.out.println("Error: debe ingresar numeros reales");
									leer.nextLine();
									precioUnitarioProducto = 0;
								}
							} while (precioUnitarioProducto <= 0);
							
							System.out.println("Ingrese origen de fabricacion: ");
							origenProducto = producto.menuOrigenDeFabricacion(leer);
							System.out.println("Ingrese categoria: ");
							categoriaProducto = producto.menuCategoria(leer);
							producto.setDescripcion(descipcionProducto);
							producto.setPrecioUnitario(precioUnitarioProducto);
							producto.setOrigenFabricacion(origenProducto);
							producto.setCategoria(categoriaProducto);
							System.out.println("El producto se modifico con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoProducto + " no pertenece a ningún producto de la lista");
						}
					}
				}
				break;
			case 4:// salir
				System.out.println("Saliendo...");
				break;
			default:
				break;
			}
		} while (opcion != 4);
		leer.close();
	}
}
