package com.thanhi.controller;

import com.thanhi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SecurityController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    IAccountService accountService;

    @RequestMapping("/security/login/form")
    public String loginForm(Model model) {
        model.addAttribute("message", "Please sing in now!");
        return "/security/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model, HttpSession session) {

        session.setAttribute("accountLogin", accountService.findAccountByUsername(request.getRemoteUser()).get());
        model.addAttribute("message", "Sing in success!");
        return "redirect:/product/home";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model) {
        model.addAttribute("message", "Invalid username or password!");
        return "/security/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", "You do not have permission to access this page!");
        return "/security/login";
    }

//    @RequestMapping("/security/logoff")
//    public String logoff(Model model, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "/security/login";
//    }

    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model) {
        model.addAttribute("message", "You are logoff!");
        return "/security/login";
    }
}
