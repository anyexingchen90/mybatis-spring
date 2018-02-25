package com.lh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author liuhao
 * @date 2018-01-05 15:32:06
 */
public class Test {

	public static void main(String[] args) {
		//97272795
		//66365069
	

		Long startTime1 = System.nanoTime();
		//		String str = null;
		//		Map map = null;
				List ls1 = new ArrayList();
		//1475010462
		//1572188085
		for(int i=0;i<500000;i++) {
			//			 map = new HashMap();
			//				str = new String(String.valueOf(i));
			Map map1 = new HashMap();
			String	str1 = new String(String.valueOf(i));
			map1.put(String.valueOf(i), String.valueOf(i));
			ls1.add(map1);
		}
		Long endTime1 = System.nanoTime();
		System.out.println("未优化代码前耗时：" + (endTime1 - startTime1)/1000000 + "秒");
		
		
		Long startTime = System.nanoTime();
		String str = null;
		Map map = null;
		List ls = new ArrayList();
		//1475010462
		//1572188085
		for(int i=0;i<500000;i++) {
			map = new HashMap();
			str = new String(String.valueOf(i));
			//			Map map = new HashMap();
			//			String	str = new String(String.valueOf(i));
			map.put(String.valueOf(i), String.valueOf(i));
			ls.add(map);
		}
		Long endTime = System.nanoTime();
		System.out.println("优化代码后耗时：" + (endTime - startTime)/1000000 + "秒");
	}


}
