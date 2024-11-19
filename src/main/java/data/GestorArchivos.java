package data;

import model.Cafe;
import model.Cafeteria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorArchivos {

	// Guardar los datos de la cafetería en un archivo
	public static void guardarCafeteria(Cafeteria cafetería, String archivo) {
		List<String> lineas = new ArrayList<>();
		lineas.add("Nombre: " + cafetería.getNombre());
		lineas.add("Direccion: " + cafetería.getDireccion());
		lineas.add("Redes Sociales: " + cafetería.getRedesSociales().toString());
		lineas.add("Cafes: " + cafetería.getListaCafes().stream()
				.map(Cafe::toString)
				.collect(Collectors.joining(", ")));
		try {
			Files.write(Paths.get(archivo), lineas, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Cargar los datos de la cafetería desde un archivo
	public static Cafeteria cargarCafeteria(String archivo) {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(archivo));
			String nombre = lineas.get(0).split(": ")[1];
			String direccion = lineas.get(1).split(": ")[1];
			Map<String, String> redesSociales = Arrays.stream(lineas.get(2).split(": ")[1].replace("{", "").replace("}", "").split(", "))
					.map(s -> s.split("="))
					.collect(Collectors.toMap(a -> a[0], a -> a[1]));

			List<Cafe> listaCafes = Arrays.stream(lineas.get(3).split(": ")[1].split(", "))
					.map(c -> {
						String[] partes = c.replace("Cafe{", "").replace("}", "").split(", ");
						int gramosCafe = Integer.parseInt(partes[0].split("=")[1]);
						int mililitrosAgua = Integer.parseInt(partes[1].split("=")[1]);
						String tamaño = partes[2].split("=")[1];
						List<String> ingredientesOpcionales = Arrays.asList(partes[3].split("=")[1].replace("[", "").replace("]", "").split(", "));
						return new Cafe(gramosCafe, mililitrosAgua, tamaño, ingredientesOpcionales);
					}).collect(Collectors.toList());

			return new Cafeteria(nombre, direccion, redesSociales, listaCafes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Guardar los datos de los cafés en un archivo
	public static void guardarCafes(List<Cafe> cafes, String archivo) {
		List<String> lineas = cafes.stream()
				.map(Cafe::toString)
				.collect(Collectors.toList());
		try {
			Files.write(Paths.get(archivo), lineas, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Cargar los datos de los cafés desde un archivo
	public static List<Cafe> cargarCafes(String archivo) {
		try {
			List<String> lineas = Files.readAllLines(Paths.get(archivo));
			return lineas.stream().map(linea -> {
				String[] partes = linea.replace("Cafe{", "").replace("}", "").split(", ");
				int gramosCafe = Integer.parseInt(partes[0].split("=")[1]);
				int mililitrosAgua = Integer.parseInt(partes[1].split("=")[1]);
				String tamaño = partes[2].split("=")[1];
				List<String> ingredientesOpcionales = Arrays.asList(partes[3].split("=")[1].replace("[", "").replace("]", "").split(", "));
				return new Cafe(gramosCafe, mililitrosAgua, tamaño, ingredientesOpcionales);
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
