import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseDBManager implements CourseDBManagerInterface 
{

	public HashMap <Integer, CourseDBElement> data;
	
	public CourseDBManager()
	{
		data = new HashMap<>();
	}
	public void readFile(File inputFile) 
	{
		// TODO Auto-generated method stub
		
	}

	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		// TODO Auto-generated method stub
		CourseDBElement e = new CourseDBElement(id, crn, credits, roomNum, instructor);
		data.put(crn, e);
	}

	public ArrayList<String> showAll()
	{
		// TODO Auto-generated method stub
		
		ArrayList<String> courses = new ArrayList<>();
		for (CourseDBElement e : data.values())
		{
			courses.add(e.toString());
		}
		
		return courses;
	}

	public CourseDBElement get(int int1)
	{
		// TODO Auto-generated method stub
		return data.get(int1);
	}

	
}
