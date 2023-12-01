package commands;

import context.RequestContext;
import context.ResponseContext;
import dao.UserDao;
import database.MySQLOperator;

public class UserDeleteCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();
		
		MySQLOperator.getInstance().beginTransaction();
		
		int user_id = Integer.parseInt(reqc.getParameter("user_id")[0]);
		
		UserDao userDao = new UserDao();
		
		userDao.deleteUser(user_id);
		
		MySQLOperator.getInstance().commit();
		
		resc.setTarget("come/adminuser");
		
		return resc;
	}
}
	