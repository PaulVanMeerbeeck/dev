package bgc.bip.idms.dbstub;

import java.io.BufferedReader;
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
	String theStatement, MBIString, mbiDataTwo, storedProc, MBIResponse;
	BufferedReader bufReader;
	
	stubCallableStatement(String aStatement, BufferedReader theReader)
	{
		theStatement = aStatement;
		bufReader = theReader;
		return;
	}

	@Override
	public void addBatch() throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clearParameters() throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() throws SQLException
	{
		String currentLine;
		String request = "MBIRequest: "+this.MBIString;
		boolean bRequestFound=false, bResponse = false;
		try
		{
			while ((currentLine = bufReader.readLine()) != null) 
			{
				if(currentLine.startsWith(request) && !bRequestFound)
				{
					bRequestFound = true; continue;
				}
				if(bRequestFound)
				{
					if(currentLine.startsWith("MBIResponse: "))
					{
						MBIResponse = currentLine; bResponse = true; continue;
					}
					if(currentLine.startsWith("MBIDataTwo: "))
					{
						mbiDataTwo = currentLine;
					}
				}

			}
		}
		catch (IOException e)
		{
			throw new SQLException(e);
		}
		if(bRequestFound &&  bResponse  ) return true;
		else
		{
			throw new SQLException("Request not found in IDMS stub file.", "SQLState", 6);
		}
	}

	@Override
	public ResultSet executeQuery() throws SQLException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArray(int arg0, Array arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		// TODO Auto-generated method stub

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
			case 2: mbiDataTwo =arg1; break;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws SQLException
	{
		this.theStatement = null;
	}

	@Override
	public boolean execute(String sql) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean execute(String sql, String[] columnNames) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] executeBatch() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String sql) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Connection getConnection() throws SQLException
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPoolable() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCursorName(String name) throws SQLException
	{
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(String parameterName) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(int parameterIndex, Map<String, Class<?>> map) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref getRef(int parameterIndex) throws SQLException
	{
		// TODO Auto-generated method stub
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
			case 2: return mbiDataTwo;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, String typeName) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, int scale) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, String typeName) throws SQLException
	{
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return false;
	}

}
