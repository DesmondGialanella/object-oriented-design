package ooassinment2;

public class Builder {
	
	private static Builder instance;
	
	private Builder() {}
	
	public IDecision buildWizard()
	{
		IDecision sb1 = new Decision("Do you want to buy a snowboard?");
		IDecision sb2 = new Decision("Have you snowboarded before?");
		IDecision sb3 = new Decision("Are you an expert?");
		IDecision sb4 = new Decision("Do you like to go fast?");
		
		IDecision s1 = new Decision("Do you want to buy downhill skis?");
		IDecision s2 = new Decision("Have you gone skiing before?");
		IDecision s3 = new Decision("Are you an expert?");
		IDecision s4 = new Decision("Do you like to jump?");

		
		sb1.setYes(sb2);
		sb1.setNo(s1);
		
		sb2.setYes(sb3);
		sb2.setNoTerminal("BUY THE XG100 MODEL.");
		
		sb3.setYes(sb4);
		sb3.setNoTerminal("BUY THE XG200 MODEL.");
		
		sb4.setYesTerminal("BUY THE XG300 MODEL.");
		sb4.setNoTerminal("BUY THE XG200 MODEL.");
				
		s1.setYes(s2);
		s1.setNoTerminal("YOU SHOULD TRY SKIING SOME DAY. IT'S A HOOT!");

		s2.setYes(s3);
		s2.setNoTerminal("BUY THE ZR100 MODEL.");
		
		s3.setYes(s4);
		s3.setNoTerminal("BUY THE ZR200 MODEL.");
		
		s4.setYesTerminal("BUY THE ZR300 MODEL.");
		s4.setNoTerminal("BUY THE ZR200 MODEL.");

		return sb1;

		
	}
	
	public static Builder getInstance()
	{
		if (instance == null)
			instance = new Builder();
		
		return instance;
	}
	
}
