package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		//Garfield se convierte de FelinoDomestico a FelinoSalvaje
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		//Se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		//Se muestra el resultado
		converter.mostrarObjeto(felino1);
		
		//Tanner se convierte de FelinoSalvaje a FelinoDomestico
		FelinoSalvaje mishi = new FelinoSalvaje("Tanner", (byte)20, 186f);
		Converter<FelinoSalvaje, FelinoDomestico> conver = d -> new FelinoDomestico(d.getNombre(), d.getEdad(), d.getPeso());
		//Verifica que el objeto a convertir no sea nulo
		if(Converter.isNotNull(mishi)) {
			//Se realiza la conversión
			FelinoDomestico felino2 = conver.convert(mishi);
			//Se muestra el resultado de la conversión
			conver.mostrarObjeto(felino2);
		}
	}

}