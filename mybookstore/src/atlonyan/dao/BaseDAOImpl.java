package atlonyan.dao;


import atlonyan.util.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAOImpl {
    private QueryRunner queryRunner = new QueryRunner();
    /**
     * 通用的增、删、改的方法
     * @param sql String 要执行的sql
     * @param args Object... 可变参数，作用是给sql中?赋值
     * @return int 影响的记录数
     * @throws SQLException 执行sql过程中发生的异常
     */
    protected int update(String sql, Object... args)throws SQLException {
        return queryRunner.update(JDBCTools.getConnection(),sql,args);
    }

    /**
     * 通用查询多个JavaBean对象的方法
     * @param clazz Class JavaBean对象的类型的Class对象，例如Employee.class,Department.class
     * @param sql String 要执行的select
     * @param args Object... 为sql中的？赋值，如果没有？，可以不传args实参
     * @param <T> JavaBean的类型
     * @return List<T> 里面包含查询出来的多个的T 对象
     * @throws Exception 执行sql过程中发生的异常
     */
    protected <T> List<T> getList(Class<T> clazz, String sql,Object...args)throws Exception{
        return queryRunner.query(JDBCTools.getConnection(),sql,new BeanListHandler<T>(clazz),args);
    }

    /**
     * 通用的查询单个对象的方法
     * @param clazz Class JavaBean对象的类型的Class对象，例如Employee.class,Department.class
     * @param sql String 要执行的select
     * @param args Object... 为sql中的？赋值，如果没有？，可以不传args实参
     * @param <T> JavaBean的类型
     * @return T 一个Javabean对象
     * @throws Exception 执行sql过程中发生的异常
     */
    protected <T> T getBean(Class<T> clazz, String sql,Object...args)throws Exception{
        return queryRunner.query(JDBCTools.getConnection(),sql,new BeanHandler<T>(clazz),args);
        /*
        BeanHandler类的对象作用是把数据库中的表中的一条记录封装为一个JavaBean对象，
        这条记录对应的是T类型的对象，如果创建T类型的对象，是通过clazz对象来完成，
        clazz是T类型的Class对象。
         */
    }

    /**
     * 通用的查询单个值的方法
     * @param sql String 要执行的select
     * @param args Object... 为sql中的？赋值，如果没有？，可以不传args实参
     * @return T 一个Javabean对象
     * @throws Exception 执行sql过程中发生的异常
     */
    protected Object getValue(String sql,Object...args)throws SQLException{
        return queryRunner.query(JDBCTools.getConnection(),sql,new ScalarHandler(),args);
        /*
        ScalarHandler对象的作用是把sql查询结果中的 单个值返回
         */
    }

    protected void batch(String sql,Object[][] args)throws SQLException{
        queryRunner.batch(JDBCTools.getConnection(),sql,args);
    }
}
