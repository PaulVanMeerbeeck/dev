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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.DataSource;
import javax.sql.PooledConnection;
import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.RowSetMetaData;
import javax.sql.StatementEventListener;
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

	public stubDataSource()
	{
		return;
	}
	
	public void setdsName(String value)
	{
		dsName = value;
	}

	public String getdsName()
	{
		return dsName;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException
	{
		throw (new UnsupportedOperationException());
//		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException
	{
		throw (new UnsupportedOperationException());
//		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException
	{
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException
	{
//		throw (new UnsupportedOperationException());
		return null;
	}

	@Override
	public void addRowSetListener(RowSetListener arg0)
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void clearParameters() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void execute() throws SQLException
	{
		// TODO Auto-generated method stub
	}

	@Override
	public String getCommand()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDataSourceName()
	{
		return dsName;
	}

	@Override
	public boolean getEscapeProcessing() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getMaxFieldSize() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getMaxRows() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getPassword()
	{
		return this.passWord;
	}

	@Override
	public int getQueryTimeout() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getTransactionIsolation()
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getUrl() throws SQLException
	{
		return this.url;
	}

	@Override
	public String getUsername()
	{
		return this.userName;
	}

	@Override
	public boolean isReadOnly()
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void removeRowSetListener(RowSetListener arg0)
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setArray(int arg0, Array arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setAsciiStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setAsciiStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBigDecimal(int arg0, BigDecimal arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBigDecimal(String arg0, BigDecimal arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBinaryStream(int arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBinaryStream(String arg0, InputStream arg1, int arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBlob(int arg0, Blob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBlob(int arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBlob(String arg0, Blob arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBlob(String arg0, InputStream arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setBlob(int arg0, InputStream arg1, long arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		this.command = arg0;
	}

	@Override
	public void setConcurrency(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setDataSourceName(String arg0) throws SQLException
	{
		this.dsName = arg0;
	}

	@Override
	public void setDate(int arg0, Date arg1) throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setString(int arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setString(String arg0, String arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTime(int arg0, Time arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTime(String arg0, Time arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTime(int arg0, Time arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTime(String arg0, Time arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTimestamp(int arg0, Timestamp arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTimestamp(String arg0, Timestamp arg1, Calendar arg2) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTransactionIsolation(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setType(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setURL(int arg0, URL arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setUrl(String arg0) throws SQLException
	{
		this.url = arg0;
	}

	@Override
	public void setUsername(String arg0) throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void close() throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getBinaryStream(String arg0) throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getCursorName() throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(int arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Time getTime(String arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(int arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Timestamp getTimestamp(String arg0, Calendar arg1) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getType() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public URL getURL(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public URL getURL(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getUnicodeStream(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public InputStream getUnicodeStream(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public SQLWarning getWarnings() throws SQLException
	{
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setFetchSize(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void execute(Connection arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public SyncProvider getSyncProvider() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String getTableName() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean nextPage() throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void release() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void restoreOriginal() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void rollback() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void rollback(Savepoint arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setShowDeleted(boolean arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setSyncProvider(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTableName(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int size()
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Collection<?> toCollection() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Collection<?> toCollection(int arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Collection<?> toCollection(String arg0) throws SQLException
	{
		throw (new UnsupportedOperationException());
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
		throw (new UnsupportedOperationException());
	}

	@Override
	public Connection getConnection() throws SQLException
	{
		theConnection = new stubConnection();
		theConnection.getConnection(this.dsName, userName, passWord);
		return theConnection;
	}

	@Override
	public Connection getConnection(String aUsername, String aPassword) throws SQLException
	{
		this.userName = aUsername;
		this.passWord = aPassword;
		return this.getConnection();
	}


	@Override
	public PooledConnection getPooledConnection() throws SQLException
	{
		if(theConnection == null) theConnection = (stubConnection) this.getConnection();
		return (PooledConnection) theConnection;
	}

	@Override
	public PooledConnection getPooledConnection(String user, String password) throws SQLException
	{
		theConnection=(stubConnection) this.getConnection(user, password);
		return (PooledConnection) theConnection;
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
