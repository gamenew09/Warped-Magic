package com.gamenew09.warpedmagic.lib;

public class UpdateHelper {
	
	public static boolean needToUpdate(){
		return false;
	}
	
	public static String formatUpdateMessage(String version){
		return String.format(Strings.UPDATE_MESSAGE, version);
	}
	
}
