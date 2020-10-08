package com.huyy.rpc06;

import com.huyy.rpc.common.UserService;

public class Client {
    public static void main(String[] args) {
        UserService service = (UserService) Stub.getStub(UserService.class);
        System.out.println(service.findUserById(123));
    }
}
