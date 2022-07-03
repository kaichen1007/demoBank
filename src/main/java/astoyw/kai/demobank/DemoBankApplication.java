package astoyw.kai.demobank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("astoyw.kai.demobank.mapper")
@SpringBootApplication
public class DemoBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBankApplication.class, args);
    }

}
