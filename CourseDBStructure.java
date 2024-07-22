import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
	private ArrayList<LinkedList<CourseDBElement>> hashTable;
	private final double loadFactor = 1.5;
	int size;
	
	public CourseDBStructure(int x) 
	{
		// TODO Auto-generated constructor stub
		boolean status = true;
		hashTable = new ArrayList<>(x);
		int initialSize = (int) ((int) x / loadFactor);
		
		if (initialSize <= 1)
		{
			status = false;
		}
		
		for (int i = 2; i < initialSize; i++)
		{
			if (initialSize % i == 0)
			{
				status = false;
			}
		}
		
		while (status == true)
		{
			if (((initialSize - 3) % 4) == 0)
			{
				size = initialSize;
			}
			initialSize++;
		}
		
		hashTable = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++)
		{
			hashTable.add(new LinkedList<>());
		}
	}

	public CourseDBStructure(String string, int x) 
	{
		if (!"Testing".equals(string))
		{
			throw new IllegalArgumentException("invalid argument");
		}
		this.size = size;
		hashTable = new ArrayList<>(size);
		for (int i = 0; i < size; i++)
		{
			hashTable.add(new LinkedList<>());
		}
	}

	public int getTableSize() 
	{
		// TODO Auto-generated method stub
		return size;
	}

	public void add(CourseDBElement cde1)
	{
		// TODO Auto-generated method stub
		int index = cde1.hashCode() % size;
		LinkedList<CourseDBElement> newList = hashTable.get(index);
		for (CourseDBElement e : newList)
		{
			if (e.equals(cde1))
			{
				return;
			}
		}
		newList.add(cde1);
	}

	public ArrayList<String> showAll() 
	{
		// TODO Auto-generated method stub
		
		ArrayList<String> fullCourses = new ArrayList<>();
		for (LinkedList<CourseDBElement> newList : hashTable)
		{
			for (CourseDBElement e : newList)
			{
				fullCourses.add(e.toString());
			}
		}
		return fullCourses;
	}

	
	// gets the course using method below by CRN
	public CourseDBElement get(Object crn) throws IOException
	{
		return get((int) crn);
	}

	
	// also gets a course by the CRN but with an enhanced for loop
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		int index = crn % size;
		LinkedList<CourseDBElement> newList = hashTable.get(index);
		for (CourseDBElement e : newList)
		{
			if(e.getCRN() == crn)
			{
				return e;
			}
		}
		
		throw new IOException("Invalid Course input");
	}

}
