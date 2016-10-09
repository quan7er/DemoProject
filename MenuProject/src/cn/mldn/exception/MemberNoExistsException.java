package cn.mldn.exception;
/**
 * 用户名不存在
 * @author Quan_er
 *
 */
@SuppressWarnings("serial")
public class MemberNoExistsException extends MemberLoginException {
	public MemberNoExistsException(String msg){
		super(msg);
	}
}
