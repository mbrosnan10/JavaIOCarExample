package cars;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Cars
{

    static String filename = "cars.txt";

    public static void main(String[] args)
    {
	FileReader fileReader = null;
	FileWriter fileWriterileWriter = null;
	StreamTokenizer streamTokenizer = null;
	PrintWriter printWriter = null;

	try
	{
	    fileReader = new FileReader(filename);
	    //in = new StreamTokenizer(fileReader);

	    streamTokenizer = new StreamTokenizer(fileReader);

	    streamTokenizer.ordinaryChar('-');

	    readHeader(streamTokenizer);

	    
	    while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF)//reading the year
	    {
		parseCar(streamTokenizer);
	    }
	} catch (FileNotFoundException ex)
	{
	    System.out.println("File not found: in.dat");
	} catch (IOException ex)
	{
	    System.out.println(ex.getMessage());
	} finally
	{
	    try
	    {
		if (fileReader != null)
		{
		    fileReader.close();
		}
		if (fileWriterileWriter != null)
		{
		    fileWriterileWriter.close();
		}
	    } catch (IOException ex)
	    {
		System.out.println(ex);
	    }
	}
    }

    private static void parseCar(StreamTokenizer streamTokenizer) throws IOException
    {
	Car car = new Car();
	car.regYear = streamTokenizer.nval;//you don't need to advance the first one. already done outside the function in the loop.
	car.regDash1 = nextAndGetSVal(streamTokenizer);
	car.regCounty = nextAndGetSVal(streamTokenizer);
	car.regDash2 = nextAndGetSVal(streamTokenizer);
	car.regNumber = nextAndGetNVal(streamTokenizer);

	car.make = nextAndGetSVal(streamTokenizer);
	car.model = nextAndGetSVal(streamTokenizer);
	car.color = nextAndGetSVal(streamTokenizer);

	car.city = nextAndGetSVal(streamTokenizer);
	car.price = nextAndGetNVal(streamTokenizer);
	//
	//	Rest
	//
	car.owners = nextAndGetNVal(streamTokenizer);
	car.mileage = nextAndGetNVal(streamTokenizer);

	System.out.println(car.toString());
    }

    public static String nextAndGetSVal(StreamTokenizer streamTokenizer) throws IOException
    {
	streamTokenizer.nextToken();//
	return streamTokenizer.sval;
    }

    public static double nextAndGetNVal(StreamTokenizer streamTokenizer) throws IOException
    {
	streamTokenizer.nextToken();//
	return streamTokenizer.nval;
    }

    private static void readHeader(StreamTokenizer streamTokenizer) throws IOException
    {
	int numberOfTokens = 8;
	for (int i = 0; i < numberOfTokens; i++)
	{
	    streamTokenizer.nextToken();
	}
    }
}
