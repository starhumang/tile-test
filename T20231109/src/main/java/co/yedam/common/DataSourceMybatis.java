package co.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSourceMybatis {
	private static SqlSessionFactory sqlSessionFactory;
	
	
	private DataSourceMybatis() {}
	
	//getInstance()를 만듦
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		//inputStream : 바이트 단위로 데이터를 읽어오는 추상 클래스
		
		
		try {
			
			inputStream = Resources.getResourceAsStream(resource);
			//resources 파일에서 변수 resource("config/mybatis-config.xml")를 읽어 올 것이다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//inputStream을 sqlSession에 넣어서 연결하는 마지막 단계
		
		return sqlSessionFactory;
	}
	
	
}
