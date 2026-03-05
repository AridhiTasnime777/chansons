package com.chansons.chansons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.services.ChansonService;
@SpringBootApplication
public class ChansonsApplication implements CommandLineRunner {
	@Autowired
	private ChansonService chansonService;

	public static void main(String[] args) {
		SpringApplication.run(ChansonsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*chansonService.saveChanson(new Chanson("fadhel chaker", "ma32oul",new Date()));
chansonService.saveChanson(new Chanson("om kalthoum","sirt el hob" , new Date()));
chansonService.saveChanson(new Chanson("amer dieb", "maaak albi", new Date()));
*/}
}