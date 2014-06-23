package com.weasel.lang;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Dylan
 *
 * @param <T>
 */
public class EsPage<T> extends Page<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1503312445725594692L;
	
	private Map<String, Map<String, Integer>> facets = new HashMap<String, Map<String, Integer>>();
	
	public Map<String, Map<String, Integer>> getFacets() {
		return facets;
	}

	public void setFacets(Map<String, Map<String, Integer>> facets) {
		this.facets = facets;
	}

	/**
	 * 是否有分组结果
	 * @return
	 */
	public boolean hasFacet(){
		return null == facets ? false : facets.size()>0;
	}
}
