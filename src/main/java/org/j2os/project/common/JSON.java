package org.j2os.project.common;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {
    private JSON(){}
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public  static String getJSonString(Object o)throws Exception
    {
        return OBJECT_MAPPER.writeValueAsString(o);
    }
}
