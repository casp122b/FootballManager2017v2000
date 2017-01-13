/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Team;
import GUI.Model.TeamModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author FrederikD
 */
public class AddGoalsController implements Initializable {

    @FXML
    private TextField homeGoals;
    @FXML
    private TextField guestGoals;
    private Team team1;
    private Team team2;
    private TeamModel teamModel;
    @FXML
    private TextField matchID;
    @FXML
    private Label hometeamlbl;
    @FXML
    private Label guestteamlbl;
    
    /**
     * Initializes the controller class.
     */
    public AddGoalsController(){
        this.teamModel = TeamModel.getInstance();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddGoals(ActionEvent event) {
//        teamModel.addMatchScore(Integer.parseInt(matchID.getText()),hometeamlbl.setText(groupA.) 0, 0);
    }
    
}
