package jdbcProperties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcProperties {

    public static Properties getConnectionData() {

        Properties props = new Properties();

        String fileName = "src/JdbcProperties/database.properties";

        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
        	
            Logger lgr = Logger.getLogger(JdbcProperties.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return props;
    }
    
}