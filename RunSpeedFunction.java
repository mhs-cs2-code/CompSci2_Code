import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Random;
import java.util.stream.DoubleStream;
public class RunSpeedCapacity {
	private static double RunSpeedCalc(double age, double height,  double weight, double stride)
	{
		double speed = 2;
		double stridespermile = 63360 / stride;
		double heightweight = height * weight;
		heightweight = heightweight / stridespermile;
		speed *= heightweight;
		speed *= -0.0003783*age*age + 
				0.02672499*age + 0.63295515;
		return speed;
	}
	private static void SimulateRace()
	{
		Random generator= new Random();
		double times[] = new double[5];
		double curMin = 10000, minIndex = 0;
		for(int i = 0; i < 5; i++)
		{
			
			double age = Math.random() * 12 + 18;
			double height = Math.random() * 15 + 64;
			double weight = Math.random() * 80 + 120;
			double stride = Math.random() * 14 + 28;
			double time = RunSpeedCalc(age, height, weight, stride);
			time *= Math.random()*0.15 + 0.85;
			time = 60 / time;
			
			times[i] = time;
			if(time < curMin)
			{
				curMin = time;
				minIndex = i;
			}
			System.out.println("Runner #" + i + " has a time of " + time);
		}
		System.out.println();
		System.out.println("Runner #" + (int) minIndex + " wins with a time of " + curMin);
	}
	static public void main(String args[]) throws NumberFormatException, IOException
	{
		InputStreamReader systemreader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(systemreader);
		System.out.print("Calc or Sim: ");
		if(in.readLine().equals("sim"))
			SimulateRace();
		else
		{
			System.out.print("Age (Years): ");
			double age = Double.parseDouble(in.readLine());
			System.out.print("Height (Inches): ");
			double height = Double.parseDouble(in.readLine());
			System.out.print("Weight (Pounds): ");
			double weight = Double.parseDouble(in.readLine());
			System.out.print("Stride Length (Inches): ");
			double stride = Double.parseDouble(in.readLine());	
			double speed = RunSpeedCalc(age, height, weight, stride);
			System.out.println("Your max running Speed is " + speed + "mph");
		}
	}
}
