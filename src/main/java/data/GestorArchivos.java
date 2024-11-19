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

	// Guardar los datos de la cafeteria en un archivo
	public static void guardarCafeteria(Cafeteria cafeteria, String archivo) {
		List<String> lineas = new ArrayList<>();
		lineas.add("Nombre: " + cafeteria.getNombre());
		lineas.add("Direccion: " + cafeteria.getDireccion());
		lineas.add("Redes Sociales: " + formatearRedesSociales(cafeteria.getRedesSociales()));
		lineas.add("Cafes:\n" + cafeteria.getListaCafes().stream()
				.map(Cafe::toString)
				.collect(Collectors.joining("\n")));
		try {
			Files.write(Paths.get(archivo), lineas, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Formatear las redes sociales para que no incluyan los caracteres {
	private static String formatearRedesSociales(Map<String, String> redesSociales) {
		return redesSociales.entrySet().stream()
				.map(entry -> entry.getKey() + ": " + entry.getValue())
				.collect(Collectors.joining(", "));
	}

	// Cargar los datos de la cafeteria desde un archivo
	public static Cafeteria cargarCafeteria(String archivo) {
		try {
			if (!Files.exists(Paths.get(archivo))) {
				Files.createFile(Paths.get(archivo));
				return new Cafeteria("Nombre de la Cafeteria", "Direccion de la Cafeteria", Map.of());
			}
			List<String> lineas = Files.readAllLines(Paths.get(archivo));
			if (lineas.size() < 4) {
				return new Cafeteria("Nombre de la Cafeteria", "Direccion de la Cafeteria", Map.of());
			}
			String nombre = obtenerValor(lineas.get(0));
			String direccion = obtenerValor(lineas.get(1));
			Map<String, String> redesSociales = Arrays.stream(obtenerValor(lineas.get(2)).split(", "))
					.map(s -> s.split(": "))
					.filter(a -> a.length == 2)  // Asegura que hay una clave y un valor
					.collect(Collectors.toMap(a -> a[0], a -> a[1]));
			List<Cafe> listaCafes = Arrays.stream(obtenerValor(lineas.get(3)).split("\n"))
					.map(c -> {
						String[] partes = c.replace("Cafe:\n", "").split("\n");
						if (partes.length < 5) {
							return null; // Si la línea no tiene los 5 componentes, salta este café
						}
						String nombreCafe = partes[0].split(": ")[1];
						int gramosCafe = Integer.parseInt(partes[1].split(": ")[1]);
						int mililitrosAgua = Integer.parseInt(partes[2].split(": ")[1]);
						String tamano = partes[3].split(": ")[1];
						List<String> ingredientesOpcionales = Arrays.asList(partes[4].split(": ")[1].split(", "));
						return new Cafe(nombreCafe, gramosCafe, mililitrosAgua, tamano, ingredientesOpcionales);
					})
					.filter(c -> c != null) // Elimina los cafés nulos
					.collect(Collectors.toList());
			return new Cafeteria(nombre, direccion, redesSociales, listaCafes);
		} catch (IOException e) {
			e.printStackTrace();
			return new Cafeteria("Nombre de la Cafeteria", "Direccion de la Cafeteria", Map.of()); // Devolver una cafeteria vacía en caso de error
		}
	}

	private static String obtenerValor(String linea) {
		String[] partes = linea.split(": ");
		return partes.length > 1 ? partes[1] : "";
	}

	// Guardar los datos de los cafes en un archivo
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

	// Cargar los datos de los cafes desde un archivo
	public static List<Cafe> cargarCafes(String archivo) {
		try {
			if (!Files.exists(Paths.get(archivo))) {
				Files.createFile(Paths.get(archivo));
				return new ArrayList<>(); // Archivo creado, retornar lista vacía
			}
			List<String> lineas = Files.readAllLines(Paths.get(archivo));
			return lineas.stream().map(linea -> {
						String[] partes = linea.replace("Cafe:\n", "").split("\n");
						if (partes.length < 5) {
							return null; // Si la línea no tiene los 5 componentes, salta este café
						}
						String nombreCafe = partes[0].split(": ")[1];
						int gramosCafe = Integer.parseInt(partes[1].split(": ")[1]);
						int mililitrosAgua = Integer.parseInt(partes[2].split(": ")[1]);
						String tamano = partes[3].split(": ")[1];
						List<String> ingredientesOpcionales = Arrays.asList(partes[4].split(": ")[1].split(", "));
						return new Cafe(nombreCafe, gramosCafe, mililitrosAgua, tamano, ingredientesOpcionales);
					})
					.filter(c -> c != null) // Elimina los cafés nulos
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static boolean existeArchivo(String archivo) {
		return Files.exists(Paths.get(archivo));
	}
}
