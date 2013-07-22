package com.edenpod.managers;

import javax.xml.parsers.ParserConfigurationException;

import com.edenpod.common.Constants;
import com.gmail.yuyang226.flickr.Flickr;
import com.gmail.yuyang226.flickr.REST;


public class FlickrManager {
	private static FlickrManager instance = null;

	public static FlickrManager getSharedInstance() {
		if (instance == null) {
			instance = new FlickrManager();
		}
		return instance;
	}
	
	public Flickr getFlickr() {
		try {
			Flickr f = new Flickr(Constants.FLICKR_KEY, Constants.FLICKR_SECRET, new REST());
			return f;
		} catch (ParserConfigurationException e) {
			return null;
		}
	}

}
