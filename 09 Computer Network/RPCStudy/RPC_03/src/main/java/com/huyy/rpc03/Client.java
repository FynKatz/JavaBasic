package com.huyy.rpc03;


import com.huyy.rpc.common.UserService;

public class Client {
    public static void main(String[] args) {
        UserService service = Stub.getStub();
        System.out.println(service.findUserById(123));
    }
}
