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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class FinalViewController implements Initializable {

    @FXML
    private TableView<Match> tableviewFinal;
    @FXML
    private Button btnClose;
    private MainViewController main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * This method terminates Finalsview.
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
}
