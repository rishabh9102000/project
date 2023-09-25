package com.cg.calc.services;

import com.cg.calc.pojos.User;
import com.cg.calc.pojos.Variables;
import com.cg.calc.repos.Repocalc;

public class CalcServicesImpl implements CalcServices{
	private Repocalc rc;

	@Override
	public boolean createUser(String name,int num1,int num2) {
		User u = new User();
		u.setName(name);
		u.setNum1(num1);
		u.setNum2(num2);
		rc.save(u);
		return true;
	}

	@Override
	public int sum(int id) {
		User user = rc.findById(id).get();
		int a = user.getNum1();
		int b = user.getNum2();
		Variables sum = user.getVariables();
		sum.setA(a+b);
		user.setVariables(sum);
		return a+b;
	}

	@Override
	public int subtract(int id) {
		User user = rc.findById(id).get();
		int a = user.getNum1();
		int b = user.getNum2();
		Variables sum = user.getVariables();
		sum.setA(a-b);
		user.setVariables(sum);
		
		return a-b;
	}

}
