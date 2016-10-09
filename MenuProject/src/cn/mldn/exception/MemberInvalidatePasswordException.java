package cn.mldn.exception;
/**
 * 密码错误
 * @author Quan_er
 *
 */
@SuppressWarnings("serial")
public class MemberInvalidatePasswordException extends MemberLoginException {
	public MemberInvalidatePasswordException(String msg){
		super(msg);
	}
}
