package ooa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RBITextRpt extends HomeRunTextRpt {

	public RBITextRpt(String datafile, String reportfile)
	{
		
		super(datafile, reportfile);

	}
	
	public List<DataPair> loadData() throws FileNotFoundException
	{
		List<DataPair> dataList = new ArrayList<DataPair>();
		
		
		Scanner playersReader = new Scanner(new File(m_dataFile));
		
		while(playersReader.hasNextLine())
		{
			String line = playersReader.nextLine();
			String[] parts = line.split(",");
			
			if (parts.length > 2) 
			{
				DataPair Data = new DataPair(parts[0], Integer.parseInt(parts[2]));
				dataList.add(Data);
			}
			
		}
		
		return dataList;
	}
	
}
