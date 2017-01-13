/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import GUI.Model.TeamModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class AddTeamViewController implements Initializable {

    @FXML
    private Button addTeamToTableView;

    private MainViewController main;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtTeamID;
    @FXML
    private TextField txtTeamGoals;
    @FXML
    private TextField txtTeamPoints;
    private TeamModel teamModel;
    @FXML
    private TextField txtMatchesPlayed;
    int clickCount = 0;
    @FXML
    private Button editTeam;
    int editCounter = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setModel(TeamModel model) {
        this.teamModel = model;
    }

    /**
     * Sets the MainViewController as main window.
     *
     * @param aThis
     */
    void setMainWindow(MainViewController aThis) {
        main = aThis;
    }

    //adds team to teamsTable and after 16 teams have been added closes the window
    @FXML
    private void addTeamToTableView(ActionEvent event) {
        teamModel.addTeam(txtTeamName.getText(), Integer.parseInt(txtTeamID.getText()),
                Integer.parseInt(txtTeamGoals.getText()),
                Integer.parseInt(txtTeamPoints.getText()),
                Integer.parseInt(txtMatchesPlayed.getText()));
        clickCount++;
        if (clickCount == 16) {
            Stage stage = (Stage) addTeamToTableView.getScene().getWindow();
            stage.close();
        }
    }

}
