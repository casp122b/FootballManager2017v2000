/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class Group {
    public ArrayList<Team> teams = new ArrayList<>();
    /**
     * Method used to add teams to class Team.
     * @param team 
     */
    public void addTeam(Team team)
    {
        teams.add(team);
    }
    /**
     * Gets all teams stored inside the Team class array.
     * @return 
     */
    public List<Team> getAllTeams()
    {
        return teams;
    }
   
}
