
package com.huyy.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.9
 * 2019-05-30T16:04:51.535+08:00
 * Generated source version: 3.2.9
 *
 */
public final class StudentScoreService_StudentScoreServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://service.huyy.com/", "StudentScoreServiceService");

    private StudentScoreService_StudentScoreServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = StudentScoreServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        StudentScoreServiceService ss = new StudentScoreServiceService(wsdlURL, SERVICE_NAME);
        StudentScoreService port = ss.getStudentScoreServicePort();

        {
        System.out.println("Invoking getScore...");
        java.lang.String _getScore_arg0 = "";
        int _getScore__return = port.getScore(_getScore_arg0);
        System.out.println("getScore.result=" + _getScore__return);


        }

        System.exit(0);
    }

}
