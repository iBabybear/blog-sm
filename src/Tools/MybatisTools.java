package Tools;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTools {
	public static SqlSession getSqlSession() {
		String resource = "mybatis-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					 new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			return sqlSession;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
