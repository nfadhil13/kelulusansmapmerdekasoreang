package com.smapmerdeksasoreang.smapmeredekasoreang.controller;

import com.smapmerdeksasoreang.smapmeredekasoreang.model.Siswa;
import com.smapmerdeksasoreang.smapmeredekasoreang.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SiswaController {

    @Autowired
    SiswaService siswaService;

    private static final String urlPrefix = "http://smaplusmerdekasoreang.sch.id/coba/";

    @GetMapping(value = {"/","/login"})
    public String logInController(Siswa siswa, ModelMap params) {
        params.addAttribute("siswa",siswa);
        return"pages/login";
    }

    @PostMapping(value="/tryLogin")
    public String loginForm(@ModelAttribute Siswa siswa , RedirectAttributes redirectAttributes) {
        //Checking if the inserted Username is exist
        Optional<Siswa> siswaOptional =siswaService.getSiswaByNis(siswa.getNis());
        if (siswaOptional.isPresent()) {
            if (siswa.getPassword().equals(siswaOptional.get().getPassword())) {
                return "redirect:/redirect/" + siswaOptional.get().getPdfLink();
            } else {
                redirectAttributes.addFlashAttribute("notAvailable", "Password Tidak Sesuai ");
                return "redirect:/login";
            }
        } else {
            redirectAttributes.addFlashAttribute("notAvailable", "Tidak Dapat ditemukan username Tersebut ");
            return "redirect:/login";
        }
    }

        @GetMapping(value="/redirect/{filename}")
        public void method(HttpServletResponse httpServletResponse , @PathVariable("filename") String filename) {
            String fullUrl = urlPrefix+filename;
            httpServletResponse.setHeader("Location", fullUrl);
            httpServletResponse.setStatus(302);
        }
}