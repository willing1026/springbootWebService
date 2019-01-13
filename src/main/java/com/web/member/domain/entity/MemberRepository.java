package com.web.member.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//  @Modifying 사용해야하는 이유
//	Whenever you are trying to modify a record in db, 
//	you have to mark it @Transactional as well as @Modifying, 
//	which instruct Spring that it can modify existing records.
//	The repository method must be void or the exception keeps getting thrown.
//  https://stackoverflow.com/questions/43665090/why-do-we-have-to-use-modifying-annotation-for-queries-in-data-jpa
	
//  transactional을 Repository에 쓰면 안되는 이유,,	
//	@Transactional annotation in Repository is bad practice, 
//	better to use it in your Service. 
//	Cause one business action (marked as transaction) may consist of multiple requests to DB. even by several DAO. More here stackoverflow.com/questions/1079114/… – Dan Brandt Sep 11 '18 at 13:00 
	
//	방법2
//	@Modifying
//	@Query("delete from Member m where m.userId = :userId")
//	void deleteByUserId(@Param("userId") String userId);

//	방법1
	void deleteByUserId(String userId);
	
	boolean existsByUserId(String userId);
	
	Member findOneByUserId(String userId);
}
