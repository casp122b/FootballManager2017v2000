/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Match;
import BE.Round;
import BE.Team;
import GUI.Model.TeamModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class TeamPlayViewController implements Initializable {

    @FXML
    private TableColumn<Round, String> homeTeamA1Col;
    @FXML
    private TableColumn<Round, String> guestTeamA1Col;
//    private TableColumn<Round, String> homeTeamBCol;
//    private TableColumn<Round, String> guestTeamBCol;
    public TeamModel teammodel;
    public ObservableList<Match> teamPlay;
    public ObservableList<Team> groupA;
    public ObservableList<Team> groupB;
    public ObservableList<Team> groupC;
    public ObservableList<Team> groupD;
//    public int[] roundList = new int[6];
    private final TeamModel teamModel = TeamModel.getInstance();

    @FXML
    private TableView<Round> matchATable;
//    private TableView<Round> matchBTable;
//    private TableView<Round> matchDTable;
//    private TableView<Round> matchCTable;
    @FXML
    private TableColumn<Round, Integer> colAHS;
    @FXML
    private TableColumn<Round, Integer> colAGS;
    @FXML
    private TableColumn<Round, Integer> colCGS;
    @FXML
    private TableColumn<Round, Integer> colBGS;
    @FXML
    private TableColumn<Round, Integer> roundColA;
    @FXML
    private TableColumn<Round, String> hometeamA2Col;
    @FXML
    private TableColumn<Round, Integer> colAHS1;
    @FXML
    private TableColumn<Round, String> guestTeamA2Col;
    @FXML
    private TableColumn<Round, Integer> colAGS1;
    @FXML
    private TableView<Round> matchBTable;
    @FXML
    private TableColumn<Round, Integer> roundColB;
    @FXML
    private TableColumn<Round, String> homeTeamB1Col;
    @FXML
    private TableColumn<Round, String> guestTeamB1Col;
    @FXML
    private TableColumn<Round, String> hometeamB2Col;
    @FXML
    private TableColumn<Round, String> guestTeamB2Col;
    @FXML
    private TableView<Round> matchCTable;
    @FXML
    private TableColumn<Round, Integer> roundColD;
    @FXML
    private TableColumn<Round, String> homeTeamC1Col;
    @FXML
    private TableColumn<Round, String> guestTeamC1Col;
    @FXML
    private TableColumn<Round, String> hometeamC2Col;
    @FXML
    private TableColumn<Round, String> guestTeamC2Col;
    @FXML
    private TableView<Round> matchDTable;
    @FXML
    private TableColumn<Round, String> guestTeamD1Col;
    @FXML
    private TableColumn<Round, String> homeTeamD1Col;
    @FXML
    private TableColumn<Round, String> hometeamD2Col;
    @FXML
    private TableColumn<Round, String> guestTeamD2Col;
//    @FXML
//    private TableView<?> x1;
    @FXML
    private TableColumn<Round, Integer> roundColC;
    @FXML
    private Button btnClose;
    @FXML
    private Button btnQuarterfinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //setGroups(groupA, groupB, groupC, groupD);
        matchATable.setItems(teamModel.getRoundA());
        matchBTable.setItems(teamModel.getRoundB());
        matchCTable.setItems(teamModel.getRoundC());
        matchDTable.setItems(teamModel.getRoundD());
        roundColA.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getRoundNumber()));
        roundColB.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getRoundNumber()));
        roundColC.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getRoundNumber()));
        roundColD.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getRoundNumber()));

        homeTeamA1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getHomeTeam().getTeamName()));
        guestTeamA1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getAwayTeam().getTeamName()));
        hometeamA2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getHomeTeam().getTeamName()));
        guestTeamA2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getAwayTeam().getTeamName()));

        homeTeamB1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getHomeTeam().getTeamName()));
        guestTeamB1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getAwayTeam().getTeamName()));
        hometeamB2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getHomeTeam().getTeamName()));
        guestTeamB2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getAwayTeam().getTeamName()));

        homeTeamC1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getHomeTeam().getTeamName()));
        guestTeamC1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getAwayTeam().getTeamName()));
        hometeamC2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getHomeTeam().getTeamName()));
        guestTeamC2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getAwayTeam().getTeamName()));

        homeTeamD1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getHomeTeam().getTeamName()));
        guestTeamD1Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch1().getAwayTeam().getTeamName()));
        hometeamD2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getHomeTeam().getTeamName()));
        guestTeamD2Col.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getMatch2().getAwayTeam().getTeamName()));
    }

    public void setModel(TeamModel model) {
        this.teammodel = model;
    }

    /**
     * Sets teams up against each other following the rules set for the
     * assignment.
     *
     * @param groupA
     * @param groupB
     * @param groupC
     * @param groupD
     */
    public void setGroups(ObservableList<Team> groupA, ObservableList<Team> groupB, ObservableList<Team> groupC, ObservableList<Team> groupD) {
        this.groupA = groupA;
        this.groupB = groupB;
        this.groupC = groupC;
        this.groupD = groupD;
        Match ma1 = new Match(0, groupA.get(0), groupA.get(1), 0, 0);
        Match ma2 = new Match(0, groupA.get(2), groupA.get(3), 0, 0);
        Match ma3 = new Match(0, groupA.get(0), groupA.get(2), 0, 0);
        Match ma4 = new Match(0, groupA.get(1), groupA.get(3), 0, 0);
        Match ma5 = new Match(0, groupA.get(3), groupA.get(0), 0, 0);
        Match ma6 = new Match(0, groupA.get(2), groupA.get(1), 0, 0);
        Match ma7 = new Match(0, groupA.get(1), groupA.get(0), 0, 0);
        Match ma8 = new Match(0, groupA.get(3), groupA.get(2), 0, 0);
        Match ma9 = new Match(0, groupA.get(2), groupA.get(0), 0, 0);
        Match ma10 = new Match(0, groupA.get(3), groupA.get(1), 0, 0);
        Match ma11 = new Match(0, groupA.get(0), groupA.get(3), 0, 0);
        Match ma12 = new Match(0, groupA.get(1), groupA.get(2), 0, 0);

        Match mb1 = new Match(0, groupB.get(0), groupB.get(1), 0, 0);
        Match mb2 = new Match(0, groupB.get(2), groupB.get(3), 0, 0);
        Match mb3 = new Match(0, groupB.get(0), groupB.get(2), 0, 0);
        Match mb4 = new Match(0, groupB.get(1), groupB.get(3), 0, 0);
        Match mb5 = new Match(0, groupB.get(3), groupB.get(0), 0, 0);
        Match mb6 = new Match(0, groupB.get(2), groupB.get(1), 0, 0);
        Match mb7 = new Match(0, groupB.get(1), groupB.get(0), 0, 0);
        Match mb8 = new Match(0, groupB.get(3), groupB.get(2), 0, 0);
        Match mb9 = new Match(0, groupB.get(2), groupB.get(0), 0, 0);
        Match mb10 = new Match(0, groupB.get(3), groupB.get(1), 0, 0);
        Match mb11 = new Match(0, groupB.get(0), groupB.get(3), 0, 0);
        Match mb12 = new Match(0, groupB.get(1), groupB.get(2), 0, 0);

        Match mc1 = new Match(0, groupC.get(0), groupC.get(1), 0, 0);
        Match mc2 = new Match(0, groupC.get(2), groupC.get(3), 0, 0);
        Match mc3 = new Match(0, groupC.get(0), groupC.get(2), 0, 0);
        Match mc4 = new Match(0, groupC.get(1), groupC.get(3), 0, 0);
        Match mc5 = new Match(0, groupC.get(3), groupC.get(0), 0, 0);
        Match mc6 = new Match(0, groupC.get(2), groupC.get(1), 0, 0);
        Match mc7 = new Match(0, groupC.get(1), groupC.get(0), 0, 0);
        Match mc8 = new Match(0, groupC.get(3), groupC.get(2), 0, 0);
        Match mc9 = new Match(0, groupC.get(2), groupC.get(0), 0, 0);
        Match mc10 = new Match(0, groupC.get(3), groupC.get(1), 0, 0);
        Match mc11 = new Match(0, groupC.get(0), groupC.get(3), 0, 0);
        Match mc12 = new Match(0, groupC.get(1), groupC.get(2), 0, 0);

        Match md1 = new Match(0, groupD.get(0), groupD.get(1), 0, 0);
        Match md2 = new Match(0, groupD.get(2), groupD.get(3), 0, 0);
        Match md3 = new Match(0, groupD.get(0), groupD.get(2), 0, 0);
        Match md4 = new Match(0, groupD.get(1), groupD.get(3), 0, 0);
        Match md5 = new Match(0, groupD.get(3), groupD.get(0), 0, 0);
        Match md6 = new Match(0, groupD.get(2), groupD.get(1), 0, 0);
        Match md7 = new Match(0, groupD.get(1), groupD.get(0), 0, 0);
        Match md8 = new Match(0, groupD.get(3), groupD.get(2), 0, 0);
        Match md9 = new Match(0, groupD.get(2), groupD.get(0), 0, 0);
        Match md10 = new Match(0, groupD.get(3), groupD.get(1), 0, 0);
        Match md11 = new Match(0, groupD.get(0), groupD.get(3), 0, 0);
        Match md12 = new Match(0, groupD.get(1), groupD.get(2), 0, 0);

        matchATable.getItems().add(new Round(1, ma1, ma2));
        matchATable.getItems().add(new Round(2, ma3, ma4));
        matchATable.getItems().add(new Round(3, ma5, ma6));
        matchATable.getItems().add(new Round(4, ma7, ma8));
        matchATable.getItems().add(new Round(5, ma9, ma10));
        matchATable.getItems().add(new Round(6, ma11, ma12));

        matchBTable.getItems().add(new Round(1, mb1, mb2));
        matchBTable.getItems().add(new Round(2, mb3, mb4));
        matchBTable.getItems().add(new Round(3, mb5, mb6));
        matchBTable.getItems().add(new Round(4, mb7, mb8));
        matchBTable.getItems().add(new Round(5, mb9, mb10));
        matchBTable.getItems().add(new Round(6, mb11, mb12));

        matchCTable.getItems().add(new Round(1, mc1, mc2));
        matchCTable.getItems().add(new Round(2, mc3, mc4));
        matchCTable.getItems().add(new Round(3, mc5, mc6));
        matchCTable.getItems().add(new Round(4, mc7, mc8));
        matchCTable.getItems().add(new Round(5, mc9, mc10));
        matchCTable.getItems().add(new Round(6, mc11, mc12));

        matchDTable.getItems().add(new Round(1, md1, md2));
        matchDTable.getItems().add(new Round(2, md3, md4));
        matchDTable.getItems().add(new Round(3, md5, md6));
        matchDTable.getItems().add(new Round(4, md7, md8));
        matchDTable.getItems().add(new Round(5, md9, md10));
        matchDTable.getItems().add(new Round(6, md11, md12));
    }

    @FXML
    public void btnQuarterfinalActionPerformed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/QuarterfinalView.fxml"));
            Parent root = loader.load();
            QuarterfinalViewController controller = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Quarterfinal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
