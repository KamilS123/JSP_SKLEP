package com.kamil.jsp_sklep.utils;

import com.google.gson.Gson;
import com.kamil.jsp_sklep.dao.impl.UserJsonDaoImpl;
import com.kamil.jsp_sklep.models.JsonAccess;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtils {
    private static final Logger LOGGER = Logger.getLogger(UserJsonDaoImpl.class.getName());
    private static final String jsonPath = "C:\\Users\\Kamil\\IdeaProjects\\JSP_SKLEP\\app.json";
    private static Gson gson = new Gson();

    public static JsonAccess getJson() {
        JsonAccess jsonAccess;
        try {
            InputStream is = new FileInputStream(jsonPath);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            jsonAccess = gson.fromJson(reader, JsonAccess.class);

            LOGGER.log(Level.INFO, "Fetched json" + jsonAccess);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException", e);
            throw new RuntimeException("Cannot find file");
        }
        return jsonAccess;
    }

    public static void writeJson(JsonAccess jsonAccess) {
        String json = gson.toJson(jsonAccess,JsonAccess.class);
        try {
            FileWriter fileWriter = new FileWriter(jsonPath);
            fileWriter.write(json);
            fileWriter.close();
        }catch (IOException e) {
            LOGGER.log(Level.SEVERE,"IOException",e);
            throw new RuntimeException("Cannot find file");
        }
    }
}
