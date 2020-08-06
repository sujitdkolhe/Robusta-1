package com.config;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Constants {
	public static WebDriver driver;
	public static WebElement element;
	public static Actions action;
	public static Object obj;
	public static JSONObject jsonObj;
	public static JSONArray jsonArray;
	public static List<String> expectedList;
	public static ArrayList<String> actualList;
	public static boolean isDisplay;
	public static String actual;
	public static String expected;
}
