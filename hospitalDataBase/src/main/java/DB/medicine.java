package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class medicine {
    /***************************/
    private int Medicine_id;
    private String Medicine_name;
    private int Price;
    /***************************/
    public medicine (int Medicine_id, String Medicine_name, int Price) {
        this.Medicine_id = Medicine_id;
        this.Medicine_name = Medicine_name;
        this.Price = Price;
    }
    public int getMedicine_id() {
        return Medicine_id;
    }
    public String getMedicine_name() {
        return Medicine_name;
    }
    public int getPrice() {
        return Price;
    }

    public void setMedicine_id(int medicine_id) {
        this.Medicine_id = medicine_id;
    }
    public void setMedicine_name(String medicine_name) {
        this.Medicine_name = medicine_name;
    }
    public void setPrice(int price) {
        this.Price = price;
    }

}


