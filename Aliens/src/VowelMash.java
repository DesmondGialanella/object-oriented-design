
public class VowelMash implements ICrypto {

	private static VowelMash instance; 
	
	public static VowelMash getInstance()
	{
		if (instance == null)
			instance = new VowelMash();
		
		return instance;
	}

	@Override
	public String encrypt(String message) {
		
		String newmessage="";
		char C;
		for(int i= 0; i < message.length(); i++)
		{
			C=message.charAt(i);
			
			if(message.charAt(i)=='A')
			{
				C='E';
			}
			else if(message.charAt(i)=='E')
			{
				C='I';
			}
			else if(message.charAt(i)=='I')
			{
				C='O';
			}
			else if(message.charAt(i)=='O')
			{
				C='U';
			}
			else if(message.charAt(i)=='U')
			{
				C='A';
			}
			
			newmessage+=C;
		}
		
		return newmessage;
			
	}

	@Override
	public String decrypt(String message) {
		String newmessage="";
		char C;
		for(int i= 0; i < message.length(); i++)
		{
			C=message.charAt(i);
			
			if(message.charAt(i)=='E')
			{
				C='A';
			}
			else if(message.charAt(i)=='I')
			{
				C='E';
			}
			else if(message.charAt(i)=='O')
			{
				C='I';
			}
			else if(message.charAt(i)=='U')
			{
				C='O';
			}
			else if(message.charAt(i)=='A')
			{
				C='U';
			}
			
			newmessage+=C;
		}
		
		return newmessage;
	
	}
}
