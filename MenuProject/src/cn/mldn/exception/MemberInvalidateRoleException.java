package cn.mldn.exception;
/**
 * 权限或角色问�?
 * @author Quan_er
 *
 */
@SuppressWarnings("serial")
public class MemberInvalidateRoleException extends MemberLoginException {
	public MemberInvalidateRoleException(String msg){
		super(msg);
	}
}
