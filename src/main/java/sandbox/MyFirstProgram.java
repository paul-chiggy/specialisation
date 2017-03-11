package sandbox;

public class MyFirstProgram
{
	public static void main(String[] args)
	{
		say("Hello busya!");
		Person person = new Person("Oksana", 31, "Ukrainian");
	}

	private static void say(String words)
	{
		System.out.println(words);
	}
}
