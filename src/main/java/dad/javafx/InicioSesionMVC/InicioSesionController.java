package dad.javafx.InicioSesionMVC;

import javafx.event.ActionEvent;

public class InicioSesionController {

	private InicioSesionView view = new InicioSesionView();
	private InicioSesionModel model = new InicioSesionModel();
	
	public InicioSesionController() {
		
		view.getAcceder().setOnAction(e -> onAccederAction(e));
		view.getCancelar().setOnAction(e -> onCancelarAction(e));
		
		model.usuarioProperty().bind(view.getUsuarioField().textProperty());
		
	}
	

	public InicioSesionView getView() {
		return view;
	}
	
	private void onAccederAction(ActionEvent e) {
		System.out.println(view.getUsuarioField().getText());
		System.out.println(view.getPass().getText());
	}
	
	private void onCancelarAction(ActionEvent e) {
		
	}
	
}
