package com.irinnovative.onepagesigninsignup.sql;

import android.content.Context;

/*车票信息设定*/
public class SqlDataInsert {

    public void inst(Context context) {
        insertBJSH(context);//北京到上海
        insertBJCD(context);//北京到成都
        insertBJSZ(context);//北京到深圳
        insertSZBJ(context);//深圳到北京
        insertCDBJ(context);//成都到北京
        insertSHBJ(context);//上海到北京
        insertSHSZ(context);//上海到深圳
        insertSZSH(context);//深圳到上海
    }


    public void insertBJSH(Context context) {
        Database database = Database.newInstance(context);
        String[] origin = new String[]{"BeiJing", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan"};
        String[] destination = new String[]{"ShangHai", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao"};
        String[] originTime = new String[]{"11:54", "12:00", "12:10", "12:20", "12:50", "13:05", "13:35"};
        String[] destinationTime = new String[]{"07:19", "16:36", "17:56", "18:16", "18:40", "18:59", "19:18"};
        String[] time = new String[]{"19小时25分钟", "4小时46分钟", "5小时46分钟", "5小时56分钟", "5小时50分钟", "5小时54分钟", "5小时43分钟"};
        String[] identifier = new String[]{"G101", "G5", "G105", "G413", "G107", "G111", "G113"};
        int[] businessSeatCount = new int[]{10, 8, 15, 11, 7, 8, 10};
        int[] firstSeatCount = new int[]{45, 33, 67, 78, 80, 78, 23, 53};
        int[] secondSeatCount = new int[]{320, 146, 123, 214, 513, 123, 353};
        int[] noSeatCount = new int[]{124, 546, 542, 314, 421, 453, 153};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertBJCD(Context context) {
        Database database = Database.newInstance(context);
        String[] origin = new String[]{"BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi"};
        String[] destination = new String[]{"ChengDuDong", "ChengDu", "ChengDuDong", "ChengDuDong", "ChengDu", "ChengDu", "ChengDu"};
        String[] originTime = new String[]{"06:53", "08:01", "09:22", "09:38", "11:28", "11:36", "16:40"};
        String[] destinationTime = new String[]{"14:41", "16:41", "19:04", "19:42", "22:39", "21:02", "00:36"};
        String[] time = new String[]{"7小时48分钟", "8小时40分钟", "9小时42分钟", "10小时4分钟", "11小时11分钟", "9小时26分钟", "7小时56分钟"};
        String[] identifier = new String[]{"G89", "G817", "G571", "G307", "G49", "G117", "G7"};
        int[] businessSeatCount = new int[]{12, 11, 8, 6, 3, 10, 9};
        int[] firstSeatCount = new int[]{42, 35, 24, 36, 24, 43, 62};
        int[] secondSeatCount = new int[]{687, 654, 876, 573, 547, 653, 669};
        int[] noSeatCount = new int[]{246, 157, 268, 142, 210, 124, 139};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertBJSZ(Context context) {
        Database database = Database.newInstance(context);
        String[] origin = new String[]{"BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi"};
        String[] destination = new String[]{"ShenZhenBei", "ShenZhen", "ShenZhenBei", "ShenZhenBei", "ShenZhen"};
        String[] originTime = new String[]{"10:10", "19:53", "20:10", "20:25", "23:16"};
        String[] destinationTime = new String[]{"18:35", "8:10", "07:06", "07:42", "8:20"};
        String[] time = new String[]{"8小时35分钟", "12小时17分钟", "10小时56分钟", "11小时17分钟", "9小时4分钟"};
        String[] identifier = new String[]{"G79", "G107", "D901", "D927", "G105"};
        int[] businessSeatCount = new int[]{16, 13, 3, 11, 5};
        int[] firstSeatCount = new int[]{53, 14, 38, 53, 17};
        int[] secondSeatCount = new int[]{538, 647, 653, 625, 351};
        int[] noSeatCount = new int[]{146, 276, 43, 118, 102};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertSZBJ(Context context) {
        Database database = Database.newInstance(context);
        String[] destination = new String[]{"BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi"};
        String[] origin = new String[]{"ShenZhenBei", "ShenZhen", "ShenZhenBei", "ShenZhenBei", "ShenZhen"};
        String[] originTime = new String[]{"10:10", "19:53", "20:10", "20:25", "23:16"};
        String[] destinationTime = new String[]{"18:35", "8:10", "07:06", "07:42", "16:20"};
        String[] time = new String[]{"8小时35分钟", "12小时17分钟", "10小时56分钟", "11小时17分钟", "19小时4分钟"};
        String[] identifier = new String[]{"G79", "G107", "D901", "D927", "G105"};
        int[] businessSeatCount = new int[]{16, 13, 23, 18, 9};
        int[] firstSeatCount = new int[]{43, 84, 38, 43, 17};
        int[] secondSeatCount = new int[]{538, 647, 653, 625, 351};
        int[] noSeatCount = new int[]{46, 176, 243, 178, 102};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertCDBJ(Context context) {
        Database database = Database.newInstance(context);
        String[] destination = new String[]{"BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi", "BeiJingXi"};
        String[] origin = new String[]{"ChengDu", "ChengDuDong", "ChengDuDong", "ChengDu", "ChengDuDong", "ChengDu", "ChengDu", "ChengDu"};
        String[] originTime = new String[]{"08:30", "09:47", "10:42", "11:42", "13:01", "19:30", "19:47", "23:59"};
        String[] destinationTime = new String[]{"12:31", "19:53", "20:38", "10:02", "22:48", "21:06", "05:42", "05:10"};
        String[] time = new String[]{"28小时1分钟", "10小时6分钟", "9小时56分钟", "22小时20分钟", "7小时47分钟", "25小时36分钟", "33小时55分钟", "29小时11分钟"};
        String[] identifier = new String[]{"G8", "G574", "G308", "G50", "G90", "G818", "G1364", "G118"};
        int[] businessSeatCount = new int[]{9, 10, 13, 9, 10, 15, 9, 16};
        int[] firstSeatCount = new int[]{57, 67, 21, 13, 20, 34, 34, 22};
        int[] secondSeatCount = new int[]{357, 274, 376, 473, 247, 453, 369, 412};
        int[] noSeatCount = new int[]{56, 427, 218, 42, 81, 137, 128, 87};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertSHBJ(Context context) {
        Database database = Database.newInstance(context);
        String[] destination = new String[]{"BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan", "BeiJingNan"};
        String[] origin = new String[]{"ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHai", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao"};
        String[] originTime = new String[]{"06:26", "06:38", "07:00", "07:12", "07:22", "07:28", "07:51"};
        String[] destinationTime = new String[]{"12:29", "12:33", "11:38", "13:13", "13:23", "13:38", "12:24"};
        String[] time = new String[]{"6小时3分钟", "5小时55分钟", "4小时38分钟", "6小时1分钟", "6小时1分钟", "6小时10分钟", "5小时42分钟"};
        String[] identifier = new String[]{"G102", "G104", "G6", "G106", "G108", "G110", "G120"};
        int[] businessSeatCount = new int[]{21, 1, 43, 9, 12, 13, 15};
        int[] firstSeatCount = new int[]{34, 54, 76, 56, 74, 16, 51};
        int[] secondSeatCount = new int[]{456, 513, 423, 315, 314, 249, 457};
        int[] noSeatCount = new int[]{833, 546, 753, 618, 573, 427, 567};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }







    public void insertSHSZ(Context context) {
        Database database = Database.newInstance(context);
        String[] destination = new String[]{"ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhen"};
        String[] origin = new String[]{"ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiNan"};
        String[] originTime = new String[]{"07:46", "08:49", "09:05", "09:40", "10:28", "11:24", "11:41"};
        String[] destinationTime = new String[]{"19:20", "20:39", "2:46", "21:38", "21:54", "22:50", "06:22"};
        String[] time = new String[]{"11小时34分钟", "11小时50分钟", "11小时41分钟", "11小时58分钟", "11小时26分钟"
                , "11小时26分钟", "18小时41分钟"};
        String[] identifier = new String[]{"D2287", "D3125", "D2285", "D3107", "D2281", "D2283", "T211"};
        int[] businessSeatCount = new int[]{13, 22, 23, 23, 4, 34, 21};
        int[] firstSeatCount = new int[]{34, 64, 42, 64, 23, 24, 46};
        int[] secondSeatCount = new int[]{321, 354, 242, 351, 452, 375, 164};
        int[] noSeatCount = new int[]{573, 546, 453, 328, 543, 347, 347};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }

    public void insertSZSH(Context context) {
        Database database = Database.newInstance(context);
        String[] origin = new String[]{"ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei", "ShenZhenBei"};
        String[] destination = new String[]{"ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiHongQiao", "ShangHaiNan"};
        String[] originTime = new String[]{"07:00", "08:22", "08:46", "09:18", "09:54", "10:42", "11:32"};
        String[] destinationTime = new String[]{"18:43", "19:59", "20:44", "21:20", "22:12", "22:35", "19:27"};
        String[] time = new String[]{"11小时43分钟", "11小时37分钟", "11小时58分钟", "12小时2分钟", "12小时18分钟"
                , "11小时53分钟", "7小时55分钟"};
        String[] identifier = new String[]{"D3126", "D3108", "D2284", "D2282", "D2286", "D2288", "G100"};
        int[] businessSeatCount = new int[]{14, 8, 13, 24, 27, 10, 15};
        int[] firstSeatCount = new int[]{35, 23, 53, 31, 43, 45, 31};
        int[] secondSeatCount = new int[]{468, 453, 427, 351, 467, 513, 351};
        int[] noSeatCount = new int[]{576, 627, 537, 432, 689, 642, 324};
        for (int i = 0; i < origin.length; i++) {
            Ticket ticket = new Ticket();
            ticket.setOrigin(origin[i]);
            ticket.setDestination(destination[i]);
            ticket.setOriginTime(originTime[i]);
            ticket.setDestinationTime(destinationTime[i]);
            ticket.setTime(time[i]);
            ticket.setIdentifier(identifier[i]);
            ticket.setbusinessSeatCount(businessSeatCount[i]);
            ticket.setfirstSeatCount(firstSeatCount[i]);
            ticket.setsecondSeatCount(secondSeatCount[i]);
            ticket.setNoSeatCount(noSeatCount[i]);
            database.insertTicket(ticket);
        }
    }





}
