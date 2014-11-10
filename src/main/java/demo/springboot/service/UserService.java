package demo.springboot.service;

import java.util.concurrent.Future;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import demo.springboot.domain.User;
import demo.springboot.mapper.UserMapper;

@Service
public class UserService {

	//	private static Logger log = LoggerFactory.getLogger(StudyService.class);

	@Autowired
	private UserMapper userMapper;


	@Async
	public Future<Void> execute() {
		return new AsyncResult<Void>(null);
	}


	@Async
	public Future<User> findOne( String id ) {
		return new AsyncResult<User>(userMapper.findById(id));
	}


	@Async
	public Future<Void> addUser( String name ) {
		userMapper.insert(StringUtils.defaultString(name, "testname"), 10);
		return new AsyncResult<Void>(null);
	}

}
