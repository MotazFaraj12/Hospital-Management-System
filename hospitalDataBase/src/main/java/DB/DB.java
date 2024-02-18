package DB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;
import static javafx.stage.Modality.NONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DB extends Application {
    /***************************/
    private ArrayList<medicine> medicineData;
    private ArrayList<bill> billData;
    private ArrayList<diagnosis> diagnosisData;
    private ArrayList<doctor> doctorData;
    private ArrayList<nurse> nurseData;
    private ArrayList<patient> patientData;
    private ArrayList<room> roomData;
    private ArrayList<Report2> Report2;
    private ArrayList<Report3> Report3;
    private ArrayList<Report4> Report4;
    private ArrayList<Report3> Report5;
    private ArrayList<Integer> Report6;
    private ArrayList<Report5> Report10;
    /***************************/
    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "0000";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "FinalDB";
    private Connection con;
    /***************************/
    public static void main(String[] args) {
        launch(args);
    }
    /***************************/
    private ObservableList<medicine> dataListMedicine;
    private ObservableList<bill> dataListBill;
    private ObservableList<diagnosis> dataListDiagnosis;
    private ObservableList<doctor> dataListDoctor;
    private ObservableList<nurse> dataListNurse;
    private ObservableList<room> dataListRoom;
    private ObservableList<patient> dataListPatient;
    private ObservableList<Report2> PatientDoctor;
    private ObservableList<Report3> PatientRoom;
    private ObservableList<Report4> PatientBillAmount;
    private ObservableList<Report3> PatientNurses;
    private ObservableList<Report5> DoctorDignosis;
    private ImageView backGroundIV = new ImageView(new Image("file:Background.jpg"));
    /***************************/
    Stage stage2 = new Stage();
    @Override
    public void start(Stage stage) {
        /***************************/
        medicineData = new ArrayList<>();
        billData = new ArrayList<>();
        diagnosisData = new ArrayList<>();
        doctorData = new ArrayList<>();
        nurseData = new ArrayList<>();
        patientData = new ArrayList<>();
        roomData = new ArrayList<>();
        Report2 = new ArrayList<>();
        Report3 = new ArrayList<>();
        Report4= new ArrayList<>();
        Report5= new ArrayList<>();
        Report6=new ArrayList<>();
        Report10=new ArrayList<>();
        /***************************/
        try {
            //reading data
            getDataMedicine();
            getDataBill();
            getDataDiagnosis();
            getDataRoom();
            getDataNurse();
            getDataDoctor();
            getDataPatient();
            //convert data from arraylist to observable arraylist
            dataListMedicine = FXCollections.observableArrayList(medicineData);
            dataListBill = FXCollections.observableArrayList(billData);
            dataListDoctor=FXCollections.observableArrayList(doctorData);
            dataListDiagnosis=FXCollections.observableArrayList(diagnosisData);
            dataListNurse=FXCollections.observableArrayList(nurseData);
            dataListRoom=FXCollections.observableArrayList(roomData);
            dataListPatient=FXCollections.observableArrayList(patientData);
            PatientRoom = FXCollections.observableArrayList(Report3);
            // Create a Stage
            stage2.setTitle("Hospital");

            AnchorPane root1 = new AnchorPane();
            AnchorPane root2 = new AnchorPane();
            HBox root3 = new HBox();
            //making buttons
            Button MedicineTable = new Button("Medicine Table");
            Button BillTable = new Button("Bill Table");
            Button DiagnosisTable = new Button("Diagnosis Table");
            Button RoomTable = new Button("Room Table");
            Button NurseTable = new Button("Nurse Table");
            Button DoctorTable = new Button("Doctor Table");
            Button PatientTable = new Button("Patient Table");
            MedicineTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Medicine Table");
                VBox table = tableViewMedicine(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                root.getChildren().addAll(CloseTable);
                /*
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table,root);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                //stage3.show();

                 */
            });
            BillTable.setOnAction(e -> {
                root2.getChildren().clear();
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Bill Table");
                VBox table=tableViewBill(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().add(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/

            });
            DiagnosisTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Diagnosis Table");
                VBox table=tableViewDiagnosis(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                String style = getClass().getResource("Style.css").toExternalForm();
                scene3.getStylesheets().addAll(style);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/
            });
            RoomTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Room Table");
                VBox table=tableViewRoom(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                String style = getClass().getResource("Style.css").toExternalForm();
                scene3.getStylesheets().addAll(style);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/
            });
            NurseTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Nurse Table");
                VBox table=tableViewNurse(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                String style = getClass().getResource("Style.css").toExternalForm();
                scene3.getStylesheets().addAll(style);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/
            });
            DoctorTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Doctor Table");
                VBox table=tableViewDoctor(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                String style = getClass().getResource("Style.css").toExternalForm();
                scene3.getStylesheets().addAll(style);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/
            });
            PatientTable.setOnAction(e -> {
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("Patient Table");
                VBox table=tableViewPatient(stage3);
                table.setLayoutX(590);
                table.setLayoutY(100);
                root2.getChildren().clear();
                root2.getChildren().addAll(table);
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);
                Button CloseTable = new Button("Close Table");
                CloseTable.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });
                /*root.getChildren().addAll(CloseTable);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(table, root);
                String style = getClass().getResource("Style.css").toExternalForm();
                scene3.getStylesheets().addAll(style);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();*/
            });
            Button ShutDown = new Button("ShutDown");
            ShutDown.setOnAction(t -> {
                stage2.close();
            });

            root3.setAlignment(Pos.CENTER);
            root3.setLayoutX(370);
            root3.setLayoutY(20);
            root3.setPadding(new Insets(10, 5, 5, 10));
            root3.setAlignment(Pos.CENTER);
            root3.setSpacing(10);
            root3.getChildren().addAll(MedicineTable,BillTable,DiagnosisTable,RoomTable
                           ,NurseTable,DoctorTable,PatientTable,ShutDown);
            root2.setLayoutX(0);
            root2.getChildren().add(new Label("here"));
            root2.setLayoutY(70);
            root1.getChildren().add(backGroundIV);
            root1.getChildren().add(root3);
            root1.getChildren().add(root2);

            Scene scene = new Scene(root1, 1920, 1080);
            String style = getClass().getResource("Style.css").toExternalForm();
            scene.getStylesheets().addAll(style);
            stage2.setScene(scene);
            stage2.show();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * @return
     *************************/
    private VBox tableViewMedicine(Stage stage) {

        TableView<medicine> myDataTable = new TableView<medicine>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Medicine Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Medicine Table");
        label.setFont(new Font("Arial", 1000));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(600);
        /***************************/
        TableColumn<medicine, Integer> Medicine_idCol = new TableColumn<medicine, Integer>("Medicine_id");
        Medicine_idCol.setMinWidth(200);
        Medicine_idCol.setCellValueFactory(new PropertyValueFactory<medicine, Integer>("Medicine_id"));
        /***************************/
        TableColumn<medicine, String> Medicine_nameCol = new TableColumn<medicine, String>("Medicine_name");
        Medicine_nameCol.setMinWidth(200);
        Medicine_nameCol.setCellValueFactory(new PropertyValueFactory<medicine, String>("Medicine_name"));
        Medicine_nameCol.setResizable(false);

        Medicine_nameCol.setCellFactory(TextFieldTableCell.<medicine>forTableColumn());
        Medicine_nameCol.setOnEditCommit(
                (CellEditEvent<medicine, String> t) -> {
                    ((medicine) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMedicine_name(t.getNewValue()); //display only
                    updateMedicineName( t.getRowValue().getMedicine_id(),t.getNewValue());
                });
        /***************************/
        TableColumn<medicine, Integer> PriceCol = new TableColumn<medicine, Integer>("Price");
        PriceCol.setMinWidth(200);
        PriceCol.setCellValueFactory(new PropertyValueFactory<medicine, Integer>("Price"));

        PriceCol.setCellFactory(TextFieldTableCell.<medicine,Integer>
                forTableColumn(new IntegerStringConverter()));

        PriceCol.setOnEditCommit(
                (CellEditEvent<medicine, Integer> t) -> {
                    ((medicine) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPrice(t.getNewValue());
                    updateMedicinePrice( t.getRowValue().getMedicine_id(),t.getNewValue());
        });
        /***************************/

        myDataTable.setItems(dataListMedicine);

        myDataTable.getColumns().addAll(Medicine_idCol, Medicine_nameCol, PriceCol);

        final TextField addMedicine_id = new TextField();
        addMedicine_id.setPromptText("Medicine_id");
        addMedicine_id.setMaxWidth(Medicine_idCol.getPrefWidth());
        addMedicine_id.setPrefSize(300,31);

        final TextField addMedicine_name = new TextField();
        addMedicine_name.setMaxWidth(Medicine_nameCol.getPrefWidth());
        addMedicine_name.setPromptText("Medicine_name");
        addMedicine_name.setPrefSize(300,31);

        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(PriceCol.getPrefWidth());
        addPrice.setPromptText("Price");
        addPrice.setPrefSize(300,31);

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            medicine rc;
            rc = new medicine(
                    Integer.valueOf(addMedicine_id.getText()),
                    addMedicine_name.getText(),
                    Integer.valueOf(addPrice.getText()));
            dataListMedicine.add(rc);
            insertDataMedicine(rc);
            addMedicine_id.clear();
            addMedicine_name.clear();
            addPrice.clear();
        });

        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<medicine> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<medicine> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowMedicine(row);
                myDataTable.refresh();
            });
        });

        hb.getChildren().addAll(addMedicine_id, addMedicine_name, addPrice, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogMedicine(stage, NONE, myDataTable);
        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        final AnchorPane root = new AnchorPane();
        root.getChildren().addAll(label, myDataTable, hb,hb2);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2);
        vbox.setPrefSize(700,650);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewBill(Stage stage) {

        TableView<bill> myDataTable = new TableView<bill>();
        TableView<Report4> Output = new TableView<Report4>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Bill Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Bill Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(600);

        /***************************/
        TableColumn<bill, Integer> Bill_noCol = new TableColumn<bill, Integer>("Bill_no");
        Bill_noCol.setMinWidth(50);
        Bill_noCol.setCellValueFactory(new PropertyValueFactory<bill, Integer>("Bill_no"));
        /***************************/
        TableColumn<bill, Integer> Patient_idCol = new TableColumn<bill, Integer>("Patient_id");
        Patient_idCol.setMinWidth(100);
        Patient_idCol.setCellValueFactory(new PropertyValueFactory<bill, Integer>("Patient_id"));
        /***************************/
        TableColumn<bill, Integer> Bill_amountCol = new TableColumn<bill, Integer>("Bill_amount");
        Bill_amountCol.setMinWidth(50);
        Bill_amountCol.setCellValueFactory(new PropertyValueFactory<bill, Integer>("Bill_amount"));

        Bill_amountCol.setCellFactory(TextFieldTableCell.<bill,Integer>
                forTableColumn(new IntegerStringConverter()));

        Bill_amountCol.setOnEditCommit(
                (CellEditEvent<bill, Integer> t) -> {
                    ((bill) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setBill_amount(t.getNewValue());
                    updateBillAmountBill( t.getRowValue().getBill_no(),t.getNewValue());
                });
        /***************************/
        myDataTable.setItems(dataListBill);

        myDataTable.getColumns().addAll(Bill_noCol, Patient_idCol, Bill_amountCol);



        final TextField addBill_no = new TextField();
        addBill_no.setPromptText("Bill_no");
        addBill_no.setMaxWidth(Bill_noCol.getPrefWidth());

        final TextField addPatient_ide = new TextField();
        addPatient_ide.setMaxWidth(Patient_idCol.getPrefWidth());
        addPatient_ide.setPromptText("Patient_id");

        final TextField addBill_amount = new TextField();
        addBill_amount.setMaxWidth(Bill_amountCol.getPrefWidth());
        addBill_amount.setPromptText("Bill_amount");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            bill rc;
            rc = new bill(
                    Integer.valueOf(addBill_no.getText()),
                    Integer.valueOf(addPatient_ide.getText()),
                    Integer.valueOf(addBill_amount.getText()));
            dataListBill.add(rc);
            insertDataBill(rc);
            addBill_no.clear();
            addPatient_ide.clear();
            addBill_amount.clear();
        });

        final TextField addBillCount = new TextField();
        addBillCount.setMaxWidth(Bill_noCol.getPrefWidth());
        addBillCount.setPromptText("Count the Number of Bills Grater then");
        final  TextField output = new TextField();
        final Button CountBill = new Button("Excute");
        Label l = new Label("Count the Number of Bills Higher than:");
        l.setTextFill(Color.BLACK);
        CountBill.setOnAction((ActionEvent r) -> {
            int Value = Integer.valueOf(addBillCount.getText());
            try {
                output.setMaxWidth(Bill_noCol.getPrefWidth());
                output.setPromptText("Output");
                int fimnalvalue = BillCount(Value);
                output.setText(String.valueOf(fimnalvalue));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        final TextField addPatientBillAmount = new TextField();
        addPatientBillAmount.setMaxWidth(Bill_noCol.getPrefWidth());
        addPatientBillAmount.setPromptText("Bill Amount");
        final Button PatientforBillAmount = new Button("Execute");
        Label le = new Label("Find all the Patient whose Bill Amount is >=");
        le.setTextFill(Color.BLACK);
        PatientforBillAmount.setOnAction((ActionEvent r) -> {
            try {
                FindAllPatientsInBillAmount(Integer.valueOf(addPatientBillAmount.getText()));
                PatientBillAmount = FXCollections.observableArrayList(Report4);
                Output.setEditable(true);
                Output.setMaxHeight(500);
                Output.setMaxWidth(500);
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("all the Patient whose Bill Amount is >="+Integer.valueOf(addPatientBillAmount.getText()));
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);

                TableColumn<Report4, Integer> Patient_id2Col = new TableColumn<Report4, Integer>("Patient_id");
                Patient_id2Col.setMinWidth(50);
                Patient_id2Col.setCellValueFactory(new PropertyValueFactory<Report4, Integer>("Patient_id"));

                TableColumn<Report4, String> Patient_name2Col = new TableColumn<Report4, String>("Patient_name");
                Patient_name2Col.setMinWidth(50);
                Patient_name2Col.setCellValueFactory(new PropertyValueFactory<Report4, String>("Patient_name"));

                TableColumn<Report4, Integer> Bill_amount2Col = new TableColumn<Report4, Integer>("Bill_amount");
                Bill_amount2Col.setMinWidth(50);
                Bill_amount2Col.setCellValueFactory(new PropertyValueFactory<Report4, Integer>("Bill_amount"));


                Output.setItems(PatientBillAmount);
                Output.getColumns().addAll(Patient_id2Col,Patient_name2Col, Bill_amount2Col);

                Button CloseTab = new Button("Close Tab");
                CloseTab.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });

                root.getChildren().addAll(CloseTab);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(Output,root);
                vbox.setPrefSize(700,650);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        final HBox er = new HBox();
        final HBox eq = new HBox();
        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<bill> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<bill> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowBill(row);
                myDataTable.refresh();
            });
        });

        er.getChildren().addAll(l,addBillCount, CountBill,output);
        eq.getChildren().addAll(le,addPatientBillAmount,PatientforBillAmount);
        hb.getChildren().addAll(addBill_no, addPatient_ide, addBill_amount, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogBill(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPrefSize(700,650);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2,er,eq);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewDiagnosis(Stage stage) {

        TableView<diagnosis> myDataTable = new TableView<diagnosis>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Diagnosis Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Diagnosis Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(600);

        /*****************************/
        TableColumn<diagnosis, Integer> Diagnosis_noCol = new TableColumn<diagnosis, Integer>("Diagnosis_no");
        Diagnosis_noCol.setMinWidth(50);
        Diagnosis_noCol.setCellValueFactory(new PropertyValueFactory<diagnosis, Integer>("Diagnosis_no"));
        /*****************************/
        TableColumn<diagnosis, String> Diagnosis_DateCol = new TableColumn<diagnosis, String>("Diagnosis_Date");
        Diagnosis_DateCol.setMinWidth(100);
        Diagnosis_DateCol.setCellValueFactory(new PropertyValueFactory<diagnosis, String>("Diagnosis_Date"));
        /*****************************/
        TableColumn<diagnosis, String> DetailsCol = new TableColumn<diagnosis, String>("Details");
        DetailsCol.setMinWidth(50);
        DetailsCol.setCellValueFactory(new PropertyValueFactory<diagnosis, String>("Details"));

        DetailsCol.setCellFactory(TextFieldTableCell.<diagnosis>forTableColumn());
        DetailsCol.setOnEditCommit(
                (CellEditEvent<diagnosis, String> t) -> {
                    ((diagnosis) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDetails(t.getNewValue());
                    updateDetails( t.getRowValue().getDiagnosis_no(),t.getNewValue());
                });
        /*****************************/
        TableColumn<diagnosis, String> SeverityCol = new TableColumn<diagnosis, String>("Severity");
        SeverityCol.setMinWidth(50);
        SeverityCol.setCellValueFactory(new PropertyValueFactory<diagnosis, String>("Severity"));

        SeverityCol.setCellFactory(TextFieldTableCell.<diagnosis>forTableColumn());
        SeverityCol.setOnEditCommit(
                (CellEditEvent<diagnosis, String> t) -> {
                    ((diagnosis) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSeverity(t.getNewValue());
                    updateSeverity( t.getRowValue().getDiagnosis_no(),t.getNewValue());
                });
        /*****************************/
        TableColumn<diagnosis, Integer> Doctor_idCol = new TableColumn<diagnosis, Integer>("Doctor_id");
        Doctor_idCol.setMinWidth(50);
        Doctor_idCol.setCellValueFactory(new PropertyValueFactory<diagnosis, Integer>("Doctor_id"));
        /*****************************/
        myDataTable.setItems(dataListDiagnosis);

        myDataTable.getColumns().addAll(Diagnosis_noCol, Diagnosis_DateCol, DetailsCol,SeverityCol,Doctor_idCol);

        final TextField addDiagnosis_no = new TextField();
        addDiagnosis_no.setPromptText("Diagnosis_no");
        addDiagnosis_no.setMaxWidth(Doctor_idCol.getPrefWidth());

        final TextField addDiagnosis_Date = new TextField();
        addDiagnosis_Date.setMaxWidth(Diagnosis_DateCol.getPrefWidth());
        addDiagnosis_Date.setPromptText("Diagnosis_Date");

        final TextField addDetails = new TextField();
        addDetails.setMaxWidth(SeverityCol.getPrefWidth());
        addDetails.setPromptText("Details");

        final TextField addSeverity = new TextField();
        addSeverity.setMaxWidth(SeverityCol.getPrefWidth());
        addSeverity.setPromptText("Severity");

        final TextField addDoctor_id = new TextField();
        addDoctor_id.setMaxWidth(SeverityCol.getPrefWidth());
        addDoctor_id.setPromptText("Doctor_id");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            diagnosis rc;
            rc = new diagnosis(
                    Integer.valueOf(addDiagnosis_no.getText()),
                    addDiagnosis_Date.getText(),
                    addDetails.getText(),
                    addSeverity.getText(),
                    Integer.valueOf(addDoctor_id.getText())
            );
            dataListDiagnosis.add(rc);
            insertDataDiagnosis(rc);
            addDiagnosis_no.clear();
            addDiagnosis_Date.clear();
            addDetails.clear();
            addSeverity.clear();
            addDoctor_id.clear();
        });

        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<diagnosis> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<diagnosis> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowDiagnosis(row);
                myDataTable.refresh();
            });
        });

        hb.getChildren().addAll(addDiagnosis_no, addDiagnosis_Date,addDetails,addSeverity, addDoctor_id, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogDiagnosis(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2);
        vbox.setPrefSize(700,650);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewRoom(Stage stage) {

        TableView<room> myDataTable = new TableView<room>();
        TableView<Report3> Output = new TableView<Report3>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Rooms Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Rooms Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(400);


        /*************************/
        TableColumn<room, Integer> Room_noCol = new TableColumn<room, Integer>("Room_no");
        Room_noCol.setMinWidth(50);
        Room_noCol.setCellValueFactory(new PropertyValueFactory<room, Integer>("Room_no"));
        /*************************/
        TableColumn<room, String> Room_typeCol = new TableColumn<room, String>("Room_type");
        Room_typeCol.setMinWidth(100);
        Room_typeCol.setCellValueFactory(new PropertyValueFactory<room, String>("Room_type"));

        Room_typeCol.setCellFactory(TextFieldTableCell.<room>forTableColumn());
        Room_typeCol.setOnEditCommit(
                (CellEditEvent<room, String> t) -> {
                    ((room) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setRoom_type(t.getNewValue()); //display only
                    updateRoomType( t.getRowValue().getRoom_no(),t.getNewValue());
                });
        /*************************/
        TableColumn<room, Integer> PeriodCol = new TableColumn<room, Integer>("Period");
        PeriodCol.setMinWidth(50);
        PeriodCol.setCellValueFactory(new PropertyValueFactory<room, Integer>("Period"));
        PeriodCol.setCellFactory(TextFieldTableCell.<room,Integer>
                forTableColumn(new IntegerStringConverter()));
        PeriodCol.setOnEditCommit(
                (CellEditEvent<room, Integer> t) -> {
                    ((room) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPeriod(t.getNewValue());
                    updatePeriod( t.getRowValue().getRoom_no(),t.getNewValue());
                });
        /*************************/
        myDataTable.setItems(dataListRoom);

        myDataTable.getColumns().addAll(Room_noCol, Room_typeCol, PeriodCol);

        final TextField addRoom_no = new TextField();
        addRoom_no.setPromptText("Room_no");
        addRoom_no.setMaxWidth(Room_noCol.getPrefWidth());

        final TextField addRoom_type = new TextField();
        addRoom_type.setMaxWidth(Room_typeCol.getPrefWidth());
        addRoom_type.setPromptText("Room_type");

        final TextField addPeriod = new TextField();
        addPeriod.setMaxWidth(PeriodCol.getPrefWidth());
        addPeriod.setPromptText("Period");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            room rc;
            rc = new room(
                    Integer.valueOf(addRoom_no.getText()),
                    addRoom_type.getText(),
                    Integer.valueOf(addPeriod.getText()));
            dataListRoom.add(rc);
            insertDataRoom(rc);
            addRoom_no.clear();
            addRoom_type.clear();
            addPeriod.clear();
        });

        final TextField addPatientsInRoom = new TextField();
        addPatientsInRoom.setMaxWidth(addRoom_no.getPrefWidth());
        addPatientsInRoom.setPromptText("Room Number");
        final  TextField output = new TextField();
        final Button PatientinRoom = new Button("Excute");
        Label l = new Label("Find all the Patient in a certain Room with RoomNo=");
        l.setTextFill(Color.BLACK);
        PatientinRoom.setOnAction((ActionEvent r) -> {
            try {
                FindAllPatientsInaRoom(Integer.valueOf(addPatientsInRoom.getText()));
                PatientRoom = FXCollections.observableArrayList(Report3);
                Output.setEditable(true);
                Output.setMaxHeight(500);
                Output.setMaxWidth(500);
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("All Patients in Room"+Integer.valueOf(addPatientsInRoom.getText()));
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);

                TableColumn<Report3, Integer> Patient_id2Col = new TableColumn<Report3, Integer>("Patient_id");
                Patient_id2Col.setMinWidth(50);
                Patient_id2Col.setCellValueFactory(new PropertyValueFactory<Report3, Integer>("Patient_id3"));

                TableColumn<Report3, String> Patient_name2Col = new TableColumn<Report3, String>("Patient_name");
                Patient_name2Col.setMinWidth(50);
                Patient_name2Col.setCellValueFactory(new PropertyValueFactory<Report3, String>("Patient_name3"));

                Output.setItems(PatientRoom);
                Output.getColumns().addAll(Patient_id2Col,Patient_name2Col);

                Button CloseTab = new Button("Close Tab");
                CloseTab.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });

                root.getChildren().addAll(CloseTab);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(Output,root);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        final HBox rb = new HBox();
        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<room> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<room> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowRoom(row);
                myDataTable.refresh();
            });
        });

        rb.getChildren().addAll(l,addPatientsInRoom,PatientinRoom);
        hb.getChildren().addAll(addRoom_no, addRoom_type, addPeriod, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogRoom(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2,rb);
        vbox.setPrefSize(700,650);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewNurse(Stage stage) {

        TableView<nurse> myDataTable = new TableView<nurse>();
        TableView<Report3> Output = new TableView<Report3>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Nurse Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Nurse Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(600);

        /*****************************/
        TableColumn<nurse, Integer> Nurse_idCol = new TableColumn<nurse, Integer>("Nurse_id");
        Nurse_idCol.setMinWidth(50);
        Nurse_idCol.setCellValueFactory(new PropertyValueFactory<nurse, Integer>("Nurse_id"));
        /*****************************/
        TableColumn<nurse, String> Nurse_nameCol = new TableColumn<nurse, String>("Nurse_name");
        Nurse_nameCol.setMinWidth(100);
        Nurse_nameCol.setCellValueFactory(new PropertyValueFactory<nurse, String>("Nurse_name"));

        Nurse_nameCol.setCellFactory(TextFieldTableCell.<nurse>forTableColumn());
        Nurse_nameCol.setOnEditCommit(
                (CellEditEvent<nurse, String> t) -> {
                    ((nurse) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setNurse_name(t.getNewValue());
                    updateNurseName( t.getRowValue().getNurse_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<nurse, String> ShiftCol = new TableColumn<nurse, String>("Shift");
        ShiftCol.setMinWidth(50);
        ShiftCol.setCellValueFactory(new PropertyValueFactory<nurse, String>("Shift"));

        ShiftCol.setCellFactory(TextFieldTableCell.<nurse>forTableColumn());
        ShiftCol.setOnEditCommit(
                (CellEditEvent<nurse, String> t) -> {
                    ((nurse) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setShift(t.getNewValue());
                    updateShift( t.getRowValue().getNurse_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<nurse, Integer> SalaryCol = new TableColumn<nurse, Integer>("Salary");
        SalaryCol.setMinWidth(50);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<nurse, Integer>("Salary"));

        SalaryCol.setCellFactory(TextFieldTableCell.<nurse,Integer>
                forTableColumn(new IntegerStringConverter()));
        SalaryCol.setOnEditCommit(
                (CellEditEvent<nurse, Integer> t) -> {
                    ((nurse) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSalary(t.getNewValue());
                    updateNurseSalary( t.getRowValue().getNurse_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<nurse, String> AddressCol = new TableColumn<nurse, String>("Address");
        AddressCol.setMinWidth(100);
        AddressCol.setCellValueFactory(new PropertyValueFactory<nurse, String>("Address"));

        AddressCol.setCellFactory(TextFieldTableCell.<nurse>forTableColumn());
        AddressCol.setOnEditCommit(
                (CellEditEvent<nurse, String> t) -> {
                    ((nurse) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAddress(t.getNewValue());
                    updateNurseAddress( t.getRowValue().getNurse_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<nurse, Integer> PhoneNumberCol = new TableColumn<nurse, Integer>("PhoneNumber");
        PhoneNumberCol.setMinWidth(100);
        PhoneNumberCol.setCellValueFactory(new PropertyValueFactory<nurse, Integer>("PhoneNumber"));

        PhoneNumberCol.setCellFactory(TextFieldTableCell.<nurse,Integer>
                forTableColumn(new IntegerStringConverter()));
        PhoneNumberCol.setOnEditCommit(
                (CellEditEvent<nurse, Integer> t) -> {
                    ((nurse) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhoneNumber(t.getNewValue());
                    updateNursePhoneNumber( t.getRowValue().getNurse_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<nurse, Integer> GenderCol = new TableColumn<nurse, Integer>("Gender");
        GenderCol.setMinWidth(100);
        GenderCol.setCellValueFactory(new PropertyValueFactory<nurse, Integer>("Gender"));
        /*****************************/

        myDataTable.setItems(dataListNurse);

        myDataTable.getColumns().addAll(Nurse_idCol, Nurse_nameCol, ShiftCol, SalaryCol, AddressCol,PhoneNumberCol,GenderCol);

        final TextField addNurse_id = new TextField();
        addNurse_id.setPromptText("Nurse_id");
        addNurse_id.setMaxWidth(AddressCol.getPrefWidth());

        final TextField addNurse_name = new TextField();
        addNurse_name.setMaxWidth(Nurse_nameCol.getPrefWidth());
        addNurse_name.setPromptText("Nurse_name");

        final TextField addShift = new TextField();
        addShift.setMaxWidth(SalaryCol.getPrefWidth());
        addShift.setPromptText("Shift");

        final TextField addSalary = new TextField();
        addSalary.setMaxWidth(SalaryCol.getPrefWidth());
        addSalary.setPromptText("Salary");

        final TextField addAddress = new TextField();
        addAddress.setMaxWidth(SalaryCol.getPrefWidth());
        addAddress.setPromptText("Address");

        final TextField addPhoneNumber = new TextField();
        addPhoneNumber.setMaxWidth(SalaryCol.getPrefWidth());
        addPhoneNumber.setPromptText("PhoneNumber");

        final TextField addGender= new TextField();
        addGender.setMaxWidth(SalaryCol.getPrefWidth());
        addGender.setPromptText("addGender");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            nurse rc;
            rc = new nurse(
                    Integer.valueOf(addNurse_id.getText()),
                    addNurse_name.getText(),
                    addShift.getText(),
                    Integer.valueOf(addSalary.getText()),
                    addAddress.getText(),
                    Integer.valueOf(addPhoneNumber.getText()),
                    addGender.getText()
            );
            dataListNurse.add(rc);
            insertDataNurse(rc);
            addNurse_id.clear();
            addNurse_name.clear();
            addShift.clear();
            addSalary.clear();
            addAddress.clear();
            addPhoneNumber.clear();
            addGender.clear();
        });

        final TextField addPatientForNurse = new TextField();
        addPatientForNurse.setMaxWidth(addNurse_id.getPrefWidth());
        addPatientForNurse.setPromptText("Nurse ID");
        final Button PatientForNurse = new Button("Excute");
        Label l = new Label("Find all the Patient for a certain Nurse with NurseID=");
        l.setTextFill(Color.BLACK);
        PatientForNurse.setOnAction((ActionEvent r) -> {
            try {
                FindAllPatientsForNurse(Integer.valueOf(addPatientForNurse.getText()));
                PatientNurses = FXCollections.observableArrayList(Report5);
                Output.setEditable(true);
                Output.setMaxHeight(500);
                Output.setMaxWidth(500);
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("All the Patients Under the Nurse whose ID is"+Integer.valueOf(addPatientForNurse.getText()));
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);

                TableColumn<Report3, Integer> Patient_id3Col = new TableColumn<Report3, Integer>("Patient_id");
                Patient_id3Col.setMinWidth(50);
                Patient_id3Col.setCellValueFactory(new PropertyValueFactory<Report3, Integer>("Patient_id3"));

                TableColumn<Report3, String> Patient_name3Col = new TableColumn<Report3, String>("Patient_name");
                Patient_name3Col.setMinWidth(50);
                Patient_name3Col.setCellValueFactory(new PropertyValueFactory<Report3, String>("Patient_name3"));


                Output.setItems(PatientNurses);
                Output.getColumns().addAll(Patient_id3Col, Patient_name3Col);

                Button CloseTab = new Button("Close Tab");
                CloseTab.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });

                root.getChildren().addAll(CloseTab);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(Output,root);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        final HBox rb = new HBox();
        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<nurse> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<nurse> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowNurse(row);
                myDataTable.refresh();
            });
        });

        rb.getChildren().addAll(l,addPatientForNurse, PatientForNurse);
        hb.getChildren().addAll(addNurse_id, addNurse_name, addShift, addSalary, addAddress, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogNurse(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2,rb);
        vbox.setPrefSize(700,650);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewDoctor(Stage stage) {

        TableView<doctor> myDataTable = new TableView<doctor>();
        TableView<Report5> Output = new TableView<Report5>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Doctor Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Doctor Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLACK);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(700);

        /*****************************/
        TableColumn<doctor, Integer> Doctor_idCol = new TableColumn<doctor, Integer>("Doctor_id");
        Doctor_idCol.setMinWidth(50);
        Doctor_idCol.setCellValueFactory(new PropertyValueFactory<doctor, Integer>("Doctor_id"));
        /*****************************/
        TableColumn<doctor, String> Doctor_nameCol = new TableColumn<doctor, String>("Doctor_name");
        Doctor_nameCol.setMinWidth(100);
        Doctor_nameCol.setCellValueFactory(new PropertyValueFactory<doctor, String>("Doctor_name"));

        Doctor_nameCol.setCellFactory(TextFieldTableCell.<doctor>forTableColumn());
        Doctor_nameCol.setOnEditCommit(
                (CellEditEvent<doctor, String> t) -> {
                    ((doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDoctor_name(t.getNewValue());
                    updateDoctorName( t.getRowValue().getDoctor_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<doctor, String> AddresstCol = new TableColumn<doctor, String>("Address");
        AddresstCol.setMinWidth(100);
        AddresstCol.setCellValueFactory(new PropertyValueFactory<doctor, String>("Address"));

        AddresstCol.setCellFactory(TextFieldTableCell.<doctor>forTableColumn());
        AddresstCol.setOnEditCommit(
                (CellEditEvent<doctor, String> t) -> {
                    ((doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAddress(t.getNewValue());
                    updateDoctorAddress( t.getRowValue().getDoctor_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<doctor, String> SpecialtyCol = new TableColumn<doctor, String>("Specialty");
        SpecialtyCol.setMinWidth(100);
        SpecialtyCol.setCellValueFactory(new PropertyValueFactory<doctor, String>("Specialty"));

        SpecialtyCol.setCellFactory(TextFieldTableCell.<doctor>forTableColumn());
        SpecialtyCol.setOnEditCommit(
                (CellEditEvent<doctor, String> t) -> {
                    ((doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSpecialty(t.getNewValue());
                    updateDoctorSpecialty( t.getRowValue().getDoctor_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<doctor, Integer> PhoneNumberCol = new TableColumn<doctor, Integer>("PhoneNumber");
        PhoneNumberCol.setMinWidth(100);
        PhoneNumberCol.setCellValueFactory(new PropertyValueFactory<doctor, Integer>("PhoneNumber"));

        PhoneNumberCol.setCellFactory(TextFieldTableCell.<doctor,Integer>
                forTableColumn(new IntegerStringConverter()));
        PhoneNumberCol.setOnEditCommit(
                (CellEditEvent<doctor, Integer> t) -> {
                    ((doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhoneNumber(t.getNewValue());
                    updateDoctorPhoneNumber( t.getRowValue().getDoctor_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<doctor, Integer> SalaryCol = new TableColumn<doctor, Integer>("Salary");
        SalaryCol.setMinWidth(75);
        SalaryCol.setCellValueFactory(new PropertyValueFactory<doctor, Integer>("Salary"));

        SalaryCol.setCellFactory(TextFieldTableCell.<doctor,Integer>
                forTableColumn(new IntegerStringConverter()));
        SalaryCol.setOnEditCommit(
                (CellEditEvent<doctor, Integer> t) -> {
                    ((doctor) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSalary(t.getNewValue());
                    updateDoctorSalary( t.getRowValue().getDoctor_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<doctor, Integer> GenderCol = new TableColumn<doctor, Integer>("Gender");
        GenderCol.setMinWidth(100);
        GenderCol.setCellValueFactory(new PropertyValueFactory<doctor, Integer>("Gender"));
        /*****************************/

        myDataTable.setItems(dataListDoctor);

        myDataTable.getColumns().addAll(Doctor_idCol, Doctor_nameCol, AddresstCol,GenderCol, SpecialtyCol, PhoneNumberCol, SalaryCol);

        final TextField addDoctor_id = new TextField();
        addDoctor_id.setPromptText("Doctor_id");
        addDoctor_id.setMaxWidth(PhoneNumberCol.getPrefWidth());

        final TextField addDoctor_name = new TextField();
        addDoctor_name.setMaxWidth(Doctor_nameCol.getPrefWidth());
        addDoctor_name.setPromptText("Doctor_name");

        final TextField addAddress = new TextField();
        addAddress.setMaxWidth(SpecialtyCol.getPrefWidth());
        addAddress.setPromptText("Address");

        final TextField addGender = new TextField();
        addGender.setMaxWidth(SpecialtyCol.getPrefWidth());
        addGender.setPromptText("Gender");

        final TextField addSpecialty = new TextField();
        addSpecialty.setMaxWidth(SpecialtyCol.getPrefWidth());
        addSpecialty.setPromptText("Specialty");

        final TextField addPhoneNumber = new TextField();
        addPhoneNumber.setMaxWidth(SpecialtyCol.getPrefWidth());
        addPhoneNumber.setPromptText("PhoneNumber");

        final TextField addSalary = new TextField();
        addSalary.setMaxWidth(SpecialtyCol.getPrefWidth());
        addSalary.setPromptText("Salary");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            doctor rc;
            rc = new doctor(
                    Integer.valueOf(addDoctor_id.getText()),
                    addDoctor_name.getText(),
                    addAddress.getText(),
                    addGender.getText(),
                    addSpecialty.getText(),
                    Integer.valueOf(addPhoneNumber.getText()),
                    Integer.valueOf(addSalary.getText())
            );
            dataListDoctor.add(rc);
            insertDataDoctor(rc);
            addDoctor_id.clear();
            addDoctor_name.clear();
            addSpecialty.clear();
            addSalary.clear();
            addAddress.clear();
            addPhoneNumber.clear();
            addGender.clear();
        });

        final TextField addDoctorDignosis = new TextField();
        addDoctorDignosis.setMaxWidth(addDoctor_id.getPrefWidth());
        addDoctorDignosis.setPromptText("DoctorID");
        final Button PatientforBillAmount = new Button("Execute");
        Label le = new Label("Find All The Diagnosis the Doctor With Doctor ID");
        le.setTextFill(Color.BLACK);
        PatientforBillAmount.setOnAction((ActionEvent r) -> {
            try {
                FindDoctorDidDiagnosis(Integer.valueOf(addDoctorDignosis.getText()));
                DoctorDignosis = FXCollections.observableArrayList(Report10);
                Output.setEditable(true);
                Output.setMaxHeight(500);
                Output.setMaxWidth(500);
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("All The Diagnosis the Doctor With Doctor ID is"+Integer.valueOf(addDoctorDignosis.getText())+"Did");
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);

                TableColumn<Report5, Integer> Diagnosis_noCol = new TableColumn<Report5, Integer>("Diagnosis_no");
                Diagnosis_noCol.setMinWidth(50);
                Diagnosis_noCol.setCellValueFactory(new PropertyValueFactory<Report5, Integer>("Diagnosis_no"));

                TableColumn<Report5, String> DetailsCol = new TableColumn<Report5, String>("Details");
                DetailsCol.setMinWidth(50);
                DetailsCol.setCellValueFactory(new PropertyValueFactory<Report5, String>("Details"));

                TableColumn<Report5, String> SeverityCol = new TableColumn<Report5, String>("Severity");
                SeverityCol.setMinWidth(50);
                SeverityCol.setCellValueFactory(new PropertyValueFactory<Report5, String>("Severity"));


                Output.setItems(DoctorDignosis);
                Output.getColumns().addAll(Diagnosis_noCol, DetailsCol, SeverityCol);

                Button CloseTab = new Button("Close Tab");
                CloseTab.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });

                root.getChildren().addAll(CloseTab);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(Output,root);
                vbox.setPrefSize(700,650);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        final  HBox rt = new HBox();
        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<doctor> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<doctor> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowDoctor(row);
                myDataTable.refresh();
            });
        });
        rt.getChildren().addAll(le,addDoctorDignosis,PatientforBillAmount);
        hb.getChildren().addAll(addDoctor_id, addDoctor_name, addAddress, addGender, addSpecialty,addPhoneNumber,addSalary, addButton, deleteButton);
        hb.setSpacing(3);

        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogDoctor(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2,rt);
        vbox.setPrefSize(700,650);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    private VBox tableViewPatient(Stage stage) {

        TableView<patient> myDataTable = new TableView<patient>();
        TableView<Report2> Output = new TableView<Report2>();

        Scene scene = new Scene(new Group());
        stage.setTitle("Patient Table");
        stage.setWidth(550);
        stage.setHeight(500);

        Label label = new Label("Patient Table");
        label.setFont(new Font("Arial", 100));
        label.setTextFill(Color.BLUE);

        myDataTable.setEditable(true);
        myDataTable.setMaxHeight(700);
        myDataTable.setMaxWidth(600);

        /*****************************/
        TableColumn<patient, Integer> Patient_idCol = new TableColumn<patient, Integer>("Patient_id");
        Patient_idCol.setMinWidth(50);
        Patient_idCol.setCellValueFactory(new PropertyValueFactory<patient, Integer>("Patient_id"));
        /*****************************/
        TableColumn<patient, String> Patient_nameCol = new TableColumn<patient, String>("Patient_name");
        Patient_nameCol.setMinWidth(100);
        Patient_nameCol.setCellValueFactory(new PropertyValueFactory<patient, String>("Patient_name"));

        Patient_nameCol.setCellFactory(TextFieldTableCell.<patient>forTableColumn());
        Patient_nameCol.setOnEditCommit(
                (CellEditEvent<patient, String> t) -> {
                    ((patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPatient_name(t.getNewValue());
                    updatePatientName( t.getRowValue().getPatient_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<patient, String> addressCol = new TableColumn<patient, String>("address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<patient, String>("address"));

        addressCol.setCellFactory(TextFieldTableCell.<patient>forTableColumn());
        addressCol.setOnEditCommit(
                (CellEditEvent<patient, String> t) -> {
                    ((patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAddress(t.getNewValue());
                    updatePatientAddress( t.getRowValue().getPatient_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<patient, Integer> Phone_numberCol = new TableColumn<patient, Integer>("Phone_number");
        Phone_numberCol.setMinWidth(100);
        Phone_numberCol.setCellValueFactory(new PropertyValueFactory<patient, Integer>("Phone_number"));

        Phone_numberCol.setCellFactory(TextFieldTableCell.<patient,Integer>
                forTableColumn(new IntegerStringConverter()));
        Phone_numberCol.setOnEditCommit(
                (CellEditEvent<patient, Integer> t) -> {
                    ((patient) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setPhone_number(t.getNewValue());
                    updatePatientPhoneNumber( t.getRowValue().getPatient_id(),t.getNewValue());
                });
        /*****************************/
        TableColumn<patient, Integer> Nurse_idCol = new TableColumn<patient, Integer>("Nurse_id");
        Nurse_idCol.setMinWidth(50);
        Nurse_idCol.setCellValueFactory(new PropertyValueFactory<patient, Integer>("Nurse_id"));
        /*****************************/
        TableColumn<patient, Integer> Room_noCol = new TableColumn<patient, Integer>("Room_no");
        Room_noCol.setMinWidth(50);
        Room_noCol.setCellValueFactory(new PropertyValueFactory<patient, Integer>("Room_no"));
        /*****************************/

        myDataTable.setItems(dataListPatient);

        myDataTable.getColumns().addAll(Patient_idCol, Patient_nameCol, addressCol,Phone_numberCol, Nurse_idCol,Room_noCol);



        final TextField addPatient_id = new TextField();
        addPatient_id.setPromptText("Patient_id");
        addPatient_id.setMaxWidth(Phone_numberCol.getPrefWidth());

        final TextField addPatient_name = new TextField();
        addPatient_name.setMaxWidth(Patient_nameCol.getPrefWidth());
        addPatient_name.setPromptText("Patient_name");

        final TextField addaddress = new TextField();
        addaddress.setMaxWidth(Nurse_idCol.getPrefWidth());
        addaddress.setPromptText("address");

        final TextField addPhone_number = new TextField();
        addPhone_number.setMaxWidth(Nurse_idCol.getPrefWidth());
        addPhone_number.setPromptText("Phone_number");

        final TextField addNurse_id = new TextField();
        addNurse_id.setMaxWidth(Nurse_idCol.getPrefWidth());
        addNurse_id.setPromptText("Nurse_id");

        final TextField addRoom_no = new TextField();
        addRoom_no.setMaxWidth(Nurse_idCol.getPrefWidth());
        addRoom_no.setPromptText("Room_no");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            patient rc;
            rc = new patient(
                    Integer.valueOf(addPatient_id.getText()),
                    addPatient_name.getText(),
                    addaddress.getText(),
                    Integer.valueOf(addPhone_number.getText()),
                    Integer.valueOf(addNurse_id.getText()),
                    Integer.valueOf(addRoom_no.getText())
            );
            dataListPatient.add(rc);
            insertDataPatient(rc);
            addPatient_id.clear();
            addPatient_name.clear();
            addaddress.clear();
            addPhone_number.clear();
            addNurse_id.clear();
            addRoom_no.clear();
        });

        final TextField addPatientForDoctor = new TextField();
        addPatientForDoctor.setMaxWidth(addPatient_id.getPrefWidth());
        addPatientForDoctor.setPromptText("Doctor ID");
        final Button PatientForDoctor = new Button("Excute");
        Label l = new Label("Find all the Patient for a certain Doctor with DoctorId=");
        l.setTextFill(Color.BLACK);
        PatientForDoctor.setOnAction((ActionEvent r) -> {
            try {
                FindAllPatients(Integer.valueOf(addPatientForDoctor.getText()));
                PatientDoctor = FXCollections.observableArrayList(Report2);
                Output.setEditable(true);
                Output.setMaxHeight(500);
                Output.setMaxWidth(500);
                Stage stage3 = new Stage();
                Scene scene3=new Scene(new Group());
                stage3.setTitle("All the Patients Under the Doctor whose ID is"+Integer.valueOf(addPatientForDoctor.getText()));
                HBox root = new HBox();
                root.setPadding(new Insets(100, 0, 0, 100));
                root.setAlignment(Pos.CENTER);
                root.setSpacing(5);

                TableColumn<Report2, Integer> Patient_id2Col = new TableColumn<Report2, Integer>("Patient_id");
                Patient_id2Col.setMinWidth(50);
                Patient_id2Col.setCellValueFactory(new PropertyValueFactory<Report2, Integer>("Patient_id2"));

                TableColumn<Report2, String> Patient_name2Col = new TableColumn<Report2, String>("Patient_name");
                Patient_name2Col.setMinWidth(50);
                Patient_name2Col.setCellValueFactory(new PropertyValueFactory<Report2, String>("Patient_name2"));

                TableColumn<Report2, String> Doctor_name2Col = new TableColumn<Report2, String>("Doctor_name");
                Doctor_name2Col.setMinWidth(50);
                Doctor_name2Col.setCellValueFactory(new PropertyValueFactory<Report2, String>("Doctor_name2"));

                TableColumn<Report2, Integer> Doctor_id2Col = new TableColumn<Report2, Integer>("Doctor_id");
                Doctor_id2Col.setMinWidth(50);
                Doctor_id2Col.setCellValueFactory(new PropertyValueFactory<Report2, Integer>("Doctor_id2"));

                Output.setItems(PatientDoctor);
                Output.getColumns().addAll(Patient_id2Col,Patient_name2Col,Doctor_name2Col,Doctor_id2Col);

                Button CloseTab = new Button("Close Tab");
                CloseTab.setOnAction(t -> {
                    stage3.close();
                    stage2.show();
                });

                root.getChildren().addAll(CloseTab);
                VBox vbox=new VBox();
                vbox.setSpacing(5);
                vbox.setPadding(new Insets(10,0,0,10));
                vbox.setAlignment(Pos.CENTER);
                vbox.getChildren().addAll(Output,root);
                ((Group) scene3.getRoot()).getChildren().addAll(vbox);
                stage3.setScene(scene3);
                stage3.show();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        final TextField addFindBill = new TextField();
        addFindBill.setMaxWidth(addPatient_id.getPrefWidth());
        addFindBill.setPromptText("PatientID");
        final  TextField output1 = new TextField();
        final  TextField output2 = new TextField();
        final Button FindBill = new Button("Excute");
        Label lt = new Label("Find the Bill for the Patient Whose ID is ");
        lt.setTextFill(Color.BLACK);
        FindBill.setOnAction((ActionEvent r) -> {
            try {
                FindAPatientBill(Integer.valueOf(addFindBill.getText()));
                output1.setMaxWidth(addPatient_id.getPrefWidth());
                output1.setPromptText("Bill_no");
                output2.setMaxWidth(addPatient_id.getPrefWidth());
                output2.setPromptText("Bill_amount");
                output1.setText(String.valueOf(Report6.get(0)));
                output2.setText(String.valueOf(Report6.get(1)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        final HBox rb = new HBox();
        final HBox eq = new HBox();
        final HBox hb = new HBox();

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            ObservableList<patient> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
            ArrayList<patient> rows = new ArrayList<>(selectedRows);
            rows.forEach(row -> {
                myDataTable.getItems().remove(row);
                deleteRowPatient(row);
                myDataTable.refresh();
            });
        });

        eq.getChildren().addAll(lt,addFindBill,FindBill,output1,output2);
        rb.getChildren().addAll(l,addPatientForDoctor, PatientForDoctor);
        hb.getChildren().addAll(addPatient_id, addPatient_name, addaddress, addPhone_number, addNurse_id, addRoom_no, addButton, deleteButton);
        hb.setSpacing(3);


        final Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction((ActionEvent e) -> {
            myDataTable.refresh();
        });

        final Button clearButton = new Button("Clear All");
        clearButton.setOnAction((ActionEvent e) -> {
            showDialogPatient(stage, NONE, myDataTable);

        });

        final HBox hb2 = new HBox();
        hb2.getChildren().addAll(clearButton, refreshButton);
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, myDataTable, hb,hb2,rb,eq);
        vbox.setPrefSize(700,650);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        return vbox;
    }
    /***************************/
    private void showDialogMedicine(Window owner, Modality modality, TableView<medicine> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (medicine row: dataListMedicine) {
                deleteRowMedicine(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListMedicine);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogBill(Window owner, Modality modality, TableView<bill> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (bill row: dataListBill) {
                deleteRowBill(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListBill);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogDiagnosis(Window owner, Modality modality, TableView<diagnosis> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (diagnosis row: dataListDiagnosis) {
                deleteRowDiagnosis(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListDiagnosis);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogRoom(Window owner, Modality modality, TableView<room> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (room row: dataListRoom) {
                deleteRowRoom(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListRoom);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogNurse(Window owner, Modality modality, TableView<nurse> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (nurse row: dataListNurse) {
                deleteRowNurse(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListNurse);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogDoctor(Window owner, Modality modality, TableView<doctor> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (doctor row: dataListDoctor) {
                deleteRowDoctor(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListDoctor);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    private void showDialogPatient(Window owner, Modality modality, TableView<patient> table) {
        // Create a Stage with specified owner and modality
        Stage stage = new Stage();
        stage.initOwner(owner);
        stage.initModality(modality);
        //	Label modalityLabel = new Label(modality.toString());

        Button yesButton = new Button("Confirm");
        yesButton.setOnAction(e -> {
            for (patient row: dataListPatient) {
                deleteRowPatient(row);
                table.refresh();
            }
            table.getItems().removeAll(dataListPatient);
            stage.close();

        });

        Button noButton = new Button("Cancel");
        noButton.setOnAction(e -> stage.close());

        HBox root = new HBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        root.getChildren().addAll(yesButton, noButton);
        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Confirm Delete?");
        stage.show();
    }
    /***************************/
    /*connection and execution of the statment*/
    private void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection (dbURL, p);
    }
    public void ExecuteStatement(String SQL) throws SQLException {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();


        }
        catch(SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");

        }

    }
    /***************************/
    public void getDataMedicine() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from medicine order by Medicine_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            medicineData.add(new medicine(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3))));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + medicineData.size());
    }
    public void insertDataMedicine(medicine rc) {

        try {
            System.out.println("Insert into medicine (Medicine_id, Medicine_name,Price) values("+
                    rc.getMedicine_id() +",'"
                    + rc.getMedicine_name() +"',"
                    + rc.getPrice()+")"
            );

            connectDB();
            ExecuteStatement("Insert into medicine (Medicine_id, Medicine_name,Price) values("+
                    rc.getMedicine_id() +",'"
                    + rc.getMedicine_name() +"',"
                    + rc.getPrice()+")"
            );

            con.close();
            System.out.println("Connection closed" + medicineData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void deleteRowMedicine(medicine row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  medicine where Medicine_id="+row.getMedicine_id() + ";");
            connectDB();
            ExecuteStatement("delete from  medicine where Medicine_id="+row.getMedicine_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateMedicineName(int medicineID, String name) {

        try {
            System.out.println("update  medicine set Medicine_name = '"+name + "' where Medicine_id = "+medicineID);
            connectDB();
            ExecuteStatement("update  medicine set Medicine_name = '"+name + "' where Medicine_id = "+medicineID+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateMedicinePrice(int medicineID, int newPrice) {

        try {
            System.out.println("update  medicine set Price = "+ newPrice + " where Medicine_id = "+medicineID);
            connectDB();
            ExecuteStatement("update  medicine set Price = "+ newPrice + " where Medicine_id = "+medicineID+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataBill() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from bill order by Bill_no";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            billData.add(new bill(
                    Integer.parseInt(rs.getString(1)),
                    Integer.parseInt(rs.getString(2)),
                    Integer.parseInt(rs.getString(3))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + billData.size());
    }
    private void insertDataBill(bill rc) {

        try {
            System.out.println("Insert into Bill (Bill_no, Patient_id,Bill_amount) values("+
                    rc.getBill_no() +","
                    + rc.getPatient_id() +","
                    + rc.getBill_amount()+")");

            connectDB();
            ExecuteStatement("Insert into Bill (Bill_no, Patient_id,Bill_amount) values("+
                    rc.getBill_no() +","
                    + rc.getPatient_id() +","
                    + rc.getBill_amount()+")");

            con.close();
            System.out.println("Connection closed" + billData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowBill(bill row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  Bill where Bill_no="+row.getBill_no() + ";");
            connectDB();
            ExecuteStatement("delete from  Bill where Bill_no="+row.getBill_no() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateBillAmountBill(int billNo, int newAmount) {

        try {
            System.out.println("update  Bill set Bill_amount = "+ newAmount + " where Bill_no = "+billNo);
            connectDB();
            ExecuteStatement("update  Bill set Bill_amount = "+ newAmount + " where Bill_no = "+billNo+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataDiagnosis() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from diagnosis order by Diagnosis_no";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            diagnosisData.add(new diagnosis(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    Integer.parseInt(rs.getString(5))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + diagnosisData.size());

    }
    private void insertDataDiagnosis(diagnosis rc) {

        try {
            System.out.println("Insert into diagnosis (Diagnosis_no, Diagnosis_Date,Details, Severity,Doctor_id) values("+
                    rc.getDiagnosis_no()+","
                    +rc.getDiagnosis_Date()+",'"
                    + rc.getDetails() +"','"
                    + rc.getSeverity()+"',"
                    +rc.getDoctor_id()+")"
            );

            connectDB();
            ExecuteStatement("Insert into diagnosis (Diagnosis_no, Diagnosis_Date,Details, Severity,Doctor_id) values("+
                    rc.getDiagnosis_no()+","
                    +rc.getDiagnosis_Date()+",'"
                    + rc.getDetails() +"','"
                    + rc.getSeverity()+"',"
                    +rc.getDoctor_id()+")"
            );

            con.close();
            System.out.println("Connection closed" + diagnosisData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowDiagnosis(diagnosis row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  diagnosis where Diagnosis_no="+row.getDiagnosis_no() + ";");
            connectDB();
            ExecuteStatement("delete from  diagnosis where Diagnosis_no="+row.getDiagnosis_no() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDetails(int Diagnosis_no, String details) {

        try {
            System.out.println("update  diagnosis set Details = '"+details + "' where Diagnosis_no = "+ Diagnosis_no);
            connectDB();
            ExecuteStatement("update  diagnosis set Details = '"+details + "' where Diagnosis_no = "+ Diagnosis_no +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateSeverity(int Diagnosis_no, String severity) {

        try {
            System.out.println("update  diagnosis set Severity = '"+severity + "' where Diagnosis_no = "+ Diagnosis_no);
            connectDB();
            ExecuteStatement("update  diagnosis set Severity = '"+severity + "' where Diagnosis_no = "+ Diagnosis_no +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataRoom() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from room order by Room_no";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            roomData.add(new room(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + roomData.size());


    }
    private void insertDataRoom(room rc) {

        try {
            System.out.println("Insert into room (Room_no, Room_type,Period) values("+
                    rc.getRoom_no()+",'"
                    + rc.getRoom_type() +"',"
                    + rc.getPeriod()+")"
            );

            connectDB();
            ExecuteStatement("Insert into room (Room_no, Room_type,Period) values("+
                    rc.getRoom_no()+",'"
                    + rc.getRoom_type() +"',"
                    + rc.getPeriod()+")"
            );

            con.close();
            System.out.println("Connection closed" + roomData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowRoom(room row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  room where Room_no="+row.getRoom_no() + ";");
            connectDB();
            ExecuteStatement("delete from  room where Room_no="+row.getRoom_no() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateRoomType(int Room_no, String newType) {

        try {
            System.out.println("update  room set Room_type = '"+ newType + "' where Room_no = "+ Room_no);
            connectDB();
            ExecuteStatement("update  room set Room_type = '"+ newType + "' where Room_no = "+ Room_no +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updatePeriod(int Room_no, int newPeriod) {

        try {
            System.out.println("update  room set Period = '"+ newPeriod + "' where Room_no = "+ Room_no);
            connectDB();
            ExecuteStatement("update  room set Period = '"+ newPeriod + "' where Room_no = "+ Room_no +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataNurse() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from nurse order by Nurse_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            nurseData.add(new nurse(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    Integer.parseInt(rs.getString(4)),
                    rs.getString(5),
                    Integer.parseInt(rs.getString(6)),
                    rs.getString(7)
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + nurseData.size());

    }
    private void insertDataNurse(nurse rc) {

        try {
            System.out.println("Insert into Nurse (Nurse_id, Nurse_name,Shift, Salary,Address,PhoneNumber,Gender) values("+
                    rc.getNurse_id()+",'"
                    +rc.getNurse_name()+"','"
                    + rc.getShift() +"',"
                    + rc.getSalary()+",'"
                    + rc.getAddress() +"',"
                    + rc.getPhoneNumber() +",'"
                    + rc.getGender() +"')"
            );

            connectDB();
            ExecuteStatement("Insert into Nurse (Nurse_id, Nurse_name,Shift, Salary,Address,PhoneNumber,Gender) values("+
                    rc.getNurse_id()+",'"
                    +rc.getNurse_name()+"','"
                    + rc.getShift() +"',"
                    + rc.getSalary()+",'"
                    + rc.getAddress() +"',"
                    + rc.getPhoneNumber() +",'"
                    + rc.getGender() +"')"
            );

            con.close();
            System.out.println("Connection closed" + nurseData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowNurse(nurse row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  Nurse where Nurse_id="+row.getNurse_id() + ";");
            connectDB();
            ExecuteStatement("delete from  Nurse where Nurse_id="+row.getNurse_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateNurseName(int nurseId, String newName) {

        try {
            System.out.println("update  Nurse set Nurse_name = '"+ newName + "' where Nurse_id = "+nurseId);
            connectDB();
            ExecuteStatement("update  Nurse set Nurse_name = '"+ newName + "' where Nurse_id = "+nurseId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateShift(int nurseId, String newShift) {

        try {
            System.out.println("update  Nurse set Shift = '"+ newShift + "' where Nurse_id = "+nurseId);
            connectDB();
            ExecuteStatement("update  Nurse set Shift = '"+ newShift + "' where Nurse_id = "+nurseId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateNurseSalary(int nurseId, int newSalary) {

        try {
            System.out.println("update  Nurse set Salary = '"+ newSalary + "' where Nurse_id = "+nurseId);
            connectDB();
            ExecuteStatement("update  Nurse set Salary = '"+ newSalary + "' where Nurse_id = "+nurseId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateNurseAddress(int nurseId, String newAddress) {

        try {
            System.out.println("update  Nurse set Address = '"+ newAddress + "' where Nurse_id = "+nurseId);
            connectDB();
            ExecuteStatement("update  Nurse set Address = '"+ newAddress + "' where Nurse_id = "+nurseId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateNursePhoneNumber(int nurseId, int newPhoneNumber) {

        try {
            System.out.println("update  Nurse set PhoneNumber = '"+ newPhoneNumber + "' where Nurse_id = "+nurseId);
            connectDB();
            ExecuteStatement("update  Nurse set PhoneNumber = '"+ newPhoneNumber + "' where Nurse_id = "+nurseId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataDoctor() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from doctor order by Doctor_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            doctorData.add(new doctor(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    Integer.parseInt(rs.getString(6)),
                    Integer.parseInt(rs.getString(7))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + doctorData.size());
    }
    private void insertDataDoctor(doctor rc) {

        try {
            System.out.println("Insert into Doctor (Doctor_id, Doctor_name,Address,Gender,Specialty,PhoneNumber,Salary) values("+
                    rc.getDoctor_id()+",'"
                    + rc.getDoctor_name() +"','"
                    + rc.getAddress() +"','"
                    + rc.getGender() +"','"
                    + rc.getSpecialty() +"',"
                    + rc.getPhoneNumber()+","
                    + rc.getSalary()+")"
            );

            connectDB();
            ExecuteStatement("Insert into Doctor (Doctor_id, Doctor_name,Address,Gender,Specialty,PhoneNumber,Salary) values("+
                    rc.getDoctor_id()+",'"
                    + rc.getDoctor_name() +"','"
                    + rc.getAddress() +"','"
                    + rc.getGender() +"','"
                    + rc.getSpecialty() +"',"
                    + rc.getPhoneNumber()+","
                    + rc.getSalary()+")"
            );

            con.close();
            System.out.println("Connection closed" + doctorData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowDoctor(doctor row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  Doctor where Doctor_id="+row.getDoctor_id() + ";");
            connectDB();
            ExecuteStatement("delete from  Doctor where Doctor_id="+row.getDoctor_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctorName(int DoctorId, String newName) {

        try {
            System.out.println("update  Doctor set Doctor_name = '"+ newName + "' where Doctor_id = "+ DoctorId);
            connectDB();
            ExecuteStatement("update  Doctor set Doctor_name = '"+ newName + "' where Doctor_id = "+ DoctorId +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctorAddress(int DoctorId, String newAddress) {

        try {
            System.out.println("update  Doctor set Address = '"+ newAddress + "' where Doctor_id = "+ DoctorId);
            connectDB();
            ExecuteStatement("update  Doctor set Address = '"+ newAddress + "' where Doctor_id = "+ DoctorId +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctorSpecialty(int DoctorId, String newSpecialty) {

        try {
            System.out.println("update  Doctor set Specialty = '"+ newSpecialty + "' where Doctor_id = "+ DoctorId);
            connectDB();
            ExecuteStatement("update  Doctor set Specialty = '"+ newSpecialty + "' where Doctor_id = "+ DoctorId +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctorPhoneNumber(int DoctorId, int newPhoneNumber) {

        try {
            System.out.println("update  Doctor set PhoneNumber = '"+ newPhoneNumber + "' where Doctor_id = "+ DoctorId);
            connectDB();
            ExecuteStatement("update  Doctor set PhoneNumber = '"+ newPhoneNumber + "' where Doctor_id = "+ DoctorId +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDoctorSalary(int DoctorId, int newSalary) {

        try {
            System.out.println("update  Doctor set Salary = '"+ newSalary + "' where Doctor_id = "+ DoctorId);
            connectDB();
            ExecuteStatement("update  Doctor set Salary = '"+ newSalary + "' where Doctor_id = "+ DoctorId +";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    private void getDataPatient() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from Patient order by Patient_id";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            patientData.add(new patient(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    Integer.parseInt(rs.getString(4)),
                    Integer.parseInt(rs.getString(5)),
                    Integer.parseInt(rs.getString(6))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    private void insertDataPatient(patient rc) {

        try {
            System.out.println("Insert into Patient (Patient_id, Patient_name,address,Phone_number,Nurse_id,Room_no) values("+
                    rc.getPatient_id()+",'"
                    + rc.getPatient_name() +"','"
                    + rc.getAddress() +"',"
                    + rc.getPhone_number() +","
                    + rc.getNurse_id() +","
                    + rc.getRoom_no()+")"
            );

            connectDB();
            ExecuteStatement("Insert into Patient (Patient_id, Patient_name,address,Phone_number,Nurse_id,Room_no) values("+
                    rc.getPatient_id()+",'"
                    + rc.getPatient_name() +"','"
                    + rc.getAddress() +"',"
                    + rc.getPhone_number() +","
                    + rc.getNurse_id() +","
                    + rc.getRoom_no()+")"
            );

            con.close();
            System.out.println("Connection closed" + patientData.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteRowPatient(patient row) {
        // TODO Auto-generated method stub

        try {
            System.out.println("delete from  Patient where Patient_id="+row.getPatient_id() + ";");
            connectDB();
            ExecuteStatement("delete from  Patient where Patient_id="+row.getPatient_id() + ";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updatePatientAddress(int patientId, String newAddress) {

        try {
            System.out.println("update  Patient set address = '"+ newAddress + "' where Patient_id = "+patientId);
            connectDB();
            ExecuteStatement("update  Patient set address = '"+ newAddress + "' where Patient_id = "+patientId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updatePatientName(int patientId, String newName) {

        try {
            System.out.println("update  Patient set Patient_name = '"+ newName + "' where Patient_id = "+patientId);
            connectDB();
            ExecuteStatement("update  Patient set Patient_name = '"+ newName + "' where Patient_id = "+patientId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updatePatientPhoneNumber(int patientId, int newPhoneNumber) {

        try {
            System.out.println("update  Patient set Phone_number = '"+ newPhoneNumber + "' where Patient_id = "+patientId);
            connectDB();
            ExecuteStatement("update  Patient set Phone_number = '"+ newPhoneNumber + "' where Patient_id = "+patientId+";");
            con.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***************************/
    //reports

    //Report1 find the count of Bills higher than certain value
    private int BillCount(int number) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        String r = null;
        connectDB();
        System.out.println("Connection established");

        SQL = "select count(*) from Bill b where b.Bill_amount >= "+ number +";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while ( rs.next() )
             r=rs.getString(1);
        int result=Integer.valueOf(r);

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
        return result;
    }
    //Report 2 Find All the Patients of a Certain Doctor
    private void FindAllPatients(int DoctorId) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;
        connectDB();
        System.out.println("Connection established");

        SQL = "select p.Patient_id ,p.Patient_name ,d.Doctor_name,d.Doctor_id from Patient p ,Doctor d,Patient_Doctor c where p.Patient_id = c.Patient_id and d.Doctor_id = c.Doctor_id and d.Doctor_id= "+ DoctorId +" group by p.Patient_id;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report2.clear();
        while ( rs.next() ) {
            Report2.add(new Report2(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3),
                    Integer.parseInt(rs.getString(4))
            ));
        }

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    //Report 3 Find All Patients in a Certain Room
    private void FindAllPatientsInaRoom(int RoomNo) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select p.Patient_id ,p.Patient_name from Patient p, Room r where p.Room_no = r.Room_no and r.Room_no = "+ RoomNo +";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report3.clear();
        while ( rs.next() ) {
            Report3.add(new Report3(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2)
            ));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    //Report 4 find All Patients For a Bill Amount
    private void FindAllPatientsInBillAmount(int BillAmount) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select p.Patient_id ,p.Patient_name , B.Bill_amount from Patient p , Bill b where p.Patient_id = b.Patient_id and b.Bill_amount >="+ BillAmount +";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report4.clear();
        while ( rs.next() ) {
            Report4.add(new Report4(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3))
            ));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    //Report 5 Find All The Patients for a Certain Nurse
    private void FindAllPatientsForNurse(int nurseID) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select p.Patient_id , p.Patient_name from Patient p , Nurse n where p.Nurse_id = n.Nurse_id and n.Nurse_id="+ nurseID +";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report5.clear();
        while ( rs.next() ) {
            Report5.add(new Report3(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2)
            ));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    //Report 6 Find the Bill For a Certain Patient
    private void FindAPatientBill(int PatientID) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select b.Bill_no ,B.Bill_amount from Bill b,Patient p where p.Patient_id = b.Patient_id and p.Patient_id ="+ PatientID +";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report6.clear();
        while ( rs.next() ) {
            Report6.add(Integer.parseInt(rs.getString(1)));
            Report6.add(Integer.parseInt(rs.getString(2)));
        }
        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + patientData.size());
    }
    //Report 7 Find all the Diagnosis that a certain doctor Did
    private void FindDoctorDidDiagnosis(int DoctorID) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select d.Diagnosis_no , d.Details , d.Severity from Diagnosis d ,Doctor r where d.Doctor_id=r.Doctor_id and D.Doctor_id=" + DoctorID + ";";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        Report10.clear();
        while (rs.next()) {
            Report10.add(new Report5(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }

            rs.close();
            stmt.close();

            con.close();
            System.out.println("Connection closed" + patientData.size());
        }
}

