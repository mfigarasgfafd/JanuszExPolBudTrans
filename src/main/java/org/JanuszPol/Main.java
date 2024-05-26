package org.JanuszPol;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        Technician tomek = new Technician("tomek1","123");
        tomek.register();
        tomek.login();




   }


}
