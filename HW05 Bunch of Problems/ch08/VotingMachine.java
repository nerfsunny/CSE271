public class VotingMachine
{
	private int totalDemocratVotes, totalRepublicanVotes;

	public VotingMachine()
	{
		clearVotingMachine();
	}

	public void clearVotingMachine()
	{
		totalRepublicanVotes = 0;
		totalDemocratVotes = 0;
	}

	public void increaseDemocratVote()
	{
		totalDemocratVotes++;
	}

	public void increaseRepublicanVote()
	{
		totalRepublicanVotes++;
	}

	public int getTotalDemocratVotes()
	{
		return totalDemocratVotes;
	}

	public int getTotalRepublicanVotes()
	{
		return totalRepublicanVotes;
	}
}