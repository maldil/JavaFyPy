interface Convertible<T> {
	T convert();
}

public class X<A extends Convertible<Convertible<A>>> {
}