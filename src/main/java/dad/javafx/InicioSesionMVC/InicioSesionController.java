package dad.javafx.InicioSesionMVC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioSesionController {

	private InicioSesionView view = new InicioSesionView();
	private InicioSesionModel model = new InicioSesionModel();

	private final String users = "users.csv";

	public InicioSesionController() {

		view.getAcceder().setOnAction(e -> onAccederAction(e));
		view.getCancelar().setOnAction(e -> onCancelarAction(e));

		model.usuarioProperty().bindBidirectional(view.getUsuarioField().textProperty());
		model.contraseñaProperty().bindBidirectional(view.getPass().textProperty());

	}

	public InicioSesionView getView() {
		return view;
	}

	private void onAccederAction(ActionEvent e) {

		String usuario = model.getUsuario();
		String contraseña = model.getContraseña();

		if (!valido(usuario, contraseña)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Acceso denegado");
			alert.setContentText("El usuario y/o la contraseña no son válidos");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Acceso permitido");
			alert.setContentText("Las credenciales de acceso son correctas");
			alert.showAndWait();
		}
	}

	public String transformar(String texto) {
		return DigestUtils.md5Hex(texto).toUpperCase();
	}

	private boolean valido(String usuario, String contraseña) {
		File fichero = new File(users);
		try {
			FileReader Fr = new FileReader(fichero);
			BufferedReader BR = new BufferedReader(Fr);
			String linea;
			while ((linea = BR.readLine()) != null) {
				String[] datos = linea.split(",");
				if (usuario.equals(datos[0]) && transformar(contraseña).equals(datos[1])) {
					return true;
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	private void onCancelarAction(ActionEvent e) {
		Platform.exit();
	}

}
