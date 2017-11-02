import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import bgc.bip.idms.dbstub.stubDataSource;

public class Test_IDMS_Stub
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DataSource ds = getDataSource(args[0]);
		Connection conn = null;
		CallableStatement cstmt = null;

		try
		{
			String storeProcedureSt = "{CALL " + "SCSQL001.SPITR900" + "(?,?)}";
			String requestScreen ="uuuuuuuuuuuuuuuuuuuuuuuuuu";
			String mbiDataTwoIn = "                 ";
			conn = ds.getConnection();
			cstmt = conn.prepareCall(storeProcedureSt);
			// set the input string for CallableStatement
			cstmt.setString(1, requestScreen);
			cstmt.setString(2, mbiDataTwoIn);
			cstmt.execute();
			String idmsResponse = cstmt.getString(1);
			String mbiDataTwoOut = cstmt.getString(2);
			
			System.out.println("idmsResponse = " + idmsResponse);
			System.out.println("mbiDataTwoOut = " + mbiDataTwoOut);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
			
		try
		{
			String storeProcedureSt = "{CALL " + "SCSQL001.SPITR900" + "(?,?)}";
			String requestScreen ="uuuuuuuuuuuuuuuuuuuuuuuuu";
			String mbiDataTwoIn = "ddddddddd";
			conn = ds.getConnection();
			cstmt = conn.prepareCall(storeProcedureSt);
			cstmt.setString(1, requestScreen);
			cstmt.setString(2, mbiDataTwoIn);
			cstmt.execute();
			String idmsResponse = cstmt.getString(1);
			String mbiDataTwoOut = cstmt.getString(2);
			System.out.println("idmsResponse = " + idmsResponse);
			System.out.println("mbiDataTwoOut = " + mbiDataTwoOut);
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}


	}

	private static DataSource getDataSource(String dsName) 
	{
		try
		{
			stubDataSource aSource = new stubDataSource();
			aSource.setDataSourceName(dsName);
			return aSource;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}



}
