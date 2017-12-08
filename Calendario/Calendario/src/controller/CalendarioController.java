package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CalendarioController implements Initializable {

	@FXML
	private ImageView display;

	@FXML
	private Pane panedotitulo;

	@FXML
	private Button btnConfirmar;

	@FXML
	private TextField txtTitle;

	@FXML
	private Label lbTerca;

	@FXML
	private Label labelInfo;

	@FXML
	private Menu MenuNovo;

	@FXML
	private TextField txtMinutoFinal;

	@FXML
	private CheckBox CbQuin;

	@FXML
	private CheckBox CbSab;

	@FXML
	private Label lbQuin;

	@FXML
	private CheckBox CbSeg;

	@FXML
	private Label lbSex;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Label lbTer;

	@FXML
	private CheckBox CbQuar;

	@FXML
	private ChoiceBox<String> chPeriodoFinal;

	@FXML
	private Label lbLogo;

	@FXML
	private Button btnCancelar;

	@FXML
	private MenuItem menuItemSobre;

	@FXML
	private ImageView icInfor;

	@FXML
	private CheckBox CbDom;

	@FXML
	private TextArea txtaComent;

	@FXML
	private ChoiceBox<String> chPeriodoInicial;

	@FXML
	private Label lbSeg;

	@FXML
	private Label lbSexta;

	@FXML
	private Label lbQuarta;

	@FXML
	private Label lbSab;

	@FXML
	private TextField txtHoraFinal;

	@FXML
	private TextField txtMinutoInicial;

	@FXML
	private Label lbSabado;

	@FXML
	private Label lbSegunda;

	@FXML
	private Menu MenuAjuda;

	@FXML
	private Label lbDomingo;

	@FXML
	private Label lbHoraFim;

	@FXML
	private Label lbQuinta;

	@FXML
	private TextField txtSala;

	@FXML
	private AnchorPane Anchor;

	@FXML
	private Label lbDom;

	@FXML
	private AnchorPane Anchor2;

	@FXML
	private Label lbHoraInicio;

	@FXML
	private ScrollPane scroPane;

	@FXML
	private Pane panelDDS;

	@FXML
	private CheckBox CbSex;

	@FXML
	private Label lbQuar;

	@FXML
	private TextField txtHoraInicial;

	@FXML
	private MenuItem menuItemEvento;

	@FXML
	private Pane panelEsquerdo;

	@FXML
	private CheckBox CbTer;

	@FXML
	private GridPane gpTabela;

	@FXML
	private TextField txtNomeCurso;

	@FXML
	private Pane panedocurso;

	@FXML
	private ColorPicker colorpicker;

	@FXML
	private MenuItem menuItemPrint;

	@FXML
	private Label lbsad;

	@FXML
	private Pane anchorPaneError;
	@FXML
	private Label lbline2;

	@FXML
	private Hyperlink hiperlk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void pegaInfoAction(ActionEvent e) throws IOException {
		txtTitle.getText();
		txtNomeCurso.getText();
		txtHoraInicial.getText().toString();
		txtMinutoInicial.getText().toString();
		chPeriodoInicial.getSelectionModel().getSelectedItem().toString();
		txtHoraFinal.getText().toString();
		txtMinutoFinal.getText().toString();
		chPeriodoFinal.getSelectionModel().getSelectedItem().toString();
		validarTempo();
	}

	public void validarTempo() throws IOException {
		int a1 = Integer.parseInt(txtHoraInicial.getText());
		int a2 = Integer.parseInt(txtMinutoInicial.getText());
		int a3 = Integer.parseInt(txtHoraFinal.getText());
		int a4 = Integer.parseInt(txtMinutoFinal.getText());
		int startTime = a1 * 60 + a2;
		int endingTime = a3 * 60 + a4;

		if (chPeriodoFinal.getSelectionModel().getSelectedItem().toString() == "PM") {
			if (startTime >= endingTime + 12) {
				Alert alert = new Alert(AlertType.CONFIRMATION,
						"A entrada de dados foi incorreta, verifique os campos de hora e período " + " ",
						ButtonType.YES);
				alert.showAndWait();
			} else if (startTime == endingTime + 12) {
				Alert alert = new Alert(AlertType.ERROR,
						"A entrada de dados foi incorreta, verifique os campos de hora e período " + " ",
						ButtonType.YES);
				alert.showAndWait();
			}
		}

		createTextField();
		novoCalendario();
	}

	private void createTextField() {
		int col = 0;
		int lin = Integer.parseInt(txtHoraInicial.getText());
		int linFinal = Integer.parseInt(txtHoraFinal.getText());
		scroPane.setFitToWidth(true);
		String textInput = txtHoraInicial.getText() + ":" + txtMinutoInicial.getText()
				+ " - " + txtHoraFinal.getText() + ":" +txtMinutoFinal.getText() + "\n"+ txtNomeCurso.getText();
		for (int i = 1; i < linFinal + 2; i++) {
			RowConstraints row = new RowConstraints(62);
			gpTabela.getRowConstraints().add(row);
			scroPane.setFitToWidth(true);
			Anchor2.setPrefHeight((linFinal + 3) * 62);

		}
		int aux = 0;
		for (int i = 0; i < linFinal + 1; i++) {
			if (i == aux) {
				Label periodo = new Label(i + ":" + "00 Horas");
				periodo.setPrefHeight(62);
				periodo.setPrefWidth(113);
				periodo.setStyle("-fx-background-color: #d0d9e8");
				gpTabela.add(periodo, 0, i);
				aux++;
			}

			if (CbSeg.isSelected()) {
				col = 1;
				Label lbClicavel = new Label(textInput);
				lbClicavel.getStylesheets().addAll();
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
				});
				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}

			if (CbTer.isSelected()) {
				col = 2;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
				});
				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}
			if (CbQuar.isSelected()) {
				col = 3;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
					;
				});
				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}
			if (CbQuin.isSelected()) {
				col = 4;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
				});
				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}
			if (CbSex.isSelected()) {
				col = 5;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
				});
				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}
			if (CbSab.isSelected()) {
				col = 6;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
					ArtDesatack(lin, linFinal, 6);
					ArtDesatack(lin, linFinal, 6);
				});

				;
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);

			}
			if (CbDom.isSelected()) {
				col = 7;
				Label lbClicavel = new Label(textInput);
				lbClicavel.setPrefHeight(62);
				lbClicavel.setPrefWidth(111);
				lbClicavel.setOnMouseClicked(e -> {
				});
				gpTabela.add(lbClicavel, col, lin);
				String color = colorpicker.getValue().toString().substring(2,
						colorpicker.getValue().toString().length() - 2);
				lbClicavel.setStyle("-fx-background-color: #" + color);
				ArtAtack(lin, linFinal, col, color);
			}
		}
	}

	public void novoCalendario() throws IOException {
		int sCbSeg, sCbTer, sCbQuar, sCbQuin, sCbSex, sCbSab, sCbDom;
		if (CbSeg.isSelected()) {
			sCbSeg = 1;
		} else {
			sCbSeg = 0;
		}
		if (CbTer.isSelected()) {
			sCbTer = 1;
		} else {
			sCbTer = 0;
		}
		if (CbQuar.isSelected()) {
			sCbQuar = 1;
		} else {
			sCbQuar = 0;
		}
		if (CbQuin.isSelected()) {
			sCbQuin = 1;
		} else {
			sCbQuin = 0;
		}
		if (CbSex.isSelected()) {
			sCbSex = 1;
		} else {
			sCbSex = 0;
		}
		if (CbSab.isSelected()) {
			sCbSab = 1;
		} else {
			sCbSab = 0;
		}
		if (CbDom.isSelected()) {
			sCbDom = 1;
		} else {
			sCbDom = 0;
		}

		String schedule = txtHoraInicial.getText().toString() + "|" + txtMinutoInicial.getText().toString() + "|"
				+ chPeriodoInicial.getSelectionModel().getSelectedItem().toString() + "|"
				+ txtHoraFinal.getText().toString() + "|" + txtMinutoFinal.getText().toString() + "|"
				+ chPeriodoFinal.getSelectionModel().getSelectedItem().toString() + "|" + sCbSeg + "|" + sCbTer + "|"
				+ sCbQuar + "|" + sCbQuin + "|" + sCbSex + "|" + sCbSab + "|" + sCbDom + "|" + txtSala.getText() + "|"
				+ txtaComent.getText() + System.lineSeparator();
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("./src/Calendarios/" + txtTitle.getText() + ".txt", true);

			out = new BufferedWriter(fstream);
			out.write(schedule);
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public void ArtAtack(int lin, int linFinal, int col, String color) {
		for (int j = lin + 1; j < linFinal + 1; j++) {
			Label pintura = new Label();
			pintura.setPrefHeight(62);
			pintura.setPrefWidth(111);
			gpTabela.add(pintura, col, j);
			pintura.setStyle("-fx-background-color: #" + color);
		}
	}

	public void ArtDesatack(int lin, int linFinal, int col) {
		System.out.println("chegou");
		for (int j = lin - 1; j < linFinal + 1; j++) {
			Label limpar = new Label();
			limpar.setPrefHeight(62);
			limpar.setPrefWidth(111);
			gpTabela.add(limpar, col, j);
		}
	}

	public void handleAboutScreen(ActionEvent e) throws IOException {

	}

	public void lerCalendario(File text) {
		try {
			File file = new File("test.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Conteudo do Arquivo:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handlerMenuItemAbout(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/JanelaAbout.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("Sobre o projeto");
		stage.setScene(new Scene(root1));
		stage.show();
	}

	public void viewCalendarios(ActionEvent e) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("./src/Calendarios/"));
		File selectedFile = fc.showOpenDialog(null);
		fc.getExtensionFilters().addAll(new ExtensionFilter("Arquivos Txt", "*.txt"));
		if (selectedFile != null) {
			chPeriodoFinal.getItems().add(selectedFile.getAbsolutePath());
		} else {
			System.out.println("Arquivo não existe");
		}
	}

	public void handlePrint(ActionEvent event) throws IOException {
		WritableImage image = gpTabela.snapshot(new SnapshotParameters(), null);
		File file = new File("./src/Calendarios/" + txtTitle.getText() + ".jpg");
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		} catch (IOException e) {
		}
	}
}
