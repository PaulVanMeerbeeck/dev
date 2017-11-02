package bgc.bip.idms.dbstub;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;
import javax.sql.PooledConnection;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetWarning;
import javax.sql.rowset.spi.SyncProvider;
import javax.sql.rowset.spi.SyncProviderException;
import javax.sql.ConnectionPoolDataSource;

public class stubDataSource implements DataSource, CachedRowSet, ConnectionPoolDataSource   
{
	String dsName;
	String userName;
	String passWord;
	String command;
	String url;
	stubConnection theConnection;
	Statement theStatement = null;
	PrintWriter logWriter = null;
	SQLWarning warnings;

	public stubDataSource()
	{
		System.out.println("stubDataSource called");
		return;
	}
	
/*	public void setdsName(String value)
	{
		System.out.println("setdsName called");
		dsName = value;
	}

	public String getdsName()
	{
		return dsName;
	} */

	@Override
	public PrintWriter getLogWriter() throws SQLException
	{
		return this.logWriter;
	}

	@Override
	public int getLoginTimeout() throws SQLException
	{
		System.out.println("getLoginTimeout called");
		throw (new UnsupportedOperationException());
//		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException
	{
		logWriter = arg0;;
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException
	{
		System.out.println("setLoginTimeout called");
		throw (new UnsupportedOperationException());
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
	public void addRowSetListener(RowSetListener arg0)
	{
		System.out.println("addRowSetListener(RowSetListener arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void clearParameters() throws SQLException
	{
		System.out.println("clearParameters() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void execute() throws SQLException
	{
		System.out.println("execute() called");
	}

	@Override
	public String getCommand()
	{
		System.out.println("getCommand() called");
		return null;
	}

	@Override
	public String getDataSourceName()
	{
		System.out.println("getDataSourceName() called");
		return dsName;
	}

	@Override
	public boolean getEscapeProcessing() throws SQLException
	{
		System.out.println("getEscapeProcessing() called");
		return false;
	}

	@Override
	public int getMaxFieldSize() throws SQLException
	{
		System.out.println("getMaxFieldSize() called");
		return 32000;
	}

	@Override
	public int getMaxRows() throws SQLException
	{
		System.out.println("getMaxRows() called");
		return 1000;
	}

	@Override
	public String getPassword()
	{
		System.out.println("getPassword() called");
		return this.passWord;
	}

	@Override
	public int getQueryTimeout() throws SQLException
	{
		System.out.println("getQueryTimeout() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getTransactionIsolation()
	{
		System.out.println("getTransactionIsolation() called");
		if(theConnection !=  null)
		{
			try
			{
				return theConnection.getTransactionIsolation();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				return 1;
			}
		}
		else
			return 1;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException
	{
		System.out.println("Map<String, Class<?>> getTypeMap() called");
		return new HashMap<String, Class<?>>();
	}

	@Override
	public String getUrl() throws SQLException
	{
		System.out.println("getUrl() called");
		return this.url;
	}

	@Override
	public String getUsername()
	{
		System.out.println("getUsername() called");
		return this.userName;
	}

	@Override
	public boolean isReadOnly()
	{
		System.out.println("isReadOnly() called");
		return true;
	}

	@Override
	public void removeRowSetListener(RowSetListener arg0)
	{
		System.out.println("removeRowSetListener(RowSetListener arg0) called");
	}

	@Override
	public void setArray(int arg0, Array arg1) throws SQLException
	{
		System.out.println("setArray(int arg0, Array arg1) called");
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
		System.out.println("setAsciiStream(int arg0, InputStream arg1) called");
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1) throws SQLException
	{
		System.out.println("setAsciiStream(String arg0, InputStream arg1) called");
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		System.out.println("setAsciiStream(int arg0, InputStream arg1, int arg2) called");
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		System.out.println("setAsciiStream(String arg0, InputStream arg1, int arg2) called");
	}

	@Override
	public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException
	{
		System.out.println("setBigDecimal(int arg0, BigDecimal arg1) called");
	}

	@Override
	public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException
	{
		System.out.println("setBigDecimal(String arg0, BigDecimal arg1) called");
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1) throws SQLException
	{
		System.out.println("setBinaryStream(int arg0, InputStream arg1) called");
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1) throws SQLException
	{
		System.out.println("void setBinaryStream(String arg0, InputStream arg1) called");
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		System.out.println("void setBinaryStream(int arg0, InputStream arg1, int arg2) called");
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		System.out.println("void setBinaryStream(String arg0, InputStream arg1, int arg2) called");
	}

	@Override
	public void setBlob(int arg0, Blob arg1) throws SQLException
	{
		System.out.println("void setBlob(int arg0, Blob arg1) called");
	}

	@Override
	public void setBlob(int arg0, InputStream arg1) throws SQLException
	{
		System.out.println("void setBlob(int arg0, InputStream arg1) called");
	}

	@Override
	public void setBlob(String arg0, Blob arg1) throws SQLException
	{
		System.out.println("void setBlob(String arg0, Blob arg1) called");
	}

	@Override
	public void setBlob(String arg0, InputStream arg1) throws SQLException
	{
		System.out.println("void setBlob(String arg0, InputStream arg1) called");
	}

	@Override
	public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		System.out.println("void setBlob(String arg0, InputStream arg1) called");
	}

	@Override
	public void setBlob(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBoolean(int arg0, boolean arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBoolean(String arg0, boolean arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setByte(int arg0, byte arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setByte(String arg0, byte arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBytes(int arg0, byte[] arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBytes(String arg0, byte[] arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setCharacterStream(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(int arg0, Clob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(String arg0, Clob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setCommand(String arg0) throws SQLException
	{
		System.out.println("void setCommand(String arg0) called");
		this.command = arg0;
	}

	@Override
	public void setConcurrency(int arg0) throws SQLException
	{
		System.out.println("void setConcurrency(int arg0) called");
	}

	@Override
	public void setDataSourceName(String arg0) throws SQLException
	{
		System.out.println("void setDataSourceName(String arg0) called");
		this.dsName = arg0;
	}

	@Override
	public void setDate(int arg0, Date arg1) throws SQLException
	{
		System.out.println("void setDate(int arg0, Date arg1) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDate(String arg0, Date arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDate(int arg0, Date arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDate(String arg0, Date arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDouble(int arg0, double arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDouble(String arg0, double arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setEscapeProcessing(boolean arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setFloat(int arg0, float arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setFloat(String arg0, float arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setInt(int arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setInt(String arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setLong(int arg0, long arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setLong(String arg0, long arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMaxFieldSize(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMaxRows(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNCharacterStream(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(String arg0, NClob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(int arg0, NClob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNString(int arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNString(String arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNull(int arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNull(String arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNull(int arg0, int arg1, String arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setNull(String arg0, int arg1, String arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(String arg0, Object arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(int arg0, Object arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(String arg0, Object arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(int arg0, Object arg1, int arg2, int arg3) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setObject(String arg0, Object arg1, int arg2, int arg3) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setPassword(String arg0) throws SQLException
	{
		System.out.println("void setPassword(String arg0) called");
		this.passWord = arg0;
	}

	@Override
	public void setQueryTimeout(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setReadOnly(boolean arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setRef(int arg0, Ref arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setRowId(int arg0, RowId arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setRowId(String arg0, RowId arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setSQLXML(int arg0, SQLXML arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setSQLXML(String arg0, SQLXML arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setShort(int arg0, short arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setShort(String arg0, short arg1) throws SQLException
	{
		System.out.println("void setShort(String arg0, short arg1) called");
	}

	@Override
	public void setString(int arg0, String arg1) throws SQLException
	{
		System.out.println("void setString(int arg0, String arg1) called");
	}

	@Override
	public void setString(String arg0, String arg1) throws SQLException
	{
		System.out.println("void setString(String arg0, String arg1) called");
	}

	@Override
	public void setTime(int arg0, Time arg1) throws SQLException
	{
		System.out.println("void setTime(int arg0, Time arg1) called");
	}

	@Override
	public void setTime(String arg0, Time arg1) throws SQLException
	{
		System.out.println("void setTime(String arg0, Time arg1) called");
	}

	@Override
	public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException
	{
		System.out.println("setTime(int arg0, Time arg1, Calendar arg2) called");
	}

	@Override
	public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException
	{
		System.out.println("setTime(String arg0, Time arg1, Calendar arg2) called");
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1) throws SQLException
	{
		System.out.println("void setTimestamp(int arg0, Timestamp arg1) called");
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1) throws SQLException
	{
		System.out.println("setTimestamp(String arg0, Timestamp arg1) called");
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException
	{
		System.out.println("setTimestamp(int arg0, Timestamp arg1, Calendar arg2) called");
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException
	{
		System.out.println("setTimestamp(String arg0, Timestamp arg1, Calendar arg2) called");
	}

	@Override
	public void setTransactionIsolation(int arg0) throws SQLException
	{
		System.out.println("setTransactionIsolation(int arg0) called");
		if(this.theConnection!=null)
		{
			theConnection.setTransactionIsolation(arg0);
		}
	}

	@Override
	public void setType(int arg0) throws SQLException
	{
		System.out.println("setType(int arg0) called");
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException
	{
		System.out.println("setTypeMap(Map<String, Class<?>> arg0) called");
	}

	@Override
	public void setURL(int arg0, URL arg1) throws SQLException
	{
		System.out.println("setURL(int arg0, URL arg1) called");
	}

	@Override
	public void setUrl(String arg0) throws SQLException
	{
		System.out.println("setUrl(String arg0) called");
		this.url = arg0;
	}

	@Override
	public void setUsername(String arg0) throws SQLException
	{
		System.out.println("setUsername(String arg0) called");
		this.userName = arg0;
	}

	@Override
	public boolean absolute(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void afterLast() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void beforeFirst() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void cancelRowUpdates() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void clearWarnings() throws SQLException
	{
		System.out.println(" void clearWarnings() called");
		warnings = null;
	}

	@Override
	public void close() throws SQLException
	{
		System.out.println(" void close() called");
		if(theConnection != null) 
		{
			theConnection.close();
		}
		theConnection = null;
	}

	@Override
	public void deleteRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int findColumn(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean first() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Array getArray(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Array getArray(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getAsciiStream(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getAsciiStream(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public BigDecimal getBigDecimal(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public BigDecimal getBigDecimal(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public BigDecimal getBigDecimal(String arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getBinaryStream(int arg0) throws SQLException
	{
		System.out.println("InputStream getBinaryStream(int arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getBinaryStream(String arg0) throws SQLException
	{
		System.out.println("InputStream getBinaryStream(String arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Blob getBlob(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Blob getBlob(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean getBoolean(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean getBoolean(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public byte getByte(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public byte getByte(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public byte[] getBytes(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public byte[] getBytes(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Reader getCharacterStream(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Reader getCharacterStream(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Clob getClob(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Clob getClob(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getConcurrency() throws SQLException
	{
		System.out.println("int getConcurrency() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getCursorName() throws SQLException
	{
		System.out.println("String getCursorName() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Date getDate(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Date getDate(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Date getDate(int arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Date getDate(String arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public double getDouble(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public double getDouble(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getFetchDirection() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getFetchSize() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public float getFloat(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public float getFloat(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getHoldability() throws SQLException
	{
		System.out.println("int getHoldability() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getInt(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getInt(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public long getLong(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public long getLong(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Reader getNCharacterStream(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Reader getNCharacterStream(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public NClob getNClob(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public NClob getNClob(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getNString(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getNString(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Object getObject(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Object getObject(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Ref getRef(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Ref getRef(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public RowId getRowId(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public RowId getRowId(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public SQLXML getSQLXML(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public SQLXML getSQLXML(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public short getShort(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public short getShort(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Statement getStatement() throws SQLException
	{
		System.out.println("Statement getStatement() called");
		if(theStatement != null) return theStatement;
		else throw new SQLException("No statement created yet.");
	}

	@Override
	public String getString(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getString(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(String arg0) throws SQLException
	{
		System.out.println("getTime(String arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(int arg0, Calendar arg1) throws SQLException
	{
		System.out.println("Time getTime(int arg0, Calendar arg1) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(String arg0, Calendar arg1) throws SQLException
	{
		System.out.println("Time getTime(String arg0, Calendar arg1) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(int arg0) throws SQLException
	{
		System.out.println("Timestamp getTimestamp(int arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(String arg0) throws SQLException
	{
		System.out.println("Timestamp getTimestamp(String arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException
	{
		System.out.println("Timestamp getTimestamp(int arg0, Calendar arg1) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException
	{
		System.out.println("Timestamp getTimestamp(String arg0, Calendar arg1) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getType() throws SQLException
	{
		System.out.println("getType() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public URL getURL(int arg0) throws SQLException
	{
		System.out.println("URL getURL(int arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public URL getURL(String arg0) throws SQLException
	{
		System.out.println("getURL(String arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getUnicodeStream(int arg0) throws SQLException
	{
		System.out.println("getUnicodeStream(int arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getUnicodeStream(String arg0) throws SQLException
	{
		System.out.println("getUnicodeStream(String arg0) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public SQLWarning getWarnings() throws SQLException
	{
		System.out.println("SQLWarning getWarnings() called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void insertRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isAfterLast() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isBeforeFirst() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		System.out.println("isClosed() called");
		if(theConnection != null) return theConnection.isClosed();
		else return true;
	}

	@Override
	public boolean isFirst() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isLast() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean last() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void moveToCurrentRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void moveToInsertRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean next() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean previous() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void refreshRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean relative(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean rowDeleted() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean rowInserted() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean rowUpdated() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setFetchDirection(int arg0) throws SQLException
	{
		System.out.println("setFetchDirection(int arg0) called");
	}

	@Override
	public void setFetchSize(int arg0) throws SQLException
	{
		System.out.println("setFetchSize(int arg0) called");
	}

	@Override
	public void updateArray(int arg0, Array arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateArray(String arg0, Array arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateAsciiStream(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBigDecimal(int arg0, BigDecimal arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBigDecimal(String arg0, BigDecimal arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBinaryStream(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(int arg0, Blob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(String arg0, Blob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBlob(String arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBoolean(int arg0, boolean arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBoolean(String arg0, boolean arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateByte(int arg0, byte arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateByte(String arg0, byte arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBytes(int arg0, byte[] arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateBytes(String arg0, byte[] arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(int arg0, Reader arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(String arg0, Reader arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(int arg0, Clob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(String arg0, Clob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateDate(int arg0, Date arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateDate(String arg0, Date arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateDouble(int arg0, double arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateDouble(String arg0, double arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateFloat(int arg0, float arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateFloat(String arg0, float arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateInt(int arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateInt(String arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateLong(int arg0, long arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateLong(String arg0, long arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNCharacterStream(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNCharacterStream(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNCharacterStream(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNCharacterStream(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(int arg0, NClob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(String arg0, NClob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(int arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(String arg0, Reader arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(int arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNClob(String arg0, Reader arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNString(int arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNString(String arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNull(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateNull(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateObject(int arg0, Object arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateObject(String arg0, Object arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateObject(int arg0, Object arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateObject(String arg0, Object arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateRef(int arg0, Ref arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateRef(String arg0, Ref arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateRowId(int arg0, RowId arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateRowId(String arg0, RowId arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateSQLXML(int arg0, SQLXML arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateSQLXML(String arg0, SQLXML arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateShort(int arg0, short arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateShort(String arg0, short arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateString(int arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateString(String arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateTime(int arg0, Time arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateTime(String arg0, Time arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateTimestamp(int arg0, Timestamp arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void updateTimestamp(String arg0, Timestamp arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean wasNull() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int[] getMatchColumnIndexes() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String[] getMatchColumnNames() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMatchColumn(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMatchColumn(int[] arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMatchColumn(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMatchColumn(String[] arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void unsetMatchColumn(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void unsetMatchColumn(int[] arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void unsetMatchColumn(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void unsetMatchColumn(String[] arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void acceptChanges() throws SyncProviderException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void acceptChanges(Connection arg0) throws SyncProviderException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean columnUpdated(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean columnUpdated(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void commit() throws SQLException
	{
		System.out.println("commit() called");
	}

	@Override
	public CachedRowSet createCopy() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public CachedRowSet createCopyNoConstraints() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public CachedRowSet createCopySchema() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public RowSet createShared() throws SQLException
	{
		System.out.println("RowSet createShared() called");
		return null;
	}

	@Override
	public void execute(Connection arg0) throws SQLException
	{
		System.out.println("execute(Connection arg0) called");
	}

	@Override
	public int[] getKeyColumns() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public ResultSet getOriginal() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public ResultSet getOriginalRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getPageSize()
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public RowSetWarning getRowSetWarnings() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean getShowDeleted() throws SQLException
	{
		System.out.println("getShowDeleted() called");
		return false;
	}

	@Override
	public SyncProvider getSyncProvider() throws SQLException
	{
		System.out.println("SyncProvider getSyncProvider() called");
		return null;
	}

	@Override
	public String getTableName() throws SQLException
	{
		System.out.println("getTableName() called");
		return null;
	}

	@Override
	public boolean nextPage() throws SQLException
	{
		System.out.println("nextPage() called");
		return false;
	}

	@Override
	public void populate(ResultSet arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void populate(ResultSet arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean previousPage() throws SQLException
	{
		System.out.println("previousPage() called");
		return false;
	}

	@Override
	public void release() throws SQLException
	{
		System.out.println("release() called");
	}

	@Override
	public void restoreOriginal() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void rollback() throws SQLException
	{
		System.out.println("rollback() called");
	}

	@Override
	public void rollback(Savepoint arg0) throws SQLException
	{
		System.out.println("rollback(Savepoint arg0) called");
	}

	@Override
	public void rowSetPopulated(RowSetEvent arg0, int arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setKeyColumns(int[] arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setMetaData(RowSetMetaData arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setOriginalRow() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setPageSize(int arg0) throws SQLException
	{
		System.out.println("setPageSize(int arg0) called");
	}

	@Override
	public void setShowDeleted(boolean arg0) throws SQLException
	{
		System.out.println("setShowDeleted(boolean arg0) called");
	}

	@Override
	public void setSyncProvider(String arg0) throws SQLException
	{
		System.out.println("setSyncProvider(String arg0) called");
	}

	@Override
	public void setTableName(String arg0) throws SQLException
	{
		System.out.println("setTableName(String arg0) called");
	}

	@Override
	public int size()
	{
		System.out.println("size() called");
		return 0;
	}

	@Override
	public Collection<?> toCollection() throws SQLException
	{
		System.out.println("Collection<?> toCollection() called");
		return null;
	}

	@Override
	public Collection<?> toCollection(int arg0) throws SQLException
	{
		System.out.println("Collection<?> toCollection(int arg0) called");
		return null;
	}

	@Override
	public Collection<?> toCollection(String arg0) throws SQLException
	{
		System.out.println("Collection<?> toCollection(String arg0) called");
		return null;
	}

	@Override
	public void undoDelete() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void undoInsert() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void undoUpdate() throws SQLException
	{
		System.out.println("undoUpdate() called");
	}

	@Override
	public Connection getConnection() throws SQLException
	{
		System.out.println("getConnection() called");
		theConnection = new stubConnection();
		theConnection.getConnection(this.dsName, userName, passWord);
		return theConnection;
	}

	@Override
	public Connection getConnection(String aUsername, String aPassword) throws SQLException
	{
		System.out.println("getConnection(String aUsername, String aPassword) called");
		this.userName = aUsername;
		this.passWord = aPassword;
		return this.getConnection();
	}


	@Override
	public PooledConnection getPooledConnection() throws SQLException
	{
		System.out.println("getPooledConnection() called");
		if(theConnection == null) theConnection = (stubConnection) this.getConnection();
		return (PooledConnection) theConnection;
	}

	@Override
	public PooledConnection getPooledConnection(String user, String password) throws SQLException
	{
		System.out.println("getPooledConnection(String user, String password) called");
		theConnection=(stubConnection) this.getConnection(user, password);
		return (PooledConnection) theConnection;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException 
	{
		System.out.println("ResultSetMetaData getMetaData() called");
		return null;
	}
	
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <T> T getObject(String columnLabel, Class<T> type)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
