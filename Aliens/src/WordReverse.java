
public class WordReverse implements ICrypto {

	private static WordReverse instance; 
	
	public static WordReverse getInstance()
	{
		if (instance == null)
			
			instance = new WordReverse();
		
		return instance;
	}

	@Override
	public String encrypt(String message)
	{
	    String[] sarray = message.split(" ");
	    String Sflip = "";
	    for(int i = sarray.length-1; i > -1; i--)
	    {
	    	Sflip =  Sflip + sarray[i] + " ";
	    }
	    return new StringBuilder(Sflip).reverse().toString();
	  }
	
	@Override
	  public String decrypt(String message)
	{
	    String[] sarray =  new StringBuilder(message).reverse().toString().split(" ");
	    String Sflip = "";
	    for(int i = sarray.length-1; i > -1; i--)
	    {
	    	Sflip = Sflip + sarray[i] + " ";
	    }
	    return Sflip;
	  }
	}