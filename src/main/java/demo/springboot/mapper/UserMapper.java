package demo.springboot.mapper;

import org.apache.ibatis.annotations.Param;

import demo.springboot.domain.User;

public interface UserMapper {

	//@Select("select `id`, `name`, `age` from `user` where `id` = #{id}")
	User findById( @Param("id") String id );


	//@Insert("insert into user(`name`, `age`) values(#{name}, #{age})")
	void insert( @Param("name") String name, @Param("age") int age );
}
