package com.xantrix.webapp.resource.transformer;

public interface ResourceTransfromer<R, M> {

	public default R getResourceByModel(M model) throws Exception {
		return this.transformFrom(model);
	}
	
	public R transformFrom(M model) throws Exception;
}