package ooassinment2;
import java.util.Scanner;

public class Decision implements IDecision
{
	
	private String m_question;
	private IDecision m_yes;
	private IDecision m_no;
	private String m_yesTerminal;
	private String m_noTerminal;
	
	
	public Decision(String question )
	{
		m_question=question; 
	}
	
	public void setYes(IDecision yes)
	{
		m_yes=yes;
	}
	
	public void setNo(IDecision no)
	{
		m_no=no;
	}
	
	public void setYesTerminal(String yesTerminal)
	{
		m_yesTerminal=yesTerminal;
	}
	
	public void setNoTerminal(String noTerminal)
	{
		m_noTerminal=noTerminal;
	}
	
	public IDecision ask()
	{
		
		
		System.out.println(m_question);// as the user the current question...

		Scanner input= new Scanner(System.in);
		String text= input.nextLine();
				
		// if the user answers yes 
		if(text.equals("yes"))// and there is a decision object set for a yes answer
		{
			if(m_yes == null)// otherwise print the yes terminal string and return null

			{
				System.out.println(m_yesTerminal);
			}
		    return m_yes; // return the yes decision object
		}
		else if(text.equals("no"))// if the user answers no
		{
			if(m_no == null)
			{
				System.out.println(m_noTerminal);// otherwise print the no terminal string and return null
			}
			return m_no;// return the no decision object		
		}
		return null;
		
	}
	
	

}
