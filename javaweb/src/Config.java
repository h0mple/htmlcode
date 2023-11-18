import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    Properties properties=new Properties();
    InputStream is=null;
    private static Config config=null;
    private Config(){
        is=Config.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(is);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public synchronized static Config getInstance(){
        if(config==null){
            config=new Config();
        }
        return config;
    }
    public String getValue(String key){
        return properties.getProperty(key);
    }
}

