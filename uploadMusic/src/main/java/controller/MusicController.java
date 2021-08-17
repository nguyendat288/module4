package controller;

import moduls.Music;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.MusicService;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    MusicService musicService = new MusicService();

    @RequestMapping("home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",musicService.list);
        return modelAndView;
    }

    @PostMapping("create")
    public String create(@ModelAttribute Music music, @RequestParam MultipartFile uppMusic){
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppMusic.getBytes(), new File("C:\\Java\\uploadMusic\\src\\main\\webapp\\fileMusic\\" + nameMusic));
            String urlImg = "/music/" + nameMusic;
            music.setMusicfile(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        musicService.add(music);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new Music());

        return modelAndView;
    }
   @GetMapping("/delete")
    public String delete(@RequestParam int index){
        musicService.remove(index);
        return "redirect:/home";
   }
}
