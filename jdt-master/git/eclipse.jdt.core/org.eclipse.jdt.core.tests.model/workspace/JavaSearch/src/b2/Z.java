package b2;
/* Test case for bug 8928 Unable to find references or declarations of methods that use static inner classes in the signature */
public class Z {
	void bar() {
		X.Inner inner = new X.Inner();
		new Y().foo(inner);
	}
}