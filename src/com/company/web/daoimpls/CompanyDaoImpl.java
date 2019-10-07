package com.company.web.daoimpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.web.daos.CompanyDao;
import com.company.web.domains.CompanyBean;
import com.company.web.factories.DatabaseFactory;
import com.company.web.pool.Constants;

public class CompanyDaoImpl implements CompanyDao{
private static CompanyDaoImpl instance = new CompanyDaoImpl();
	
	public static CompanyDaoImpl getInstance() {return instance;}
	
	private CompanyDaoImpl() {}
	
	@Override
	public boolean insertEmp(CompanyBean param) {
		boolean flag = false;
		String sql = "INSERT INTO EMP(EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , DEPTNO)\r\n" + 
				"VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			stmt.setString(1, param.getEmpno());
			stmt.setString(2, param.getEname());
			stmt.setString(3, param.getJob());
			stmt.setString(4, param.getMgr());
			stmt.setString(5, param.getHireDate());
			stmt.setString(6, param.getSal());
			stmt.setString(7, param.getComm());
			stmt.setString(8, param.getDeptno());
			int rs = stmt.executeUpdate();
			flag = (rs==1)? true : false;
			System.out.println("다오임플1"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("다오임플2"+flag);
		return flag;
	}

	@Override
	public CompanyBean selectByEmpnoEname(CompanyBean param) {
		CompanyBean emp = new CompanyBean();
		String sql = "SELECT EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM, DNAME \r\n" + 
				" FROM EMP E JOIN DEPT D\r\n" + 
				"    ON E.DEPTNO LIKE D.DEPTNO\r\n" + 
				" WHERE E.DEPTNO LIKE (SELECT DEPTNO\r\n" + 
				"                    FROM DEPT\r\n" + 
				"                    WHERE DNAME LIKE ?)\r\n" + 
				"    AND EMPNO LIKE ?\r\n" + 
				"        AND ENAME LIKE ?";
		
		try {
			PreparedStatement stmt = DatabaseFactory.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			System.out.println("sql: "+sql);
			stmt.setString(1, param.getDname());
			stmt.setString(2, param.getEmpno());
			stmt.setString(3, param.getEname());
			ResultSet rs = stmt.executeQuery();
			System.out.println("DB도착");
			while(rs.next()) {
				emp.setEmpno(rs.getString(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getString(4));
				emp.setHireDate(rs.getString(5));
				emp.setSal(rs.getString(6));
				emp.setComm(rs.getString(7));
				emp.setDname(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("db값 : "+emp.toString());
		return emp;
	}

	@Override
	public List<CompanyBean> findByTable(CompanyBean param) {
		List<CompanyBean> tables = new ArrayList<CompanyBean>();
		String sql = " SELECT DNAME , LOC , DEPTNO\r\n" + 
							" FROM DEPT ";
		
		try {
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CompanyBean emp = new CompanyBean();
				emp.setDname(rs.getString(1));
				emp.setLoc(rs.getString(2));
				emp.setDeptno(rs.getString(3));
				tables.add(emp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tables;
	}

}
