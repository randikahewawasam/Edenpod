package com.edenpod.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import android.util.Log;


public class SharedMethods {

	public String md5(String s) {
		try {
			// Create MD5 Hash
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(s.getBytes());
			byte messageDigest[] = digest.digest();

			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			for (int i=0; i<messageDigest.length; i++)
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void logMessage(String message) {
		Log.d(Constants.APP_DEBUG_TAG, message);
	}

	public static void logMessage(Class<?> className, String message) {
		Log.d(Constants.APP_DEBUG_TAG, className.getName() + " : " + message);
	}

	public static void logError(String errMessage) {
		if(errMessage != null)
			Log.e(Constants.APP_DEBUG_TAG, errMessage);
	}

	// To use in the catching exceptions
	public synchronized static void logException(Exception exception,
			Class<?> className) {
		if (exception.getMessage() != null) {
			Log.e(Constants.APP_DEBUG_TAG, className.getName() + " : "
					+ exception.getMessage());
		}
	}
}
