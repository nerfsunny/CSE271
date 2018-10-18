public class Letter
{
	private String fromPerson, toPerson, bodyLetter;

	public Letter(String fromPerson, String toPerson)
	{
		setSender(fromPerson);
		setReceiver(toPerson);
		bodyLetter = "";
		addLine("Dear " + toPerson + ":");
		addLine("");
	}

	public void setSender(String sender)
	{
		fromPerson = sender;
	}

	public void setReceiver(String receiver)
	{
		toPerson = receiver;
	}

	public String getSender()
	{
		return fromPerson;
	}

	public String getReceiver()
	{
		return toPerson;
	}
	
	public String signLetter()
	{
		return "Signed: " + fromPerson;
	}

	public void addLine(String line)
	{
		bodyLetter = String.format("%s \n %s \n", bodyLetter, line);
	}

	public String getText()
	{
		return bodyLetter;
	}
}