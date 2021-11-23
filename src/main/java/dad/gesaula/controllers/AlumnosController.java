package dad.gesaula.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Grupo;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;

public class AlumnosController implements Initializable {

	// MODEL
	DatosController datos = new DatosController();
	
	private ListProperty<Alumno> alumnos = new SimpleListProperty<Alumno>(FXCollections.observableArrayList());

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellidos = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fecha = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<Sexo> sexo = new SimpleObjectProperty<Sexo>();
	private BooleanProperty repite = new SimpleBooleanProperty();
	
	private ObjectProperty<Alumno> selectedAlumno = new SimpleObjectProperty<>();
	

	// VIEW
	@FXML
	private SplitPane view;

	@FXML
	private BorderPane leftPane;

	@FXML
	private TableView<Alumno> alumnosTable;

	@FXML
	private TableColumn<Alumno, String> nombreColumn;

	@FXML
	private TableColumn<Alumno, String> apellidosColumn;

	@FXML
	private TableColumn<Alumno, LocalDate> fechaColumn;

	@FXML
	private TableColumn<Alumno, Sexo> sexoColumn;

	@FXML
	private TableColumn<Alumno, Boolean> repiteColumn;

	@FXML
	private Button nuevoButton;

	@FXML
	private Button eliminarButton;

	@FXML
	private BorderPane rightPane;

	public AlumnosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AlumnosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public SplitPane getView() {
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Init

		// Table
		alumnosTable.itemsProperty().bind(alumnos);

		// Columns
		nombreColumn.setCellValueFactory(v -> v.getValue().nombreProperty());
		apellidosColumn.setCellValueFactory(v -> v.getValue().apellidosProperty());
		fechaColumn.setCellValueFactory(v -> v.getValue().fechaNacimientoProperty());
		sexoColumn.setCellValueFactory(v -> v.getValue().sexoProperty());
		repiteColumn.setCellValueFactory(v -> v.getValue().repiteProperty());
		
		// Bindings
		
		
		// Listeners
		selectedAlumno.addListener((o, ov, nv) -> onSelected(o, ov, nv));
	}

	private void onSelected(ObservableValue<? extends Alumno> o, Alumno ov, Alumno nv) {
		if(nv != null)
		{
			rightPane.setCenter(DatosController.getView());
		}
		else
		{
			rightPane.setCenter(null);
		}
	}

	@FXML
	void onEliminar(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("¿Seguro");
		alert.setHeaderText("Se va a eliminar al alumno" + nombre.get() + "" + apellidos.get());
		alert.setContentText("¿Está seguro de hacerlo");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			alumnos.remove(alumnosTable.getSelectionModel().getSelectedItem());
		} else {
			alert.close();
		}
	}

	@FXML
	void onNuevo(ActionEvent event) {
		alumnos.add(new Alumno());
	}

	
	
}
