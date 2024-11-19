package gui_vista;

import controller.CafeteriaController;
import model.Cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CafeteriaGUI extends JFrame {
	private CafeteriaController controller;
	private JTextArea textArea;
	private JTextField nombreCafeField, gramosField, mililitrosField, tamanoField, ingredientesField;

	// Constructor
	public CafeteriaGUI(CafeteriaController controller) {
		this.controller = controller;
		initialize();
		// Mostrar datos iniciales
		mostrarDatos();
	}

	// Inicializa los componentes de la GUI
	private void initialize() {
		// Configuración básica de la ventana
		setTitle("Gestión de Cafetería");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		// TextArea para mostrar los datos
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(BorderFactory.createTitledBorder("Datos de la Cafetería"));
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// Panel para la entrada de datos
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		inputPanel.setBorder(BorderFactory.createTitledBorder("Agregar Café"));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Nombre del Café:"), gbc);

		gbc.gridx = 1;
		nombreCafeField = new JTextField(15);
		inputPanel.add(nombreCafeField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		inputPanel.add(new JLabel("Gramos de Café:"), gbc);

		gbc.gridx = 1;
		gramosField = new JTextField(15);
		inputPanel.add(gramosField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		inputPanel.add(new JLabel("Mililitros de Agua:"), gbc);

		gbc.gridx = 1;
		mililitrosField = new JTextField(15);
		inputPanel.add(mililitrosField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		inputPanel.add(new JLabel("Tamaño:"), gbc);

		gbc.gridx = 1;
		tamanoField = new JTextField(15);
		inputPanel.add(tamanoField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		inputPanel.add(new JLabel("Ingredientes Opcionales:"), gbc);

		gbc.gridx = 1;
		ingredientesField = new JTextField(15);
		inputPanel.add(ingredientesField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		JButton addButton = new JButton("Agregar Café");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCafe();
			}
		});
		inputPanel.add(addButton, gbc);

		getContentPane().add(inputPanel, BorderLayout.NORTH);

		// Panel para los botones de acción
		JPanel actionPanel = new JPanel();
		actionPanel.setLayout(new FlowLayout());
		actionPanel.setBorder(BorderFactory.createTitledBorder("Acciones"));

		JButton loadButton = new JButton("Cargar Datos");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos();
			}
		});
		actionPanel.add(loadButton);

		JButton saveButton = new JButton("Guardar Datos");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		actionPanel.add(saveButton);

		getContentPane().add(actionPanel, BorderLayout.SOUTH);

		// Muestra la ventana
		setVisible(true);
	}

	public void agregarCafe() {
		String nombre = nombreCafeField.getText();
		int gramos = Integer.parseInt(gramosField.getText());
		int mililitros = Integer.parseInt(mililitrosField.getText());
		String tamano = tamanoField.getText();
		List<String> ingredientes = List.of(ingredientesField.getText().split(","));
		Cafe cafe = new Cafe(nombre, gramos, mililitros, tamano, ingredientes);
		controller.agregarCafe(cafe);
		mostrarDatos();
	}

	public void mostrarDatos() {
		textArea.setText(controller.getCafeteria().toString());
	}
	public void cargarDatos() {
		controller.cargarDatosCafeteria();
		controller.cargarDatosCafes();
		mostrarDatos();
	}
	public void guardarDatos() {
		controller.guardarDatosCafeteria();
		controller.guardarDatosCafes();
	}
}
