/**
 * Aug 29, 2012
 */
package org.zlex.redis.dao;

import org.zlex.redis.domain.User;

public interface UserDao {

    /**
     *
     * @param user
     */
    void save(User user);

	/**
	 * @param uid
	 * @return
	 */
	User read(String uid);

	/**
	 * @param uid
	 */
	void delete(String uid);
}
