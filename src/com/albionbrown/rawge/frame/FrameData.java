package com.albionbrown.rawge.frame;

import java.util.HashMap;

public final class FrameData {
	
	private static HashMap<String, Object> frameData = new HashMap<String, Object>();
	private static HashMap<String, Object> previousFrameData = new HashMap<String, Object>();
	
//	public static FrameData()
//	{
//		frameData = new HashMap<String, Object>();
//		previousFrameData = new HashMap<String, Object>();
//	}

	public static HashMap<String, Object> getWholeFrameData() {
		return frameData;
	}

	public static HashMap<String, Object> getWholePreviousFrameData() {
		return previousFrameData;
	}
	
	public static Object getFrameData(String id)
	{
		return frameData.get(id);
	}
	
	public static Object getPreviousFrameData(String id)
	{
		return previousFrameData.get(id);
	}
	
	/**
	 * Transfers all data of frameData to 
	 * previousFrameData
	 */
	public static void shift()
	{
		previousFrameData = frameData;
	}
	
	public static void setData(String id, Object data)
	{
		frameData.put(id, data);
	}
}
