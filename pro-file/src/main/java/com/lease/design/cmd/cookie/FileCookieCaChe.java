package com.lease.design.cmd.cookie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by HP on 2018/5/26.
 */
public class FileCookieCaChe {

	private static final Map<String, String> fileMap = new ConcurrentHashMap<>();

	public static void put(String ip, String path) {
		fileMap.put(ip, path);
	}

	public static String get(String ip) {
		return fileMap.get(ip);
	}

	public static void remove(String ip) {
		fileMap.remove(ip);
	}

}
