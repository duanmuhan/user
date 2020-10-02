package com.cgs.interfaces;

import constant.Response;

public interface UserAuthService {

    public Response auth(String token);
}
