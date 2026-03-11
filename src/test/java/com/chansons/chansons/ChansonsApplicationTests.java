package com.chansons.chansons;

import java.util.List;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.chansons.chansons.entities.Album;
import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.repositories.AlbumRepository;
import com.chansons.chansons.repositories.ChansonRepository;
import com.chansons.chansons.services.ChansonService;

@SpringBootTest
class ChansonsApplicationTests {

    @Autowired
    private ChansonRepository chansonRepository;

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
	ChansonService chansonService;
     @Test
		public void testFindByNomChansonContains()
		 {
		
			Page<Chanson>  Chans = chansonService.getAllChansonsParPage(0,2);
			System.out.println(Chans.getSize());
			System.out.println(Chans.getTotalElements());
			System.out.println(Chans.getTotalPages());
			
			Chans.getContent().forEach(p -> {System.out.println(p.toString());
			 });};
     @Test
    public void testFindByAlbum() {
        Album album = new Album();
        album.setIdalb(1L);
        List<Chanson> chansons = chansonRepository.findByAlbum(album);
        System.out.println("✅ findByAlbum(id=1) - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    
    @Test
    public void testFindChanson() {
        // ✅ FIX: id 73 is your first existing record
        Chanson c = chansonRepository.findById(76L).get();
        System.out.println("✅ Chanson trouvée : " + c);
    }
  
    @Test
    public void testCreateChanson() {
        Chanson c = new Chanson("Off The Grid", "Kanye West", new Date());
        chansonRepository.save(c);
        System.out.println("✅ Chanson créée : " + c);
    }

    

    @Test
    public void testUpdateChanson() {
        // ✅ FIX: id 73 exists in your DB
        Chanson c = chansonRepository.findById(74L).get();
        c.setArtist("Updated Artist");
        chansonRepository.save(c);
        System.out.println("✅ Chanson mise à jour : " + c);
    }

    @Test
    public void testDeleteChanson() {
        chansonRepository.deleteById(73L);
        System.out.println("✅ Chanson supprimée");
    }

    @Test
    public void testListerTousChansons() {
        List<Chanson> chansons = chansonRepository.findAll();
        System.out.println("✅ Toutes les chansons (" + chansons.size() + ") :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    @Test
    public void testFindByTitle() {
        List<Chanson> chansons = chansonRepository.findByTitle("fadhel chaker");
        System.out.println("✅ findByTitle - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    @Test
    public void testFindByTitleContains() {
        List<Chanson> chansons = chansonRepository.findByTitleContains("om");
        System.out.println("✅ findByTitleContains('om') - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    @Test
    public void testFindByTitleAndDateAfter() {
        Date date = new Date(0);
        List<Chanson> chansons = chansonRepository.findByTitleAndDateAfter("chaker", date);
        System.out.println("✅ findByTitleAndDateAfter - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

   

    @Test
    public void testFindByAlbumIdalb() {
        List<Chanson> chansons = chansonRepository.findByAlbumIdalb(1L);
        System.out.println("✅ findByAlbumIdalb(1) - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    @Test
    public void testFindByOrderByTitleAsc() {
        List<Chanson> chansons = chansonRepository.findByOrderByTitleAsc();
        System.out.println("✅ findByOrderByTitleAsc - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    @Test
    public void testTrierChansonsParTitreEtDate() {
        List<Chanson> chansons = chansonRepository.trierChansonsParTitreEtDate();
        System.out.println("✅ trierChansonsParTitreEtDate - " + chansons.size() + " résultat(s) :");
        for (Chanson c : chansons) { System.out.println(c); }
    }

    
}