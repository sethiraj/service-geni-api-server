/**
 * This Class could be used for Application Logging Purpose.
 */
package com.mahelinc.servicegenie.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class AppLogger.
 *
 * @author surendrane
 */
public class AppLogger {

	/** The Constant COLON. */
	private static final Object COLON = null;

	/** The Constant DASH. */
	private static final Object DASH = null;

	/** The app logger. */
	private static AppLogger appLogger = null;

	/** The logger. */
	private static Logger logger = null;

	/** The stack trace level. */
	private static int stackTraceLevel = 4;

	/**
	 * Instantiates a new application logger.
	 */
	private AppLogger() {
		logger = LoggerFactory.getLogger(AppLogger.class);
	}

	/**
	 * Gets the single instance of ApplicationLogger.
	 *
	 * @return single instance of ApplicationLogger
	 */
	public static AppLogger getInstance() {
		if (appLogger == null) {
			synchronized (AppLogger.class) {
				if (appLogger == null) {
					appLogger = new AppLogger();
				}
			}
		}
		return appLogger;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	private String getClassName() {
		String className = StringUtils.EMPTY;
		try {
			className = Thread.currentThread().getStackTrace()[stackTraceLevel].getClassName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return className;
	}

	/**
	 * Gets the method name.
	 *
	 * @return the method name
	 */
	private String getMethodName() {
		String methodName = StringUtils.EMPTY;
		try {
			methodName = Thread.currentThread().getStackTrace()[stackTraceLevel].getMethodName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return methodName;
	}

	/**
	 * Gets the base message.
	 *
	 * @param message the message
	 * @return the base message
	 */
	private String getBaseMessage(String message) {
		String logMsg = new StringBuilder(getClassName()).append(COLON).append(getMethodName()).append(DASH)
				.append(message).toString();
		return logMsg;
	}

	/**
	 * Info.
	 *
	 * @param message the message
	 */
	public void info(String message) {
		logger.info(getBaseMessage(message));
	}

	/**
	 * Info.
	 *
	 * @param message the message
	 * @param objects the objects
	 */
	public void info(String message, Object... objects) {
		logger.info(getBaseMessage(message), objects);
	}

	/**
	 * Warn.
	 *
	 * @param message the message
	 */
	public void warn(String message) {
		logger.warn(getBaseMessage(message));
	}

	/**
	 * Warn.
	 *
	 * @param message the message
	 * @param objects the objects
	 */
	public void warn(String message, Object... objects) {
		logger.warn(getBaseMessage(message), objects);
	}

	/**
	 * Warn.
	 *
	 * @param message the message
	 * @param t       the t
	 */
	public void warn(String message, Throwable t) {
		logger.warn(getBaseMessage(message), t);
	}

	/**
	 * Debug.
	 *
	 * @param message the message
	 */
	public void debug(String message) {
		logger.debug(getBaseMessage(message));
	}

	/**
	 * Debug.
	 *
	 * @param message the message
	 * @param objects the objects
	 */
	public void debug(String message, Object... objects) {
		logger.debug(getBaseMessage(message), objects);
	}

	/**
	 * Debug.
	 *
	 * @param message the message
	 * @param t       the t
	 */
	public void debug(String message, Throwable t) {
		logger.debug(getBaseMessage(message), t);
	}

	/**
	 * Error.
	 *
	 * @param message the message
	 */
	public void error(String message) {
		logger.error(getBaseMessage(message));
	}

	/**
	 * Error.
	 *
	 * @param message the message
	 * @param objects the objects
	 */
	public void error(String message, Object... objects) {
		logger.error(getBaseMessage(message), objects);
	}

	/**
	 * Error.
	 *
	 * @param message the message
	 * @param t       the t
	 */
	public void error(String message, Throwable t) {
		logger.error(getBaseMessage(message), t);
	}

}
