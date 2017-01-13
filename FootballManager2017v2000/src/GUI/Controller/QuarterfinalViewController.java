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
public class QuarterfinalViewController implements Initializable {

    @FXML
    private TableView<Match> tableViewQuarterfinal;
    @FXML
    private TableColumn<Match, String> colHomeTeam;
    @FXML
    private TableColumn<Match, String> colVisitors;
    @FXML
    private Button btnClose;
    private MainViewController main;
    @FXML
    private Button btnSemifinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    /**
     * This method terminates QuarterfinalView.
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

    @FXML
    public void btnSemifinalActionPerformed(ActionEvent event)
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/SemifinalView.fxml"));
            Parent root = loader.load();
            SemifinalViewController controller = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Semifinal");
            stage.setScene(new Scene(root));
            stage.show();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
