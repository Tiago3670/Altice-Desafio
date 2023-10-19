import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class Tests {


    @Test
    public void requestServiceARoaming()    //pedido 5 minutos roaming para o bucktA, neste caso deverá ser usado o tarifario Alpha1
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, true, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals("OK",reply.getResult());
    }
    @Test
    public void requestServiceBRoaming()    //pedido 5 minutos roaming para o bucktA, neste caso deverá ser usado o tarifario Alpha1
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.B, true, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals("OK",reply.getResult());
    }
    @Test
    public void requestServiceBRoamingFalse()    //pedido 5 minutos sem roaming , neste caso deverá ser usado o tarifario Beta1
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.B, false, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals("OK",reply.getResult());
    }
    @Test
    public void requestServiceARoamingFalse()    //pedido 5 minutos sem roaming para o bucktC, neste caso deverá ser usado o tarifario Alpha1
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, false, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals("OK",reply.getResult());
    }
    @Test
    public void requestServiceARoamingFalseBucketA()    //pedido 5 minutos sem roaming para o BucketA, o valor a pagar deverá ser 10€ logo o BucketA deverá ficar com 5
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, false, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals(5.00, BillingAccount.getBucketA()/100, 0.001);
    }

    @Test
    public void requestServiceBRoamingFalseBucketA()    //pedido 5 minutos sem roaming para o BucketA, o valor a pagar deverá ser 50 centimos logo o BucketA deverá ficar com 9,95€
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.B, false, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);

        assertEquals(9.95, BillingAccount.getBucketA()/100, 0.001);
    }
    @Test
    public void requestServiceARoamingTrueBucketC()    //pedido 5 minutos sem roaming para o BucketC, o valor a pagar deverá ser 10€ logo o BucketC deverá ficar com 5
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);
        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, true, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals(5.00, BillingAccount.getBucketC()/100, 0.001);
    }
    @Test
    public void CDRHasUpdated()    //verificar se MSISDN do request está no CDR
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);
        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, true, "99999", Integer.valueOf(5));
        reply = Central.setRequest(request);
        assertEquals(request.getMsisdn(), CDR.getMsisdn());
    }

    @Test
    public void requestServiceARoamingTrueBucketACreditLimitReached()    //pedido 15 minutos com roaming ou seja 2€ por minuot (Alpha 1) da´ra 30€ para o bucketA  sendo que este só tem 10€
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, false, "99999", Integer.valueOf(15));
        reply = Central.setRequest(request);

        assertEquals("CreditLimitReached",reply.getResult());
    }
    @Test
    public void consultarRequest()    //conultar o uso e custos associados a um MSISDN
    {
        BillingAccount.addBucketA(10);
        BillingAccount.addBucketB(20);
        BillingAccount.addBucketC(15);
        List<ChargingReply> replyList = new ArrayList<>();

        ChargingReply reply;
        ChargingRequest request = new ChargingRequest(UUID.randomUUID(), System.currentTimeMillis(), ServiceType.A, false, "123", Integer.valueOf(15));
        reply = Central.setRequest(request);
        reply = Central.setRequest(request);
        replyList=Central.getAllRequests();
        assertEquals(2,replyList.size());
    }
}
