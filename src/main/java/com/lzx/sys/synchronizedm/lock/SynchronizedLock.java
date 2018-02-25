package com.lzx.sys.synchronizedm.lock;

/**
 * 
 * <p>Title: 锁对象</p>
 * <p>Description: 单列对象 </p>
 * <p>Company: lzx</p> 
 * @author lzx
 * @date 2018年2月25日下午3:11:14
 */
public class SynchronizedLock {
	
	private static SynchronizedLock synchronizedLock;
		
	private SynchronizedLock() {
	}

	public SynchronizedLock getLock(){
		if(synchronizedLock == null){
			synchronizedLock = new SynchronizedLock();
		}
		return synchronizedLock;
		
	}
	
}
