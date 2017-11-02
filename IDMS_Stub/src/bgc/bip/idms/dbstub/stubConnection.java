package bgc.bip.idms.dbstub;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;

public class stubConnection implements Connection, PooledConnection, DatabaseMetaData
{
    public static final int CONNECTION_ERROR_EVENT = 1;
    public final int CONNECTION_CLOSED_EVENT = 2;

	List<ConnectionEventListener> theConnectionEventListeners = new ArrayList<ConnectionEventListener>();
	List<StatementEventListener> theStatementEventListener = new ArrayList<StatementEventListener>();

	SQLWarning warnings;
	CallableStatement callableStatement;
	int networkTimeout, transactionIsolation;
	String schema;
	HashMap<String, Class<?>> theMap;
	String userName;
	String password;
	String dbName;
	
	Properties clientInfo;
	
	stubConnection()
	{
		callableStatement = null;
		clientInfo = null;
		transactionIsolation = 8;
	}
	
	Connection getConnection(String dbName, String username, String password) throws SQLException
	{
    	this.userName = username;
    	this.password = password;
    	this.dbName = dbName;
        return this;
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
	public void clearWarnings() throws SQLException
	{
		warnings = null;
	}

	@Override
	public void close() throws SQLException
	{
		if(callableStatement!=null) callableStatement.close();
		callConnectionEventListeners(this.CONNECTION_CLOSED_EVENT, new SQLException("Conenction closed."));
	}

	@Override
	public void commit() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Blob createBlob() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Clob createClob() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public NClob createNClob() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public SQLXML createSQLXML() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Statement createStatement() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean getAutoCommit() throws SQLException
	{
		return false;
	}

	@Override
	public String getCatalog() throws SQLException
	{
		return "the IDMS stub catalog";
	}

	@Override
	public Properties getClientInfo() throws SQLException
	{
		return this.clientInfo;
	}

	@Override
	public String getClientInfo(String name) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public int getHoldability() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException
	{
		return this;
	}

	@Override
	public int getTransactionIsolation() throws SQLException
	{
		return transactionIsolation;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException
	{
		return new HashMap<String, Class<?>>();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public boolean isClosed() throws SQLException
	{
		if(callableStatement !=  null) return true;
		return false;
	}

	@Override
	public boolean isReadOnly() throws SQLException
	{
		return true;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public String nativeSQL(String sql) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException
	{
		System.out.println("stubConnection - CallableStatement prepareCall(String sql) called");
		callableStatement = new stubCallableStatement(sql, this.dbName);
		return callableStatement;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException
	{
		System.out.println("stubConnection - CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) called");
		callableStatement = new stubCallableStatement(sql, this.dbName);
		return callableStatement;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
	{
		System.out.println("stubConnection - CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException
	{
		System.out.println("stubConnection - PreparedStatement prepareStatement(String sql) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException
	{
		System.out.println("stubConnection - PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException
	{
		System.out.println("stubConnection - PreparedStatement prepareStatement(String sql, int[] columnIndexes) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException
	{
		System.out.println("stubConnection - PreparedStatement prepareStatement(String sql, String[] columnNames) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void rollback() throws SQLException
	{
		System.out.println("stubConnection - void rollback() called");
		if(this.callableStatement != null)
		{
			this.callableStatement.close();
			this.callableStatement = null;
		}
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException
	{
		System.out.println("stubConnection - void rollback(Savepoint savepoint) called");
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException
	{
		System.out.println("stubConnection - void setAutoCommit(boolean autoCommit) called");
	}

	@Override
	public void setCatalog(String catalog) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException
	{
		System.out.println("void setClientInfo(Properties properties) called");
		this.clientInfo = properties;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException
	{
		System.out.println("void setClientInfo(String name, String value) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setHoldability(int holdability) throws SQLException
	{
		System.out.println("void setHoldability(int holdability) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException
	{
		System.out.println("void setReadOnly(boolean readOnly) called");
		throw (new UnsupportedOperationException());
	}

	@Override
	public Savepoint setSavepoint() throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException
	{
		throw (new UnsupportedOperationException());
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException
	{
		System.out.println("stubConnection - setTransactionIsolation(int level) called");
		transactionIsolation = level;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException
	{
		System.out.println("stubConnection - void setTypeMap(Map<String, Class<?>> map) called");
		theMap = (HashMap<String, Class<?>>) map;
	}

	@Override
	public void addConnectionEventListener(ConnectionEventListener listener) 
	{
		System.out.println("stubConnection - void addConnectionEventListener(ConnectionEventListener listener) called");
		theConnectionEventListeners.add(listener);
	}

	@Override
	public void removeConnectionEventListener(ConnectionEventListener listener) 
	{
		System.out.println("stubConnection - void removeConnectionEventListener(ConnectionEventListener listener) called");
		int idx=theConnectionEventListeners.indexOf(listener);
		if(idx<0) return;
		theConnectionEventListeners.remove(idx);
	}

	@Override
	public void addStatementEventListener(StatementEventListener listener) 
	{
		System.out.println("stubConnection - void addStatementEventListener(StatementEventListener listener) called");
		theStatementEventListener.add(listener);
	}

	@Override
	public void removeStatementEventListener(StatementEventListener listener) 
	{
		System.out.println("stubConnection - void removeStatementEventListener(StatementEventListener listener) called");
		int idx=theStatementEventListener.indexOf(listener);
		if(idx<0) return;
		theStatementEventListener.remove(idx);
	}

	 protected synchronized void callConnectionEventListeners(int eventType, SQLException sqlException) 
	 {
		System.out.println("stubConnection - synchronized void callConnectionEventListeners(int eventType, SQLException sqlException) called");
		 if (this.theConnectionEventListeners == null) 
		 {
            return;
		 }
		 Iterator<ConnectionEventListener> iterator = theConnectionEventListeners.iterator();
		 ConnectionEvent connectionevent = new ConnectionEvent(this, sqlException);
		 while (iterator.hasNext()) 
		 {
			 ConnectionEventListener connectioneventlistener = iterator.next();
			 if (eventType == CONNECTION_CLOSED_EVENT) 
			 {
				 connectioneventlistener.connectionClosed(connectionevent);
			 }
			 else if (eventType == CONNECTION_ERROR_EVENT) 
			 {
				 connectioneventlistener.connectionErrorOccurred(connectionevent);
			 }
	        }
	    }

	@Override
	public Connection getConnection() throws SQLException
	{
		System.out.println("stubConnection - Connection getConnection() called");
		return this;
	}

	@Override
	public boolean allProceduresAreCallable() throws SQLException
	{
		System.out.println("stubConnection - boolean allProceduresAreCallable() called");
		return false;
	}

	@Override
	public boolean allTablesAreSelectable() throws SQLException
	{
		System.out.println("stubConnection - boolean allTablesAreSelectable() called");
		return false;
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() throws SQLException
	{
		System.out.println("stubConnection - boolean autoCommitFailureClosesAllResultSets() called");
		return false;
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() throws SQLException
	{
		System.out.println("stubConnection - boolean dataDefinitionCausesTransactionCommit() called");
		return false;
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() throws SQLException
	{
		System.out.println("stubConnection - boolean dataDefinitionIgnoredInTransactions() called");
		return false;
	}

	@Override
	public boolean deletesAreDetected(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) throws SQLException
	{
		System.out.println("stubConnection - ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) called");
		return null;
	}

	@Override
	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatalogSeparator() throws SQLException
	{
		System.out.println("stubConnection - String getCatalogSeparator() called");
		return null;
	}

	@Override
	public String getCatalogTerm() throws SQLException
	{
		System.out.println("stubConnection - String getCatalogTerm() called");
		return null;
	}

	@Override
	public ResultSet getCatalogs() throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getCatalogs() called");
		return null;
	}

	@Override
	public ResultSet getClientInfoProperties() throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getClientInfoProperties() called");
		return null;
	}

	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) called");
		return null;
	}

	@Override
	public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) called");
		return null;
	}

	@Override
	public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema,
			String foreignTable) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable) called");
		return null;
	}

	@Override
	public int getDatabaseMajorVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getDatabaseMinorVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDatabaseProductName() throws SQLException
	{
		return "IDMSstub";
	}

	@Override
	public String getDatabaseProductVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public int getDefaultTransactionIsolation() throws SQLException
	{
		System.out.println("stubConnection -  int getDefaultTransactionIsolation() called");
		return this.transactionIsolation;
	}

	@Override
	public int getDriverMajorVersion()
	{
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getDriverMinorVersion()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDriverName() throws SQLException
	{
		return "bgc.bip.idms.dbstub";
	}

	@Override
	public String getDriverVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getExportedKeys(String catalog, String schema, String table) called");
		return null;
	}

	@Override
	public String getExtraNameCharacters() throws SQLException
	{
		System.out.println("stubConnection -  String getExtraNameCharacters() called");
		return null;
	}

	@Override
	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) called");
		return null;
	}

	@Override
	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) called");
		return null;
	}

	@Override
	public String getIdentifierQuoteString() throws SQLException
	{
		System.out.println("stubConnection -  String getIdentifierQuoteString() called");
		return null;
	}

	@Override
	public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getImportedKeys(String catalog, String schema, String table) called");
		return null;
	}

	@Override
	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getJDBCMajorVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getJDBCMinorVersion() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxBinaryLiteralLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCatalogNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCharLiteralLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInGroupBy() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInIndex() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInOrderBy() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInSelect() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxColumnsInTable() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxConnections() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCursorNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxIndexLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxProcedureNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxRowSize() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxSchemaNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxStatementLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxStatements() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTableNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxTablesInSelect() throws SQLException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxUserNameLength() throws SQLException
	{
		// TODO Auto-generated method stub
		return 256;
	}

	@Override
	public String getNumericFunctions() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProcedureTerm() throws SQLException
	{
		System.out.println("stubConnection -  String getProcedureTerm() called");
		return null;
	}

	@Override
	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) called");
		return null;
	}

	@Override
	public int getResultSetHoldability() throws SQLException
	{
		System.out.println("stubConnection -  int getResultSetHoldability() called");
		return 0;
	}

	@Override
	public RowIdLifetime getRowIdLifetime() throws SQLException
	{
		System.out.println("stubConnection -  RowIdLifetime getRowIdLifetime() called");
		return null;
	}

	@Override
	public String getSQLKeywords() throws SQLException
	{
		System.out.println("stubConnection -  String getSQLKeywords() called");
		return null;
	}

	@Override
	public int getSQLStateType() throws SQLException
	{
		System.out.println("stubConnection -  String getSQLKeywords() called");
		return 0;
	}

	@Override
	public String getSchemaTerm() throws SQLException
	{
		System.out.println("stubConnection -  String getSchemaTerm() called");
		return null;
	}

	@Override
	public ResultSet getSchemas() throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getSchemas() called");
		return null;
	}

	@Override
	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException
	{
		System.out.println("stubConnection -  ResultSet getSchemas(String catalog, String schemaPattern) called");
		return null;
	}

	@Override
	public String getSearchStringEscape() throws SQLException
	{
		System.out.println("stubConnection -  String getSearchStringEscape() called");
		return null;
	}

	@Override
	public String getStringFunctions() throws SQLException
	{
		System.out.println("stubConnection -  String getStringFunctions() called");
		return null;
	}

	@Override
	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSystemFunctions() throws SQLException
	{
		System.out.println("stubConnection - String getSystemFunctions() called");
		return null;
	}

	@Override
	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getTableTypes() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTimeDateFunctions() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getTypeInfo() throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() throws SQLException
	{
		System.out.println("stubConnection - String getURL() called");
		return null;
	}

	@Override
	public String getUserName() throws SQLException
	{
		System.out.println("stubConnection - String getUserName() called");
		return this.userName;
	}

	@Override
	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException
	{
		System.out.println("stubConnection - ResultSet getVersionColumns(String catalog, String schema, String table) called");
		return null;
	}

	@Override
	public boolean insertsAreDetected(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCatalogAtStart() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean locatorsUpdateCopy() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nullPlusNonNullIsNull() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nullsAreSortedAtEnd() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nullsAreSortedAtStart() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nullsAreSortedHigh() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean nullsAreSortedLow() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersDeletesAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersInsertsAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownDeletesAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownInsertsAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesLowerCaseIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesMixedCaseIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesUpperCaseIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsANSI92FullSQL() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsBatchUpdates() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsColumnAliasing() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsConvert() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsConvert(int fromType, int toType) throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCoreSQLGrammar() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsCorrelatedSubqueries() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsExpressionsInOrderBy() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsExtendedSQLGrammar() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsFullOuterJoins() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGetGeneratedKeys() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupBy() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupByBeyondSelect() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsGroupByUnrelated() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsLikeEscapeClause() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsLimitedOuterJoins() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMinimumSQLGrammar() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMultipleOpenResults() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMultipleResultSets() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsMultipleTransactions() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsNamedParameters() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsNonNullableColumns() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOrderByUnrelated() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsOuterJoins() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsOuterJoins() called");
		return false;
	}

	@Override
	public boolean supportsPositionedDelete() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsPositionedDelete() called");
		return false;
	}

	@Override
	public boolean supportsPositionedUpdate() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsPositionedUpdate() called");
		return false;
	}

	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException
	{
		System.out.println("stubConnection - boolean supportsResultSetConcurrency(int type, int concurrency) called");
		return false;
	}

	@Override
	public boolean supportsResultSetHoldability(int holdability) throws SQLException
	{
		System.out.println("stubConnection - boolean supportsResultSetHoldability(int holdability) called");
		return false;
	}

	@Override
	public boolean supportsResultSetType(int type) throws SQLException
	{
		System.out.println("stubConnection - boolean supportsResultSetType(int type) called");
		return false;
	}

	@Override
	public boolean supportsSavepoints() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSavepoints() called");
		return false;
	}

	@Override
	public boolean supportsSchemasInDataManipulation() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSchemasInDataManipulation() called");
		return false;
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSchemasInIndexDefinitions() called");
		return false;
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSchemasInPrivilegeDefinitions() called");
		return false;
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSchemasInProcedureCalls() called");
		return false;
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSchemasInTableDefinitions() called");
		return false;
	}

	@Override
	public boolean supportsSelectForUpdate() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSelectForUpdate() called");
		return false;
	}

	@Override
	public boolean supportsStatementPooling() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsStatementPooling() called");
		return false;
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsStoredFunctionsUsingCallSyntax() called");
		return false;
	}

	@Override
	public boolean supportsStoredProcedures() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsStoredProcedures() called");
		return true;
	}

	@Override
	public boolean supportsSubqueriesInComparisons() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSubqueriesInComparisons() called");
		return false;
	}

	@Override
	public boolean supportsSubqueriesInExists() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSubqueriesInExists() called");
		return false;
	}

	@Override
	public boolean supportsSubqueriesInIns() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSubqueriesInIns() called");
		return false;
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsSubqueriesInQuantifieds() called");
		return false;
	}

	@Override
	public boolean supportsTableCorrelationNames() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsTableCorrelationNames() called");
		return false;
	}

	@Override
	public boolean supportsTransactionIsolationLevel(int level) throws SQLException
	{
		System.out.println("stubConnection - boolean supportsTransactionIsolationLevel(int level) called");
		return true;
	}

	@Override
	public boolean supportsTransactions() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsTransactions() called");
		return false;
	}

	@Override
	public boolean supportsUnion() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsUnion() called");
		return false;
	}

	@Override
	public boolean supportsUnionAll() throws SQLException
	{
		System.out.println("stubConnection - boolean supportsUnionAll() called");
		return false;
	}

	@Override
	public boolean updatesAreDetected(int type) throws SQLException
	{
		System.out.println("stubConnection - boolean updatesAreDetected(int type) called");
		return false;
	}

	@Override
	public boolean usesLocalFilePerTable() throws SQLException
	{
		System.out.println("stubConnection - boolean usesLocalFilePerTable() called");
		return false;
	}

	@Override
	public boolean usesLocalFiles() throws SQLException
	{
		System.out.println("stubConnection - boolean usesLocalFiles() called");
		return false;
	}

	@Override
	public void setSchema(String schema) throws SQLException
	{
		this.schema=schema;		
	}

	@Override
	public String getSchema() throws SQLException 
	{
		return this.schema;
	}

	@Override
	public void abort(Executor executor) throws SQLException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds)
			throws SQLException {
		networkTimeout = milliseconds;
		
	}

	@Override
	public int getNetworkTimeout() throws SQLException 
	{
		return networkTimeout;
	}

	@Override
	public ResultSet getPseudoColumns(String catalog, String schemaPattern,
			String tableNamePattern, String columnNamePattern)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
