package com.vinod.docsch.view.helper;

/***
 * This is helper class for all JSF operations like getting the instance of managed beans,
 * display the faces messages , read properties from resourse bundles .
 * @author Vinod
 * 
 */
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

public class JsfWebHelper {

	/**
	 * This method is responsible for getting the instance of managed bean
	 * 
	 * @param beanName managed bean name
	 * @return Object
	 */
	public static Object getDataBean(String beanName) {
		FacesContext fcontext = FacesContext.getCurrentInstance();
		Object returnedObject = null;
		if (returnedObject == null) {
			/*
			 * returnedObject=fcontext.getApplication().
			 * getVariableResolver().resolveVariable(fc,beanName);
			 */
			returnedObject =
					fcontext.getELContext().getELResolver()
							.getValue(fcontext.getELContext(), null, beanName);
		}
		return returnedObject;

	}

	/***
	 * This method add the error message to component
	 * 
	 * @param messageKey resource bundle message key
	 * @param bundleName resource bundle name
	 * @param arguments arry of input arguments who are replaced {0}{1} in
	 *        property values
	 * @param jspId component id where the message is attach.
	 */

	public static void addErrorMessage(String messageKey, String bundleName,
			String[] arguments, String jspId) {

		try {
			String errorMessage =
					getErrorMessageFromBundle(messageKey, bundleName);
			if (arguments != null) {
				// Converting the messageKeys for labels to the Labels.
				String[] labelNames =
						getLabelNamesFromArguments(arguments, bundleName);
				// Formatting the error message and setting to the errorMessage
				// String.
				errorMessage = MessageFormat.format(errorMessage, labelNames);
			}
			setErrorMessage(errorMessage, jspId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method add error faces message to component
	 * 
	 * @param errorMessage message to display
	 * @param jspId id of a component
	 */
	public static void setErrorMessage(String errorMessage, String jspId) {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(errorMessage);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		if (StringUtils.isBlank(jspId)) {
			facesContext.addMessage(null, message);
		} else {
			UIComponent uiComp = findComponentInRoot(jspId);
			facesContext.addMessage(uiComp.getClientId(facesContext), message);
		}
	}

	/**
	 * This method add info faces message to component
	 * 
	 * @param errorMessage message to display
	 * @param jspId id of a component
	 */
	public static void setInfoMessage(String infoMessage, String jspId) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(infoMessage);
		facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		if (StringUtils.isBlank(jspId)) {
			facesContext.addMessage(null, facesMessage);
		} else {
			UIComponent uiComp = findComponentInRoot(jspId);
			facesContext.addMessage(uiComp.getClientId(facesContext),
					facesMessage);
		}
	}

	private static UIComponent findComponentInRoot(String id) {
		UIComponent ret = null;
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			ret = findComponent(root, id);
		}
		return ret;
	}

	private static UIComponent findComponent(UIComponent base, String id) {
		UIComponent returnComp;
		// Is the "base" component itself the match we are looking for?
		if (id.equals(base.getId())) {
			returnComp = base;
		} else
		// Search through our facets and children
		{
			UIComponent kid = null;
			UIComponent result = null;

			Iterator kids = base.getFacetsAndChildren();
			while (kids.hasNext() && (result == null)) {
				kid = (UIComponent) kids.next();
				if (id.equals(kid.getId())) {
					result = kid;
					break;
				}
				result = findComponent(kid, id);
				if (result != null) {
					break;
				}
			}
			returnComp = result;
		}
		return returnComp;
	}

	private static String[] getLabelNamesFromArguments(String[] arguments,
			String bundleName) {
		String[] labelNames = new String[5];

		// Iterates through the String arry arguments and gets the strings
		// attached to the keys present in the properties file.
		if (arguments != null && arguments.length != 0) {
			int length = arguments.length;
			for (int i = 0; i < length; i++) {
				if (arguments[i] != null) {
					labelNames[i] =
							getErrorMessageFromBundle(arguments[i], bundleName);
				}
			}
		}
		return labelNames;
	}

	private static String getErrorMessageFromBundle(String messageKey,
			String bundleName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String errorMessage;
		Locale locale = facesContext.getViewRoot().getLocale();
		facesContext.getApplication().setMessageBundle(bundleName);
		ResourceBundle resourceBundle =
				ResourceBundle.getBundle(bundleName, locale);
		errorMessage = resourceBundle.getString(messageKey);
		return errorMessage;
	}
}
