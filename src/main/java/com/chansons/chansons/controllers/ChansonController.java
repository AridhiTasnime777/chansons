package com.chansons.chansons.controllers;

import com.chansons.chansons.repositories.AlbumRepository;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chansons.chansons.entities.Album;
import com.chansons.chansons.entities.Chanson;
import com.chansons.chansons.services.ChansonService;

@Controller
public class ChansonController {

    @Autowired
    ChansonService chansonService;

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/myView")
    public String myView() {
        return "myView";
    }

    @RequestMapping("/ListeChansons")
    public String listeChansons(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
										@RequestParam (name="size", defaultValue = "2") int size) {
        Page<Chanson> chs = chansonService.getAllChansonsParPage(page, size);
        modelMap.addAttribute("chansons", chs);
        modelMap.addAttribute("pages", new int[chs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);	
        return "listeChansons";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        List<Album> albums = chansonService.getAllAlbums();
        modelMap.addAttribute("albums", albums);
        modelMap.addAttribute("chanson", new Chanson());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("albums", chansonService.getAllAlbums());
        modelMap.addAttribute("mode", "new");
        return "formChanson";
    }

    @RequestMapping("/saveChanson")
    public String saveChanson(@Valid Chanson chanson,BindingResult bindingResult,
            @RequestParam(name="page" , defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="2") int size) 
           {
            int currentpage;
            boolean isNew=false;
            if (bindingResult.hasErrors()) 
                return "formChanson";
            if(chanson.getIdChanson() == null) {
                isNew = true;
            }
            chansonService.saveChanson(chanson);
            if(isNew) {
                Page<Chanson> chs = chansonService.getAllChansonsParPage(page, size);
                currentpage = chs.getTotalPages() - 1;
            } else {
                currentpage = page;
            }
            return "redirect:/ListeChansons?page="+currentpage+"&size="+size;
    }

    @RequestMapping("/supprimerChanson")
    public String supprimerChanson(@RequestParam("id") Long id, ModelMap modelMap) {
        chansonService.deleteChansonById(id);
        List<Chanson> chs = chansonService.getAllChansons();
        modelMap.addAttribute("chansons", chs);
        return "listeChansons";
    }

    @RequestMapping("/modifierChanson")
    public String editerChanson(@RequestParam("id") Long id, ModelMap modelMap) {
        Chanson p = chansonService.getChanson(id);
        List<Album> albums = chansonService.getAllAlbums();
        modelMap.addAttribute("albums", albums);
        modelMap.addAttribute("chanson", p);
        modelMap.addAttribute("mode","edit");
        modelMap.addAttribute("albums", chansonService.getAllAlbums());
        modelMap.addAttribute("mode", "edit");
        return "formChanson";
    }

    @RequestMapping("/updateChanson")
    public String updateChanson(
            @ModelAttribute("chanson") Chanson chanson,
            @RequestParam("dateCreation") String date,
            @RequestParam(value = "album.idalb", required = false) Long idalb, // ← THIS WAS MISSING
            ModelMap modelMap) throws ParseException {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        chanson.setReleaseDate(dateformat.parse(date));

        if (idalb != null) {
            chanson.setAlbum(albumRepository.findById(idalb).orElse(null));
        } else {
            chanson.setAlbum(null);
        }

        chansonService.updateChanson(chanson);
        List<Chanson> chs = chansonService.getAllChansons();
        modelMap.addAttribute("chansons", chs);
        return "listeChansons";
    }
}