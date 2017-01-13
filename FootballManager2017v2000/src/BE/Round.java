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
public class Round {
    
    private Match match1;
    private Match match2;
    private int roundNumber;

    /**
     * Constructor for the class.
     * @param match1
     * @param match2
     * @param roundNumber 
     */
    public Round(int roundNumber, Match match1, Match match2) {
        this.match1 = match1;
        this.match2 = match2;
        this.roundNumber = roundNumber;
    }

    public Match getMatch1() {
        return match1;
    }

    public Match getMatch2() {
        return match2;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
