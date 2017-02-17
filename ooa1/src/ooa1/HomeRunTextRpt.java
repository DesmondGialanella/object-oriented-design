package ooa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeRunTextRpt {
	
	protected String m_dataFile;
	
	protected String m_reportFile;
	
	public HomeRunTextRpt(String dataFile, String reportfile)
	{
		m_dataFile = dataFile;
		m_reportFile= reportfile;
		
	}
	
	
	public List<DataPair> loadData() throws FileNotFoundException
	{
		
		List<DataPair> dataList = new ArrayList<DataPair>();
		
		
		Scanner playersReader = new Scanner(new File(m_dataFile));
		
		while(playersReader.hasNextLine())
		{
			
			String line = playersReader.nextLine();
			String[] parts = line.split(",");
			
			if (parts.length > 1) 
			{
				DataPair Data = new DataPair(parts[0], Integer.parseInt(parts[1]));
				dataList.add(Data);
			}
			
		}
		
		return dataList;
	}
	
	public void generateReport(List<DataPair> data) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new File(m_reportFile));
		
		for (DataPair dp : data)
		{
			pw.println("Player Name: " + dp.getName() + ", Player Stat: " + dp.getStat());
		}
	}
	
	
}
