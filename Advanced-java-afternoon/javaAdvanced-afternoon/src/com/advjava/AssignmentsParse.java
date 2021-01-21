package com.advjava;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="assignments")
@XmlAccessorType(XmlAccessType.FIELD)
public class AssignmentsParse {
	

@XmlElement(name="assignment")
List<AssignmentParse> assignment = new ArrayList<AssignmentParse>();

	
	public List<AssignmentParse> getAssignment() {
		return assignment;
	}
	
	public void setAssignment(List<AssignmentParse> assignment) {
		this.assignment = assignment;
	}


	@Override
	public String toString() {
		return "Assignments [assignments=" + assignment + "]";
	}


}
