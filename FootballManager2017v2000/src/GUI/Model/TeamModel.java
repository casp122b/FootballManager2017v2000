/*
    * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;

import BE.Round;
import BE.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class TeamModel 
{
    private ObservableList<Team> allTeams;
    private ObservableList<Team> teamsA;
    private ObservableList<Team> teamsB;
    private ObservableList<Team> teamsC;
    private ObservableList<Team> teamsD;
    private ObservableList<Round> matchA;
    private ObservableList<Round> matchB;
    private ObservableList<Round> matchC;
    private ObservableList<Round> matchD;
    private static TeamModel instance;
    
    /**
     * Singleton for TeamModel. Makes it impossible to make more than one instance of TeamModel.
     */
    private TeamModel()
    {
        allTeams = FXCollections.observableArrayList();
        teamsA = FXCollections.observableArrayList();
        teamsB = FXCollections.observableArrayList();
        teamsC = FXCollections.observableArrayList();
        teamsD = FXCollections.observableArrayList();
        matchA = FXCollections.observableArrayList();
        matchB = FXCollections.observableArrayList();
        matchC = FXCollections.observableArrayList();
        matchD = FXCollections.observableArrayList();
    }
    
    /**
     * This method makes it possible to instantiate TeamModel from another class.
     * @return 
     */
    public static TeamModel getInstance()
    {
        if (instance == null)
        {
            instance = new TeamModel();
        }
        
        return instance;
    }
    
    public ObservableList<Team> getTeamsA()
    {
       return teamsA;
    }
      
    public void setTeamsA(ObservableList<Team> teams)
    {
        teamsA = teams;
    }
    
    public ObservableList<Team> getTeamsB() {
        return teamsB;
    }

    public void setTeamsB(ObservableList<Team> teamsB) {
        this.teamsB = teamsB;
    }

    public ObservableList<Team> getTeamsC() {
        return teamsC;
    }

    public void setTeamsC(ObservableList<Team> teamsC) {
        this.teamsC = teamsC;
    }

    public ObservableList<Team> getTeamsD() {
        return teamsD;
    }

    public void setTeamsD(ObservableList<Team> teamsD) {
        this.teamsD = teamsD;
    }
    
    public void addTeam(String teamName, int teamID, int scoredGoals, int matchesPlayed, int numberOfPoints){
        Team team = new Team(teamName, teamID, scoredGoals, matchesPlayed, numberOfPoints);
        allTeams.add(team);
    }
    public ObservableList<Team> getAllTeams()
    {
        return allTeams;
    }
    public ObservableList<Round> getRoundA() {
        return matchA;
    }

    public ObservableList<Round> getRoundB() {
        return matchB;
    }

    public ObservableList<Round> getRoundC() {
        return matchC;
    }

    public ObservableList<Round> getRoundD() {
        return matchD;
    }

}
