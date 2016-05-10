/**
 * Copyright 2005-2013 Restlet S.A.S.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL
 * 1.0 (the "Licenses"). You can select the license that you prefer but you may
 * not use this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package com.dream.common.utils;

import java.util.HashMap;
import java.util.Map;
public final class MediaType extends Metadata {

    
	  public MediaType(String name, String description) {
			super(name, description);
			// TODO Auto-generated constructor stub
		}

    private static volatile Map<String, MediaType> _types = null;

    
    public static final MediaType APPLICATION_ALL_XML = register(
            "application/*+xml", "All application/*+xml documents");
    
    public static final MediaType APPLICATION_JSON = register(
            "application/json", "JavaScript Object Notation document");

    public static final MediaType IMAGE_BMP = register("image/bmp",
            "Windows bitmap");

    public static final MediaType IMAGE_GIF = register("image/gif", "GIF image");

    public static final MediaType IMAGE_ICON = register("image/x-icon",
            "Windows icon (Favicon)");

    public static final MediaType IMAGE_JPEG = register("image/jpeg",
            "JPEG image");

    public static final MediaType IMAGE_PNG = register("image/png", "PNG image");

    
    public static final MediaType TEXT_HTML = register("text/html",
            "HTML document");


    public static final MediaType TEXT_PLAIN = register("text/plain",
            "Plain text");
    
    public static final MediaType TEXT_XML = register("text/xml", "XML text");

   

    /**
     * Returns the known media types map.
     * 
     * @return the known media types map.
     */
    private static Map<String, MediaType> getTypes() {
        if (_types == null) {
            _types = new HashMap<String, MediaType>();
        }
        return _types;
    }


    public static synchronized MediaType register(String name,
            String description) {

        if (!getTypes().containsKey(name)) {
            final MediaType type = new MediaType(name, description);
            getTypes().put(name, type);
        }

        return getTypes().get(name);
    }
    
    public static MediaType valueOf(String name) {
        MediaType result = null;

        if ((name != null) && !name.equals("")) {
            result = getTypes().get(name);
            if (result == null) {
                return APPLICATION_JSON;
            }
        }

        return result;
    }
    
    /**
     * Returns the main type.
     * 
     * @return The main type.
     */
    public String getMainType() {
        String result = null;

        if (getName() != null) {
            int index = getName().indexOf('/');

            // Some clients appear to use name types without subtypes
            if (index == -1) {
                index = getName().indexOf(';');
            }

            if (index == -1) {
                result = getName();
            } else {
                result = getName().substring(0, index);
            }
        }

        return result;
    }
   
   
}
