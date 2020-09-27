package cn.uu710.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
	1. 声明静态数据源成员变量
	2. 创建连接池对象
	3. 定义公有的得到数据源的方法
	4. 定义得到连接对象的方法
	5. 定义关闭资源的方法
 */
public class JDBCUtils {
	// 1.	声明静态数据源成员变量
	private static DataSource ds;
	private static ThreadLocal<Connection> tl=new ThreadLocal<>();
	private static PlatformTransactionManager ptm;

	// 2. 创建连接池对象
	static {
		// 加载配置文件中的数据
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pp = new Properties();
		try {
			pp.load(is);
			// 创建连接池，使用配置文件中的参数
			ds = DruidDataSourceFactory.createDataSource(pp);

			ptm = new DataSourceTransactionManager(ds);
		} catch (Exception e) {}
	}

	// 3. 定义公有的得到数据源的方法
	public static DataSource getDataSource() {
		return ds;
	}

	// 4. 定义得到连接对象的方法
	public static Connection getConnection() throws SQLException {
		//从线程中获取conneciton
		Connection conn = tl.get();
		if(conn==null){
			conn=ds.getConnection();
			//和当前线程绑定
			tl.set(conn);
		}
		return conn;
	}

	// 释放 connection
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//和线程解绑
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	//开启事务
	public static TransactionStatus startTransaction() throws SQLException{
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = ptm.getTransaction(def);
		return status;
	}

	public static void commit(TransactionStatus status) {
		if ( status != null) {
			ptm.commit(status);
		}
	}

	public static void rollback(TransactionStatus status) {
		if( status != null) {
			ptm.rollback(status);
		}
	}
}
