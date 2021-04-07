package kz.iitu.model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@SpringBootApplication
class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}