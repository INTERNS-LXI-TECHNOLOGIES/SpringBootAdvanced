package com.lxisoft.config;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.net.*; 
import java.net.URLConnection;
import java.io.*;
import java.util.*;
/**
 *International class
 */
public class International
{
    /**
     *inner class UTF8Control to include UTF-8 in ResourceBundle
     */
	public class UTF8Control extends Control {
    public ResourceBundle newBundle (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
    				throws IllegalAccessException, InstantiationException, IOException
    {
        // The below is a copy of the default implementation.
        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, "properties");
        ResourceBundle bundle = null;
        InputStream stream = null;
        if (reload) {
            URL url = loader.getResource(resourceName);
            if (url != null) {
                URLConnection connection = url.openConnection();
                if (connection != null) {
                    connection.setUseCaches(false);
                    stream = connection.getInputStream();
                }
            }
        } else {
            stream = loader.getResourceAsStream(resourceName);
        }
        if (stream != null) {
            try {
                // Only this line is changed to make it to read properties files as UTF-8.
                bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
            } finally {
                stream.close();
            }
        }
        return bundle;
    }
	}
    /**
     *method to get locale
     *@param word locale word
     *@param lang language selected
     *@param country country selected
     *@return converted word
     */
	public  String getLocale(String word,String lang,String country)
	{
		Locale.setDefault(new Locale(lang,country));
		ResourceBundle bundle = ResourceBundle.getBundle("text", new UTF8Control());
		return(bundle.getString(word));
	}
}
