package dad.gesaula.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Grupo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GrupoController implements Initializable {

	// MODEL

	private ObjectProperty<Grupo> grupo = new SimpleObjectProperty<Grupo>();

	// VIEW
	@FXML
	private GridPane view;

	@FXML
	private TextField denominacionField;

	@FXML
	private DatePicker inicioDate;

	@FXML
	private DatePicker finDate;

	@FXML
	private Slider examenesSlider;

	@FXML
	private Label examenesLabel;

	@FXML
	private Slider practicasSlider;

	@FXML
	private Label practicasLabel;

	@FXML
	private Slider actitudSlider;

	@FXML
	private Label actitudLabel;

	public GrupoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GrupoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public GridPane getView() {
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
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
