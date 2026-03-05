package com.chansons.chansons;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chansons.chansons.entities.Album;
import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.repositories.ChansonRepository;

@SpringBootTest
class ChansonsApplicationTests {

    @Autowired
    private ChansonRepository chansonRepository;

    @Test
    public void testCreateChanson() {
        Chanson chs = new Chanson("Off The Grid", "Kanye West", new Date());
        chansonRepository.save(chs);
    }

    @Test
    public void testFindChanson() {
        Chanson c = chansonRepository.findById(1L).get();
        System.out.println(c);
    }

    @Test
    public void testUpdateChanson() {
        Chanson c = chansonRepository.findById(1L).get();
        c.setArtist("Updated Artist");
        chansonRepository.save(c);
    }

    @Test
    public void testDeleteChanson() {
        chansonRepository.deleteById(1L);
    }

    @Test
    public void testListerTousChansons() {
        List<Chanson> chansons = chansonRepository.findAll();
        for (Chanson c : chansons) {
            System.out.println(c);
        }
    }
    @Test
public void testFindByTitre()
{
List<Chanson> chans = chansonRepository.findByTitle("Off The Grid");
for (Chanson c : chans) {
{
System.out.println(c);
}
}
}
@Test
public void testFindByTitreContains ()
{
List<Chanson> chans=chansonRepository.findByTitleContains("Off The Grid");
for (Chanson c : chans)
{
System.out.println(c);
} }
@Test
public void findByTitleAndDateAfter()
{
List<Chanson> chans = chansonRepository.findByTitleAndDateAfter("Off The Grid", new Date());
for (Chanson c : chans)
{
System.out.println(c);
}
}
@Test
public void testfindByAlbum()
{
Album alb = new Album();
alb.setIdalb(1L);
List<Chanson> chans = chansonRepository.findByAlbum(alb);
for (Chanson c : chans)
{
System.out.println(c);
}
}
@Test
public void findByAlbumidalb()
{
List<Chanson> chans = chansonRepository.findByAlbumIdalb(1L);
for (Chanson c : chans)
{
System.out.println(c);
}
}
@Test
public void findByOrderByTitleAsc()
{
List<Chanson> chans =
chansonRepository.findByOrderByTitleAsc();
for (Chanson c : chans)
{
System.out.println(c);
}
}
@Test
public void trierChansonsParTitreEtDate()
{
List<Chanson> chans = chansonRepository.trierChansonsParTitreEtDate();
for (Chanson c : chans)
{
System.out.println(c);
}
}
}