package com.qr.generator.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.qr.generator.entities.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpSession;
import com.qr.generator.helper.Message;
import org.springframework.web.bind.annotation.PostMapping;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.vcard.VCard;
import net.glxn.qrgen.javase.QRCode;
import java.io.*;
import java.util.Base64;

@Controller
public class HomeController{

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("user",new User());
        return "home";
    }

    @PostMapping("/")
    public String registerUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        try {
            model.addAttribute("user",user);

            VCard vCard = new VCard();
            vCard.setName(user.getFirst_name() + " " + user.getLast_name());
            vCard.setAddress(user.getStreet()+ ", " + user.getCity() +", " + user.getState() +", " + user.getCountry() +", " + user.getZip() );
            vCard.setCompany(user.getCountry());
            vCard.setPhoneNumber(user.getPhone());
            vCard.setTitle(user.getJob());
            vCard.setEmail(user.getEmail());
            vCard.setWebsite(user.getLinkedinURL());
            System.out.println(vCard);


            ByteArrayOutputStream bout =
                    QRCode.from(vCard)
                            .withSize(250, 250)
                            .to(ImageType.PNG)
                            .stream();
            

            byte[] pngData = Base64.getEncoder().encode(bout.toByteArray());
           
            String result = new String(pngData);
            model.addAttribute("qrURL", "data:image/png;base64," + result);

            try {
                String filename = user.getFirst_name()+ "_" + user.getPhone() + "_vcard.png";
                OutputStream out = new FileOutputStream("./src/main/resources/static/images/" + filename);
                bout.writeTo(out);
                out.flush();
                out.close();
                session.setAttribute("message", new Message("QR code generated succesfuly","success"));
//                model.addAttribute("qrURL", filename);


            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "home";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message", new Message("Something went wrong "+ e.getMessage(),"danger"));
            return "home";
        }
    }
}