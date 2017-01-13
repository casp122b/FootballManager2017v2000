/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Match;
import java.net.URL;
import java.util.ResourceBundle;
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
public class SemifinalViewController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private TableView<Match> tableviewSemifinal;
    @FXML
    private TableColumn<Match, String> colHomeTeam;
    @FXML
    private TableColumn<Match, String> colVisitors;
    
    private MainViewController main;
    @FXML
    private Button btnGrandFinale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * This method terminates SemifinalView.
     * @param event 
     */
    @FXML
    public void btnCloseActionPerformed(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
    /**
     * sets the main window
     * @param aThis 
     */
    void setMainWindow(MainViewController aThis) {
        main = aThis;
    }
    
    /**
     * Opens the FinalView.
     * @param event 
     */
    @FXML
    private void btnFinalActionPerformed(ActionEvent event) 
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/FinalView.fxml"));
            Parent root = loader.load();
            FinalViewController controller = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Grand finale");
            stage.setScene(new Scene(root));
            stage.show();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
