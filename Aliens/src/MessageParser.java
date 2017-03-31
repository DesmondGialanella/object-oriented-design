import java.util.*;

public class MessageParser implements IMessageParser
{
  private List<String> m_words;
  private String m_msg;

  
  public MessageParser(String msg)
  {
	  m_msg = msg;
  }
  
  public int getCharCount()
  {
	  return m_msg.length();
  }
  
  public int getWordCount()
  {
	  return m_words.size();
  }
  
  public char getChar(int i)
  {
	  return m_msg.charAt(i);
  }
  
  public String getWord(int i)
  {
	  return m_words.get(i);
  }
  
}
