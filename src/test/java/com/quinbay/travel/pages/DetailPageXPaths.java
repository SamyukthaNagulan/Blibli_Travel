package com.quinbay.travel.pages;

public class DetailPageXPaths {

    public static String source = "//*[@class=\"hub__flight-detail-right__departure\"]/div[@class=\"route__departure-city\"]";
    public static String destination = "//*[@class=\"hub__flight-detail-right__arrival\"]/div[@class=\"route__arrival-city padding-top-10\"]";
    public static String airlineCode = "//div[@class=\"route__departure-airline-code\"]";
    public static String startTime = "//div[@class=\"route__departure-time\"]";
    public static String endTime = "//div[@class=\"route__arrival-time\"]";
    public static String selectGo1 = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[2]/button";
    public static String detail1 = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[1]/div[2]/div/ul/li[1]/a";
    public static String selectGo2 = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[4]/div[1]/div/div/div[2]/button";
    public static String check = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/label";
    public static String detail2 = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[4]/div[1]/div/div/div[1]/div[2]/div/ul/li[1]/a";
    public static String back = "//b[contains(text(),'×')]";
    public static String orderTicket = "//button[contains(text(),'Pesan Tiket')]";
    public static String date = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[1]/select";
    public static String month = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[2]/select";
    public static String year = "//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[3]/select";
    public static String detail = "//a[@class=\"order-header-right-value\"]";
}
