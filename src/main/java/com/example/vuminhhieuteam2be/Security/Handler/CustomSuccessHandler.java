package com.example.vuminhhieuteam2be.Security.Handler;

import com.example.vuminhhieuteam2be.Entity.RoleEntity;
import com.example.vuminhhieuteam2be.Entity.UserEntity;
import com.example.vuminhhieuteam2be.Repository.IUserRepository;
import com.example.vuminhhieuteam2be.Security.DetailModels.CustomUser;
import com.example.vuminhhieuteam2be.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    IUserService userService;
    @Autowired
    IUserRepository userRepository;
//    @Autowired
//    CategoryRepository categoryRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        UserEntity user =customUser.getUserEntity();
        List<String> permissions =new ArrayList<>();
        for (RoleEntity a: user.getRoleSet()) {
            permissions.add(a.getRole_name());
        }
        request.getSession().setAttribute("user", user.getId());
        if (permissions.contains("ADMIN")){
            response.sendRedirect("/admin/dashboard");
        }
        else if (permissions.contains("USER")){
//            request.getSession().setAttribute("categories",categoryRepository.findAll());
            request.getSession().setAttribute("user", user.getId());
            request.getSession().setAttribute("usermail", user.getEmail());
//            List<ProductEntity> productEntities = new ArrayList<>();
//            if(user.getCart().getProductEntitySet()!=null){
//                productEntities = (List<ProductEntity>) user.getCart().getProductEntitySet();
//            }
//            request.getSession().setAttribute("cart", productEntities);
            response.sendRedirect("/user/index");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
