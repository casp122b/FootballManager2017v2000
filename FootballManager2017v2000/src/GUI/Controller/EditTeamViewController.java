/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;
import BE.Team;
import GUI.Controller.MainViewController;
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
public class EditTeamViewController implements Initializable {
    int editCounter = 0;
private MainViewController main;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtTeamID;
    @FXML
    private TextField txtTeamGoals;
    @FXML
    private TextField txtTeamPoints;
    @FXML
    private TextField txtMatchesPlayed;
    private TeamModel teamModel;
    @FXML
    private Button edit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void setModel(TeamModel model)
    {
        this.teamModel = model;
    }
    /**
     * Sets MainViewController as main window.
     * @param aThis 
     */
    void setMainWindow(MainViewController aThis) 
    {
        main = aThis;
    }   
 
   
        
        //replaces the selected team
          @FXML
    private void editTeam(ActionEvent event) {
        teamModel.addTeam(txtTeamName.getText(), Integer.parseInt(txtTeamID.getText()), 
                                                 Integer.parseInt(txtTeamGoals.getText()), 
                                                 Integer.parseInt(txtTeamPoints.getText()), 
                                                 Integer.parseInt(txtMatchesPlayed.getText()));
     editCounter++;
        if(editCounter==1){
        Stage stage = (Stage) edit.getScene().getWindow();
        stage.close();
    }
        
           
       
        }
    }
    
