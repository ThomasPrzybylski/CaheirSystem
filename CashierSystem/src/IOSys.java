import java.io.*;
@SuppressWarnings("unchecked")
public class IOSys<T>{
	public static void writeToBinary(String filename, Object output)
	{
		try {
			@SuppressWarnings("resource")
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream (filename));
			out.writeObject(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public T ReadBinaryFile (String filename)
	{
		T item = null;
		
		try {
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			while(true)
			{
				try {
					item = (T) in.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		catch (EOFException e)
		{
			System.out.println("End of File Reached.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T) item;
	}

}
