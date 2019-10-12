package com.centaline.pojo;

import java.util.List;

/**
 * Created by zhangpan on 2019/10/11.
 */
public class QueryVO {
	private User user;

	private List<Integer> ids;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
