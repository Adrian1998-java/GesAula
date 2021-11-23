package dad.gesaula.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DatosController implements Initializable {

	// MODEL
//	private AlumnosController alumnoscontroller = new AlumnosController();
	private ListProperty<Alumno> alumnos = new SimpleListProperty<Alumno>(FXCollections.observableArrayList());

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellidos = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fecha = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<Sexo> sexo = new SimpleObjectProperty<Sexo>();
	private BooleanProperty repite = new SimpleBooleanProperty();

	// VIEW
	@FXML
	private static GridPane view;

	@FXML
	private TextField nombreField;

	@FXML
	private TextField apellidosField;

	@FXML
	private DatePicker fechaDate;

	@FXML
	private ComboBox<Sexo> sexoCombo;

	@FXML
	private CheckBox repiteCheck;

	public DatosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DatosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public static GridPane getView() {
		return view;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Init Alumnos List
//		alumnos.set(alumnoscontroller.getAlumnos());

		// Init componets
		sexoCombo.getItems().addAll(Sexo.values());
		sexoCombo.getSelectionModel().selectFirst();
		
		//Bindings
		nombreField.textProperty().bind(nombre);
		apellidosField.textProperty().bind(apellidos);
		fechaDate.valueProperty().bind(fecha);
		sexoCombo.valueProperty().bind(sexo);
		repiteCheck.selectedProperty().bind(repite);

	}

	public final ListProperty<Alumno> alumnosProperty() {
		return this.alumnos;
	}

	public final ObservableList<Alumno> getAlumnos() {
		return this.alumnosProperty().get();
	}

	public final void setAlumnos(final ObservableList<Alumno> alumnos) {
		this.alumnosProperty().set(alumnos);
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public String getNombre() {
		return this.nombreProperty().get();
	}
	

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public StringProperty apellidosProperty() {
		return this.apellidos;
	}
	

	public String getApellidos() {
		return this.apellidosProperty().get();
	}
	

	public void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}
	

	public ObjectProperty<LocalDate> fechaProperty() {
		return this.fecha;
	}
	

	public LocalDate getFecha() {
		return this.fechaProperty().get();
	}
	

	public void setFecha(final LocalDate fecha) {
		this.fechaProperty().set(fecha);
	}
	

	public ObjectProperty<Sexo> sexoProperty() {
		return this.sexo;
	}
	

	public Sexo getSexo() {
		return this.sexoProperty().get();
	}
	

	public void setSexo(final Sexo sexo) {
		this.sexoProperty().set(sexo);
	}
	

	public BooleanProperty repiteProperty() {
		return this.repite;
	}
	

	public boolean isRepite() {
		return this.repiteProperty().get();
	}
	

	public void setRepite(final boolean repite) {
		this.repiteProperty().set(repite);
	}
	

	
}
