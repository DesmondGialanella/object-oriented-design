
public class Factory {
	
	public IMessageParser createParse(String text)
	{
		return new MessageParser(text);
	}
	
	private static Factory instance;

	
	public static Factory getInstance()
	{
		if (instance == null)
			instance = new Factory();
		
		return instance;
	}

}
