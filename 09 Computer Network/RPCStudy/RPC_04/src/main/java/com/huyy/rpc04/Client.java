package com.huyy.rpc04;

import com.huyy.rpc.common.UserService;

/**
 * @author yyhu
 * @create 2020-09-03 10:00
 */
public class Client {
    public static void main(String[] args) {
        UserService service = Stub.getStub();
        //方法及其参数调用
        System.out.println(service.findUserById(123));
    }
}
