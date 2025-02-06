package com.varun.AmayHotels.service.interfac;

import com.varun.AmayHotels.dto.LoginRequest;
import com.varun.AmayHotels.dto.Response;
import com.varun.AmayHotels.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
