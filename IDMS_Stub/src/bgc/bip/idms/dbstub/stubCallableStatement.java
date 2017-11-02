package bgc.bip.idms.dbstub;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class stubCallableStatement implements CallableStatement
{
	String theStatement, MBIString, mbiDataTwoRequest, storedProc, MBIResponse, mbiDataTwoResponse="";
	FileReader fileReader;
	SQLWarning warnings;
	boolean poolable;
	
	stubCallableStatement(String aStatement, String dbName) throws SQLException
	{
        try 
        {
			System.out.println("stubCallableStatement - stubCallableStatement(String aStatement, String dbName) called");
			theStatement = aStatement;
	    	fileReader = new FileReader(dbName);
	    	System.out.println("stubCallableStatement - Opened file.");
			return;
	    } 
	    catch (FileNotFoundException ex) 
	    {
	        throw new SQLException("stubCallableStatement - File not found",dbName,100);
	    }
	}

	@Override
	public void addBatch() throws SQLException
	{
		System.out.println("stubCallableStatement - void addBatch() called");
		// TODO Auto-generated method stub

	}

	@Override
	public void clearParameters() throws SQLException
	{
		System.out.println("stubCallableStatement - void clearParameters() called");
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() throws SQLException
	{
		System.out.println("stubCallableStatement - boolean execute() called");
		String currentLine;
		String request = "MBIRequest: "+this.MBIString;
		if(this.mbiDataTwoRequest.trim().isEmpty()==false) request=request+mbiDataTwoRequest;
		boolean bRequestFound=false, bResponseFound = false, bDataToBeFound = false;
		try
		{
			System.out.println("stubCallableStatement - execute +["+request+"]");
			BufferedReader bufReader = new BufferedReader(fileReader);

			while ((currentLine = bufReader.readLine()) != null) 
			{
				if(currentLine.length()<10) continue;
				System.out.println("stubCallableStatement - read line +["+currentLine+"]");
				if(currentLine.startsWith("MBIRequest: ") && !bRequestFound)
				{
					if(request.length() < currentLine.length())
					{
						if(currentLine.startsWith(request))
						{
							bRequestFound = true;
						}
					}
					else if(request.startsWith(currentLine))
					{
						bRequestFound = true;
					}
					if(bRequestFound) System.out.println("stubCallableStatement - request found");
					continue;
				}
				if(bRequestFound && bResponseFound && currentLine.startsWith("MBIRequest: ") && bDataToBeFound==true)
				{
					bDataToBeFound = false;
//					System.out.println("stubCallableStatement - resetting bDataToBeFound to false.");
				}
				if(bRequestFound)
				{
					if(bResponseFound==false && currentLine.startsWith("MBIResponse: "))
					{
						MBIResponse = currentLine.substring("MBIResponse: ".length()); 
						bResponseFound = true; 
						bDataToBeFound = true;
						System.out.println("stubCallableStatement - response found");
						continue;
					}
					if(bDataToBeFound==true && currentLine.startsWith("MBIDataTwo: "))
					{
						mbiDataTwoResponse = currentLine.substring("MBIDataTwo: ".length());
						bDataToBeFound=false;
						System.out.println("stubCallableStatement - continuation data found");
					}
				}

			}
		}
		catch (IOException e)
		{
			throw new SQLException(e);
		}
		if(bRequestFound &&  bResponseFound) 
		{
			System.out.println("stubCallableStatement - request & response found");
			return true;
		}
		else
		{
			System.out.println("stubCallableStatement - execute - request not found!");
			throw new SQLException("Request not found in IDMS stub file.", "SQLState", 6);
		}
	}

	@Override
	public ResultSet executeQuery() throws SQLException
	{
		System.out.println("stubCallableStatement - ResultSet executeQuery() called");
		return null;
	}

	@Override
	public int executeUpdate() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException
	{
		System.out.println("stubCallableStatement - ResultSetMetaData getMetaData() called");
		return null;
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException
	{
		System.out.println("stubCallableStatement - ParameterMetaData getParameterMetaData() called");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArray(int arg0, Array arg1) throws SQLException
	{
		System.out.println("stubCallableStatement - void setArray(int arg0, Array arg1) called");

	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
		System.out.println("stubCallableStatement - void setAsciiStream(int arg0, InputStream arg1) called");
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		System.out.println("stubCallableStatement - void setAsciiStream(int arg0, InputStream arg1, int arg2) called");
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		System.out.println("stubCallableStatement - void setAsciiStream(int arg0, InputStream arg1, long arg2) called");
	}

	@Override
	public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int arg0, Blob arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int arg0, InputStream arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBoolean(int arg0, boolean arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setByte(int arg0, byte arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBytes(int arg0, byte[] arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int arg0, Clob arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int arg0, Reader arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(int arg0, Date arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDouble(int arg0, double arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setFloat(int arg0, float arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(int arg0, int arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setLong(int arg0, long arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int arg0, NClob arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int arg0, Reader arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNString(int arg0, String arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(int arg0, int arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(int arg0, int arg1, String arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(int arg0, Object arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setRef(int arg0, Ref arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setRowId(int arg0, RowId arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setSQLXML(int arg0, SQLXML arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setShort(int arg0, short arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setString(int arg0, String arg1) throws SQLException
	{
		switch (arg0)
		{
			case 1: MBIString = arg1; break;
			case 2: mbiDataTwoRequest =arg1; break;
		}
	}

	@Override
	public void setTime(int arg0, Time arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setURL(int arg0, URL arg1) throws SQLException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void setUnicodeStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void addBatch(String sql) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clearBatch() throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clearWarnings() throws SQLException
	{
		warnings = null;
	}

	@Override
	public void close() throws SQLException
	{
		System.out.println("stubCallableStatement - void close() called");
		try
		{
			if(this.fileReader!=null) 
			{ 
				this.fileReader.close();
				this.fileReader=null;
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.theStatement = null;
	}

	@Override
	public boolean execute(String sql) throws SQLException
	{
		System.out.println("stubCallableStatement - boolean execute(String sql) called");
		return false;
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
	{
		System.out.println("stubCallableStatement - boolean execute(String sql, int autoGeneratedKeys) called");
		return false;
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException
	{
		System.out.println("stubCallableStatement - boolean execute(String sql, int[] columnIndexes) called");
		return false;
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException
	{
		System.out.println("stubCallableStatement - boolean execute(String sql, String[] columnNames) called");
		return false;
	}

	@Override
	public int[] executeBatch() throws SQLException
	{
		System.out.println("stubCallableStatement - int[] executeBatch() called");
		return new int[]{};
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException
	{
		System.out.println("stubCallableStatement - ResultSet executeQuery(String sql) called");
		return null;
	}

	@Override
	public int executeUpdate(String sql) throws SQLException
	{
		System.out.println("stubCallableStatement - int executeUpdate(String sql) called");
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
	{
		System.out.println("stubCallableStatement - int executeUpdate(String sql, int autoGeneratedKeys) called");
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
	{
		System.out.println("stubCallableStatement - int executeUpdate(String sql, int[] columnIndexes) called");
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException
	{
		System.out.println("stubCallableStatement - int executeUpdate(String sql, String[] columnNames) called");
		return 0;
	}

	@Override
	public Connection getConnection() throws SQLException
	{
		System.out.println("stubCallableStatement - Connection getConnection() called");
		return null;
	}

	@Override
	public int getFetchDirection() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFetchSize() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxFieldSize() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxRows() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQueryTimeout() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getResultSet() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetHoldability() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetType() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUpdateCount() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException
	{
		System.out.println("stubCallableStatement - SQLWarning getWarnings() called");
		// TODO Auto-generated method stub
		return this.warnings;
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		System.out.println("stubCallableStatement - boolean isClosed() called");
		return false;
	}

	@Override
	public boolean isPoolable() throws SQLException
	{
		System.out.println("stubCallableStatement - boolean isPoolable() called");
		return this.poolable;
	}

	@Override
	public void setCursorName(String name) throws SQLException
	{
		System.out.println("stubCallableStatement - void setCursorName(String name) called");

	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setFetchDirection(int direction) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setFetchSize(int rows) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxRows(int max) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException
	{
		System.out.println("stubCallableStatement - boolean isPoolable() called");
		this.poolable = poolable;
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		return arg0.isInstance(this);
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
		try
		{
			return arg0.cast(this);
		}
		catch(ClassCastException ex)
		{
			throw new SQLException("Class "+this.getClass().getName()+ " does not implement or extend "+arg0.getName());
		}
	}

	@Override
	public Array getArray(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array getArray(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob getBlob(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getBoolean(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte getByte(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getByte(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getBytes(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBytes(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getCharacterStream(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getCharacterStream(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob getClob(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(int parameterIndex, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getDate(String parameterName, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDouble(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDouble(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloat(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFloat(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reader getNCharacterStream(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reader getNCharacterStream(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob getNClob(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob getNClob(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNString(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNString(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(int parameterIndex) throws SQLException
	{
		System.out.println("stubCallableStatement - Object getObject(int parameterIndex) called");
		return null;
	}

	@Override
	public Object getObject(String parameterName) throws SQLException
	{
		System.out.println("stubCallableStatement - Object getObject(String parameterName) called");
		return null;
	}

	@Override
	public Object getObject(int parameterIndex, Map<String, Class<?>> map) throws SQLException
	{
		System.out.println("stubCallableStatement - Object getObject(int parameterIndex, Map<String, Class<?>> map) called");
		return null;
	}

	@Override
	public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException
	{
		System.out.println("stubCallableStatement - Object getObject(String parameterName, Map<String, Class<?>> map) called");
		return null;
	}

	@Override
	public Ref getRef(int parameterIndex) throws SQLException
	{
		System.out.println("stubCallableStatement -  Ref getRef(int parameterIndex) called");
		return null;
	}

	@Override
	public Ref getRef(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowId getRowId(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML getSQLXML(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public short getShort(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getShort(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getString(int parameterIndex) throws SQLException
	{
		switch(parameterIndex)
		{
			case 1: return MBIResponse;
			case 2: return mbiDataTwoResponse;
		}
		return null;
	}

	@Override
	public String getString(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(int parameterIndex, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time getTime(String parameterName, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getURL(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(int parameterIndex, int sqlType) called");

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(String parameterName, int sqlType) called");

	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(int parameterIndex, int sqlType, int scale) called");

	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(int parameterIndex, int sqlType, String typeName) called");

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(String parameterName, int sqlType, int scale) called");

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException
	{
		System.out.println("stubCallableStatement - void registerOutParameter(String parameterName, int sqlType, String typeName) called");

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(String parameterName, Blob x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBoolean(String parameterName, boolean x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setByte(String parameterName, byte x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setBytes(String parameterName, byte[] x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, int length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Clob x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Reader reader) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setClob(String parameterName, Reader reader, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(String parameterName, Date x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDate(String parameterName, Date x, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setDouble(String parameterName, double x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setFloat(String parameterName, float x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(String parameterName, int x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setLong(String parameterName, long x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, NClob value) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, Reader reader) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNClob(String parameterName, Reader reader, long length) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNString(String parameterName, String value) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(String parameterName, int sqlType) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setNull(String parameterName, int sqlType, String typeName) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(String parameterName, Object x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType, int scale) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setRowId(String parameterName, RowId x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setShort(String parameterName, short x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setString(String parameterName, String x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(String parameterName, Time x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTime(String parameterName, Time x, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setURL(String parameterName, URL val) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean wasNull() throws SQLException
	{
		System.out.println("stubCallableStatement - boolean wasNull() called");
		return false;
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T getObject(int parameterIndex, Class<T> type)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getObject(String parameterName, Class<T> type)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
