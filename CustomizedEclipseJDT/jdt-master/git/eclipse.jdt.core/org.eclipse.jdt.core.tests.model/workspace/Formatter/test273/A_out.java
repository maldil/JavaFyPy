public class firstClass
{
	int a;
	Object o;
	void myMethod()
	{
		if (i == 0)
		{
			doSomething();
			doSomethingElse();
		}
		else
		{
			if (right())
				doThis();
			else if (left())
			{
				doThis();
				doThat();
			}
			else if (up())
				doThis();
			else
			{
				doThat();
				doThat();
				switch (a)
				{
					case 1 :
						break;
					case 2 :
						return;
					case 3 :
					case 4 :
						{
						}
					default :
						System.out.println();
				}
			}
			lastThing();
		}
	}
}