package com.chansons.chansons;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.repositories.ChansonRepository;

@SpringBootTest
class ChansonsApplicationTests {

	@Autowired
private ChansonRepository chansonRepository;
@Test
public void testCreateChanson() {
Chanson chs = new Chanson("Off The Grid","Kanye West",new Date());
chansonRepository.save(chs);
}
@Test
public void testFindChanson()
{
Chanson c = chansonRepository.findById(1L).get();
System.out.println(c);
}
@Test
public void testUpdateChanson()
{
Chanson c = chansonRepository.findById(1L).get();
c.setArtist("Updated Artist");
chansonRepository.save(c);
}
@Test
public void testDeleteChanson()
{
chansonRepository.deleteById(1L);
}

@Test
public void testListerTousChansons()
{
List<Chanson> chansons = chansonRepository.findAll();
for (Chanson c : chansons)
{
System.out.println(c);
}
}
}
