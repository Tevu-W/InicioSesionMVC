package dad.javafx.InicioSesionMVC;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioSesionView extends VBox {

	private Label usuario, contraseña;
	private TextField usuarioField;
	private PasswordField pass;
	private Button acceder, cancelar;

	public InicioSesionView() {
		super();

		usuario = new Label("Usuario: ");
		contraseña = new Label("Contraseña: ");

		usuarioField = new TextField();
		usuarioField.setPromptText("Usuario");

		pass = new PasswordField();
		pass.setPromptText("Contraseña");

		acceder = new Button("Acceder");
		cancelar = new Button("Cancelar");

		acceder.setDefaultButton(true);

		HBox usuarioBox = new HBox();
		usuarioBox.setSpacing(30);
		usuarioBox.setAlignment(Pos.BASELINE_CENTER);
		usuarioBox.getChildren().addAll(usuario, usuarioField);

		HBox contraseñaBox = new HBox();
		contraseñaBox.setSpacing(10);
		contraseñaBox.setAlignment(Pos.BASELINE_CENTER);
		contraseñaBox.getChildren().addAll(contraseña, pass);

		HBox botones = new HBox();
		botones.setSpacing(10);
		botones.setAlignment(Pos.BASELINE_CENTER);
		botones.getChildren().addAll(acceder, cancelar);

		setSpacing(20);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(usuarioBox, contraseñaBox, botones);

	}

	public Label getUsuario() {
		return usuario;
	}

	public Label getContraseña() {
		return contraseña;
	}

	public TextField getUsuarioField() {
		return usuarioField;
	}

	public PasswordField getPass() {
		return pass;
	}

	public Button getAcceder() {
		return acceder;
	}

	public Button getCancelar() {
		return cancelar;
	}

}
