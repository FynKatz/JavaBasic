package com.huyy.client.impl;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;



public class CXFTest2 {
	public static void main(String[] args) {
			
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8089/score?wsdl");
        Object[] res = null;
        try {
            res = client.invoke("getScore", new String[]{"小王"});
            for (Object obj:res) {
                System.out.println(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
	}

}
