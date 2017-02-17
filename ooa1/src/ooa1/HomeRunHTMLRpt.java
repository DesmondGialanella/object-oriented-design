package ooa1;
import java.io.*;
import java.util.*;

public class HomeRunHTMLRpt extends HomeRunTextRpt {
	
	public HomeRunHTMLRpt(String datafile, String reportfile)
	{
		super(datafile, reportfile);
		
	}
	
	public void generateReport(List<DataPair> data) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new File(m_reportFile));
		
		pw.println("<html>");
		pw.println("<head><title>Home Run Report</title></head>");
		pw.println("<body><table>");
		
		for (DataPair dp : data)
		{
			pw.println("<tr>");
			
			if (dp.getStat() != -1)
			{
				pw.println("<td>" + dp.getName() + "</td><td>" + dp.getStat() + "</td>\n");
			}
			else
			{
				pw.println("<td>" + dp.getName() + "</td><td>N/A</td>\n");
				pw.println("</tr>");
			}
		}
		
		pw.println("</table></body>");
		pw.println("</html>");
		pw.close();
	}

}
