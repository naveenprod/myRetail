package module.common;

import javax.ws.rs.core.CacheControl;

public class CacheInit {
	
	public static CacheControl cacheInit(){
		CacheControl cache = new CacheControl();
		cache.setMaxAge(86400);
		cache.setPrivate(true);
		return cache;
	}

}
