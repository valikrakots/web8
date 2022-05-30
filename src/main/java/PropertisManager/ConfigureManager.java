package PropertisManager;

import Connector.Exceptions.JDBCConnectionException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureManager {

    // Имя property файла
    private static final String DB_PROPERTIES = "database.properties";
    public String driver;
    public String DB_URL;
    public String user;
    public String password;

    public ConfigureManager()
    {
        /*Properties prop = new Properties();

        try { // Пробуем получить досупт к property файлу
            prop.load(new FileInputStream(DB_PROPERTIES));
        } catch (
                IOException e) {
            try {
                throw new JDBCConnectionException("Error! Couldn't load properties file.");
            } catch (JDBCConnectionException dbConnectionException) {
                dbConnectionException.printStackTrace();
            }
        }*/

        // Получаем неободимую информацию для подключения из property-файла
        driver = "com.mysql.cj.jdbc.Driver";
        DB_URL = "mysql://rzdja73fx3xy37n1:f313xs6jhynexnue@ilzyz0heng1bygi8.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/up49pdigfoxz5fqo";
        user = "rzdja73fx3xy37n1";
        password = "f313xs6jhynexnue";
    }

}
