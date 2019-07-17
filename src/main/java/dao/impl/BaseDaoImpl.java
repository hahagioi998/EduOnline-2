package dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.inter.IBaseDao;
import util.StringCode;

/**
 * IBaseDao的实现，使用反射技术
 * @author SongPengJie
 * @param <T>
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {

	/**
	 * 获取到jdbcTemplate对象
	 */
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jt;
	
	protected String sql = null;
	
	@SuppressWarnings("rawtypes")
	private Class clazz = null;
	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		String tClassName = types[0].toString().substring(6);
		try {
			clazz = Class.forName(tClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得表名
	 * @param className
	 * @return
	 */
	private String getTableName(String className) {
		StringBuilder sb = new StringBuilder();
		char[] chars = className.toCharArray();
		for(char c : chars) {
			if(c >= 'A' && c<='Z') {
				sb.append("_"+(c+"").toLowerCase());
			}else {
				sb.append(c);
			}
		}
		return "t"+sb;
	}
	
	/**
	 * 获得表字段名
	 * @param fieldName
	 * @return
	 */
	private String getFieldName(String fieldName) {
		StringBuilder sb = new StringBuilder();
		char[] chars = fieldName.toCharArray();
		for(char c : chars) {
			if(c >= 'A' && c <= 'Z') {
				sb.append("_"+ (c+"").toLowerCase());
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取表字段列表
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getFieldsName(Class clazz) {
		StringBuilder sb = new StringBuilder();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			String fieldName = field.getName();
			if("id".equals(fieldName)) {
				continue;
			}
			fieldName = getFieldName(fieldName);
			sb.append(","+fieldName);
		}
		return sb.toString().substring(1);
	}
	
	/**
	 * 获取表字段值的列表
	 * @param clazz
	 * @param t
	 * @return
	 */
	private String getFieldsValue(Class<?> clazz,T t) {
		StringBuilder sb = new StringBuilder();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			String fieldName = field.getName();
			if("id".equals(fieldName)) {
				continue;
			}
			String getMethodName = "get"+(fieldName.charAt(0)+"").toUpperCase()+fieldName.substring(1);
			try {
				Method method = clazz.getDeclaredMethod(getMethodName, new Class[] {});
				Object value = method.invoke(t, new Object[] {});
				if(value == null) {
					sb.append(", 'null'");
				}
				if("String".equals(value.getClass().getSimpleName())) {
					value = StringCode.transformCode(value.toString());
					System.out.println(value);
					sb.append(", '"+value+"' ");
				}else {
					sb.append(", "+value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString().substring(1);
	}
	
	/**
	 * 获得表的字段名和值
	 * @param clazz
	 * @param t
	 * @return
	 */
	private String getFieldNameAndValue(Class<?> clazz, T t) {
		StringBuilder sb = new StringBuilder();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			String fieldName = field.getName();
			if("id".equals(fieldName)) {
				continue;
			}
			String getMethodName = "get"+(fieldName.charAt(0)+"").toUpperCase()+fieldName.substring(1);
			try {
				Method method = clazz.getDeclaredMethod(getMethodName, new Class[] {});
				Object value = method.invoke(t, new Object[] {});
				fieldName = getFieldName(fieldName);
				if("String".equals(fieldName.getClass().getSimpleName())) {
					sb.append(", "+fieldName+" = '"+value+"'");
					value = StringCode.transformCode(value.toString());
				}else {
					sb.append(", "+fieldName+" = "+value);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sb.substring(1);
	}
	
	private String getWhereValue(Class<?> clazz, T t) {
		StringBuilder sb = new StringBuilder();
		try {
			Method method = clazz.getDeclaredMethod("getId", new Class[] {});
			Object value = method.invoke(t, new Object[] {});
			if("String".equals(method.getClass().getSimpleName())) {
				sb.append("'"+value+"'");
				value = StringCode.transformCode(value.toString());
			}else {
				sb.append(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	@Override
	public void insert(T t) {
		Class<?> clazz = t.getClass();
		String className = clazz.getSimpleName();
		String tableName = getTableName(className);
		String fieldsName = getFieldsName(clazz);
		String fieldsValue = getFieldsValue(clazz, t);
		sql = "insert into "+tableName+" ("+fieldsName+") values("+fieldsValue+")";
		jt.execute(sql);
	}

	@Override
	public void update(T t) {
		Class<?> clazz = t.getClass();
		String className = clazz.getSimpleName();
		String tableName = getTableName(className);
		String fieldNameAndValue = getFieldNameAndValue(clazz, t);
		String whereValue = getWhereValue(clazz, t);
		sql = "update " + tableName + " set "+ fieldNameAndValue +" where id = "+whereValue;
		jt.execute(sql);
	}

	@Override
	public void delete(int id) {
		String className = clazz.getSimpleName();
		String tableName = getTableName(className);
		sql = "delete from " + tableName + " where id = " + id;
		jt.execute(sql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		T t = null;
		try {
			t = (T)clazz.newInstance();
			String className = clazz.getSimpleName();
			String tableName = getTableName(className);
			sql = "select * from " + tableName + " where id = ?";
			t = jt.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<T>(clazz));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		String tableName = getTableName(clazz.getSimpleName());
		sql = "select * from " + tableName;
		return jt.query(sql, new BeanPropertyRowMapper<T>(clazz));
	}

}
