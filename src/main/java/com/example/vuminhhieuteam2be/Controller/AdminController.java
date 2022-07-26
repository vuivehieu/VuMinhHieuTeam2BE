package com.example.vuminhhieuteam2be.Controller;

import com.example.vuminhhieuteam2be.DTO.RoomDTO;
import com.example.vuminhhieuteam2be.Entity.RoomEntity;
import com.example.vuminhhieuteam2be.Model.RoomModel;
import com.example.vuminhhieuteam2be.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Value("${config.upload_folder}")
    private String UPLOAD_FOLDER;
    @Autowired
    IRoomService roomService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/room")
    public String room(Model model) {
        model.addAttribute("rooms",roomService.getAll().stream().map(RoomDTO::toDTO).collect(Collectors.toList()));

        return "admin/roommanage";
    }

    @GetMapping("/room/add")
    public String addRoom(Model model) {
        model.addAttribute("room",new RoomModel());
        return "admin/addnewroom";
    }

    @GetMapping("/room/edit/{id}")
    public String editRoom(Model model, @PathVariable("id") Long id) {
        RoomEntity room = roomService.getByID(id);
        model.addAttribute("room",RoomModel.builder().id(room.getId()).name(room.getRoomName()).description(room.getRoomDescription()).image(room.getRoomImage()).status(room.getRoomStatus()).type(room.getRoomType()).price(room.getRoomPrice()).size(room.getRoomSize()).build());
        return "admin/addnewroom";
    }

    @PostMapping("/room/editted")
    public String editRoom(RoomModel roomModel, @RequestParam("fileimage") MultipartFile file){
        String relativeFilePath = null;
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        String subFolder = month+"_"+year+"/";
        String fullUploadDir = UPLOAD_FOLDER + subFolder;
        File checkDir = new File(fullUploadDir);
        if(!checkDir.exists()|| checkDir.isFile()){
            checkDir.mkdir();
        }

        relativeFilePath = subFolder + Instant.now().getEpochSecond() + file.getOriginalFilename();
        try {
            Files.write(Paths.get(UPLOAD_FOLDER+relativeFilePath), file.getBytes());
        } catch (IOException e) {
            System.out.println("failed");
            e.printStackTrace();
            return null;
        }
        roomModel.setImage(relativeFilePath);
        roomService.updateOld(roomModel);
        return "redirect:/admin/room";
    }

    @GetMapping("/room/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id){
        roomService.deleteOld(id);
        return "redirect:/admin/room";
    }

    @PostMapping("/room/added")
    public String addProduct(RoomModel roomModel, @RequestParam("fileimage") MultipartFile file){
        String relativeFilePath = null;
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        String subFolder = month+"_"+year+"/";
        String fullUploadDir = UPLOAD_FOLDER + subFolder;
        File checkDir = new File(fullUploadDir);
        if(!checkDir.exists()|| checkDir.isFile()){
            checkDir.mkdir();
        }

        relativeFilePath = subFolder + Instant.now().getEpochSecond() + file.getOriginalFilename();
        try {
            Files.write(Paths.get(UPLOAD_FOLDER+relativeFilePath), file.getBytes());
        } catch (IOException e) {
            System.out.println("failed");
            e.printStackTrace();
            return null;
        }
        roomModel.setImage(relativeFilePath);
        roomService.insertNew(roomModel);
        return "redirect:/admin/room";
    }


}
