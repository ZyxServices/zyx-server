package com.live;

import com.zyx.entity.live.LiveInfo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	LiveInfo liveInfo = new LiveInfo();
    	
    	System.out.println(liveInfo.getClass().getSimpleName());
    }
}
