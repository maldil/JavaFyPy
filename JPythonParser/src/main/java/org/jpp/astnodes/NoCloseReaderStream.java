
package org.jpp.astnodes;

import java.io.*;

import org.antlr.runtime.ANTLRStringStream;

//This is the same as ANTLRReaderStream except it does not close the Reader.
//Used for interactive mode where we may need to parse twice.
public class NoCloseReaderStream extends ANTLRStringStream {
	public static final int READ_BUFFER_SIZE = 1024;
	public static final int INITIAL_BUFFER_SIZE = 1024;

	public NoCloseReaderStream(Reader r) throws IOException {
		this(r, INITIAL_BUFFER_SIZE, READ_BUFFER_SIZE);
	}

	public NoCloseReaderStream(Reader r, int size) throws IOException {
		this(r, size, READ_BUFFER_SIZE);
	}

	public NoCloseReaderStream(Reader r, int size, int readChunkSize) throws IOException {
		load(r, size, readChunkSize);
	}

	public void load(Reader r, int size, int readChunkSize)
		throws IOException
	{
		if ( r==null ) {
			return;
		}
		if ( size<=0 ) {
			size = INITIAL_BUFFER_SIZE;
		}
		if ( readChunkSize<=0 ) {
			readChunkSize = READ_BUFFER_SIZE;
		}
		data = new char[size];
		// read all the data in chunks of readChunkSize
		int numRead=0;
		int p = 0;
		do {
			if ( p+readChunkSize > data.length ) { // overflow?
				char[] newdata = new char[data.length*2]; // resize
				System.arraycopy(data, 0, newdata, 0, data.length);
				data = newdata;
			}
			numRead = r.read(data, p, readChunkSize);
			p += numRead;
		} while (numRead!=-1); // while not EOF
		// set the actual size of the data available;
		// EOF subtracted one above in p+=numRead; add one back
		super.n = p+1;
	}
}
