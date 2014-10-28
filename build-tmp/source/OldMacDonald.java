import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OldMacDonald extends PApplet {

//your variable declarations here
public void setup()
{
	Farm myFarm = new Farm();
	myFarm.animalSounds();
}
interface Animal
{
	public String getType();
	public String getSound();
}
class Cow implements Animal
{
	protected String myType;
	protected String mySound;
	public Cow (String type, String sound)
	{
		myType = type;
		mySound = sound;
	}
	public Cow()
	{
		myType = "unknown";
		mySound = "unknown";
	}
	public String getType(){return myType;}
	public String getSound(){return mySound;}
}
class Chick implements Animal
{
	private String myType;
	private String mySound;
	public Chick (String type, String sound, String sound1)
	{
		myType = type;
		if ((int)(Math.random()*2)+1 == 1)
		{
			mySound = sound;
		}
		else 
		{	
			mySound = sound1;	
		}
	}
	public Chick()
	{
		myType = "unknown";
		mySound = "unknown";
	}
	public String getType(){return myType;}
	public String getSound(){return mySound;}
}
class Pig implements Animal
{
	private String myType;
	private String mySound;
	public Pig (String type, String sound)
	{
		myType = type;
		mySound = sound;
	}
	public Pig()
	{
		myType = "unknown";
		mySound = "unknown";
	}
	public String getType(){return myType;}
	public String getSound(){return mySound;}
}
class NamedCow extends Cow
{
	private String myName;
	public NamedCow(String type, String name, String sound)
	{
		myName = name;
		myType = type;
		mySound = sound;
	}
	public String getmyName()
	{
		return myName;
	}
}
class Farm
{
	private Animal[] aBunchOfAnimals = new Animal[3];
	public Farm()
	{
		aBunchOfAnimals[0] = new NamedCow("cow", "Elsie", "moo");
		aBunchOfAnimals[1] = new Chick("chick", "cluck", "cheep");
		aBunchOfAnimals[2] = new Pig("pig", "oink");
	}
	public void animalSounds()
	{
		for (int nI = 0; nI < aBunchOfAnimals.length; nI++)
		{
			System.out.println(aBunchOfAnimals[nI].getType() + " goes " + aBunchOfAnimals[nI].getSound());
		}
		System.out.println( "The cow is known as " + ((NamedCow)aBunchOfAnimals[0]).getmyName());
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
