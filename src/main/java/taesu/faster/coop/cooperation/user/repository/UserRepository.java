package taesu.faster.coop.cooperation.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taesu.faster.coop.cooperation.user.model.User;

/**
 * @author Lee Tae Su
 * @version 1.0
 * @project cooperation
 * @since 2018-01-22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(String userId);
	
	User findByUserIdAndPassword(String userId, String password);
	
}
