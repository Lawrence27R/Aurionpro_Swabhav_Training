package com.aurionpro.set.model;

import java.util.Comparator;

public class ComparatorClassEmployee {
	public static class EmployeeIdComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee employee1, Employee employee2) {
			if (employee1.getEmployeeId() > employee2.getEmployeeId()) {
				return 1;
			}
			if (employee1.getEmployeeId() < employee2.getEmployeeId()) {
				return -1;
			}
			return 0;
		}
		
	}
}
