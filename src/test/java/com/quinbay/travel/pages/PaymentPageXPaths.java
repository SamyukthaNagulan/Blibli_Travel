package com.quinbay.travel.pages;

public class PaymentPageXPaths {

    public static String cancel = "//b[contains(text(),'×')]";
    public static String confirm = "//button[contains(text(),'Lanjutkan pemesanan')]";
    public static String proceed = "//button[contains(text(),'Yakin, lanjutkan')]";
    public static String details = "//a[@class=\"order-header-right-value\"]";
    public static String source = "//*[@class=\"hub__flight-detail-right__departure\"]/div[@class=\"route__departure-city\"]";
    public static String destination = "//*[@class=\"hub__flight-detail-right__arrival\"]/div[@class=\"route__arrival-city padding-top-10\"]";
    public static String airlineCode = "//div[@class=\"route__departure-airline-code\"]";
    public static String startTime = "//div[@class=\"route__departure-time\"]";
    public static String endTime = "//div[@class=\"route__arrival-time\"]";
}
