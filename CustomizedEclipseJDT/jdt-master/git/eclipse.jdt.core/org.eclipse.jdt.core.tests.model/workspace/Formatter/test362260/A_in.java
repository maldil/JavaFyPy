// 45678901234567890123456789 1234567890 2
// 45678901234567890123456789 12345678901
class A {
	// 45678901234567890123456789 1234567890 2
	// 45678901234567890123456789 12345678901
	int f() {
		// 45678901234567890123456789 1234567890 2
		// 45678901234567890123456789 12345678901

		int a; // 45678901234567890123456789 1234567890 2
		int b; // 45678901234567890123456789 12345678901

		String c; // 45678901234567890123456789 1234567890 2
		String d; // 45678901234567890123456789 12345678901

		String e = "aaaaaaaaaaaaaaaa" + "aaaaaaaaaaaaaaa"; // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

		String f = "aaaaaa"; // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		String g = "aaaaaa"; //$NON-NLS-1$ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		String h = "aaaaaaaaaaaa"; //$NON-NLS-1$ 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
		String i = "aaaaaaaaaaaa"; // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 //$NON-NLS-1$

		f(); // 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0
	}
}
