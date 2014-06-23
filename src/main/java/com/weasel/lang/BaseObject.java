/**
 * BaseObject.java
 */
package com.weasel.lang;

import java.io.Serializable;

import com.weasel.lang.annotation.Id;

/**
 * @author Dylan
 * @time 2013-4-17
 */
public abstract class BaseObject<ID extends Object> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	

}
