package musician;

import java.util.List;

public interface imusicianDButil {

	public  List<musicin> validate(String username, String password);
	
	public  boolean insertmusician(String name,String email,String username, String Password);
	
	public boolean updatemusician(String id, String name,String email,String username,String password);
	
	public List<musicin> getmusicianDetails(String id);
		
	public boolean deletemusician(String id);
	
}
