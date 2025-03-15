package labs.lab1;
/**
 * A simple voting machine that records votes for two parties.
 */
public class VotingMachine {
// ADD YOUR INSTANCE VARIABLES HERE
    private int vote_count;
    private int dem_vote ;
    private int rep_vote;
    /**
     * Constructs a voting machine, with vote counts set to zero.
     */
    public VotingMachine() {
        this.vote_count = 0 ;
        this.dem_vote = 0 ;
        this.rep_vote = 0;
// FILL IN
    }
    /**
     * Clears the vote counts.
     */
    public void clear() {
        this.vote_count = 0 ;
        this.rep_vote = 0;
        this.dem_vote = 0 ;
// FILL IN
    }
    /**
     * Records a vote for a democrat.
     */
    public void voteForDemocrat() {
        this.dem_vote += 1;
        this.vote_count += 1;
// FILL IN
    }
    /**
     * Records a vote for a republican.
     */
    public void voteForRepublican() {
        this.rep_vote += 1;
        this.vote_count += 1;
// FILL IN
    }
    /**
     * Gets the votes cast for a democrat.
     *
     * @return the vote count
     */
    public int getDemocratVotes() {

        return this.dem_vote; // FIX ME
    }
    /**
     * Gets the votes cast for a republican.
     *
     * @return the vote count
     */
    public int getRepublicanVotes() {
        return this.rep_vote; // FIX ME
    }
    public static void main(String[] args){
        VotingMachine machine = new VotingMachine();

        machine.voteForRepublican();
        machine.voteForDemocrat();
        machine.voteForRepublican();
        machine.voteForDemocrat();
        machine.voteForRepublican();
        machine.voteForDemocrat();

        System.out.println(machine.getDemocratVotes()); // returns 3
        System.out.println(machine.getRepublicanVotes()); // returns 3

        machine.clear();
        System.out.println(machine.getDemocratVotes()); // returns 0
        System.out.println(machine.getRepublicanVotes()); // returns 0

        machine.voteForDemocrat();
        machine.voteForDemocrat();
        machine.voteForDemocrat();
        machine.voteForDemocrat();
        machine.voteForDemocrat();
        System.out.println(machine.getDemocratVotes()); // returns 5
        System.out.println(machine.getRepublicanVotes()); // returns 0

        machine.voteForRepublican();
        machine.voteForRepublican();
        machine.voteForRepublican();
        machine.voteForRepublican();
        machine.voteForRepublican();
        System.out.println(machine.getDemocratVotes()); // returns 5
        System.out.println(machine.getRepublicanVotes()); // returns 5
    }
}
