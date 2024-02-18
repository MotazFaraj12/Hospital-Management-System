package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class room {
    /***************************/
    private int Room_no;
    private String Room_type;
    private int Period;
    /***************************/
    public room (int Room_no, String Room_type, int Period) {
        this.Room_no = Room_no;
        this.Room_type = Room_type;
        this.Period = Period;
    }
    public int getRoom_no() {
        return Room_no;
    }
    public String getRoom_type() {
        return Room_type;
    }
    public int getPeriod() {
        return Period;
    }

    public void setRoom_no(int room_no) {
        this.Room_no = room_no;
    }
    public void setRoom_type(String room_type) {
        this.Room_type = room_type;
    }
    public void setPeriod(int period) {
        this.Period = period;
    }

}
