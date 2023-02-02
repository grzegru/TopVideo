package com.example.topvideo.client.user;

import com.example.topvideo.domain.api.DiscoveryBasicInfo;
import com.example.topvideo.domain.api.DiscoveryService;
import com.example.topvideo.domain.api.UserProfile;
import com.example.topvideo.domain.api.UserService;
import com.example.topvideo.domain.user.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/userprofile")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = "USER"),
        }
)
public class UserProfileController extends HttpServlet {
    private final UserService userService = new UserService();
    private final DiscoveryService discoveryService = new DiscoveryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loggedInUsername = request.getUserPrincipal().getName();
        User loggedUser = userService.getUser(loggedInUsername);
        UserProfile profileData = userService.getUserData(loggedUser);
        List<DiscoveryBasicInfo> discoveries = discoveryService.findByUserId(loggedUser.getId());
        double summaryVotes = countSummaryVotes(discoveries);
        request.setAttribute("profile_data", profileData);
        request.setAttribute("discoveries", discoveries);
        request.setAttribute("votes", summaryVotes);
        request.getRequestDispatcher("/WEB-INF/views/user-profile.jsp").forward(request, response);
    }


    private double countSummaryVotes(List<DiscoveryBasicInfo> discoveries){
        int sum = 0;
        for (DiscoveryBasicInfo discovery : discoveries) {
            sum += discovery.getVoteCount();
        }
        return sum;
    }

}
