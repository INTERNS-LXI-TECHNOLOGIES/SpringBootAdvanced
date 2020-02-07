package com.lxisoft.config;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.*;
import java.io.*;
import java.net.*; 
import java.net.URLConnection;
public class Localizer
{
	public class UTF8Control extends Control {
    public ResourceBundle newBundle
        (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
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
	public String getWord(String w,String lang,String country)
	{
	
        Locale.setDefault(new Locale(lang,"IN"));
	ResourceBundle r=ResourceBundle.getBundle("messages",new UTF8Control());
	String s=r.getString(w);
    System.out.println(s);
	return s;
	}
}