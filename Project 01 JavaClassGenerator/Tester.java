/*
 * Project 01 - Java Class Generator
 * Due: 11-07-2018 by 11:59 pm
 *  
 *	@Sundeep Vaswani (vaswansk)
 * 
 */

import java.util.*;
import java.io.*;
import java.security.*;

public class Tester
{
	public static void main(String[] args)
	{
		RandomAccessFile raf = null;
		RandomAccessFile createFile = null;

		try
		{
			raf = new RandomAccessFile("Script.txt", "r");

			while(raf.getFilePointer() < raf.length())
			{
				String line = raf.readLine();

				if(!(line.toLowerCase().contains("end;")));
				{
					String buffer = raf.readLine();


				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				raf.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}