package com.example.vuminhhieuteam2be.Controller;

import com.example.vuminhhieuteam2be.DTO.RoomDTO;
import com.example.vuminhhieuteam2be.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IRoomService roomService;
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("rooms",roomService.getAll().stream().filter(m->m.getRoomStatus()==true).map(RoomDTO::toDTO).collect(Collectors.toList()));
        return "user/index";
    }
    @PostMapping("/room/book")
    public String bookRoom() {
        return "user/bookroom";
    }

    @GetMapping("/room/{id}")
    public String showRoom(@PathVariable("id") Long id) {
        return "user/showroom";
    }
}
