package org.j2os.project.common;



import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorWrapper {
    private static final Logger LOGGER =  Logger.getLogger(ErrorWrapper.class);
    private ErrorWrapper() {
    }
    public static Map<String, String> getError(Exception exception) {
        LOGGER.error(exception);
        exception.printStackTrace();

        Map<String, String> map = new HashMap<>();
        if (exception instanceof SQLException) {
            map.put("errorCode", "101");
            map.put("errorMessage", "DataBase Error");
            return map;
        } else if (exception instanceof ArithmeticException) {
            map.put("errorCode", "102");
            map.put("errorMessage", "Arithmetic Error");
            return map;

        } else {
            map.put("errorCode", "200");
            map.put("errorMessage", "Unknown Error");
            return map;
        }
    }
}
