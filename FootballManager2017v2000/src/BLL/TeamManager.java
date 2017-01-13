/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Group;
import BE.Team;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jens, Patrick, Casper, Frederik
 */
public class TeamManager 
{ 
    /**
     * Array of the class Group that refers to an array of the Team class.
     * Shuffles teams into A-D groups.
     * @param teams
     * @return 
     */
    public List<Group> makeGroups(List<Team> teams)
    {
        ArrayList<Group> allGroups = new ArrayList<>();
        for (int i = 0; i < 4; i++) 
        {
            allGroups.add(new Group());   
        }
        Collections.shuffle(teams);
        int counter = 0;
        for (Team team : teams) 
        {
            allGroups.get(counter).addTeam(team);
            if (counter == 3)
            {
                counter = -1;
            }
        counter++;
        }
     return allGroups;
    }
}
