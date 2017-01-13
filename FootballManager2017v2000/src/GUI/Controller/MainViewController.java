package GUI.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BE.Group;
import BE.Team;
import BLL.TeamManager;
import GUI.Model.TeamModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class MainViewController implements Initializable {

//    private Team team;
    @FXML
    private Label label;
    @FXML
    private TableView<Team> tableviewA;
    @FXML
    private TableView<Team> tableviewB;
    @FXML
    private TableView<Team> tableviewC;
    @FXML
    private TableView<Team> tableviewD;
    @FXML
    private TableColumn<Team, String> colA1;
    @FXML
    private TableColumn<Team, String> colB1;
    @FXML
    private TableColumn<Team, String> colC1;
    @FXML
    private TableColumn<Team, String> colD1;
    @FXML
    private Button handleAddTeam;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnQuarterfinal;
    @FXML
    private Button btnSemifinal;
    @FXML
    private Button btnFinal;
    @FXML
    private TableColumn<Team, String> teamView;
    @FXML
    private TableView<Team> teamsTable;
    @FXML
    private Button shuffleBtn;

    ObservableList<String> listTeams;

    private ArrayList<String> getTeams = new ArrayList<>();

    private TeamModel teamModel;

    private TeamManager teamManager = new TeamManager();
    @FXML
    private Button editButton;

    public MainViewController() {
        this.teamModel = TeamModel.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dataBind();
        for (int i = 0; i < 16; i++) {
            teamsTable.getItems().add(new Team(i + "", 0, 0, 0, 0));
        }
    }

    /**
     * Puts data in teamsTable and makes it possible to put data into colA1,
     * colB1, colC1 and colD1.
     */
    private void dataBind() {
        teamsTable.setItems(teamModel.getTeamsA());
        teamsTable.setItems(teamModel.getAllTeams());
        teamView.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));
        tableviewA.setItems(FXCollections.observableArrayList());
        colA1.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));
        colB1.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));
        colC1.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));
        colD1.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));

    }

    /**
     * Creates a list of the array Team and opens AddTeamView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleAddTeam(ActionEvent event) throws IOException {
        Team team = teamsTable.getSelectionModel().getSelectedItem();
        loadTeamView(team);
    }

    /**
     * This method terminates MainView.
     *
     * @param event
     */
    @FXML
    public void btnCloseActionPerformed(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    /**
     *
     * @param team
     * @throws IOException
     */
    private void loadTeamView(Team team) throws IOException {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage) tableviewA.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/AddTeamView.fxml"));
        Parent root = loader.load();

        AddTeamViewController addTeamViewController = loader.getController();

        addTeamViewController.setModel(teamModel);

        // Sets new stage as modal window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);

        stage.show();
    }

    @FXML //sends the teams shuffled into tableview A->D and disables the handleAddTeam and the shuffleBtn button
    private void btnShuffleActionPerformed(ActionEvent event) {
        List<Group> groups = teamManager.makeGroups(teamsTable.getItems());
        tableviewA.setItems(FXCollections.observableArrayList(groups.get(0).getAllTeams()));
        tableviewB.setItems(FXCollections.observableArrayList(groups.get(1).getAllTeams()));
        tableviewC.setItems(FXCollections.observableArrayList(groups.get(2).getAllTeams()));
        tableviewD.setItems(FXCollections.observableArrayList(groups.get(3).getAllTeams()));

        handleAddTeam.setDisable(true);
        shuffleBtn.setDisable(true);
        editButton.setDisable(true);
    }

    @FXML //clears all tables and resets the handleAddTeam and shuffleBtn buttons
    private void handleClear(ActionEvent event) {
        //clears teamsTable
        teamsTable.getItems().clear();
        //Clears tableviewA
        tableviewA.getItems().clear();
        //Clears tableviewB
        tableviewB.getItems().clear();
        //Clears tableviewC
        tableviewC.getItems().clear();
        //Clears tableviewD
        tableviewD.getItems().clear();
        //Clears matchA
        teamModel.getRoundA().clear();
        //Clears matchB
        teamModel.getRoundB().clear();
        //Clears matchC
        teamModel.getRoundC().clear();
        //Clears matchD
        teamModel.getRoundD().clear();
        //disables the shuffleBtn
        handleAddTeam.setDisable(false);
        //disables the shuffleBtn
        shuffleBtn.setDisable(false);
        editButton.setDisable(false);
    }

    private void loadGroupPlay() throws IOException {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage) tableviewA.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/TeamPlayView.fxml"));
        Parent root = loader.load();

        TeamPlayViewController teamPlayController = loader.getController();

        teamPlayController.setModel(teamModel);
        teamPlayController.setGroups(tableviewA.getItems(), tableviewB.getItems(),
                tableviewC.getItems(), tableviewD.getItems());

        // Sets new stage as modal window
        Stage stage = new Stage();
        stage.setTitle("Group play");
        stage.setScene(new Scene(root));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);

        stage.show();
    }

    @FXML
    private void handleLoadGroupPlay(ActionEvent event) throws IOException {
        teamModel.setTeamsA(tableviewA.getItems());
        teamModel.setTeamsB(tableviewB.getItems());
        teamModel.setTeamsC(tableviewC.getItems());
        teamModel.setTeamsD(tableviewD.getItems());

        loadGroupPlay();
    }

    @FXML //opens the EditTeamView and then removes the team afterwards
    private void handleEditTeam(ActionEvent event) throws IOException {
        Team selectedItem = teamsTable.getSelectionModel().getSelectedItem();
        teamsTable.getItems().remove(selectedItem);

        {
            loadEditView(selectedItem);
        }
    }

    private void loadEditView(Team team) throws IOException {
        // Fetches primary stage and gets loader and loads FXML file to Parent
        Stage primStage = (Stage) tableviewA.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/EditTeams.fxml"));
        Parent root = loader.load();

        EditTeamViewController editController = loader.getController();

        editController.setModel(teamModel);

        // Sets new stage as modal window
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);

        stage.show();
    }

    @FXML //deletes the selected items from the tables and clears the selected afterwards
    private void handleDeleteButton(ActionEvent event) {
        Team selectedItem = teamsTable.getSelectionModel().getSelectedItem();
        teamsTable.getItems().remove(selectedItem);
        teamsTable.getSelectionModel().clearSelection();

        selectedItem = tableviewA.getSelectionModel().getSelectedItem();
        tableviewA.getItems().remove(selectedItem);
        tableviewA.getSelectionModel().clearSelection();

        selectedItem = tableviewB.getSelectionModel().getSelectedItem();
        tableviewB.getItems().remove(selectedItem);
        tableviewB.getSelectionModel().clearSelection();

        selectedItem = tableviewC.getSelectionModel().getSelectedItem();
        tableviewC.getItems().remove(selectedItem);
        tableviewC.getSelectionModel().clearSelection();

        selectedItem = tableviewD.getSelectionModel().getSelectedItem();
        tableviewD.getItems().remove(selectedItem);
        tableviewD.getSelectionModel().clearSelection();
    }
}
