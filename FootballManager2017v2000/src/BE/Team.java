/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class Team {
    private String teamName;
    private int matchesPlayed;
    private int teamID;
    private int scoredGoals;
    private int numberOfPoints;
    
    /**
     * Constructor for the class.
     * @param teamName
     * @param teamID
     * @param scoredGoals
     * @param matchesPlayed
     * @param numberOfPoints 
     */
    public Team(String teamName, int teamID, int scoredGoals, int matchesPlayed, int numberOfPoints){
        this.teamName = teamName;
        this.teamID = teamID;
        this.scoredGoals = scoredGoals;
        this.matchesPlayed = matchesPlayed;
        this.numberOfPoints = numberOfPoints;
    }
    
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }
    
}
