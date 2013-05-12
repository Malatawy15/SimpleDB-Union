package simpledb.remote;

import java.sql.*;
import java.util.concurrent.Executor;

/**
 * An adapter class that wraps RemoteConnection.
 * Its methods do nothing except transform RemoteExceptions
 * into SQLExceptions.
 * @author Edward Sciore
 */
public class SimpleConnection extends ConnectionAdapter {
   private RemoteConnection rconn;
   
   public SimpleConnection(RemoteConnection c) {
      rconn = c;
   }
   
   public Statement createStatement() throws SQLException {
      try {
         RemoteStatement rstmt = rconn.createStatement();
         return new SimpleStatement(rstmt);
      }
      catch(Exception e) {
         throw new SQLException(e);
      }
   }
   
   public void close() throws SQLException {
      try {
         rconn.close();
      }
      catch(Exception e) {
         throw new SQLException(e);
      }
   }

@Override
public void abort(Executor arg0) throws SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public int getNetworkTimeout() throws SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String getSchema() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
	// TODO Auto-generated method stub
	
}

@Override
public void setSchema(String arg0) throws SQLException {
	// TODO Auto-generated method stub
	
}
}

