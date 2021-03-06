package cn.gyw.glearn.design.behaviour.chainofresponsibility;

/**
 * 请假请求
 * 实现Request 接口
 * Created by guanyw on 2018/7/10.
 */
public class LeaveRequest implements Request {

	private String empName;//请假人
	private int leaveDays;//请假天数
	private String reason;//请假理由

	public LeaveRequest(String empName, int leaveDays, String reason) {
		super();
		this.empName = empName;
		this.leaveDays = leaveDays;
		this.reason = reason;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
