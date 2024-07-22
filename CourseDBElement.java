
public class CourseDBElement implements Comparable<CourseDBElement>
{
	
	String courseID;
	int crn;
	int credits;
	String roomNumber;
	String instructor;

	public CourseDBElement(String string, int x, int y, String string2, String string3) 
	{
		// TODO Auto-generated constructor stub
		this.courseID = string;
		this.crn = x;
		this.credits = y;
		this.roomNumber = string2;
		this.instructor = string3;
	}

	public CourseDBElement() 
	{
		// TODO Auto-generated constructor stub
	}

	public int getCRN() 
	{
		// TODO Auto-generated method stub
		return crn;
	}

	public String getID() 
	{
		// TODO Auto-generated method stub
		return courseID;
	}

	public void setCRN(int int1) 
	{
		crn = int1;
	}

	public String getRoomNum() 
	{
		// TODO Auto-generated method stub
		return roomNumber;
	}
	
	public String getInstructor()
	{
		return instructor;
	}

	@Override
	public int compareTo(CourseDBElement o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.crn, o.crn);
	}

}
