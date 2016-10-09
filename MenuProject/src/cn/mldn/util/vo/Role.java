package cn.mldn.util.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Role implements Serializable {
	
	private Integer rid;
	private String title;
	private String flag;
	private List<Member> members;
	private List<Action> actions;

	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
