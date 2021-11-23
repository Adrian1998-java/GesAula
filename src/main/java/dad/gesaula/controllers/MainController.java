package dad.gesaula.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Grupo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	//MODEL
	
	private GrupoController grupoController = new GrupoController();
	private AlumnosController alumnosController = new AlumnosController();
	
	private ObjectProperty<Grupo> grupo = new SimpleObjectProperty<Grupo>();
	
	//VIEW
	
	@FXML
	private BorderPane view;

	@FXML
	private Button nuevoButton;

	@FXML
	private Button guardarButton;

	@FXML
	private Tab grupoTab;

	@FXML
	private Tab alumnosTab;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Init View
		grupoTab.setContent(grupoController.getView());
		alumnosTab.setContent(alumnosController.getView());
		
		//Init grupo
		grupo.set(new Grupo());
		
		grupoController.setGrupo(getGrupo());

	}
	
	public BorderPane getView() {
		return view;
	}
	

	@FXML
	void onGuardar(ActionEvent event) {

	}

	@FXML
	void onNuevo(ActionEvent event) {

	}

	public final ObjectProperty<Grupo> grupoProperty() {
		return this.grupo;
	}
	

	public final Grupo getGrupo() {
		return this.grupoProperty().get();
	}
	

	public final void setGrupo(final Grupo grupo) {
		this.grupoProperty().set(grupo);
	}
	
}
